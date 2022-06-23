import java.sql.ResultSet;
import java.sql.SQLException;

import conexiones.ConexionClientes;
import controladores.ControladorHomepage;
import javafx.application.Application;
import javafx.scene.image.Image;
import javafx.stage.Stage;

public class Main extends Application {
	public static void main(String[] args) {
		ConexionClientes con = new ConexionClientes();
		//con.guardarCliente(cliente);
		ResultSet res = con.obtenerCliente(1);
		if (res == null) {
			System.out.println("No se pudo obtener");
		} else {
			try {
				System.out.println(res.getString("nombres"));
			} catch (SQLException e) {
				e.printStackTrace();
			}
		}
		launch();
	}

	@Override
	public void start(Stage escenario) {
		escenario.setTitle("Gestor del Vivero San Isidro");
		escenario.getIcons()
		.add(new Image(getClass().getResource("/assets/logo.png").toExternalForm()));
		new ControladorHomepage(escenario);
		escenario.show();
	}
}