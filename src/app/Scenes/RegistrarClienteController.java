package app.scenes;

import java.io.IOException;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.scene.control.Alert;
import javafx.scene.control.Button;
import javafx.scene.control.TextField;
import javafx.scene.image.Image;
import javafx.scene.image.ImageView;
import javafx.scene.input.MouseEvent;
import javafx.scene.text.Text;
import javafx.stage.Stage;
import javafx.scene.Node;


public class RegistrarClienteController {

	/* Variables de la clase */

	private Stage stage;
	private Parent root;
	private Alert alerta;


	/* Variables de los campos en la interfaz */

	@FXML
	private Button btnRegresar;

	@FXML
	private TextField nombres;

	@FXML
	private Text nombresError;

	@FXML
	private TextField apellidos;

	@FXML
	private Text apellidosError;

	@FXML
	private TextField telefonos;

	@FXML
	private Text telefonosError;

	@FXML
	private TextField poblacion;

	@FXML
	private Text poblacionError;


	/* Inicializador de clase */

    @FXML
    public void initialize() {
		ImageView iv = new ImageView(getClass().getResource("/app/assets/home.png").toExternalForm());
		btnRegresar.setGraphic(iv);
    }

	
	/* Funciones para eventos de la interfaz */

	@FXML
	private void openPrincipal(ActionEvent event) throws IOException {
		root = FXMLLoader.load(getClass().getResource("/app/Homepage.fxml"));
		stage = (Stage)((Node)event.getSource()).getScene().getWindow();
		stage.setScene(new Scene(root));
	}

	@FXML
	private void quitarError(MouseEvent event){
		TextField campo = (TextField) event.getSource();

		switch(campo.getId()){
			case "nombres":
				nombresError.setVisible(false);
				break;
			case "apellidos":
				apellidosError.setVisible(false);
				break;
			case "telefonos":
				telefonosError.setVisible(false);
				break;
			case "poblacion":
				poblacionError.setVisible(false);
				break;
		}
	}

	@FXML
	private void registrar(){
		String valor;

		// En caso de que algún campo esté vacío
		boolean contenido = true;
		if (nombres.getText().isEmpty()){
			telefonosError.setText("Nombre(s) requerido(s)");
			nombresError.setVisible(true);
			contenido = false;
		}

		// En caso de que no se introduzcan solo letras
		valor = nombres.getText().replaceAll("\\s+","");
		if (!nombres.getText().isEmpty() && !valor.matches("^[a-zA-Z]+$")){
			nombresError.setText("Solo se aceptan letras");
			nombresError.setVisible(true);
			contenido = false;
		}

		if (apellidos.getText().isEmpty()){
			telefonosError.setText("Apellido(s) requerido(s)");
			apellidosError.setVisible(true);
			contenido = false;
		}

		// En caso de que no se introduzcan solo letras
		valor = apellidos.getText().replaceAll("\\s+","");
		if (!apellidos.getText().isEmpty() && !valor.matches("^[a-zA-Z]+$")){
			apellidosError.setText("Solo se aceptan letras");
			apellidosError.setVisible(true);
			contenido = false;
		}

		if (telefonos.getText().isEmpty()){
			telefonosError.setText("Teléfono(s) requerido(s)");
			telefonosError.setVisible(true);
			contenido = false;
		}

		// En caso de que no se introduzcan solo números
		if (!telefonos.getText().isEmpty() && !telefonos.getText().matches("[0-9]*")){
			telefonosError.setText("Solo se aceptan valores númericos");
			telefonosError.setVisible(true);
			contenido = false;
		}

		if (poblacion.getText().isEmpty()){
			poblacionError.setVisible(true);
			contenido = false;
		}

		// Sí ningún campo está vacío
		if (contenido) {

			// Muestra alerta de confirmación
			alerta = new Alert(Alert.AlertType.INFORMATION);
			Stage alertaStage = (Stage) alerta.getDialogPane().getScene().getWindow();
			alertaStage.getIcons()
			.add(new Image(getClass().getResource("/app/assets/logo.png").toExternalForm()));
			alerta.setTitle("Confirmación");
			alerta.setHeaderText("Usuario registrado con éxito");
			alerta.setContentText("Ya puede cerrar esté menú");
			alerta.showAndWait();
			
			// Limpia inputs
			nombres.setText("");
			apellidos.setText("");
			telefonos.setText("");
			poblacion.setText("");

		}
		
	}

}