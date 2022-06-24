package controladores;

import java.sql.ResultSet;
import java.sql.SQLException;
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
import javafx.scene.Node;
import javafx.scene.Scene;
import javafx.scene.layout.VBox;
import javafx.stage.Stage;
import javafx.util.Callback;

public class ControladorAbono {

	private BusquedaRegistrarAbono interfazBusqueda;

	private final ConexionPedido conexionPedido = new ConexionPedido();
	private final ConexionClientes conexionClientes = new ConexionClientes();
	private final ConexionAbono conexionAbono = new ConexionAbono();
	private final ConexionPlantas conexionPlantas = new ConexionPlantas();
	
	public ControladorAbono(Stage escenario, Scene anterior) {
		interfazBusqueda = new BusquedaRegistrarAbono();

		interfazBusqueda.principal.setOnAction(e -> {
			escenario.setScene(anterior);
		});

		interfazBusqueda.regresar.setOnAction(e -> {
			escenario.setScene(anterior);
		});

		interfazBusqueda.buscar.setOnAction(e -> {
			// busqueda
		});

		interfazBusqueda.pag.setPageFactory(new Callback<Integer, Node>() {
            @Override
            public Node call(Integer index) {
                return creaPagina(index);
            }
        });
	}

    public VBox creaPagina(int indice) {
		VBox box = new VBox();

        int itemsPorPagina = 4;
        int pagina = indice * itemsPorPagina;         

        return box;
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
				while(resultado.next()) {
					Pedido aux = new Pedido();
					Cliente clienteAux = new Cliente();
					ArrayList<AbonoPago> abonos = new ArrayList<AbonoPago>();
					ArrayList<Planta> plantas = new ArrayList<Planta>();

					// ObtenerCliente
					ResultSet clienteRes = conexionClientes.obtenerCliente(resultado.getInt("idCliente"));
					clienteAux.setIdCliente(clienteRes.getInt("idCliente"));
					clienteAux.setNombre(clienteRes.getString("nombres"));
					clienteAux.setApellidos(clienteRes.getString("apellidos"));
					clienteAux.setPoblacion(clienteRes.getString("poblacion"));
					String telefonos[] = {clienteRes.getString("telefono1"), clienteRes.getString("telefono2")};
					clienteAux.setTelefonos(telefonos);
					aux.setCliente(clienteAux);

					// ObtenerPagos
					ResultSet abonosRes = conexionAbono.obtenerAbonosDePedido(resultado.getInt("idPedido"));
					while(abonosRes.next()) {
						AbonoPago abonoAux = new AbonoPago();
						abonoAux.setIdAbonosPago(abonosRes.getInt("idAbonosPago"));
						abonoAux.setFecha(abonosRes.getString("fecha"));
						abonoAux.setCantidad(abonosRes.getDouble("cantidad"));
						abonos.add(abonoAux);
					}
					aux.setPagos(abonos.toArray(new AbonoPago[0]));

					// Obtener Plantas
					ResultSet plantasRes = conexionPlantas.obtenerPlantasDePedido(resultado.getInt("idPedido"));
					while(plantasRes.next()) {
						Planta plantaAux = new Planta();
						plantaAux.setIdPlanta(plantasRes.getInt("idPlantaPedido"));
						plantaAux.setTipoHortaliza(plantasRes.getInt("idTipoHortaliza"));
						plantaAux.setVariedad(plantasRes.getString("variedad"));
						plantaAux.setNumeroCharolas(plantasRes.getInt("numeroCharolas"));
						plantaAux.setPrecio(plantasRes.getDouble("precio"));
						plantas.add(plantaAux);
					}
					aux.setPlantas(plantas.toArray(new Planta[0]));
				}
			} catch (SQLException e) {
				e.printStackTrace();
			}
		}

		return res;
	}
}
