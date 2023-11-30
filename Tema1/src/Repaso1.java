import java.util.Scanner;

public class Repaso1 {

	public static final double PI = 3.14;
	public static void main(String[] args) {
		Scanner scanner = new Scanner(System.in);
		
		System.out.println("Escriba el radio del círculo");
		double radio = scanner.nextDouble();
		double diametro = radio * 2;
		double circunferencia = diametro * PI;
		double area = (radio*radio) * PI;
		
		System.out.println("La circunferencia es " + circunferencia + " y el área es " + area);
		
		scanner.close();

	}

}
