package interfaces;

import java.time.LocalDate;
import javafx.scene.Cursor;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.scene.control.DatePicker;
import javafx.scene.control.Pagination;
import javafx.scene.control.Separator;
import javafx.scene.control.TextField;
import javafx.scene.image.ImageView;
import javafx.scene.layout.AnchorPane;
import javafx.scene.layout.Pane;
import javafx.scene.paint.Color;
import javafx.scene.shape.StrokeType;
import javafx.scene.text.Font;
import javafx.scene.text.Text;

public class BusquedaAdministrarPedidos {

	private Scene escena;
	public Button principal;
	public TextField busqueda;
	public Button buscar;
	public DatePicker fechaInicial;
	public DatePicker fechaFinal;
	public Button regresar;

	public Pagination pag;

	public Mensajes mensajes;
	
	public BusquedaAdministrarPedidos() {

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

		Text titulo =  new Text("Administrar Pedidos");
		titulo.setLayoutX(508.0);
		titulo.setLayoutY(87.0);
		titulo.setStrokeType(StrokeType.OUTSIDE);
		titulo.setStrokeWidth(0.0);
		titulo.setFont(new Font("Segoe UI", 24.0));

		/////////////////////////////////////////////////////////

		busqueda = new TextField();
		busqueda.setLayoutX(411.0);
		busqueda.setLayoutY(35.0);
		busqueda.setPrefHeight(26.0);
		busqueda.setPrefWidth(300.0);
		busqueda.setPromptText("Ingresar el nombre del cliente");

		buscar = new Button("Buscar");
		buscar.setLayoutX(719.0);
		buscar.setLayoutY(35.0);
		buscar.setMnemonicParsing(false);
		buscar.setPrefHeight(26.0);
		buscar.setPrefWidth(146.0);
		buscar.setStyle("-fx-background-radius: 50px; -fx-max-width: 80px;");
		buscar.setCursor(Cursor.HAND);

		fechaInicial = new DatePicker();
		fechaInicial.setLayoutX(864.0);
		fechaInicial.setLayoutY(36.0);
		fechaInicial.setPrefHeight(25.0);
		fechaInicial.setPrefWidth(150.0);
		fechaInicial.setPromptText("Fecha inicial");
		fechaInicial.setValue(LocalDate.now());

		fechaFinal = new DatePicker();
		fechaFinal.setLayoutX(1031.0);
		fechaFinal.setLayoutY(36.0);
		fechaFinal.setPrefHeight(25.0);
		fechaFinal.setPrefWidth(150.0);
		fechaFinal.setPromptText("Fecha Final");
		fechaFinal.setValue(LocalDate.now());

		pag = new Pagination();
		pag.setLayoutX(30.0);
		pag.setLayoutY(88.0);
		pag.setPrefHeight(382.0);
		pag.setPrefWidth(1152.0);
		pag.setPageCount(1);
		pag.setMaxPageIndicatorCount(5);

		Separator sep = new Separator();
		sep.setLayoutX(356.0);
		sep.setLayoutY(481.0);
		sep.setPrefWidth(500.0);

		regresar = new Button("Regresar");
		regresar.setLayoutX(532.0);
		regresar.setLayoutY(499.0);
		regresar.setMnemonicParsing(false);
		regresar.setPrefHeight(26.0);
		regresar.setPrefWidth(146.0);
		regresar.setCursor(Cursor.HAND);

		AnchorPane cuerpo = new AnchorPane(
			busqueda, buscar, 
			fechaInicial, fechaFinal, 
			pag, sep, regresar
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

		mensajes = new Mensajes();
	}

	public Scene getScene(){
		return escena;
	}
	
}
