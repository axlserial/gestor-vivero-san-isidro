package conexiones;

import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;

import Entidades.AbonoPago;
import resources.CreaConexion;

public class ConexionAbono {
	private CreaConexion crea;
	private Statement conexion;

	public ConexionAbono() {
		crea = new CreaConexion();
		conexion = crea.getStatement();
	}

	public ResultSet obtenerAbonosDePedido(int idPedido) {
		String consulta = "";
		consulta = "SELECT * FROM abonosPago WHERE idPedido=" + idPedido;
		try {
			ResultSet resultado = conexion.executeQuery(consulta);
			return resultado;
		} catch (SQLException e) {
			e.printStackTrace();
			return null;
		}
	}

	public Boolean registrarAbono(AbonoPago abono, int idPedido) {
		String consulta = "";
		consulta = "INSERT INTO abonosPago (fecha, cantidad, idPedido) VALUES ";
		consulta += "('" + abono.getFecha() + "', " + abono.getCantidad() + ", " + idPedido + ")";
		try {
			conexion.executeUpdate(consulta);
			return true;
		} catch (SQLException e) {
			System.err.println(e);
			System.err.println("Consulta: " + consulta);
			return false;
		}
	}
}
