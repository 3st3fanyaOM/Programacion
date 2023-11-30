package Arrays;

import java.util.Scanner;

public class Ejer10 {

	public static void main(String[] args) {
		Scanner scanner = new Scanner(System.in);
		Integer n = 0;
		
		do {System.out.println("Dame un número mayor de 2");
		n = scanner.nextInt();
		}
		while (n<2);
		Integer [] fibonacci = new Integer [n];
		fibonacci [0] = 0;
		fibonacci [1] = 1;
		
		for (int i = 2;i<fibonacci.length;i++) {
			fibonacci [i] = fibonacci [i-1] + fibonacci [i-2];
		}
		
		for (int i = 0; i< fibonacci.length;i++) {
			System.out.print(fibonacci [i]+ " ");
		}
		scanner.close();
	}

}
