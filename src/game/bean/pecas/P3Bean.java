package game.bean.pecas;

import game.bean.BoardBean;

// p3
// ****
public class P3Bean extends Peca {

	public P3Bean(BoardBean board) {
		super(board, y);
	}

	@Override
	protected boolean desenharZeroGraus(int x, int y) {
		return false;
	}

	@Override
	protected boolean desenharNoventaGraus(int x, int y) {
		return false;
	}

	@Override
	protected boolean desenharSentoEOitentaGraus(int x, int y) {
		return false;
	}

	@Override
	protected boolean desenharDuzentosESetentaGraus(int x, int y) {
		return false;
	}

	@Override
	protected void apagarZeroGraus(int x, int y) {

	}

	@Override
	protected void apagarNoventaGraus(int x, int y) {

	}

	@Override
	protected void apagarCentoEOitentaGraus(int x, int y) {

	}

	@Override
	protected void apagarDuzentosESetentaGraus(int x, int y) {

	}

	@Override
	protected boolean verificaZeroGraus(int x, int y) {
		return false;
	}

	@Override
	protected boolean verificaNoventaGraus(int x, int y) {
		return false;
	}

	@Override
	protected boolean verificaSentoEOitentaGraus(int x, int y) {
		return false;
	}

	@Override
	protected boolean verificaDuzentosESetentaGraus(int x, int y) {
		return false;
	}

}
