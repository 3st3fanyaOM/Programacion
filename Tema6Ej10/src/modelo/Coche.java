package modelo;

import java.math.BigDecimal;
import java.text.DecimalFormat;
import java.time.LocalDate;
import java.time.format.DateTimeFormatter;
import java.util.Objects;

public class Coche {
	
	private String matricula;
	private String marca;
	private BigDecimal precio;
	private LocalDate fechaCompra;
	
	public String getMatricula() {
		return matricula;
	}
	public void setMatricula(String matricula) {
		this.matricula = matricula;
	}
	public String getMarca() {
		return marca;
	}
	public void setMarca(String marca) {
		this.marca = marca;
	}
	public BigDecimal getPrecio() {
		return precio;
	}
	public void setPrecio(BigDecimal precio) {
		this.precio = precio;
	}
	public LocalDate getFechaCompra() {
		return fechaCompra;
	}
	public void setFechaCompra(LocalDate fechaCompra) {
		this.fechaCompra = fechaCompra;
	}
	
	@Override
	public String toString() {
		DecimalFormat formato = new DecimalFormat("#,###.00");
		DateTimeFormatter formatoF = DateTimeFormatter.ofPattern("dd/MM/yyyy");
		return "Coche [matricula=" + matricula + ", marca=" + marca + ", precio=" + formato.format(precio) + ", fechaCompra="
				+ fechaCompra.format(formatoF)+ "]";
	}
	@Override
	public int hashCode() {
		return Objects.hash(matricula);
	}
	@Override
	public boolean equals(Object obj) {
		if (this == obj)
			return true;
		if (obj == null)
			return false;
		if (getClass() != obj.getClass())
			return false;
		Coche other = (Coche) obj;
		return Objects.equals(matricula, other.matricula);
	}
	
	

}
