package resources;

import java.sql.DriverManager;
import java.sql.SQLException;
import java.sql.Connection;
import java.sql.Statement;

public class CreaConexion {

	private Connection c;
	private Statement stmt;

	public Statement abrirConexion() {
		String conexion = "jdbc:sqlite::resource:";
		conexion += getClass().getResource("/resources/").toExternalForm() + "invernadero.db";

		try {
			c = DriverManager.getConnection(conexion);
			stmt = c.createStatement();
			System.out.println("Conexion con la base de datos ESTABLECIDA");
			return stmt;
		} catch (Exception e) {
			System.err.println(e.getClass().getName() + ": " + e.getMessage());
			System.exit(0);
			return null;
		}
	}

	public void cerrarConexion() {
		try {
			stmt.close();
			c.close();
			System.out.println("Conexion Cerrada");
		} catch (SQLException e) {
			e.printStackTrace();
		}
	}

}