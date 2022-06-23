package Entidades;

public class Cliente {
	private int idCliente;
	private String nombre;
	private String apellidos;
	private String[] telefonos;
	private String poblacion;

	public Cliente() {
		idCliente = 0;
		nombre = "";
		apellidos = "";
		telefonos = new String[2];
		poblacion = "";
	}

	public Cliente crearObjeto(int id, String[] datos) {
		Cliente cliente = new Cliente();
		cliente.idCliente = id;
		cliente.nombre = datos[0];
		cliente.apellidos = datos[1];
		cliente.telefonos[0] = datos[2];
		cliente.telefonos[1] = datos[3];
		cliente.poblacion = datos[4];
		return cliente;
	}

	// Getters y Setters
	public int getIdCliente() {
		return idCliente;
	}

	public void setIdCliente(int idCliente) {
		this.idCliente = idCliente;
	}

	public String getNombre() {
		return nombre;
	}

	public void setNombre(String nombre) {
		this.nombre = nombre;
	}

	public String getApellidos() {
		return apellidos;
	}

	public void setApellidos(String apellidos) {
		this.apellidos = apellidos;
	}

	public String[] getTelefonos() {
		return telefonos;
	}

	public void setTelefonos(String[] telefonos) {
		this.telefonos = telefonos;
	}

	public String getPoblacion() {
		return poblacion;
	}

	public void setPoblacion(String poblacion) {
		this.poblacion = poblacion;
	}

}
