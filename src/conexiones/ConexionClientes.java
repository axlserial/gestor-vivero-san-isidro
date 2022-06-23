package conexiones;

import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;

import Entidades.Cliente;
import resources.CreaConexion;

public class ConexionClientes {
	private CreaConexion crea;
	private Statement conexion;

	public ConexionClientes() {
		crea = new CreaConexion();

		// Obtener conexión
		conexion = crea.getStatement();
	}

	public Boolean guardarCliente(Cliente cliente) {
		String consulta = "";
		consulta = "INSERT INTO clientes (nombres, apellidos, telefono1, telefono2, poblacion) VALUES ";
		String[] telefonos = new String[2];
		telefonos = cliente.getTelefonos();
		consulta += "('" + cliente.getNombre() + "', '" + cliente.getApellidos() + "', '" + telefonos[0] + "', '" + telefonos[1] + "', '" + cliente.getPoblacion() + "')";
		try {
			conexion.executeUpdate(consulta);
			return true;
		} catch (SQLException e) {
			System.err.println(e);
			System.err.println("Consulta: " + consulta);
			return false;
		}
	}

	public ResultSet obtenerCliente(int id) {
		String consulta = "";
		consulta = "SELECT * FROM clientes WHERE idCliente=" + id;
		try {
			ResultSet resultado = conexion.executeQuery(consulta);
			return resultado;
		} catch (SQLException e) {
			e.printStackTrace();
			return null;
		}
	}

	public ResultSet buscarClientes(String nombre) {
		String consulta = "";
		consulta = "SELECT * FROM clientes WHERE nombres LIKE '%" + nombre + "%'";
		try {
			return conexion.executeQuery(consulta);
		} catch (SQLException e) {
			System.err.println(e);
			return null;
		}
	}
	
}
