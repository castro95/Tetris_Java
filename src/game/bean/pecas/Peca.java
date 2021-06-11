package game.bean.pecas;

import game.bean.BoardBean;
import game.bean.PosicaoBean;

public abstract class Peca {
	private PosicaoBean posicao;
	protected int LARGURA_BOARD;
	protected int ALTURA_BOARD;
	protected int rotacao;
	protected BoardBean board;
	
	public Peca(BoardBean board, int y) {
		this.LARGURA_BOARD = board.getLARGURA();
		this.ALTURA_BOARD = board.getALTURA();
		this.board = board;
		rotacao = 0;
		posicao = new PosicaoBean(LARGURA_BOARD/2, y);
	}

	public PosicaoBean getPosicao() {
		return posicao;
	}

	public void setPosicao(PosicaoBean posicao) {
		this.posicao = posicao;
	}
	
	public void incrementarRotacao() {
		int x = this.getPosicao().getX();
		int y = this.getPosicao().getY();
		this.apagar(this.getRotacao(), x, y);
		this.setRotacao(this.getRotacao() + 90);
		if(this.verificarPosicao(x, y)) {
			this.setRotacao(this.getRotacao() - 90);
			this.desenhar(this.getRotacao(), x, y);
		}
		else {
			this.desenhar(this.getRotacao(), x, y);
		}
			
	}
	
	public int getRotacao() {
		return rotacao;
	}

	private void setRotacao(int rotacao) {
		if(rotacao < 0)
			rotacao = 270;
		
		while(rotacao > 360)
			rotacao -= 360;
		
		if(rotacao == 0 || rotacao == 90 || rotacao == 180 || rotacao == 270)
			this.rotacao = rotacao;
		else if(rotacao > 0 && rotacao < 90){
			if(90-rotacao <= 45)
				this.rotacao = 90;
			else
				this.rotacao = 0;
		}
		else if(rotacao > 90 && rotacao < 180){
			if(180-rotacao <= 45)
				this.rotacao = 180;
			else
				this.rotacao = 90;
		}
		else if(rotacao > 180 && rotacao < 270){
			if(270-rotacao <= 45)
				this.rotacao = 270;
			else
				this.rotacao = 180;
		}
		else if(rotacao > 0 && rotacao < 360){
			if(360-rotacao <= 45)
				this.rotacao = 270;
			else
				this.rotacao = 0;
		}
		else
			this.rotacao = 0;
	}
	
	public boolean descerPeca() {
		boolean retorno = false;
		int x = this.getPosicao().getX();
		int y = this.getPosicao().getY();
				
		this.apagar(this.rotacao, x, y);
//		boolean retorno = this.desenhar(this.rotacao, x, y+1);
		retorno = verificarPosicao(x, y+1);
		if(retorno == true)
			this.desenhar(this.rotacao, x, y+1);
		else
			this.desenhar(this.rotacao, x, y);
		
		if(retorno == true)
			this.getPosicao().setY(this.getPosicao().getY()+1);
		return retorno;
	}
	
//	public boolean descerPeca() {
//		int x = this.getPosicao().getX();
//		int y = this.getPosicao().getY();
//		this.getPosicao().setY(this.getPosicao().getY()+1);
//		if(rotacao == 0) {
//			apagarZeroGraus(x, y);
//			if(desenharZeroGraus(x, y+1))
//				return true;
//			else {
//				desenharZeroGraus(x, y);
//				return false;
//			}
//		}
//		if(rotacao == 90) {
//			desenharNoventaGraus(x, y);
//			return desenharNoventaGraus(x, y);
//		}
//		if(rotacao == 180) {
//			desenharSentoEOitentaGraus(x, y);
//			return desenharSentoEOitentaGraus(x, y);
//		}
//		if(rotacao == 270) {
//			desenharDuzentosESetentaGraus(x, y);
//			return desenharDuzentosESetentaGraus(x, y);
//		}
//		return false;
//	}
	
	public boolean desenhoInicial() {
		for(int i = 0 ; i < 4 ; i++) {
			if(desenharZeroGraus(this.getPosicao().getX(), this.getPosicao().getY()))
				return true;
			incrementarRotacao();
		}
		return false;
	}
	
	protected abstract boolean desenharZeroGraus(int x, int y);
	
	protected abstract boolean desenharNoventaGraus(int x, int y);
	
	protected abstract boolean desenharSentoEOitentaGraus(int x, int y);
	
	protected abstract boolean desenharDuzentosESetentaGraus(int x, int y);

	protected abstract void apagarZeroGraus(int x, int y);
	
	protected abstract void apagarNoventaGraus(int x, int y);
	
	protected abstract void apagarCentoEOitentaGraus(int x, int y);
	
	protected abstract void apagarDuzentosESetentaGraus(int x, int y);
	
	protected abstract boolean verificaZeroGraus(int x, int y);
	
	protected abstract boolean verificaNoventaGraus(int x, int y);
	
	protected abstract boolean verificaSentoEOitentaGraus(int x, int y);
	
	protected abstract boolean verificaDuzentosESetentaGraus(int x, int y);
	
	private boolean verificarPosicao(int x, int y) {
		if(this.rotacao == 0) {
			return this.verificaZeroGraus(x, y);
		}
		
		if(this.rotacao == 90) {
			return this.verificaNoventaGraus(x, y);
		}
		
		if(this.rotacao == 180) {
			return this.verificaSentoEOitentaGraus(x, y);
		}
		
		if(this.rotacao == 270) {
			return this.verificaDuzentosESetentaGraus(x, y);
		}		
		return false;
	}
	
	public boolean desenhar(int rotacao, int x, int y) {
		setRotacao(rotacao);
		boolean verificaPosicao = this.verificarPosicao(x, y);
		if(verificaPosicao) {
			if(this.rotacao == 0) {
					return this.desenharZeroGraus(x, y);
			}
			
			if(this.rotacao == 90) {
				return this.desenharNoventaGraus(x, y);
			}
			
			if(this.rotacao == 180) {
				return this.desenharSentoEOitentaGraus(x, y);
			}
			
			if(this.rotacao == 270) {
				return this.desenharDuzentosESetentaGraus(x, y);
			}		
		}
		return false;
	}
	
	public void apagar(int rotacao, int x, int y) {
		setRotacao(rotacao);
		if(this.rotacao == 0) {
			this.apagarZeroGraus(x, y);
		}
		
		if(this.rotacao == 90) {
			this.apagarNoventaGraus(x, y);
		}
		
		if(this.rotacao == 180) {
			this.apagarCentoEOitentaGraus(x, y);
		}
		
		if(this.rotacao == 270) {
			this.apagarDuzentosESetentaGraus(x, y);
		}
	}	
}
