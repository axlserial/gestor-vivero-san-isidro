package app;

import java.io.IOException;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.scene.image.Image;
import javafx.scene.image.ImageView;
import javafx.stage.Stage;
import javafx.scene.Node;

public class HomepageController {

	private Stage stage;
	private Parent root;

	@FXML
	private ImageView logo;

	/* Inicializador de clase */

    @FXML
    public void initialize() {
		Image logoUrl = new Image(getClass().getResource("/app/assets/logo.png").toExternalForm());
		logo.setImage(logoUrl);
    }


	@FXML
	private void openRegistrar(ActionEvent event) throws IOException {
		root = FXMLLoader.load(getClass().getResource("/app/scenes/RegistrarCliente.fxml"));
		stage = (Stage)((Node)event.getSource()).getScene().getWindow();
		stage.setScene(new Scene(root));
	}

}