package Arrays;

import java.util.Scanner;

public class Ejer4 {

	public static void main(String[] args) {
		Scanner scanner = new Scanner(System.in);
		System.out.println("¿Cuantos números desea almacenar?");
		Integer n = scanner.nextInt();
		
		Integer [] numeros = new Integer [n];
		Integer longi = numeros.length;
		for (int i=0;i<longi;i++) {
			System.out.println("Introduzca un número");
			Integer num = scanner.nextInt();
			numeros [i] = num;
			
		}
		
		for (int i=longi-1;i>=0;i--) {
			System.out.print(numeros[i]+" ");
		}
		
		
		
		scanner.close();
		
		}

	}