package game.controller;

import java.util.ArrayList;
import java.util.List;
import java.util.Random;

import com.googlecode.lanterna.input.Key;

import game.bean.BoardBean;
import game.bean.Input;
import game.bean.PosicaoBean;
import game.bean.pecas.P1Bean;
import game.bean.pecas.P2Bean;
import game.bean.pecas.Peca;
import game.view.Console;

public class Controller {

	private Random r = new Random(System.currentTimeMillis());
	private BoardBean board;
	private Input input;
	private Console console;
	private int velocidadeQueda = 1;
	private Peca peca;

	public Controller(BoardBean board, Console console) {
		this.board = board;
		this.console = console;
	}

	public void start() {
		List<Integer> l = new ArrayList<>();
		console.start();
		this.atualizar();
		for(int i : l)
			System.out.println(i);
	}
	
	private void atualizar() {
		long msPerFrame = 1000 / velocidadeQueda;
		long lastUpdateTime = System.currentTimeMillis() - msPerFrame;
		do {
			long currentUpdateTime = System.currentTimeMillis();
			long nextUpdateTime = currentUpdateTime + msPerFrame;

			if (lastUpdateTime <= (currentUpdateTime - msPerFrame)) {
				if (currentUpdateTime - lastUpdateTime != msPerFrame)
					System.out.println(
							"Atraso atualização controller de " + (currentUpdateTime - lastUpdateTime - msPerFrame) + " ms");

				// ajuste rotação...
				if(this.console.getInput().getKind() == Key.Kind.ArrowUp && this.peca != null) {
					System.out.println("Caiu aqui ------------------");
					this.peca.incrementarRotacao();
				}

				if(peca == null) {
					peca = getPeca();
					boolean naoPerdeu = peca.desenhoInicial();
					if(!naoPerdeu)
						System.out.println("perdeu");
					while(!naoPerdeu);
					console.atualizarPosicoes();
					board.printBoard();
				}
				else {
					atualizarAux();
					board.printBoard();
				}
				
				lastUpdateTime = currentUpdateTime;
				long waitingTime = nextUpdateTime - System.currentTimeMillis() - 1;
				if (waitingTime < 0)
					waitingTime = 0;
//				System.out.println("WaitingTime: " + waitingTime);
				try {
					Thread.sleep(waitingTime);
				} catch (InterruptedException e) {
					Thread.interrupted();
					e.printStackTrace();
				}
			}
		} while (true);
	}

	private void atualizarAux() {
		if(!this.peca.descerPeca())
			peca = null;
		console.atualizarPosicoes();
	}

	private Peca getPeca() {
		final int QUANTIDADE_PECAS = 2;
		int random = Math.abs(r.nextInt()%QUANTIDADE_PECAS) + 1;
		if(random == 1) {
			System.out.println("Retornou p1");
			return new P1Bean(this.board);
		}
		else if(random == 2) {
			System.out.println("Retornou p2");
			return new P2Bean(this.board);
		}
		return null;
	}
	
	public static void main(String[] args) {
		BoardBean board = new BoardBean();
		System.out.println("Altura: " + board.getALTURA());
		System.out.println("Largura: " + board.getLARGURA());
		Console console = new Console(board);
		Controller controller = new Controller(board, console);
		
		controller.start();
	}	
}
