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
		
		long x1 = Long.parseLong(a);
		String x2 = b.toString();
		int x3 = b.intValue();
		long x4 = c.longValue();
		
		System.out.println(x1 + x2 + x3 + x4);
		scanner.close();

	}

}
