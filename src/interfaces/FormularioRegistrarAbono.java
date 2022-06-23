package interfaces;

import javafx.scene.Cursor;
import javafx.scene.Scene;
import javafx.scene.control.Accordion;
import javafx.scene.control.Button;
import javafx.scene.control.Label;
import javafx.scene.control.ScrollPane;
import javafx.scene.control.Separator;
import javafx.scene.control.TextField;
import javafx.scene.control.TitledPane;
import javafx.scene.layout.AnchorPane;
import javafx.scene.shape.StrokeType;
import javafx.scene.text.Font;
import javafx.scene.text.Text;

public class FormularioRegistrarAbono {

	private Scene escena;
	public Button registrar;
	public Button cancelar;
	public TextField pago;
	
	public FormularioRegistrarAbono() {

		Text titulo =  new Text("Pedido #XXXX");
		titulo.setLayoutX(317.0);
		titulo.setLayoutY(40.0);
		titulo.setStrokeType(StrokeType.OUTSIDE);
		titulo.setStrokeWidth(0.0);
		titulo.setFont(new Font("Segoe UI", 24.0));

		/////////////////////////////////////////////////////////

		Text infoPed = new Text("Información general del pedido");
		infoPed.setLayoutX(72.0);
		infoPed.setLayoutY(56.0);
		infoPed.setStrokeType(StrokeType.OUTSIDE);
		infoPed.setStrokeWidth(0.0);
		infoPed.setFont(new Font("Segoe UI", 18.0));

		ScrollPane datosPedido = new ScrollPane();
		datosPedido.setPrefHeight(99.0);
		datosPedido.setPrefWidth(381.0);

		TitledPane infoPedido = new TitledPane("Información del pedido", datosPedido);
		infoPedido.setAnimated(false);
		infoPedido.setPrefHeight(111.0);
		infoPedido.setPrefWidth(382.0);

		Accordion contPedido = new Accordion(infoPedido);
		contPedido.setLayoutX(47.0);
		contPedido.setLayoutY(83.0);
		contPedido.setPrefHeight(172.0);
		contPedido.setPrefWidth(300.0);

		/////

		Text infoAb = new Text("Información de abonos");
		infoAb.setLayoutX(501.0);
		infoAb.setLayoutY(68.0);
		infoAb.setStrokeType(StrokeType.OUTSIDE);
		infoAb.setStrokeWidth(0.0);
		infoAb.setFont(new Font("Segoe UI", 18.0));

		ScrollPane datosAbono = new ScrollPane();
		datosAbono.setPrefHeight(99.0);
		datosAbono.setPrefWidth(381.0);

		TitledPane infoAbono = new TitledPane("Abonos anteriores", datosAbono);
		infoAbono.setAnimated(false);
		infoAbono.setPrefHeight(111.0);
		infoAbono.setPrefWidth(382.0);

		Accordion contAbono = new Accordion(infoAbono);
		contAbono.setLayoutX(443.0);
		contAbono.setLayoutY(83.0);
		contAbono.setPrefHeight(172.0);
		contAbono.setPrefWidth(300.0);

		/////		

		Text abRealizar = new Text("Abono a realizar");
		abRealizar.setLayoutX(335.0);
		abRealizar.setLayoutY(309.0);
		abRealizar.setStrokeType(StrokeType.OUTSIDE);
		abRealizar.setStrokeWidth(0.0);
		abRealizar.setFont(new Font("Segoe UI", 18.0));

		Label pCliente = new Label("Pago del cliente");
		pCliente.setLayoutX(250.0);
		pCliente.setLayoutY(346.0);

		pago = new TextField();
		pago.setLayoutX(250.0);
		pago.setLayoutY(363.0);
		pago.setPrefHeight(26.0);
		pago.setPrefWidth(300.0);

		Separator sepPago = new Separator();
		sepPago.setLayoutX(150.0);
		sepPago.setLayoutY(426.0);
		sepPago.setPrefHeight(2.0);
		sepPago.setPrefWidth(500.0);

		registrar = new Button("Registrar Abono");
		registrar.setLayoutX(188.0);
		registrar.setLayoutY(460.0);
		registrar.setMnemonicParsing(false);
		registrar.setPrefHeight(26.0);
		registrar.setPrefWidth(146.0);
		registrar.setCursor(Cursor.HAND);

		cancelar = new Button("Cancelar");
		cancelar.setLayoutX(464.0);
		cancelar.setLayoutY(460.0);
		cancelar.setMnemonicParsing(false);
		cancelar.setPrefHeight(26.0);
		cancelar.setPrefWidth(146.0);
		cancelar.setCursor(Cursor.HAND);

		AnchorPane cuerpo = new AnchorPane(
			infoPed, contPedido, infoAb, contAbono,
			abRealizar, pCliente, pago, sepPago,
			registrar, cancelar
		);
		cuerpo.setLayoutX(5.0);
		cuerpo.setLayoutY(62.0);
		cuerpo.setPrefHeight(532.0);
		cuerpo.setPrefWidth(790.0);
		cuerpo.setStyle("-fx-border-color: #363837; -fx-background-color: #eeeeee;");

		/////

		AnchorPane todo = new AnchorPane(titulo, cuerpo);
		todo.setPrefHeight(600.0);
		todo.setPrefWidth(800.0);

		escena = new Scene(todo, 800, 600);
	}

	public Scene getScene(){
		return escena;
	}
}
