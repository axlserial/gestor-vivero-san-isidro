package interfaces;

import java.util.Optional;
import javafx.scene.control.Alert;
import javafx.scene.control.ButtonType;
import javafx.scene.image.Image;
import javafx.stage.Stage;

public class Mensajes {

	public void mensaje(String mensaje) {
		Alert alerta = new Alert(Alert.AlertType.INFORMATION);
		Stage alertaStage = (Stage) alerta.getDialogPane().getScene().getWindow();
		alertaStage.getIcons()
				.add(new Image(getClass().getResource("/assets/logo.png").toExternalForm()));
		alerta.setTitle("Mensaje");
		alerta.setHeaderText(mensaje);
		alerta.setContentText("Ya puede cerrar esté menú");
		alerta.showAndWait();
	}

	public void error(String mensaje) {
		Alert alerta = new Alert(Alert.AlertType.ERROR);
		Stage alertaStage = (Stage) alerta.getDialogPane().getScene().getWindow();
		alertaStage.getIcons()
				.add(new Image(getClass().getResource("/assets/logo.png").toExternalForm()));
		alerta.setTitle("Error");
		alerta.setHeaderText(mensaje);
		alerta.setContentText("Puede cerrar este mensaje");
		alerta.showAndWait();
	}

	public boolean confirmacion(String mensaje) {
		Alert alerta = new Alert(Alert.AlertType.CONFIRMATION);
		Stage alertaStage = (Stage) alerta.getDialogPane().getScene().getWindow();
		alertaStage.getIcons()
				.add(new Image(getClass().getResource("/assets/logo.png").toExternalForm()));
		alerta.setTitle("Confirmación");
		alerta.setHeaderText(mensaje);
		alerta.setContentText("Elija una opción");
		Optional<ButtonType> res = alerta.showAndWait();

		return !res.get().getButtonData().isCancelButton();
	}

}
