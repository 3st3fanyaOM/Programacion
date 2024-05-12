package app;

import java.sql.SQLException;
import java.time.LocalDate;
import java.time.format.DateTimeFormatter;
import java.time.format.DateTimeParseException;
import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

import modelo.Equipo;
import modelo.Jugador;
import services.EquipoServiceException;
import services.EquiposService;
import services.NotFoundException;

public class App {

	private static Scanner scanner;
	private static EquiposService service;

	public static void main(String[] args) {

		try {

			service = new EquiposService();
			scanner = new Scanner(System.in);

			int opc;
			do {
				opc = menu();
				switch (opc) {
				case 1:
					consultarEquipos();
					break;
				case 2:
					insertarEquipoCompleto();
					break;
				case 3:
					consultarEquipoPorCodigo();
					break;
				case 0:
					System.out.println("Bye!!");
					break;
				default:
					System.out.println("Opción no válida. Intente de nuevo.");
					break;
				}
			} while (opc != 0);

		} catch (EquipoServiceException e) {

			e.printStackTrace();
		} catch (NotFoundException e) {

			e.printStackTrace();
		} catch (SQLException e) {

			e.printStackTrace();
		} finally {
			scanner.close();
		}

	}

	private static void consultarEquipoPorCodigo() throws SQLException, NotFoundException, EquipoServiceException {
		System.out.println("Indica el código del equipo :");
		String codigo = scanner.nextLine();

		Equipo e;
		e = service.consultarEquipoCompleto(codigo);
		System.out.println(e);

		System.out.println("Elige una de estas opciones pata el equipo");

		int opcion;
		do {
			System.out.println("1. Ver plantilla del equipo");
			System.out.println("2. Borrar equipo");
			System.out.println("3. Añadir un jugador");
			System.out.println("4. Calcular edad media plantilla");
			System.out.println("5. Exportar plantilla del equipo a fichero");
			System.out.println("0. Volver al menú principal");
			opcion = scanner.nextInt();

			switch (opcion) {
			case 1:

				break;
			case 2:
				System.out.println("Indica el código del equipo:");
				String codigoEquipo = scanner.nextLine();

				service.borrarEquipoCompleto(codigoEquipo);

				break;
			case 3:

				break;
			case 4:

				break;
			case 5:

				break;
			case 0:
				break;
			default:
				System.out.println("Opción no válida. Intente de nuevo.");
				break;
			}

		} while (opcion != 0);
	}

	private static void insertarEquipoCompleto() throws EquipoServiceException, NotFoundException, SQLException {
		Boolean error = false;
		do {
			Equipo e = new Equipo();
			error = false;
			scanner.nextLine();
			System.out.println("Indica código del equipo :");
			e.setCodigo(scanner.nextLine());

			System.out.println("Indica nombre del equipo :");
			e.setNombre(scanner.nextLine());

			Jugador j = new Jugador();
			List<Jugador> jugadores = new ArrayList<>();
			String respuesta = "";
			do {
				System.out.println("Indica nombre del Jugador :");
				j.setNombre(scanner.nextLine());

				System.out.println("Indica fecha de nacimiento del Jugador :");
				String fecha = scanner.nextLine();
				DateTimeFormatter format = DateTimeFormatter.ofPattern("dd/MM/yyyy");
				LocalDate fechaNacimiento = null;

				fechaNacimiento = LocalDate.parse(fecha, format);

				jugadores.add(j);

				System.out.println("¿Deseas añadir otro Jugador?");
				respuesta = scanner.nextLine();
			} while (!respuesta.equalsIgnoreCase("n"));

			service.crearEquipo(e);
			System.out.println("Equipo guardado!!");

		} while (error);
	}

	private static void consultarEquipos() throws EquipoServiceException {

		service.consultarEquipos();

	}

	private static int menu() {
		int opc;
		System.out.println("Menú:");
		System.out.println("1. Ver todos los equipos registrados");
		System.out.println("2. Crear nuevo equipo");
		System.out.println("3. Consultar equipo por su codigo");
		System.out.println("0. Salir");
		System.out.print("Seleccione una opción: ");
		opc = scanner.nextInt();
		return opc;

	}
}
