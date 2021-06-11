package game.view;

import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Collections;
import java.util.Date;
import java.util.List;

import javax.swing.JFrame;

import com.googlecode.lanterna.input.Key;
import com.googlecode.lanterna.input.Key.Kind;
import com.googlecode.lanterna.terminal.Terminal;
import com.googlecode.lanterna.terminal.swing.SwingTerminal;

import game.bean.BoardBean;
import game.bean.Input;
import game.bean.PosicaoBean;

public class Console {
	private Terminal terminal; // = TerminalFacade.createTerminal(System.in, System.out,
								// StandardCharsets.UTF_8);
	private final int FRAMES_PER_SECOND = 20;
	private PosicaoBean[] posicoes;
	private Long firstFrame = System.currentTimeMillis();
	private Long lastFrame = System.currentTimeMillis();
	private List<Input> inputs = Collections.synchronizedList(new ArrayList<Input>());
	private int ALTURA;
	private int LARGURA;
	private int alturaTerminal = 0;
	private BoardBean board;
	
	public Console(BoardBean board) {
		this.board = board;
		this.ALTURA = board.getALTURA();
		this.LARGURA = board.getLARGURA();
	}

	private void atualizar() {
		long msPerFrame = 1000 / FRAMES_PER_SECOND;
		long lastUpdateTime = System.currentTimeMillis() - msPerFrame;
		do {
			long currentUpdateTime = System.currentTimeMillis();
			long nextUpdateTime = currentUpdateTime + msPerFrame;

			if (lastUpdateTime <= (currentUpdateTime - msPerFrame)) {
				if (currentUpdateTime - lastUpdateTime != msPerFrame)
					System.out.println(
							"Atraso atualização console de " + (currentUpdateTime - lastUpdateTime - msPerFrame) + " ms");

//				if(this.getInput().getKey().equals("d"))
				atualizarAux();
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
		
		this.limparTerminal();
		PosicaoBean[] posicoes = getPosicoes();
		for (int k = 0; k <= this.LARGURA + 1; k++) {
			escreverTerminal("X");
		}
		escreverTerminalln("");
		for (int y = 1; y <= this.ALTURA; y++) {

			escreverTerminal("X");
			for (int x = 1; x <= this.LARGURA; x++) {
				BoardBean b = new BoardBean(posicoes);
//				b.printBoard();
//				escreverTerminal(PosicaoBean.getPosicao(x, y, posicoes, this.LARGURA).isPreenchido() ? "O" : " ");
				escreverTerminal(b.getPosicao(x, y).isPreenchido() == true ? "+" : " ");
			}
			escreverTerminal("X");
			escreverTerminalln("");

			if (y == this.ALTURA) {
				for (int k = 0; k <= this.LARGURA + 1; k++)
					escreverTerminal("X");
				escreverTerminalln("");
			}
		}
	}

	private PosicaoBean getPosicao(int x, int y) {
		return PosicaoBean.getPosicao(x, y, posicoes, this.LARGURA);
	}

	private PosicaoBean[] getPosicoes() {
		return posicoes;
//		return manipulaPosicoes(1, null);
	}

	public void atualizarPosicoes() {
//		this.posicoes = posicoes;
		this.posicoes = board.getPosicoes();
//		board.printBoard();
//		manipulaPosicoes(2, posicoes);
//		new BoardBean(this.posicoes).printBoard();
	}

	// operacao == 1 => getPosicao
	// operacao == 2 => atualizaPosicoes
	private synchronized PosicaoBean[] manipulaPosicoes(int operacao, PosicaoBean[] posicoes) {
		if (operacao == 1)
			return posicoes;
		else if (operacao == 2) {
//			System.out.println("Atualizando posições................");
			this.posicoes = posicoes;
//			new BoardBean(posicoes).printBoard();
		}

		return null;
	}

	public Input getInput() {
		Key key = terminal.readInput();
		if (key == null) {
			return new Input("", Kind.NormalKey);
		}
		else {
			return new Input(String.valueOf(key.getCharacter()), key.getKind());
		}
	}
//	private Input getInput() {
//		Key key = terminal.readInput();
//		Input input = null;
//		if (key == null) {
//			input = new Input("", Kind.NormalKey);
//			manipularVetor(0, input, 0);
//		}
//
//		else {
//			input = new Input(String.valueOf(key.getCharacter()), key.getKind());
//			manipularVetor(0, input, 0);
//		}
//
//		return input;
//	}

	private void atualizarInput() {
		while (true) {
			Key key = terminal.readInput();
			Input input = null;
			if (key == null) {
				input = new Input("", Kind.NormalKey);
				manipularVetor(0, input, 0);
			}

			else {
				input = new Input(String.valueOf(key.getCharacter()), key.getKind());
				manipularVetor(0, input, 0);
			}
//			inputs.add(input);

		}
	}

	private void limparInput() {
		while (true) {
			if (inputs.size() > 0) {
				Input primeiroFrame = inputs.get(0);
				if ((System.currentTimeMillis() - primeiroFrame.getTime()) / 1000 > 2) {
					while (primeiroFrame != null && (System.currentTimeMillis() - primeiroFrame.getTime()) / 1000 > 1) {
//						inputs.remove(0);
						manipularVetor(-1, null, 0);
						primeiroFrame = (inputs.size() == 0) ? null : inputs.get(0);
					}
				}
			}
		}
	}

	// i == 0 = adicionar
	// i == -1 = remover
	// i == 1 = cloneList
	private synchronized List<Input> manipularVetor(int i, Input input, int excluir) {
		if (i == 0)
			inputs.add(input);
		else if (i == -1)
			inputs.remove(excluir);
		else
			return new ArrayList<Input>(inputs);
		return null;
	}

//	public static void main(String[] args) {
//		Console console = new Console();
//		while(true) {
//			SimpleDateFormat sdf = new SimpleDateFormat("dd/MM/yyyy hh:mm:ss:SSS");
//			Date d = new Date(System.currentTimeMillis());
//			System.out.println(sdf.format(d));
//			for(Input i : console.manipularVetor(1, null, 0)) {
//				System.out.println(i);
//			}
//			
//			System.out.println("\n-----------------------\n\n");
//		}
//		
//	}
//	
	public static void main(String[] args) throws InterruptedException {
//		Terminal terminal = TerminalFacade.createTerminal(System.in, System.out, StandardCharsets.UTF_8);
		Terminal terminal = new SwingTerminal();
		terminal.enterPrivateMode();
		if (terminal instanceof SwingTerminal) {
			SwingTerminal s = (SwingTerminal) terminal;
			s.getJFrame().setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		}
		while (1 == 1) {
			Key key = terminal.readInput();
			if (key != null) {
				new Console(new BoardBean()).escreverTerminal(terminal, key.getCharacter() + "");
				if (key.getKind().equals(Kind.ArrowUp)) {
					System.out.println("ArrowUp");
					new Console(new BoardBean()).escreverTerminalln(terminal, key.getCharacter() + "");
				}
				System.out.println("[" + key.getCharacter() + "][" + key.getKind() + "]");
			}
//				
			if (1 != 1)
				break;
		}

//		t.

		for (int i = 0; i < 100000; i++) {
			char c = new String("" + i).charAt(0);
//			terminal.moveCursor(0, i + 1);
			terminal.putCharacter(c);
			wait(1);
			terminal.clearScreen();

		}
//		terminal.exitPrivateMode();
	}

//	public static void main(String[] args) {
//		Terminal terminal = TerminalFacade.createTerminal(System.in, System.out, StandardCharsets.UTF_8);
//		terminal.enterPrivateMode();
//	}

	public void start() {
		terminal = new SwingTerminal();
		terminal.enterPrivateMode();
		SwingTerminal s = (SwingTerminal) terminal;
		s.getJFrame().setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);

		new Thread(new Runnable() {
			@Override
			public void run() {
				atualizar();
			}
		}).start();
	}

	static int i = 0;

	public void escreverTerminal(Terminal terminal, String string) {
		char[] temp = string.toCharArray();
		for (char c : temp)
			terminal.putCharacter(c);
	}

	private void escreverTerminalln(String string) {
		terminal.moveCursor(0, ++alturaTerminal);
//		if (i == 1)
//			while (true)
//				;
//		escreverTerminal(terminal, string + "\n");
	}

	private void escreverTerminal(String string) {
		char[] temp = string.toCharArray();
		for (char c : temp)
			terminal.putCharacter(c);
	}

	private void limparTerminal() {
		terminal.clearScreen();
		alturaTerminal = 0;
//		terminal.moveCursor(0, 0);
	}

	static int alturaTerminal2 = 0;

	public void escreverTerminalln(Terminal terminal, String string) {
		terminal.moveCursor(0, alturaTerminal2++);
//		escreverTerminal(terminal, string + "\n");
	}

	private static void wait(int i) {
		Long max = System.currentTimeMillis() + (i * 1000);
		while (System.currentTimeMillis() < max)
			;
		System.out.println("Saiu");
	}
}
