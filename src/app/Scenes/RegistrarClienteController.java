package app.Scenes;

import java.io.IOException;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.scene.control.TextField;
import javafx.stage.Stage;
import javafx.scene.Node;


public class RegistrarClienteController {

	/* Variables para cambio de escena */

	private Stage stage;
	private Scene scene;
	private Parent root;


	/* Variables de los campos en la interfaz */

	@FXML
	private TextField nombres;

	@FXML
	private TextField apellidos;

	@FXML
	private TextField telefonos;

	@FXML
	private TextField poblacion;

	
	/* Funciones para eventos de la interfaz */

	@FXML
	private void openPrincipal(ActionEvent event) throws IOException {
		root = FXMLLoader.load(getClass().getResource("/app/Homepage.fxml"));
		stage = (Stage)((Node)event.getSource()).getScene().getWindow();
		scene = new Scene(root);
		stage.setScene(scene);
		stage.show();
	}

	@FXML
	private void registrar(){
		// Acciones cuando se presiona el botón "registrar cliente"
	}

}