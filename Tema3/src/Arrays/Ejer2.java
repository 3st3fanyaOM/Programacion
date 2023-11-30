package Arrays;

import java.util.Scanner;

public class Ejer2 {

	public static void main(String[] args) {
	Integer[] cuadrados = new Integer [6];
	Scanner scanner = new Scanner (System.in);
	System.out.println("Dame un número");
	Integer num = scanner.nextInt();

	for(int i =0;i<cuadrados.length;i++) {
		
		
		cuadrados [i]=num*num;
		num++;
		System.out.println(cuadrados[i]);
		
	}
	scanner.close();
	
	}

}
