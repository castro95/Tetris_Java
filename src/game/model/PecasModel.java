//package game.model;
//
//import game.bean.BoardBean;
//import game.bean.pecas.P1Bean;
//
//public abstract class PecasModel {
//	// Rotacao sentido horario: 0 => 90 => 180 => 270
//	// p1	p2	p3		p4		p5		p6
//	// **	**	****	**		 **		**
//	// *	 *			 **		**		**
//	// *	 *
//	private static int ajustarRotacao(int rotacao) {
//		while(rotacao >= 360)
//			rotacao -= 360;
//		return rotacao;
//	}
//	
//	public static boolean deseharP1(int rotacao, BoardBean board, int x, int y) {
//		rotacao = ajustarRotacao(rotacao);
//		if(rotacao == 0) {
//			return P1Bean.desenharZeroGraus(board, x, y);
//		}
//		
//		if(rotacao == 90) {
//			return P1Bean.desenharNoventaGraus(board, x, y);
//		}
//		
//		if(rotacao == 180) {
//			return P1Bean.desenharSentoEOitentaGraus(board, x, y);
//		}
//		
//		if(rotacao == 270) {
//			return P1Bean.desenharDuzentosESetentaGraus(board, x, y);
//		}
//		
//		return false;
//	}
//	
//	public static void apagarP1(int rotacao, BoardBean board, int x, int y) {
//		rotacao = ajustarRotacao(rotacao);
//		if(rotacao == 0) {
//			P1Bean.apagarZeroGraus(board, x, y);
//		}
//		
//		if(rotacao == 90) {
//			P1Bean.apagarNoventaGraus(board, x, y);
//		}
//		
//		if(rotacao == 180) {
//			P1Bean.apagarcentoEOitentaGraus(board, x, y);
//		}
//		
//		if(rotacao == 270) {
//			P1Bean.apagarDuzentosESetentaGraus(board, x, y);
//		}
//	}
//
//	public static boolean deseharP2(int rotacao, BoardBean board, int x, int y) {
//		rotacao = ajustarRotacao(rotacao);
//		if(rotacao == 0) {
//			return P1Bean.desenharZeroGraus(board, x, y);
//		}
//		
//		if(rotacao == 90) {
//			return P1Bean.desenharNoventaGraus(board, x, y);
//		}
//		
//		if(rotacao == 180) {
//			return P1Bean.desenharSentoEOitentaGraus(board, x, y);
//		}
//		
//		if(rotacao == 270) {
//			return P1Bean.desenharDuzentosESetentaGraus(board, x, y);
//		}
//		
//		return false;
//	}
//	
//	public static void apagarP2(int rotacao, BoardBean board, int x, int y) {
//		rotacao = ajustarRotacao(rotacao);
//		if(rotacao == 0) {
//			P1Bean.apagarZeroGraus(board, x, y);
//		}
//		
//		if(rotacao == 90) {
//			P1Bean.apagarNoventaGraus(board, x, y);
//		}
//		
//		if(rotacao == 180) {
//			P1Bean.apagarcentoEOitentaGraus(board, x, y);
//		}
//		
//		if(rotacao == 270) {
//			P1Bean.apagarDuzentosESetentaGraus(board, x, y);
//		}
//	}
//
//	
//	
//}
