package Arrays;

import java.util.Scanner;

public class Ejer8 {

	public static void main(String[] args) {
		Scanner scanner = new Scanner(System.in);
		System.out.println("¿Cuantos números desea almacenar?");
		Integer n = scanner.nextInt();//pido numero de posiciones del array
		
		Integer [] numeros = new Integer [n];
		Integer longi = numeros.length;
		
		for (int i=0;i<longi;i++) {//dar valores al array
			System.out.println("Introduzca un número");
			Integer num = scanner.nextInt();
			numeros [i] = num;
		}
		
		Integer j = longi-1;
		for (int i=0;i<j;i++, j--) {
			Integer aux = numeros[i];
			numeros[j] =aux;
	
			
			
		}
		
		for (int i=0;i<numeros.length;i++) {
			System.out.print(numeros[i]+" ");
		}
		
		
		scanner.close();
		
		}

	}
