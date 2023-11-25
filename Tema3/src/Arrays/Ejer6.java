package Arrays;

import java.util.Scanner;

public class Ejer6 {

	public static void main(String[] args) {
		
	Scanner scanner = new Scanner(System.in);

	
	String [] tresPalabras = new String [3];
	
	

	for (int i = 0;i<=2;i++) {
		System.out.println("Escribe una palabra");
		String palabras = scanner.nextLine();
		tresPalabras [i]= palabras;
	}
	String frase = "";
	for (int i =0;i<tresPalabras.length;i++) {
		frase = frase + tresPalabras[i];
	}
	System.out.println(frase);
	scanner.close();
	}
	
}
