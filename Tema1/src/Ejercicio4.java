import java.util.Scanner;

public class Ejercicio4 {

	public static final int ACTUAL = 2023;
	public static void main(String[] args) {
	Scanner scanner = new Scanner(System.in);
	
	System.out.println("Escriba su año de nacimiento");
	int nacimiento = scanner.nextInt();
	int edad = ACTUAL-nacimiento;
	System.out.println("Su edad es " + edad);
	scanner.close();
	}

}
