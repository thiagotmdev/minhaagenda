package ThiagoMendesDev.minhaagenda;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class Console {
	
	public static String readString() {
		
		try {
			BufferedReader reader = new BufferedReader(new InputStreamReader(System.in));
			return reader.readLine();
		} catch (IOException e) {
			throw new RuntimeException("Erro ao ler o dado do teclado");
		}
	}
	
	public static char readChar() {
		try {
			BufferedReader reader = new BufferedReader(new InputStreamReader(System.in));
			return reader.readLine().charAt(0);
		} catch (IOException e) {
			throw new RuntimeException("Erro ao ler o dado do teclado");
		}
	}
	
	public static int readInt() {
		String str = readString();
		
		try {
			return Integer.parseInt(str);
		} catch (NumberFormatException e) {
			throw new RuntimeException(str + " não é um int válido");
		}
	}
}
