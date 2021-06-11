package game.bean;

public class PosicaoBean {
	private int x;
	private int y;
	private boolean preenchido = false;

	public PosicaoBean(int x, int y) {
		this.x = x;
		this.y = y;
	}

	public int getX() {
		return x;
	}

	public void setX(int x) {
		this.x = x;
	}

	public int getY() {
		return y;
	}

	public void setY(int y) {
		this.y = y;
	}

	public boolean isPreenchido() {
		return preenchido;
	}

	public void setPreenchido(boolean preenchido) {
		this.preenchido = preenchido;
	}
	
	public PosicaoBean clone() {
		PosicaoBean p = new PosicaoBean(this.x, this.y);
		p.setPreenchido(p.isPreenchido());
		return p;
	}
	
	public static PosicaoBean getPosicao(int x, int y, PosicaoBean[] posicoes, int LARGURA) {
		if(posicoes == null) {
			return new PosicaoBean(x, y);
		}
		x--;
		y--;
		return posicoes[(y*LARGURA) + x];
	}
}
