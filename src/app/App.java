package app;

import javafx.application.Application;
import javafx.fxml.FXMLLoader;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.scene.image.Image;
import javafx.stage.Stage;

public class App extends Application {
	@Override
	public void start(Stage escenarioPrincipal){
		try {
			FXMLLoader fxmlLoader = new FXMLLoader(getClass().getResource("Homepage.fxml"));
			Parent root = (Parent) fxmlLoader.load();
			Scene escena = new Scene(root);
			escenarioPrincipal.setTitle("Gestor del Vivero San Isidro");
			escenarioPrincipal.getIcons()
			.add(new Image(getClass().getResource("/app/assets/logo.png").toExternalForm()));
			escenarioPrincipal.setScene(escena);
			escenarioPrincipal.setResizable(false);
			escenarioPrincipal.show();
		} catch(Exception e){
			e.printStackTrace();
		}
	}

	public static void main(String[] args){
		launch(args);
	}
}
