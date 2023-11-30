import java.util.Scanner;

public class Repaso3 {

	public static void main(String[] args) {
Scanner scanner = new Scanner(System.in);
		
		System.out.println("Diga un número");
		String num1 = scanner.nextLine();
		Long.parseLong(num1);
		System.out.println("Diga otro número");
		String num2 = scanner.nextLine();
		Long.parseLong(num2);
		long resultado = num1*num2;
		System.out.println("El resultado es " + resultado);
	}

}
