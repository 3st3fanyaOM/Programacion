package app;

import java.sql.SQLException;
import java.time.LocalDate;
import java.time.format.DateTimeFormatter;
import java.time.format.DateTimeParseException;
import java.util.List;
import java.util.Scanner;

import modelo.Coche;
import servicios.CocheService;

public class App {

	private static Scanner scanner;
	private static CocheService service;

	public static void main(String[] args) {

		try {
			service = new CocheService();
			scanner = new Scanner(System.in);

			String opcionElegida = "";

			do {

				opcionElegida = mostrarMenu();

				switch (opcionElegida) {
				case "1":
					insertarCoche();

					break;

				case "2":
					Coche c = solicitarDatosCoche();
					service.actualizarCoche(c);
					break;

				case "3":
					c = solicitarDatosCoche();
					service.borrarCoche(c);
					break;

				case "4": {
					System.out.println("Dime matricula");
					String matricula = scanner.nextLine();
					c = service.consultarCoche(matricula);
					System.out.println(c);
					break;
				}
				case "5": {
					System.out.println("Dime marca");
					String marca = scanner.nextLine();
					
					List<Coche> coches  = service.buscarCoches(marca);
					for(Coche coche : coches) {
						System.out.println(coche);
					}
					break;
				}

				case "0":
					System.err.println("Bye!!");
					break;
				default:
					System.out.println("La opcion elegida no es correcta");
				}

			} while (!opcionElegida.equals("0"));

		} catch (SQLException e) {
			System.out.println(e.getMessage());
		} finally {
			scanner.close();
		}
	}

	private static void insertarCoche() throws SQLException {
		Coche c = solicitarDatosCoche();

		service.insertarCoche(c);
	}

	private static Coche solicitarDatosCoche() {
		Coche c = new Coche();
		System.out.println("Dime matricula");
		c.setMatricula(scanner.nextLine());

		System.out.println("Dime la marca");
		c.setMarca(scanner.nextLine());

		System.out.println("Dime precio");
		c.setPrecio(scanner.nextBigDecimal());
		scanner.nextLine();

		System.out.println("Dime la fecha de compra");
		String fecha = scanner.nextLine();
		DateTimeFormatter formato = DateTimeFormatter.ofPattern("dd/MM/yyyy");
		
		try {
			LocalDate fechaCompra = LocalDate.parse(fecha, formato);
			c.setFechaCompra(fechaCompra);
		} catch (DateTimeParseException e) {
			System.out.println("La fecha indicada no es correcta");
		}

		c.setFechaCompra(LocalDate.parse(fecha, formato));
		return c;
	}

	private static String mostrarMenu() {

		System.out.println("-----------------------------");
		System.out.println("Elige una de estas opciones: ");
		System.out.println("\t (1) Insertar coche");
		System.out.println("\t (2) Actualizar coche");
		System.out.println("\t (3) Borrar coche");
		System.out.println("\t (4) Consultar coche");
		System.out.println("\t (5) Buscar coche");
		System.out.println("\t (0) Salir");
		System.out.println("-----------------------------");
		String opcion = scanner.nextLine();

		return opcion;
	}

}
