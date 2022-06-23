package conexiones;

import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;

import Entidades.Pedido;
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
		consulta += "()";
		try {
			conexion.executeUpdate(consulta);
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
