package game.bean;

public class BoardBean {
	private final int LARGURA = 10;
	private final int ALTURA = 20;
	private PosicaoBean posicoes[];
	
	
	public BoardBean() {
		posicoes = new PosicaoBean[LARGURA*ALTURA];
		
		for(int y = 1, count = 0; y <= ALTURA ; y++) {
			for(int x = 1 ; x <= LARGURA ; x++) {
				PosicaoBean posicao = new PosicaoBean(x, y);
				posicoes[count++] = posicao;
			}
		}
	}
	
	public BoardBean(PosicaoBean[] posicoes) {
		this.posicoes = posicoes;
	}

//	{
//		posicoes = new PosicaoBean[LARGURA*ALTURA];
//		
//		for(int y = 1, count = 0; y <= ALTURA ; y++) {
//			for(int x = 1 ; x <= LARGURA ; x++) {
//				PosicaoBean posicao = new PosicaoBean(x, y);
//				posicoes[count++] = posicao;
//			}
//		}
//	}
	
	public void preencherPosicao(int x, int y) {
		getPosicao(x, y).setPreenchido(true);
	}
	
	public void esvaziarPosicao(int x, int y) {
		getPosicao(x, y).setPreenchido(false);
	}
	
	public PosicaoBean getPosicao(int x, int y) {
		return PosicaoBean.getPosicao(x, y, posicoes, this.LARGURA);
	}
	
	public boolean isPosicaoPreenchida(int x, int y) {
		return getPosicao(x, y).isPreenchido();
	}

	public PosicaoBean[] getPosicoes() {
//		PosicaoBean[] posicoes = new PosicaoBean[this.posicoes.length];
//		for(int i = 0 ; i < this.posicoes.length ; i++)
//			posicoes[i] = this.posicoes[i].clone();
		return posicoes;
	}
	
	public BoardBean clone() {
		BoardBean board = new BoardBean();
		board.posicoes = this.getPosicoes();
		return board;
	}
	
	public void printBoard() {
		BoardBean b = this;
		System.out.println("XXXXXXXXXXXX");
		for(int y = 1 ; y <= b.ALTURA ; y++) {
			System.out.print("X");
			for(int x = 1 ; x <= b.LARGURA ; x++) {
				System.out.print(b.getPosicao(x, y).isPreenchido() == true ? "+" : "-");
			}
			System.out.println("X");
		}
		System.out.println("XXXXXXXXXXXX");
	}
	
	public int getLARGURA() {
		return LARGURA;
	}

	public int getALTURA() {
		return ALTURA;
	}
}