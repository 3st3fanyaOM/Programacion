import java.util.Scanner;

public class Ejercicio6 {
	
	public static final double IVA = 0.21;
	public static void main(String[] args) {
	Scanner scanner = new Scanner(System.in);
	
	System.out.println("¿Cuál es el precio del artículo sin IVA?");
	double siniva = scanner.nextDouble();
	double iva = siniva * IVA;
	double coniva = iva + siniva;
	System.out.println("El precio final es " + coniva + " €");
	
	scanner.close();

	}

}
