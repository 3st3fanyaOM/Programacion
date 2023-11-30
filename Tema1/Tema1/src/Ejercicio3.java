import java.util.Scanner;

public class Ejercicio3 {

	public static void main(String[] args) {
		
		Scanner scanner = new Scanner(System.in);

		System.out.println("Escriba su edad");
		int edad = scanner.nextInt();
		System.out.println("Su edad es " + edad + " años");
		
		scanner.close();
	}

}
