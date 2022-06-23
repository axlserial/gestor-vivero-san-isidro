package Entidades;

public class AbonoPago {
	private int idAbonosPago;
	private String fecha;
	private Double cantidad;

	public AbonoPago() {
		idAbonosPago = 0;
		fecha = "";
		cantidad = 0.0;
	}

	public AbonoPago crearObjeto(String[] datos) {
		return new AbonoPago();
	}

	// Getters y Setters
	public int getIdAbonosPago() {
		return idAbonosPago;
	}

	public void setIdAbonosPago(int idAbonosPago) {
		this.idAbonosPago = idAbonosPago;
	}

	public String getFecha() {
		return fecha;
	}

	public void setFecha(String fecha) {
		this.fecha = fecha;
	}

	public Double getCantidad() {
		return cantidad;
	}

	public void setCantidad(Double cantidad) {
		this.cantidad = cantidad;
	}

}
