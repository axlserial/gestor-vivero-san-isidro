package controladores;

import java.sql.ResultSet;
import java.sql.SQLException;
import java.time.LocalDate;
import java.util.ArrayList;

import Entidades.AbonoPago;
import Entidades.Cliente;
import Entidades.Pedido;
import Entidades.Planta;
import conexiones.ConexionAbono;
import conexiones.ConexionClientes;
import conexiones.ConexionPedido;
import conexiones.ConexionPlantas;
import interfaces.BusquedaRegistrarAbono;
import interfaces.FormularioRegistrarAbono;
import javafx.geometry.Pos;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.scene.control.Label;
import javafx.scene.layout.HBox;
import javafx.scene.layout.VBox;
import javafx.scene.text.Font;
import javafx.stage.Stage;

public class ControladorAbono {

	private BusquedaRegistrarAbono interfazBusqueda;
	private ArrayList<Pedido> pedidos;

	private final ConexionPedido conexionPedido = new ConexionPedido();
	private final ConexionClientes conexionClientes = new ConexionClientes();
	private final ConexionAbono conexionAbono = new ConexionAbono();
	private final ConexionPlantas conexionPlantas = new ConexionPlantas();

	public ControladorAbono(Stage escenario, Scene anterior) {
		interfazBusqueda = new BusquedaRegistrarAbono();
		pedidos = new ArrayList<Pedido>();

		interfazBusqueda.principal.setOnAction(e -> {
			escenario.setScene(anterior);
		});

		interfazBusqueda.regresar.setOnAction(e -> {
			escenario.setScene(anterior);
		});

		interfazBusqueda.buscar.setOnAction(e -> {
			// Aqui se realiza la busqueda y se guarda en el arraylist pedidos
			String nombre = interfazBusqueda.busqueda.getText();
			String fechaIni = interfazBusqueda.fechaInicial.getValue().toString();
			String fechaFin = interfazBusqueda.fechaFinal.getValue().toString();
			pedidos = buscarPedidos(nombre, fechaIni, fechaFin);

			// Establece cantidad de páginas
			int paginas = pedidos.size() / 4;
			if (paginas == 0)
				paginas = 1;
			else
				paginas = pedidos.size() % 2 == 0 ? paginas : paginas + 1;
			interfazBusqueda.pag.setPageCount(paginas + 1);
		});

		interfazBusqueda.pag.setPageFactory((indice) -> {
			return creaPagina(indice);
		});

	}

	public VBox creaPagina(int indice) {
		HBox datos;
		VBox box = new VBox();
		box.setAlignment(Pos.CENTER);
		box.setSpacing(20);

		int indiceInicial = indice * 4, indiceFinal;
		if (indiceInicial == 0)
			indiceFinal = pedidos.size() <= 4 ? pedidos.size() : 4;
		else
			indiceFinal = pedidos.size() - indiceInicial;

		// Llena vbox con datos de lso resultados de pedidos
		for (int i = 0; i < indiceFinal; i++, indiceInicial++) {
			int indicePedido = indiceInicial;
			Pedido actual = pedidos.get(indiceInicial);
			datos = new HBox();
			datos.setAlignment(Pos.CENTER);
			datos.setSpacing(20);

			Label info = new Label("Pedido #" + actual.getIdPedido() + " - Fecha: " + actual.getFechaPedido());
			info.setFont(new Font("Segoe UI", 18.0));

			Button regAbono = new Button("Registrar abono");
			regAbono.setOnAction(e -> {
				modificar(indicePedido);
			});

			datos.getChildren().addAll(info, regAbono);
			box.getChildren().add(datos);
		}

		return box;
	}

	private void modificar(int indice) {
		Pedido pedido = this.pedidos.get(indice);
		// aqui se abre ventana para agregar abono
		FormularioRegistrarAbono ff = new FormularioRegistrarAbono();
		Scene escenaAbonar = ff.abrir(pedido);
		Stage ventana = new Stage();
		ventana.setScene(escenaAbonar);

		ff.cancelar.setOnAction(e -> {
			ventana.close();
		});

		ff.registrar.setOnAction(e -> {
			boolean contenido = true;
			Double precio = Double.parseDouble("0.0");

			if (ff.pago.getText().isEmpty()) {
				ff.mensajes.error("Abono vacío");
				contenido = false;
			} else {
				try {
					precio = Double.parseDouble(ff.pago.getText());
				} catch (Exception exp) {
					ff.mensajes.error("Valor incorrecto");
					contenido = false;
				}
			}

			// Pasó varificación
			if (!contenido)
				return;

			// insersión del abono
			AbonoPago nuevoAbono = new AbonoPago();
			nuevoAbono.setCantidad(precio);
			nuevoAbono.setFecha(LocalDate.now().toString());	// sacar fecha
			if (!conexionAbono.registrarAbono(nuevoAbono, pedido.getIdPedido())) {
				ff.mensajes.error("Error al Intentar Registrar el Abono");
				return;
			}
			conexionAbono.cerrarConexion();
			AbonoPago pagos[] = pedido.getPagos();
			AbonoPago nuevos[] = new AbonoPago[pagos.length + 1];
			for (int i = 0; i < pagos.length; i++) {
				nuevos[i] = pagos[i];
			}
			nuevos[pagos.length] = nuevoAbono;
			pedido.setPagos(nuevos);

			// mensaje de exito
			ff.mensajes.mensaje("Registro correcto");
			ventana.close();
		});

		ventana.showAndWait();
	}

	public Scene getScene() {
		return interfazBusqueda.getScene();
	}

	private ArrayList<Pedido> buscarPedidos(String nombres, String fechaInicial, String fechaFinal) {
		ResultSet resultado = conexionPedido.buscarPedido(nombres, fechaInicial, fechaFinal);
		ArrayList<Pedido> res = null;
		if (resultado != null) {
			res = new ArrayList<Pedido>();
			try {
				// Recorrer Pedidos
				while (resultado.next()) {
					Pedido aux = new Pedido();
					aux.setIdPedido(resultado.getInt("idPedido"));
					aux.setFechaPedido(resultado.getString("fechaPedido"));
					Cliente clienteAux = new Cliente();
					ArrayList<AbonoPago> abonos = new ArrayList<AbonoPago>();
					ArrayList<Planta> plantas = new ArrayList<Planta>();

					// ObtenerCliente
					ResultSet clienteRes = conexionClientes.obtenerCliente(resultado.getInt("idCliente"));
					clienteAux.setIdCliente(clienteRes.getInt("idCliente"));
					clienteAux.setNombre(clienteRes.getString("nombres"));
					clienteAux.setApellidos(clienteRes.getString("apellidos"));
					clienteAux.setPoblacion(clienteRes.getString("poblacion"));
					String telefonos[] = { clienteRes.getString("telefono1"), clienteRes.getString("telefono2") };
					clienteAux.setTelefonos(telefonos);
					aux.setCliente(clienteAux);
					conexionClientes.cerrarConexion();

					// ObtenerPagos
					ResultSet abonosRes = conexionAbono.obtenerAbonosDePedido(resultado.getInt("idPedido"));
					while (abonosRes.next()) {
						AbonoPago abonoAux = new AbonoPago();
						abonoAux.setIdAbonosPago(abonosRes.getInt("idAbonosPago"));
						abonoAux.setFecha(abonosRes.getString("fecha"));
						abonoAux.setCantidad(abonosRes.getDouble("cantidad"));
						abonos.add(abonoAux);
					}
					aux.setPagos(abonos.toArray(new AbonoPago[0]));
					conexionAbono.cerrarConexion();

					// Obtener Plantas
					ResultSet plantasRes = conexionPlantas.obtenerPlantasDePedido(resultado.getInt("idPedido"));
					while (plantasRes.next()) {
						Planta plantaAux = new Planta();
						plantaAux.setIdPlanta(plantasRes.getInt("idPlantaPedido"));
						plantaAux.setTipoHortaliza(plantasRes.getInt("idTipoHortaliza"));
						plantaAux.setVariedad(plantasRes.getString("variedad"));
						plantaAux.setNumeroCharolas(plantasRes.getInt("numeroCharolas"));
						plantaAux.setPrecio(plantasRes.getDouble("precio"));
						plantas.add(plantaAux);
					}
					aux.setPlantas(plantas.toArray(new Planta[0]));
					res.add(aux);
					conexionPlantas.cerrarConexion();
				}
				conexionPedido.cerrarConexion();
			} catch (SQLException e) {
				e.printStackTrace();
			}
		}

		return res;
	}
}
