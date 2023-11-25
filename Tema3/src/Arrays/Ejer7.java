package Arrays;

import java.util.Scanner;

public class Ejer7 {

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
		
		for (int i=0;i<longi;i++) {//imprimir array1
			System.out.print(+numeros[i]);
		}
		Integer [] numeros2 = new Integer [longi];
		Integer longitud = 0;
		Integer j = longi-1;
		for (int i=0;i<numeros2.length;i++, j--) {
			numeros2 [i] = numeros[j];
			
			
		}
		for (int i =0;i<numeros2.length;i++) {
			System.out.print(numeros2 [i]);
		}
		scanner.close();
		
		

	}
}