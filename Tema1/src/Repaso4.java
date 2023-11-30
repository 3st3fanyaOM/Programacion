import java.util.Scanner;

public class Repaso4 {

	public static void main(String[] args) {
		Scanner scanner = new Scanner(System.in);
		
		System.out.println("Escriba su número favorito");
		int numFav = scanner.nextInt();
		
		scanner.nextInt();
		
		System.out.println("Escriba su ciudad favorita");
		String ciudadFav = scanner.nextLine();
		
		scanner.close();

	}

}
