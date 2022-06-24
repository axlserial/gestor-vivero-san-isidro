package Entidades;

public class Planta {
	
	private int idPlanta;
	private int idTipoHortaliza;
	private String variedad;
	private int numeroCharolas;
	private Double precio;

	public Planta() {
		idPlanta = 0;
		idTipoHortaliza = 0;
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

	public int getIdTipoHortaliza() {
		return idTipoHortaliza;
	}

	public void setTipoHortaliza(int idTipoHortaliza) {
		this.idTipoHortaliza = idTipoHortaliza;
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
