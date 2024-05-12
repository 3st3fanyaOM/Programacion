package servicios;

import java.sql.Connection;
import java.sql.Date;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

import modelo.Coche;

public class CocheService {

	private OpenConnection openConn;

	public CocheService() {
		openConn = new OpenConnection();
	}

	public void insertarCoche(Coche c) throws SQLException {
		String sql = "INSERT INTO COCHES VALUES (?, ?, ?, ?)";
		
		try (Connection conn = openConn.getNewConnection(); PreparedStatement stmt = conn.prepareStatement(sql)) {
			
			stmt.setString(1, c.getMatricula());
			stmt.setString(2, c.getMarca());
			stmt.setBigDecimal(3, c.getPrecio());
			stmt.setDate(4, Date.valueOf(c.getFechaCompra()));
			
			stmt.execute();
		}
	}
	
	public void actualizarCoche(Coche c) throws SQLException {
		String sql = "UPDATE COCHES SET MATRICULA = ?, MARCA= ?, PRECIO=  ?, FECHA_HORA_COMPRA= ?";
		
		try (Connection conn = openConn.getNewConnection(); PreparedStatement stmt = conn.prepareStatement(sql)) {
			
			stmt.setString(1, c.getMatricula());
			stmt.setString(2, c.getMarca());
			stmt.setBigDecimal(3, c.getPrecio());
			stmt.setDate(4, Date.valueOf(c.getFechaCompra()));
			
			stmt.execute();
		}
	}
	
	public void borrarCoche(Coche c) throws SQLException {
		String sql = "DELETE FROM COCHES WHERE MATRICULA = ?";
		
		try (Connection conn = openConn.getNewConnection(); PreparedStatement stmt = conn.prepareStatement(sql)) {
			
			stmt.setString(1, c.getMatricula());
			
			stmt.execute();
		}
	}
	
	public Coche consultarCoche(String matricula) throws SQLException {
		String sql = "SELECT * FROM COCHES WHERE MATRICULA = ?";
		Coche c = new Coche();
		try (Connection conn = openConn.getNewConnection(); PreparedStatement stmt = conn.prepareStatement(sql)) {
			
			stmt.setString(1, matricula);
			
			ResultSet rs = stmt.executeQuery();
			
			if(rs.next()) {
				c = getCocheFromResultSet(rs);
			}
			
			return c;
		}
	}
	
	public List<Coche> buscarCoches(String marca) throws SQLException {
		String sql = "SELECT * FROM COHES WHERE MARCA = ?";
		List<Coche> coches= new ArrayList<Coche>();
		try (Connection conn = openConn.getNewConnection(); PreparedStatement stmt = conn.prepareStatement(sql)) {
			
			stmt.setString(1, marca);
			
			ResultSet rs = stmt.executeQuery();			
			
			while(rs.next()) {
				Coche c = getCocheFromResultSet(rs);
				
				coches.add(c);
			}
		}
		return coches;
		
	}

	private Coche getCocheFromResultSet(ResultSet rs) throws SQLException {
		Coche c = new Coche();
		c.setMatricula(rs.getString("MATRICULA"));
		c.setMarca(rs.getString("MARCA"));
		c.setPrecio(rs.getBigDecimal("PRECIO"));
		c.setFechaCompra(rs.getDate("FECHA_HORA_COMPRA").toLocalDate());
		return c;
	}
}
