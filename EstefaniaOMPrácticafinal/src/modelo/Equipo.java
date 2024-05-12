package modelo;

import java.math.BigDecimal;
import java.math.RoundingMode;
import java.time.LocalDate;
import java.time.Period;
import java.util.ArrayList;
import java.util.List;

public class Equipo {
	private String codigo;
	private String nombre;
	private List<Jugador> jugadores;

	public Equipo() {
		this.jugadores = new ArrayList<>();
	}

	public String getCodigo() {
		return codigo;
	}

	public void setCodigo(String codigo) {
		this.codigo = codigo;
	}

	public String getNombre() {
		return nombre;
	}

	public void setNombre(String nombre) {
		this.nombre = nombre;
	}

	public List<Jugador> getJugadores() {
		return jugadores;
	}

	public void setJugadores(List<Jugador> jugadores) {
		this.jugadores = jugadores;
	}

	@Override
	public String toString() {
		return "EQUIPO: " + codigo + " / " + nombre;
	}

	public BigDecimal getEdadMedia() {
		LocalDate hoy = LocalDate.now();
		BigDecimal totalAños = BigDecimal.ZERO;
		for (Jugador jugador : jugadores) {
			Period periodo = jugador.getFecha_nacimiento().until(hoy);
			Integer años = periodo.getYears();
			totalAños = totalAños.add(new BigDecimal(años));

		}
		return totalAños.divide(new BigDecimal(jugadores.size())).setScale(2, RoundingMode.HALF_UP);

	}
}
