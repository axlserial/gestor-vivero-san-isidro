package controladores;

import interfaces.BusquedaRegistrarAbono;
import javafx.scene.Node;
import javafx.scene.Scene;
import javafx.scene.layout.VBox;
import javafx.stage.Stage;
import javafx.util.Callback;

public class ControladorAbono {

	private BusquedaRegistrarAbono interfazBusqueda;
	
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
}
