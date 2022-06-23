import controladores.ControladorHomepage;
import javafx.application.Application;
import javafx.scene.image.Image;
import javafx.stage.Stage;

public class Main extends Application {
	public static void main(String[] args) {
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