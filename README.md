# Programacion
repositorio de programacion
package Arrays;

public class Ejer11 {

	public static void main(String[] args) {

		Integer[][] tabla = new Integer [5][10];
		
		for (int fila=0;fila<tabla.length;fila++) {
			for (int col =0;col<tabla[fila].length;col++) {
				Integer numero=1;
				tabla [fila][col]=numero;
				numero++;
				
			}
			
		}
		for (int fila=0;fila<5;fila++) {
			//System.out.println(tabla[fila]);
		
			for (int col =0;col<tabla[fila].length;col++) {
				
			}
			//System.out.println(tabla[col]);
		}
	}

}
