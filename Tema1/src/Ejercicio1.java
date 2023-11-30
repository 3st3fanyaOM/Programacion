import java.util.Scanner;

public class Ejercicio1 {

	public static void main(String[] args) {
		
		Scanner scanner = new Scanner(System.in);
		
		System.out.println("Escriba nombre de usuario");
		String nombre = scanner.nextLine();
		System.out.println("Escriba su apellido");
		String apellido = scanner.nextLine();
		System.out.println("Su nombre completo es: " + nombre + " " + apellido);
 
		scanner.close();
	}

}
