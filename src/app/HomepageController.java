package app;

import java.io.IOException;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.stage.Stage;
import javafx.scene.Node;

public class HomepageController {

	private Stage stage;
	private Scene scene;
	private Parent root;

	@FXML
	private void openRegistrar(ActionEvent event) throws IOException {
		root = FXMLLoader.load(getClass().getResource("Scenes/RegistrarCliente.fxml"));
		stage = (Stage)((Node)event.getSource()).getScene().getWindow();
		scene = new Scene(root);
		stage.setScene(scene);
		stage.show();
	}

}