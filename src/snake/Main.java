package snake;

import java.nio.charset.StandardCharsets;
import java.util.Date;

import com.googlecode.lanterna.TerminalFacade;
import com.googlecode.lanterna.terminal.Terminal;

public class Main {
	public static void main(String[] args) throws InterruptedException {
		Terminal terminal = TerminalFacade.createTerminal(System.in, System.out, StandardCharsets.UTF_8);
		terminal.enterPrivateMode();
		for(int i = 0 ; i < 100000 ; i++) {
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

	private static void escreverTerminal(Terminal terminal, String string) {
		char[] temp = string.toCharArray();
		for(char c : temp)
			terminal.putCharacter(c);
	}
	
	private static void escreverTerminalln(Terminal terminal, String string) {
		escreverTerminal(terminal, string + "\n");
	}
	
	private static void wait(int i) {
		Long max = System.currentTimeMillis() + (i * 1000);
		while(System.currentTimeMillis() < max);
		System.out.println("Saiu");
	}
}