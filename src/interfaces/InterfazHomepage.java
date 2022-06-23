package interfaces;

import javafx.scene.Cursor;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.scene.image.Image;
import javafx.scene.image.ImageView;
import javafx.scene.layout.Pane;
import javafx.scene.layout.VBox;
import javafx.scene.paint.Color;
import javafx.scene.shape.StrokeType;
import javafx.scene.text.Font;
import javafx.scene.text.Text;

public class InterfazHomepage {

	private Scene escena;
	public Button registrarCliente;
	public Button registrarPedido;
	public Button registrarAbono;

	public InterfazHomepage(){

		registrarCliente = new Button("Registrar Cliente");
		registrarCliente.setPrefHeight(75.0);
		registrarCliente.setPrefWidth(294.0);
		registrarCliente.setStyle("-fx-background-color: #A6634B;");
		registrarCliente.setTextFill(Color.WHITE);
		registrarCliente.setCursor(Cursor.HAND);
		registrarCliente.setFont(new Font("Segoe UI Semibold", 14.0));

		registrarPedido = new Button("Registrar Pedido");
		registrarPedido.setPrefHeight(75.0);
		registrarPedido.setPrefWidth(294.0);
		registrarPedido.setStyle("-fx-background-color: #A6634B;");
		registrarPedido.setTextFill(Color.WHITE);
		registrarPedido.setCursor(Cursor.HAND);
		registrarPedido.setFont(new Font("Segoe UI Semibold", 14.0));

		registrarAbono = new Button("Registrar Abono");
		registrarAbono.setPrefHeight(75.0);
		registrarAbono.setPrefWidth(294.0);
		registrarAbono.setStyle("-fx-background-color: #A6634B;");
		registrarAbono.setTextFill(Color.WHITE);
		registrarAbono.setCursor(Cursor.HAND);
		registrarAbono.setFont(new Font("Segoe UI Semibold", 14.0));

		VBox literal = new VBox(registrarCliente, registrarPedido, registrarAbono);
		literal.setLayoutY(-29.0);
		literal.setPrefHeight(720.0);
		literal.setPrefWidth(294.0);

		Text vivero = new Text("Vivero San Isidro");
		vivero.setFont(new Font("Segoe UI", 16.0));
		vivero.setLayoutX(434.0);
		vivero.setLayoutY(501.0);
		vivero.setStrokeType(StrokeType.OUTSIDE);
		vivero.setStrokeWidth(0.0);

		ImageView logoImg = new ImageView(new Image(
			getClass().getResource("/assets/logo.png").toExternalForm()
		));
		logoImg.setFitHeight(300.0);
		logoImg.setFitWidth(300.0);
		logoImg.setLayoutY(1.0);
		logoImg.setPickOnBounds(true);
		logoImg.setPreserveRatio(true);

		Pane logo = new Pane(logoImg);
		logo.setLayoutX(343.0);
		logo.setLayoutY(171.0);
		logo.setPrefHeight(300.0);
		logo.setPrefWidth(300.0);

		Pane logoSpace = new Pane(vivero, logo);
		logoSpace.setLayoutX(294.0);
		logoSpace.setLayoutY(-29.0);
		logoSpace.setPrefHeight(720.0);
		logoSpace.setPrefWidth(986.0);
		logoSpace.setStyle("-fx-background-color: #d4ffe9;");
		logoSpace.setCursor(Cursor.DEFAULT);

		Pane contenedor = new Pane(literal, logoSpace);
		contenedor.setLayoutY(28.0);

		Pane principal = new Pane(contenedor);
		principal.setPrefHeight(720.0);
		principal.setPrefWidth(1280.0);

		escena = new Scene(principal, 1280, 720);
	}

	public Scene getScene(){
		return escena;
	}
}
