package conexiones;

import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;

import resources.CreaConexion;

public class ConexionPlantas {
	private CreaConexion crea;
	private Statement conexion;

	public ConexionPlantas() {
		crea = new CreaConexion();
	}

	public ResultSet obtenerPlantasDePedido(int idPedido) {
		conexion = crea.abrirConexion();
		String consulta = "";
		consulta = "SELECT * FROM plantaPedido as PP INNER JOIN tipoHortaliza TH ON PP.idTipoHortaliza=TH.idTipoHortaliza WHERE PP.idPedido="
				+ idPedido;
		try {
			ResultSet resultado = conexion.executeQuery(consulta);
			return resultado;
		} catch (SQLException e) {
			e.printStackTrace();
			return null;
		}
	}
	
	public void cerrarConexion() {
		crea.cerrarConexion();
	}

}
