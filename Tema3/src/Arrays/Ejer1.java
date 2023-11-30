package Arrays;

public class Ejer1 {

	public static void main(String[] args) {
	
	Integer [] pares = new Integer [15];
	Integer posicion = 0;
	
	
	for (int num = 1;num<=30;num++) {
		if (num%2==0) {
			
			
			System.out.println("mi array de " + posicion + " es: "+(pares[posicion]= num));
			posicion++;
		}
	}

	}

}
