package modelo;

import java.time.LocalDate;

public class Jugador {
	private Integer numero;
	private String codigo_equipo;
	private String nombre;
	private LocalDate fecha_nacimiento;

	public Integer getNumero() {
		return numero;
	}

	public void setNumero(Integer numero) {
		this.numero = numero;
	}

	public String getCodigo_equipo() {
		return codigo_equipo;
	}

	public void setCodigo_equipo(String codigo_equipo) {
		this.codigo_equipo = codigo_equipo;
	}

	public String getNombre() {
		return nombre;
	}

	public void setNombre(String nombre) {
		this.nombre = nombre;
	}

	public LocalDate getFecha_nacimiento() {
		return fecha_nacimiento;
	}

	public void setFecha_nacimiento(LocalDate fecha_nacimiento) {
		this.fecha_nacimiento = fecha_nacimiento;
	}

	@Override
	public String toString() {
		return "Jugador [numero=" + numero + ", codigo_equipo=" + codigo_equipo + ", nombre=" + nombre
				+ ", fecha_nacimiento=" + fecha_nacimiento + "]";
	}

}
