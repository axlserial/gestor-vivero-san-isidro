package interfaces;

import javafx.scene.Cursor;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.scene.control.Label;
import javafx.scene.control.TextField;
import javafx.scene.image.ImageView;
import javafx.scene.layout.AnchorPane;
import javafx.scene.layout.Pane;
import javafx.scene.paint.Color;
import javafx.scene.shape.StrokeType;
import javafx.scene.text.Font;
import javafx.scene.text.Text;

public class BusquedaRegistrarAbono {

	private Scene escena;
	public Button principal;
	public Button buscar;
	public Button cancelar;
	public TextField numPedido;
	
	public BusquedaRegistrarAbono() {

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

		Text titulo =  new Text("Registrar Abono de Pago");
		titulo.setLayoutX(508.0);
		titulo.setLayoutY(87.0);
		titulo.setStrokeType(StrokeType.OUTSIDE);
		titulo.setStrokeWidth(0.0);
		titulo.setFont(new Font("Segoe UI", 24.0));

		/////////////////////////////////////////////////////////

		Label ingNum = new Label("Ingresa el número del pedido");
		ingNum.setLayoutX(527.0);
		ingNum.setLayoutY(143.0);

		numPedido = new TextField();
		numPedido.setLayoutX(455.0);
		numPedido.setLayoutY(168.0);
		numPedido.setPrefHeight(26.0);
		numPedido.setPrefWidth(300.0);

		buscar = new Button("Buscar");
		buscar.setLayoutX(565.0);
		buscar.setLayoutY(220.0);
		buscar.setMnemonicParsing(false);
		buscar.setPrefHeight(26.0);
		buscar.setPrefWidth(146.0);
		buscar.setStyle("-fx-background-radius: 50px; -fx-max-width: 80px;");
		buscar.setCursor(Cursor.HAND);

		cancelar = new Button("Cancelar");
		cancelar.setLayoutX(531.0);
		cancelar.setLayoutY(450.0);
		cancelar.setMnemonicParsing(false);
		cancelar.setPrefHeight(26.0);
		cancelar.setPrefWidth(146.0);
		cancelar.setCursor(Cursor.HAND);

		AnchorPane cuerpo = new AnchorPane(
			ingNum, numPedido, buscar, cancelar
		);
		cuerpo.setLayoutX(36.0);
		cuerpo.setLayoutY(129.0);
		cuerpo.setPrefHeight(553.0);
		cuerpo.setPrefWidth(1210.0);
		cuerpo.setStyle("-fx-border-color: #363837; -fx-background-color: #eeeeee;");

		/////////////////////////////////////////////////////////

		AnchorPane buscarAbono = new AnchorPane(
			navbar, titulo, cuerpo
		);
		buscarAbono.setPrefHeight(720.0);
		buscarAbono.setPrefWidth(1280.0);

		escena = new Scene(buscarAbono, 1280, 720);
	}

	public Scene getScene(){
		return escena;
	}
}
