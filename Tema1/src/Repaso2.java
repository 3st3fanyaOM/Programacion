import java.util.Scanner;

public class Repaso2 {

	public static void main(String[] args) {
		Scanner scanner = new Scanner(System.in);
		
		System.out.println("Diga un número");
		int num1 = scanner.nextInt();

		System.out.println("Diga otro número");
		int num2 = scanner.nextInt();
		long resultado = num1 * num2;
		System.out.println("El resultado es " + resultado);
		
		scanner.close();

	}

}
