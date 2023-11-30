import java.util.Scanner;

public class Ejercicio2 {

	public static void main(String[] args) {
		
		Scanner scanner = new Scanner(System.in);
		
		System.out.println("Escriba nombre de usuario");
		String nombre = scanner.nextLine();
		System.out.println("Bienvenido " + nombre);
		
		System.out.println("¿De donde eres?");
		String localidad = scanner.nextLine();
		System.out.println("¿Que tal se vive en " + localidad + "?");
		
		scanner.nextLine();
		System.out.println("Gracias, un saludo");
		
		scanner.close();

	}

}
