package Entidades;

public class Pedido {
	private int idPedido;
	private String fechaSiembra;
	private Cliente cliente;
	private String fechaPedido;
	private String fechaAproximada;
	private String fechaEntrega;
	private Planta[] plantas;
	private AbonoPago[] pagos;

	public Pedido() {
		idPedido = 0;
		fechaSiembra = "";
		cliente = new Cliente();
		fechaPedido = "";
		fechaAproximada = "";
		fechaEntrega = "";
		plantas = new Planta[2];
		pagos = new AbonoPago[2];
	}

	public Pedido crearObjeto(String[] datos) {
		return new Pedido();
	}

	// Getters y Setters
	public int getIdPedido() {
		return idPedido;
	}

	public void setIdPedido(int idPedido) {
		this.idPedido = idPedido;
	}

	public String getFechaSiembra() {
		return fechaSiembra;
	}

	public void setFechaSiembra(String fechaSiembra) {
		this.fechaSiembra = fechaSiembra;
	}

	public Cliente getCliente() {
		return cliente;
	}

	public void setCliente(Cliente cliente) {
		this.cliente = cliente;
	}

	public String getFechaPedido() {
		return fechaPedido;
	}

	public void setFechaPedido(String fechaPedido) {
		this.fechaPedido = fechaPedido;
	}

	public String getFechaAproximada() {
		return fechaAproximada;
	}

	public void setFechaAproximada(String fechaAproximada) {
		this.fechaAproximada = fechaAproximada;
	}

	public String getFechaEntrega() {
		return fechaEntrega;
	}

	public void setFechaEntrega(String fechaEntrega) {
		this.fechaEntrega = fechaEntrega;
	}

	public Planta[] getPlantas() {
		return plantas;
	}

	public void setPlantas(Planta[] plantas) {
		this.plantas = plantas;
	}

	public AbonoPago[] getPagos() {
		return pagos;
	}

	public void setPagos(AbonoPago[] pagos) {
		this.pagos = pagos;
	}

}
