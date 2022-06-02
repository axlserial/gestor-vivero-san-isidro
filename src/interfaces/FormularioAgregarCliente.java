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
import javafx.scene.layout.VBox;
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

	public VBox contTelef;
	public TextField[] telefono;

	public TextField poblacion;

	public Text nombresError;
	public Text apellidosError;
	public Text telefonoError;
	public Text poblacionError;

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

		nombres = new TextField();
		nombres.setLayoutX(455.0);
		nombres.setLayoutY(82.0);
		nombres.setPrefHeight(26.0);
		nombres.setPrefWidth(300.0);

		Label nombresLabel = new Label("Nombre(s)");
		nombresLabel.setLayoutX(455.0);
		nombresLabel.setLayoutY(64.0);

		nombresError = new Text();
		nombresError.setFill(Color.web("#dc1515"));
		nombresError.setLayoutX(455.0);
		nombresError.setLayoutY(121.0);
		nombresError.setStrokeType(StrokeType.OUTSIDE);
		nombresError.setStrokeWidth(0.0);
		nombresError.setVisible(false);
		/////

		apellidos = new TextField();
		apellidos.setLayoutX(455.0);
		apellidos.setLayoutY(160.0);
		apellidos.setPrefHeight(26.0);
		apellidos.setPrefWidth(300.0);

		Label apellidosLabel = new Label("Apellido(s)");
		apellidosLabel.setLayoutX(455.0);
		apellidosLabel.setLayoutY(142.0);

		apellidosError = new Text();
		apellidosError.setFill(Color.web("#dc1515"));
		apellidosError.setLayoutX(455.0);
		apellidosError.setLayoutY(199.0);
		apellidosError.setStrokeType(StrokeType.OUTSIDE);
		apellidosError.setStrokeWidth(0.0);
		apellidosError.setVisible(false);
		/////

		telefono = new TextField[3];
		telefono[0] = new TextField();
		telefono[0].setLayoutX(455.0);
		telefono[0].setLayoutY(240.0);
		telefono[0].setPrefHeight(26.0);
		telefono[0].setPrefWidth(300.0);

		Label telefonoLabel = new Label("Teléfono");
		telefonoLabel.setLayoutX(455.0);
		telefonoLabel.setLayoutY(222.0);

		telefonoError = new Text();
		telefonoError.setFill(Color.web("#dc1515"));
		telefonoError.setLayoutX(455.0);
		telefonoError.setLayoutY(281.0);
		telefonoError.setStrokeType(StrokeType.OUTSIDE);
		telefonoError.setStrokeWidth(0.0);
		telefonoError.setVisible(false);

		contTelef = new VBox(telefono[0]);
		contTelef.setLayoutX(455.0);
		contTelef.setLayoutY(240.0);
		contTelef.setPrefHeight(26.0);
		contTelef.setPrefWidth(300.0);
		/////

		poblacion = new TextField();
		poblacion.setLayoutX(455.0);
		poblacion.setLayoutY(323.0);
		poblacion.setPrefHeight(26.0);
		poblacion.setPrefWidth(300.0);

		Label poblacionLabel = new Label("Población");
		poblacionLabel.setLayoutX(455.0);
		poblacionLabel.setLayoutY(305.0);

		poblacionError = new Text("Población requerida");
		poblacionError.setFill(Color.web("#dc1515"));
		poblacionError.setLayoutX(455.0);
		poblacionError.setLayoutY(362.0);
		poblacionError.setStrokeType(StrokeType.OUTSIDE);
		poblacionError.setStrokeWidth(0.0);
		poblacionError.setVisible(false);
		/////

		Separator sep = new Separator();
		sep.setLayoutX(347.0);
		sep.setLayoutY(398.0);
		sep.setPrefHeight(3.0);
		sep.setPrefWidth(516.0);

		registrar = new Button("Registrar cliente");
		registrar.setLayoutX(382.0);
		registrar.setLayoutY(452.0);
		registrar.setMnemonicParsing(false);
		registrar.setPrefHeight(26.0);
		registrar.setPrefWidth(146.0);
		registrar.setCursor(Cursor.HAND);

		cancelar = new Button("Cancelar");
		cancelar.setLayoutX(682.0);
		cancelar.setLayoutY(452.0);
		cancelar.setMnemonicParsing(false);
		cancelar.setPrefHeight(26.0);
		cancelar.setPrefWidth(146.0);
		cancelar.setCursor(Cursor.HAND);

		AnchorPane formulario = new AnchorPane(
				nombres, nombresLabel, nombresError,
				apellidos, apellidosLabel, apellidosError,
				contTelef, telefonoLabel, telefonoError,
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

		contTelef.setOnMouseClicked(e -> {
			quitarError("telefono");
		});

		poblacion.setOnMouseClicked(e -> {
			quitarError("poblacion");
		});

		escena = new Scene(todo, 1280, 720);
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
			case "telefono":
				telefonoError.setVisible(false);
				break;
			case "poblacion":
				poblacionError.setVisible(false);
				break;
		}
	}
}
