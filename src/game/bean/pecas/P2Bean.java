package game.bean.pecas;

import game.bean.BoardBean;

// p2
// **
//  *
//  *
public class P2Bean extends Peca {

	public P2Bean(BoardBean board) {
		super(board, 1);
	}
	
	@Override
	protected boolean desenharZeroGraus(int x, int y) {
		if(y < 1)
			y = 1;
		
		if(x < 2 || x > board.getLARGURA() ||  y + 2 > board.getALTURA())
			return false;
		
		if(board.isPosicaoPreenchida(x, y) || board.isPosicaoPreenchida(x-1, y) ||
				board.isPosicaoPreenchida(x, y+1) || board.isPosicaoPreenchida(x, y+2))
			return false;
		
		board.preencherPosicao(x, y);
//		board.printBoard();
		board.preencherPosicao(x-1, y);
//		board.printBoard();
		board.preencherPosicao(x, y+1);
//		board.printBoard();
		board.preencherPosicao(x, y+2);
//		board.printBoard();
		return true;
	}
	
	@Override
	protected boolean desenharNoventaGraus(int x, int y) {
		if(y < 1)
			y = 1;
		
		if(x < 3 || x > board.getLARGURA() ||  y + 1 > board.getALTURA())
			return false;
		
		if(board.isPosicaoPreenchida(x, y) || board.isPosicaoPreenchida(x-1, y) ||
				board.isPosicaoPreenchida(x-2, y) || board.isPosicaoPreenchida(x, y+1))
			return false;
		
		board.preencherPosicao(x, y);
		board.preencherPosicao(x-1, y);
		board.preencherPosicao(x-2, y);
		board.preencherPosicao(x, y+1);
		return true;
	}
	
	@Override
	protected boolean desenharSentoEOitentaGraus(int x, int y) {
		if(y < 1)
			y = 1;
		
		if(x < 2 || x > board.getLARGURA() ||  y > board.getALTURA() || y < 3)
			return false;
		
		if(board.isPosicaoPreenchida(x, y) || board.isPosicaoPreenchida(x, y-1) ||
				board.isPosicaoPreenchida(x, y-2) || board.isPosicaoPreenchida(x-1, y))
			return false;
		
		board.preencherPosicao(x, y);
		board.preencherPosicao(x, y-1);
		board.preencherPosicao(x, y-2);
		board.preencherPosicao(x-1, y);
		return true;
	}
	
	@Override
	protected boolean desenharDuzentosESetentaGraus(int x, int y) {
		if(y < 1)
			y = 1;
		
		if(x+2 > board.getLARGURA() ||  y > board.getALTURA() || y == 1)
			return false;
		
		if(board.isPosicaoPreenchida(x, y) || board.isPosicaoPreenchida(x+1, y) ||
				board.isPosicaoPreenchida(x+2, y) || board.isPosicaoPreenchida(x, y-1))
			return false;
		
		board.preencherPosicao(x, y);
		board.preencherPosicao(x+1, y);
		board.preencherPosicao(x+2, y);
		board.preencherPosicao(x, y-1);
		return true;
	}
	
	@Override
	protected void apagarZeroGraus(int x, int y) {
		board.esvaziarPosicao(x, y);
		board.esvaziarPosicao(x-1, y);
		board.esvaziarPosicao(x, y+1);
		board.esvaziarPosicao(x, y+2);
	}
	
	@Override
	protected void apagarNoventaGraus(int x, int y) {
		board.esvaziarPosicao(x, y);
		board.esvaziarPosicao(x-1, y);
		board.esvaziarPosicao(x-2, y);
		board.esvaziarPosicao(x, y+1);
	}
	
	@Override
	protected void apagarCentoEOitentaGraus(int x, int y) {
		board.esvaziarPosicao(x, y);
		board.esvaziarPosicao(x, y-1);
		board.esvaziarPosicao(x, y-2);
		board.esvaziarPosicao(x-1, y);
	}
	
	@Override
	protected void apagarDuzentosESetentaGraus(int x, int y) {
		board.esvaziarPosicao(x, y);
		board.esvaziarPosicao(x+1, y);
		board.esvaziarPosicao(x+2, y);
		board.esvaziarPosicao(x, y-1);
	}
	
	@Override
	protected boolean verificaZeroGraus(int x, int y) {
		if(y < 1)
			y = 1;
		
		if(x < 2 || x > board.getLARGURA() ||  y + 2 > board.getALTURA())
			return false;
		
		if(board.isPosicaoPreenchida(x, y) || board.isPosicaoPreenchida(x-1, y) ||
				board.isPosicaoPreenchida(x, y+1) || board.isPosicaoPreenchida(x, y+2))
			return false;

		return true;
	}
	
	@Override
	protected boolean verificaNoventaGraus(int x, int y) {
		if(y < 1)
			y = 1;
		
		if(x < 3 || x > board.getLARGURA() ||  y + 1 > board.getALTURA())
			return false;
		
		if(board.isPosicaoPreenchida(x, y) || board.isPosicaoPreenchida(x-1, y) ||
				board.isPosicaoPreenchida(x-2, y) || board.isPosicaoPreenchida(x, y+1))
			return false;

		return true;
	}
	
	@Override
	protected boolean verificaSentoEOitentaGraus(int x, int y) {
		if(y < 1)
			y = 1;
		
		if(x < 2 || x > board.getLARGURA() ||  y > board.getALTURA() || y < 3)
			return false;
		
		if(board.isPosicaoPreenchida(x, y) || board.isPosicaoPreenchida(x, y-1) ||
				board.isPosicaoPreenchida(x, y-2) || board.isPosicaoPreenchida(x-1, y))
			return false;
		
		return true;
	}
	
	@Override
	protected boolean verificaDuzentosESetentaGraus(int x, int y) {
		if(y < 1)
			y = 1;
		
		if(x+2 > board.getLARGURA() ||  y > board.getALTURA() || y == 1)
			return false;
		
		if(board.isPosicaoPreenchida(x, y) || board.isPosicaoPreenchida(x+1, y) ||
				board.isPosicaoPreenchida(x+2, y) || board.isPosicaoPreenchida(x, y-1))
			return false;
		
		return true;
	}
}
