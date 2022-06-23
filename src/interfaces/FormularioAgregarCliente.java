package interfaces;

import javafx.scene.Cursor;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.scene.control.Label;
import javafx.scene.control.Separator;
import javafx.scene.control.TextField;
import javafx.scene.image.ImageView;
import javafx.scene.layout.AnchorPane;
import javafx.scene.layout.Pane;
import javafx.scene.paint.Color;
import javafx.scene.shape.StrokeType;
import javafx.scene.text.Font;
import javafx.scene.text.Text;

public class FormularioAgregarCliente {
	
	private Scene escena;
	public Button principal;
	public Button registrar;
	public Button cancelar;

	public TextField nombres;
	public TextField apellidos;

	public TextField telefono1;
	public TextField telefono2;

	public TextField poblacion;

	public Text nombresError;
	public Text apellidosError;
	public Text telefono1Error;
	public Text telefono2Error;
	public Text poblacionError;

	public Mensajes mensajes;

	public FormularioAgregarCliente(){

		principal = new Button("Página Principal");
		principal.setLayoutY(-1.0);
		principal.setMnemonicParsing(false);
		principal.setPrefHeight(30.0);
		principal.setPrefWidth(128.0);
		principal.setStyle("-fx-background-color: #7A8E1E;");
		principal.setTextFill(Color.WHITE);
		principal.setCursor(Cursor.HAND);

		ImageView iv = new ImageView(getClass().getResource("/assets/home.png").toExternalForm());
		principal.setGraphic(iv);

		Pane navbar = new Pane(principal);
		navbar.setLayoutX(-2.0);
		navbar.setLayoutY(-1.0);
		navbar.setPrefHeight(30.0);
		navbar.setPrefWidth(1282.5);
		navbar.setStyle("-fx-background-color: #7A8E1E;");

		/////////////////////////////////////////////////////////

		Text titulo =  new Text("Registrar Cliente");
		titulo.setLayoutX(553.0);
		titulo.setLayoutY(87.0);
		titulo.setStrokeType(StrokeType.OUTSIDE);
		titulo.setStrokeWidth(0.0);
		titulo.setFont(new Font("Segoe UI", 24.0));

		/////////////////////////////////////////////////////////

		Label nombresLabel = new Label("Nombre(s)");
		nombresLabel.setLayoutX(455.0);
		nombresLabel.setLayoutY(47.0);

		nombres = new TextField();
		nombres.setLayoutX(455.0);
		nombres.setLayoutY(65.0);
		nombres.setPrefHeight(26.0);
		nombres.setPrefWidth(300.0);

		nombresError = new Text();
		nombresError.setFill(Color.web("#dc1515"));
		nombresError.setLayoutX(455.0);
		nombresError.setLayoutY(104.0);
		nombresError.setStrokeType(StrokeType.OUTSIDE);
		nombresError.setStrokeWidth(0.0);
		nombresError.setVisible(false);

		/////
		Label apellidosLabel = new Label("Apellido(s)");
		apellidosLabel.setLayoutX(455.0);
		apellidosLabel.setLayoutY(119.0);

		apellidos = new TextField();
		apellidos.setLayoutX(455.0);
		apellidos.setLayoutY(137.0);
		apellidos.setPrefHeight(26.0);
		apellidos.setPrefWidth(300.0);

		apellidosError = new Text();
		apellidosError.setFill(Color.web("#dc1515"));
		apellidosError.setLayoutX(455.0);
		apellidosError.setLayoutY(176.0);
		apellidosError.setStrokeType(StrokeType.OUTSIDE);
		apellidosError.setStrokeWidth(0.0);
		apellidosError.setVisible(false);
		
		// Telefono 1
		Label telefono1Label = new Label("Teléfono 1");
		telefono1Label.setLayoutX(455.0);
		telefono1Label.setLayoutY(191.0);

		telefono1 = new TextField();
		telefono1.setLayoutX(455.0);
		telefono1.setLayoutY(209.0);
		telefono1.setPrefHeight(26.0);
		telefono1.setPrefWidth(300.0);

		telefono1Error = new Text();
		telefono1Error.setFill(Color.web("#dc1515"));
		telefono1Error.setLayoutX(455.0);
		telefono1Error.setLayoutY(250.0);
		telefono1Error.setStrokeType(StrokeType.OUTSIDE);
		telefono1Error.setStrokeWidth(0.0);
		telefono1Error.setVisible(false);

		// Telefono 2
		Label telefono2Label = new Label("Teléfono 2 (opcional)");
		telefono2Label.setLayoutX(455.0);
		telefono2Label.setLayoutY(262.0);

		telefono2 = new TextField();
		telefono2.setLayoutX(455.0);
		telefono2.setLayoutY(280.0);
		telefono2.setPrefHeight(26.0);
		telefono2.setPrefWidth(300.0);

		telefono2Error = new Text();
		telefono2Error.setFill(Color.web("#dc1515"));
		telefono2Error.setLayoutX(455.0);
		telefono2Error.setLayoutY(321.0);
		telefono2Error.setStrokeType(StrokeType.OUTSIDE);
		telefono2Error.setStrokeWidth(0.0);
		telefono2Error.setVisible(false);

		/////
		Label poblacionLabel = new Label("Población");
		poblacionLabel.setLayoutX(455.0);
		poblacionLabel.setLayoutY(331.0);
	
		poblacion = new TextField();
		poblacion.setLayoutX(455.0);
		poblacion.setLayoutY(349.0);
		poblacion.setPrefHeight(26.0);
		poblacion.setPrefWidth(300.0);

		poblacionError = new Text("Población requerida");
		poblacionError.setFill(Color.web("#dc1515"));
		poblacionError.setLayoutX(455.0);
		poblacionError.setLayoutY(388.0);
		poblacionError.setStrokeType(StrokeType.OUTSIDE);
		poblacionError.setStrokeWidth(0.0);
		poblacionError.setVisible(false);

		/////
		Separator sep = new Separator();
		sep.setLayoutX(347.0);
		sep.setLayoutY(426.0);
		sep.setPrefHeight(3.0);
		sep.setPrefWidth(516.0);

		registrar = new Button("Registrar cliente");
		registrar.setLayoutX(382.0);
		registrar.setLayoutY(468.0);
		registrar.setMnemonicParsing(false);
		registrar.setPrefHeight(26.0);
		registrar.setPrefWidth(146.0);
		registrar.setCursor(Cursor.HAND);

		cancelar = new Button("Cancelar");
		cancelar.setLayoutX(682.0);
		cancelar.setLayoutY(468.0);
		cancelar.setMnemonicParsing(false);
		cancelar.setPrefHeight(26.0);
		cancelar.setPrefWidth(146.0);
		cancelar.setCursor(Cursor.HAND);

		AnchorPane formulario = new AnchorPane(
				nombres, nombresLabel, nombresError,
				apellidos, apellidosLabel, apellidosError,
				telefono1Label, telefono1, telefono1Error,
				telefono2Label, telefono2, telefono2Error,
				poblacion, poblacionLabel, poblacionError,
				sep, registrar, cancelar);
		formulario.setLayoutX(36.0);
		formulario.setLayoutY(129.0);
		formulario.setPrefHeight(553.0);
		formulario.setPrefWidth(1210.0);
		formulario.setStyle("-fx-border-color: #363837; -fx-background-color: #eeeeee;");

		////////////////////////////////////////////////
		AnchorPane todo = new AnchorPane(navbar, titulo, formulario);
		todo.setPrefHeight(720.0);
		todo.setPrefWidth(1280.0);

		nombres.setOnMouseClicked(e -> {
			quitarError("nombres");
		});

		apellidos.setOnMouseClicked(e -> {
			quitarError("apellidos");
		});

		telefono1.setOnMouseClicked(e -> {
			quitarError("telefono1");
		});

		telefono2.setOnMouseClicked(e -> {
			quitarError("telefono2");
		});

		poblacion.setOnMouseClicked(e -> {
			quitarError("poblacion");
		});

		escena = new Scene(todo, 1280, 720);

		mensajes = new Mensajes();
	}

	public Scene getScene(){
		return escena;
	}

	private void quitarError(String id){
		switch(id){
			case "nombres":
				nombresError.setVisible(false);
				break;
			case "apellidos":
				apellidosError.setVisible(false);
				break;
			case "telefono1":
				telefono1Error.setVisible(false);
				break;
			case "telefono2":
				telefono2Error.setVisible(false);
				break;
			case "poblacion":
				poblacionError.setVisible(false);
				break;
		}
	}
}
