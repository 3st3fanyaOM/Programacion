package Arrays;

import java.util.Scanner;

public class Ejer3 {

	public static void main(String[] args) {
	Scanner scanner = new Scanner(System.in);
	System.out.println("¿Cuantos números desea almacenar?");
	Integer n = scanner.nextInt();
	Integer [] numeros = new Integer [n];
	
		
	
	
	for (int i=0;i<numeros.length;i++) {
		System.out.print(numeros[i]+" ");
	}
	
	
	
	scanner.close();
	
	}

}
