package services;

import java.io.FileWriter;
import java.io.IOException;
import java.sql.Connection;
import java.sql.Date;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.time.format.DateTimeFormatter;
import java.util.ArrayList;
import java.util.List;

import modelo.Equipo;
import modelo.Jugador;
import oracle.jdbc.driver.OracleSQLException;

public class EquiposService {

	private OpenConnection openConn;

	public EquiposService() {
		openConn = new OpenConnection();
	}

	public List<Equipo> consultarEquipos() throws EquipoServiceException {
		List<Equipo> equipos = new ArrayList<>();
		ResultSet rs = null;
		try (Connection conn = openConn.getNewConnection(); Statement stmt = conn.createStatement()) {
			String sql = "SELECT * FROM EQUIPO";
			rs = stmt.executeQuery(sql);

			while (rs.next()) {
				Equipo e = new Equipo();
				e.setCodigo(rs.getString("CODIGO"));
				e.setNombre(rs.getString("NOMBRE"));

				equipos.add(e);

			}
		} catch (SQLException e) {
			throw new EquipoServiceException();
		}
		return equipos;
	}

	public List<Jugador> consultarJugadoresEquipo(String codigo) throws SQLException {
		ResultSet rs = null;
		List<Jugador> resultados = new ArrayList<>();
		String sql = "SELECT * FROM jugador WHERE CODIGO_EQUIPO = ?";
		try (Connection conn = openConn.getNewConnection(); PreparedStatement stmt = conn.prepareStatement(sql)) {

			stmt.setString(1, codigo);
			rs = stmt.executeQuery();

			while (rs.next()) {
				Jugador j = new Jugador();
				j.setNumero(rs.getInt("NUMERO"));
				j.setCodigo_equipo(rs.getString("CODIGO_EQUIPO"));
				j.setNombre(rs.getString("NOMBRE"));
				j.setFecha_nacimiento(rs.getDate("FECHA_NACIMIENTO").toLocalDate());

				resultados.add(j);
			}
		}
		return resultados;

	}

	public Equipo consultarEquipoCompleto(String codigo)
			throws SQLException, NotFoundException, EquipoServiceException {
		List<Jugador> jugadores = new ArrayList<>();
		Equipo e = null;

		try (Connection conn = openConn.getNewConnection()) {
			e = consultarEquipoCodigo(conn, codigo);
			if (e == null) {
				throw new EquipoServiceException("Hay algun problema con el equipo");
			}
			jugadores = consultarJugadoresEquipo(codigo);
			e.setJugadores(jugadores);
		}
		return e;

	}

	private Equipo consultarEquipoCodigo(Connection conn, String codigo)
			throws NotFoundException, EquipoServiceException, SQLException {
		Equipo e = new Equipo();
		ResultSet rs = null;
		String sql = "SELECT * FROM equipo WHERE CODIGO_EQUIPO = ?";
		try (PreparedStatement stmt = conn.prepareStatement(sql)) {
			stmt.setString(1, codigo);
			rs = stmt.executeQuery();

			while (rs.next()) {
				e.setCodigo(rs.getString("CODIGO"));
				e.setNombre(rs.getString("NOMBRE"));
			}
		}
		return e;
	}

	public void insertarJugador(Connection conn, Jugador j) throws SQLException {

		String sql = "INSERT INTO JUGADOR VALUES (?, ?, ?, ?)";
		try (PreparedStatement stmt = conn.prepareStatement(sql)) {

			stmt.setInt(1, j.getNumero());
			stmt.setString(2, j.getCodigo_equipo());
			stmt.setString(3, j.getNombre());
			stmt.setDate(4, Date.valueOf(j.getFecha_nacimiento()));

			stmt.execute();
		}

	}

	public void crearEquipo(Equipo e) throws EquipoServiceException, NotFoundException, SQLException {

		try (Connection conn = openConn.getNewConnection()) {

			conn.setAutoCommit(false);

			try {
				System.out.println("Inserta equipo");
				String sql = "INSERT INTO EQUIPOS VALUES (?, ?)";
				try (PreparedStatement stmt = conn.prepareStatement(sql)) {

					stmt.setString(1, "CODIGO");
					stmt.setString(2, "NOMBRE");

					stmt.execute();
				}

				for (int i = 0; i < e.getJugadores().size(); i++) {
					System.out.println("Inserta jugador");
					insertarJugador(conn, e.getJugadores().get(i));
				}

				conn.commit();

			} catch (SQLException i) {
				try {
					conn.rollback();
				} catch (SQLException e1) {

					e1.printStackTrace();
				}
				i.printStackTrace();
				throw new EquipoServiceException("Error al insertar el jugador");
			}
		}
	}

	public void añadirJugadorAlEquipo(Equipo e, Jugador j) throws EquipoServiceException {

		try (Connection conn = openConn.getNewConnection()) {

			List<Jugador> jugadores = consultarJugadoresEquipo(e.getCodigo());

			j.setNumero(jugadores.size() + 1);
			j.setCodigo_equipo(e.getCodigo());

			insertarJugador(conn, j);

		} catch (SQLException e1) {
			throw new EquipoServiceException();
		}

	}

	public void borrarEquipoCompleto(String codigo) throws SQLException, NotFoundException {

		try (Connection conn = openConn.getNewConnection()) {

			conn.setAutoCommit(false);

			try {
				borrarJugador(codigo, conn);
				Boolean borrado = borrarEquipo(codigo, conn);
				conn.commit();

				if (borrado = false) {
					conn.rollback();
					throw new NotFoundException();
				}

			} catch (SQLException e) {
				conn.rollback();

			}

		}
	}

	private void borrarJugador(String codigo, Connection conn) throws SQLException {
		String sql = "delete from jugador where numero = codigo";
		try (PreparedStatement stmt = conn.prepareStatement(sql)) {

			stmt.setString(1, codigo);
			stmt.execute();
		}
	}

	private Boolean borrarEquipo(String codigo, Connection conn) throws SQLException {
		Boolean borrado = false;
		String sql = "DELETE FROM EQUIPO WHERE CODIGO = ?";
		try (PreparedStatement stmt = conn.prepareStatement(sql)) {

			stmt.setString(1, codigo);
			borrado = stmt.execute();
		}
		return borrado;
	}

	public void exportarJugadores(String codigo, String ruta)
			throws SQLException, NotFoundException, EquipoServiceException {
		try (Connection conn = openConn.getNewConnection()) {
			List<Jugador> jugadores = consultarJugadoresEquipo(codigo);
			try {
				FileWriter fichero = new FileWriter(ruta);
				for (Jugador jugador : jugadores) {
					DateTimeFormatter formato = DateTimeFormatter.ofPattern("dd/MM/yyyy");
					fichero.write(jugador.getNumero() + " - " + jugador.getNombre() + " - "
							+ jugador.getFecha_nacimiento().format(formato));
				}
			} catch (IOException e) {
				e.printStackTrace();
			}
		} catch (SQLException e) {
			throw new NotFoundException();
		} catch (Exception e1) {
			throw new EquipoServiceException();
		}

	}

}
