package Arrays;

import java.util.Scanner;

public class Ejer5 {

	public static void main(String[] args) {
		Scanner scanner = new Scanner(System.in);
		System.out.println("¿Cuantos números desea almacenar?");
		Integer n = scanner.nextInt();
		
		Integer [] numeros = new Integer [n];
		Integer longi = numeros.length;
		double suma= 0;
		double media= 0;
		for (int i=0;i<longi;i++) {
			System.out.println("Introduzca un número");
			Integer num = scanner.nextInt();
			numeros [i] = num;
			
		}
		
		for (int i=longi-1;i>=0;i--) {
			System.out.print(numeros[i]+" ");
			
		}
		
		Integer mayor = numeros[0]; // 5
		Integer posic=0;
		Integer posic2=0;
		Integer menor = numeros[0];
		for (int i =0;i<longi;i++) {
			if (mayor<numeros[i]) {
				mayor=numeros[i];
				posic = i;				
			}
			else if (menor>numeros[i]) {
				menor=numeros[i];
				posic2 = i;				
			}
		
		}
			System.out.println("El número mayor es " + mayor + " y está en la posición "+posic);
			System.out.println("El número menor es " + menor + " y está en la posición "+posic2);
		
			for (int i =0;i < numeros.length;i++) {
				suma = suma + numeros[i];//suma+= numeros[i]
				media = suma/numeros.length;
			}
			System.out.println("La media de los números es "+ media);
		
		scanner.close();
		
		}

	}