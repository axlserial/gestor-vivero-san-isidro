package conexiones;

import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;

import Entidades.Pedido;
import Entidades.Planta;
import resources.CreaConexion;

public class ConexionPedido {
	private CreaConexion crea;
	private Statement conexion;

	public ConexionPedido() {
		crea = new CreaConexion();
		conexion = crea.getStatement();
	}

	public Boolean registrarPedido(Pedido pedido) {
		String consulta = "";
		consulta = "INSERT INTO pedidos (idCliente, fechaPedido, fechaAproximada) VALUES ";
		consulta += "(" + pedido.getCliente().getIdCliente() + ", '" + pedido.getFechaPedido() + "', '"
				+ pedido.getFechaAproximada() + "')";
		try {
			conexion.executeUpdate(consulta);
			ResultSet inserts = conexion.getGeneratedKeys();

			// Agregar Abono Pago
			consulta = "INSERT INTO abonosPago (fecha, cantidad, idPedido) VALUES ";
			consulta += "('" + pedido.getPagos()[0].getFecha() + "', " + pedido.getPagos()[0].getCantidad() + ", "
					+ inserts.getInt(1) + ")";
			conexion.executeUpdate(consulta);

			// Agregar Plantas
			Planta plantas[] = pedido.getPlantas();
			for (Planta planta : plantas) {
				consulta = "INSERT INTO plantaPedido (idTipoHortaliza, variedad, numeroCharolas, idPedido, precio) VALUES";
				consulta += "(" + planta.getIdTipoHortaliza() + ", '" + planta.getVariedad() + "', "
						+ planta.getNumeroCharolas() + ", " + inserts.getInt(1) + ", " + planta.getPrecio() + ")";
				conexion.executeUpdate(consulta);
			}
			return true;
		} catch (SQLException e) {
			System.err.println(e);
			System.err.println("Consulta: " + consulta);
			return false;
		}
	}

	public ResultSet buscarPedido(String nombre) {
		String consulta = "";
		consulta = "SELECT * FROM pedidos WHERE nombres LIKE '%" + nombre + "%'";
		try {
			return conexion.executeQuery(consulta);
		} catch (SQLException e) {
			System.err.println(e);
			return null;
		}
	}

	public Boolean modificarPedido(Pedido pedido) {
		return true;
	}

	public Boolean eliminarPedido(int id) {
		return true;
	}
}
