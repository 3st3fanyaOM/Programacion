import java.util.Scanner;

public class Ejercicio7 {

	public static void main(String[] args) {
		Scanner scanner = new Scanner(System.in);
		
		System.out.println("Escriba su altura");
		double altura = scanner.nextDouble();
		System.out.println("Escriba su peso");
		double peso = scanner.nextDouble();
		double imc = peso / (altura * altura);
		System.out.println("Su IMC es de " + imc);
		scanner.close();
	}

}
