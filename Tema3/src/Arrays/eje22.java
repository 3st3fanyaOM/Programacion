package Arrays;

import java.util.Scanner;

public class eje22 {

	public static void main(String[] args) {
	Scanner scanner = new Scanner (System.in);
	System.out.println("Escribe una palabra");
	String palabra = scanner.nextLine();
	String letra []= palabra.split("");
	
	for (String deletreo : letra ) {
		System.out.println(deletreo + " ");
	}
	scanner.close();

	}

}
