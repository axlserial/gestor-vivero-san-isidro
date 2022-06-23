package Entidades;

public class Planta {
	
	private int idPlanta;
	private String tipoHortaliza;
	private String variedad;
	private int numeroCharolas;
	private Double precio;

	public Planta() {
		idPlanta = 0;
		tipoHortaliza = "";
		variedad = "";
		numeroCharolas = 0;
		precio = 0.0;
	}

	public Planta crearObjeto(String[] datos) {
		return new Planta();
	}

	// Getters y Setters
	public int getIdPlanta() {
		return idPlanta;
	}

	public void setIdPlanta(int idPlanta) {
		this.idPlanta = idPlanta;
	}

	public String getTipoHortaliza() {
		return tipoHortaliza;
	}

	public void setTipoHortaliza(String tipoHortaliza) {
		this.tipoHortaliza = tipoHortaliza;
	}

	public String getVariedad() {
		return variedad;
	}

	public void setVariedad(String variedad) {
		this.variedad = variedad;
	}

	public int getNumeroCharolas() {
		return numeroCharolas;
	}

	public void setNumeroCharolas(int numeroCharolas) {
		this.numeroCharolas = numeroCharolas;
	}

	public Double getPrecio() {
		return precio;
	}

	public void setPrecio(Double precio) {
		this.precio = precio;
	}

}
