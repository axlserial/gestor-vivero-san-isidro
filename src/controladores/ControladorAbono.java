package controladores;

import interfaces.BusquedaRegistrarAbono;
import javafx.scene.Scene;
import javafx.stage.Stage;

public class ControladorAbono {

	private BusquedaRegistrarAbono interfazBusqueda;
	
	public ControladorAbono(Stage escenario, Scene anterior) {
		interfazBusqueda = new BusquedaRegistrarAbono();

		interfazBusqueda.principal.setOnAction(e -> {
			escenario.setScene(anterior);
		});

		interfazBusqueda.cancelar.setOnAction(e -> {
			escenario.setScene(anterior);
		});
	}

	public Scene getScene() {
		return interfazBusqueda.getScene();
	}
}
