import java.util.Scanner;

public class Ejercicio8 {

	public static void main(String[] args) {
		Scanner scanner = new Scanner(System.in);
		
		System.out.println("Escriba un número");
		String a = scanner.nextLine();
		System.out.println("Escriba un número decimal");
		Double b = scanner.nextDouble();
		System.out.println("Escriba un número entero");
		Float c = scanner.nextFloat();
		
		System.out.println("Parseo de string a long");
		long x1 = Long.parseLong(a);
		
		System.out.println("Parseo de double a string");
		String x2 = b.toString();
		
		System.out.println("Parseo de double a integer");
		int x3 = b.intValue();
		
		System.out.println("Parseo de long a float");
		long x4 = c.longValue();
		
		System.out.println("x1: " + x1);
		System.out.println("x2: " + x2);
		System.out.println("x3: " + x3);
		System.out.println("x4: " + x4);
		
		scanner.close();

	}

}
