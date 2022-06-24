package interfaces;

import java.time.LocalDate;

import Entidades.Pedido;
import Entidades.Planta;
import javafx.scene.Cursor;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.scene.control.ChoiceBox;
import javafx.scene.control.DatePicker;
import javafx.scene.control.Label;
import javafx.scene.control.Separator;
import javafx.scene.control.Tab;
import javafx.scene.control.TabPane;
import javafx.scene.control.TextField;
import javafx.scene.control.TabPane.TabClosingPolicy;
import javafx.scene.layout.AnchorPane;
import javafx.scene.layout.Pane;
import javafx.scene.paint.Color;
import javafx.scene.shape.StrokeType;
import javafx.scene.text.Font;
import javafx.scene.text.Text;

public class FormularioModificarPedido {
	private Scene escena;
	public Button principal;
	public Button registrar;
	public Button cancelar;

	private Label nombre;
	private Label telefonos;
	private Label poblacion;
	// public Button entradaNombre;
	// public ChoiceBox<String> clientesExistentes;

	public TabPane plantas;
	public Button agregarPlanta;

	public DatePicker fecha;
	public DatePicker fechaSiembra;
	public DatePicker fechaEntrega;
	public TextField pagoInicial;
	public TextField diasAprox;

	public Text fechaError;
	public Text fechaSError;
	public Text fechaEError;
	// public Text pagoError;
	// public Text diasError;

	public Mensajes mensajes;
	
	public FormularioModificarPedido(){

		Text titulo =  new Text("Modificar Pedido");
		titulo.setLayoutX(569.0);
		titulo.setLayoutY(63.0);
		titulo.setStrokeType(StrokeType.OUTSIDE);
		titulo.setStrokeWidth(0.0);
		titulo.setFont(new Font("Segoe UI", 24.0));

		/////////////////////////////////////////////////////////

		Text titleCliente = new Text("Datos del cliente");
		titleCliente.setLayoutX(149.0);
		titleCliente.setLayoutY(42.0);
		titleCliente.setStrokeType(StrokeType.OUTSIDE);
		titleCliente.setStrokeWidth(0.0);
		titleCliente.setFont(new Font("Segoe UI", 18.0));
		
		/////
		
		// nombre = new TextField();
		// nombre.setPromptText("Ingresa un nombre");
		// nombre.setLayoutX(75.0);
		// nombre.setLayoutY(82.0);
		// nombre.setPrefHeight(26.0);
		// nombre.setPrefWidth(200.0);

		// entradaNombre = new Button("Buscar");
		// entradaNombre.setLayoutX(275.0);
		// entradaNombre.setLayoutY(82.0);
		// entradaNombre.setMnemonicParsing(false);
		// entradaNombre.setPrefHeight(26.0);
		// entradaNombre.setPrefWidth(146.0);
		// entradaNombre.setStyle(
		// 	"-fx-background-radius: 50px; -fx-max-width: 80px;"
		// );
		// entradaNombre.setCursor(Cursor.HAND);

		// Text selCliente = new Text("Seleccionar Cliente");
		// selCliente.setLayoutX(65.0);
		// selCliente.setLayoutY(154.0);
		// selCliente.setStrokeType(StrokeType.OUTSIDE);
		// selCliente.setStrokeWidth(0.0);

		// clientesExistentes = new ChoiceBox<>();
		// clientesExistentes.setLayoutX(65.0);
		// clientesExistentes.setLayoutY(158.0);
		// clientesExistentes.setPrefHeight(25.0);
		// clientesExistentes.setPrefWidth(300.0);

		nombre = new Label("Nombre: ");
		nombre.setLayoutX(100);
		nombre.setLayoutY(100);
		telefonos = new Label("Teléfonos: ");
		telefonos.setLayoutX(100);
		telefonos.setLayoutY(120);
		poblacion = new Label("Población: ");
		poblacion.setLayoutX(100);
		poblacion.setLayoutY(140);

		/////
		Pane parteCliente = new Pane(
			titleCliente, nombre, telefonos, poblacion
		);
		parteCliente.setLayoutX(5.0);
		parteCliente.setPrefHeight(448.0);
		parteCliente.setPrefWidth(384.0);

		/////////////////////////////////////////////////////////

		Text titlePlanta = new Text("Datos de la(s) planta(s)");
		titlePlanta.setLayoutX(87.0);
		titlePlanta.setLayoutY(41.0);
		titlePlanta.setStrokeType(StrokeType.OUTSIDE);
		titlePlanta.setStrokeWidth(0.0);
		titlePlanta.setFont(new Font("Segoe UI", 18.0));
		/////

		Tab planta1 = new Tab("Planta 1");
		planta1.setContent(agregaTabPlanta());
		planta1.setClosable(false);

		plantas = new TabPane(planta1);
		plantas.setLayoutX(1.0);
		plantas.setLayoutY(80.0);
		plantas.setPrefHeight(377.0);
		plantas.setPrefWidth(354.0);
		plantas.setStyle("-fx-border-color: #D0D0D0;");
		plantas.setTabClosingPolicy(TabClosingPolicy.ALL_TABS);
		/////

		agregarPlanta = new Button("+ Agregar planta");
		agregarPlanta.setLayoutX(1.0);
		agregarPlanta.setLayoutY(457.0);
		agregarPlanta.setMnemonicParsing(false);
		agregarPlanta.setCursor(Cursor.HAND);
		/////

		Pane partePlantas = new Pane(
			titlePlanta, plantas, agregarPlanta
		);
		partePlantas.setLayoutX(439.0);
		partePlantas.setPrefHeight(490.0);
		partePlantas.setPrefWidth(354.0);

		/////////////////////////////////////////////////////////

		Text titlePedido = new Text("Datos del pedido");
		titlePedido.setLayoutX(123.0);
		titlePedido.setLayoutY(42.0);
		titlePedido.setStrokeType(StrokeType.OUTSIDE);
		titlePedido.setStrokeWidth(0.0);
		titlePedido.setFont(new Font("Segoe UI", 18.0));
		/////

		Label fp = new Label("Fecha de pedido");
		fp.setLayoutX(42.0);
		fp.setLayoutY(70.0);

		fecha = new DatePicker();
		fecha.setLayoutX(42.0);
		fecha.setLayoutY(87.0);
		fecha.setPrefHeight(25.0);
		fecha.setPrefWidth(300.0);
		fecha.setValue(LocalDate.now());

		fechaError = new Text("Fecha requerida");
		fechaError.setFill(Color.web("#dc1515"));
		fechaError.setLayoutX(42.0);
		fechaError.setLayoutY(125.0);
		fechaError.setStrokeType(StrokeType.OUTSIDE);
		fechaError.setStrokeWidth(0.0);
		fechaError.setVisible(false);
		/////

		Label fs = new Label("Fecha de siembra");
		fs.setLayoutX(42.0);
		fs.setLayoutY(142.0);

		fechaSiembra = new DatePicker();
		fechaSiembra.setLayoutX(42.0);
		fechaSiembra.setLayoutY(159.0);
		fechaSiembra.setPrefHeight(25.0);
		fechaSiembra.setPrefWidth(300.0);

		fechaSError = new Text("Fecha requerida");
		fechaSError.setFill(Color.web("#dc1515"));
		fechaSError.setLayoutX(42.0);
		fechaSError.setLayoutY(197.0);
		fechaSError.setStrokeType(StrokeType.OUTSIDE);
		fechaSError.setStrokeWidth(0.0);
		fechaSError.setVisible(false);
		/////

		Label fe = new Label("Fecha de entrega");
		fe.setLayoutX(42.0);
		fe.setLayoutY(218.0);

		fechaEntrega = new DatePicker();
		fechaEntrega.setLayoutX(42.0);
		fechaEntrega.setLayoutY(235.0);
		fechaEntrega.setPrefHeight(25.0);
		fechaEntrega.setPrefWidth(300.0);

		fechaEError = new Text("Fecha requerida");
		fechaEError.setFill(Color.web("#dc1515"));
		fechaEError.setLayoutX(42.0);
		fechaEError.setLayoutY(273.0);
		fechaEError.setStrokeType(StrokeType.OUTSIDE);
		fechaEError.setStrokeWidth(0.0);
		fechaEError.setVisible(false);
		/////

		Label pi = new Label("Pago inicial");
		pi.setLayoutX(42.0);
		pi.setLayoutY(301.0);

		pagoInicial = new TextField();
		pagoInicial.setLayoutX(42.0);
		pagoInicial.setLayoutY(318.0);
		pagoInicial.setPrefHeight(26.0);
		pagoInicial.setPrefWidth(300.0);
		pagoInicial.setEditable(false);

		// pagoError = new Text("Pago inicial requerido");
		// pagoError.setFill(Color.web("#dc1515"));
		// pagoError.setLayoutX(42.0);
		// pagoError.setLayoutY(357.0);
		// pagoError.setStrokeType(StrokeType.OUTSIDE);
		// pagoError.setStrokeWidth(0.0);
		// pagoError.setVisible(false);
		/////

		Label dap = new Label("Fecha aproximada");
		dap.setLayoutX(42.0);
		dap.setLayoutY(379.0);

		diasAprox = new TextField();
		diasAprox.setLayoutX(42.0);
		diasAprox.setLayoutY(396.0);
		diasAprox.setPrefHeight(26.0);
		diasAprox.setPrefWidth(300.0);
		diasAprox.setEditable(false);

		// diasError = new Text("Cantidad de días requeridos");
		// diasError.setFill(Color.web("#dc1515"));
		// diasError.setLayoutX(42.0);
		// diasError.setLayoutY(435.0);
		// diasError.setStrokeType(StrokeType.OUTSIDE);
		// diasError.setStrokeWidth(0.0);
		// diasError.setVisible(false);
		/////

		Pane partePedido = new Pane(
			titlePedido, fp, fecha, fechaError, 
			fs, fechaSiembra, fechaSError,
			fe, fechaEntrega, fechaEError,
			pi, pagoInicial,
			dap, diasAprox
		);
		partePedido.setLayoutX(819.0);
		partePedido.setPrefHeight(448.0);
		partePedido.setPrefWidth(384.0);

		/////////////////////////////////////////////////////////

		Separator sepCliente = new Separator();
		sepCliente.setLayoutX(50.0);
		sepCliente.setLayoutY(502.0);
		sepCliente.setPrefHeight(2.0);
		sepCliente.setPrefWidth(331.0);

		Separator sepPlanta = new Separator();
		sepPlanta.setLayoutX(450.0);
		sepPlanta.setLayoutY(501.0);
		sepPlanta.setPrefHeight(2.0);
		sepPlanta.setPrefWidth(331.0);
		
		Separator sepPedido = new Separator();
		sepPedido.setLayoutX(845.0);
		sepPedido.setLayoutY(501.0);
		sepPedido.setPrefHeight(2.0);
		sepPedido.setPrefWidth(331.0);

		registrar = new Button("Registrar pedido");
		registrar.setLayoutX(382.0);
		registrar.setLayoutY(531.0);
		registrar.setMnemonicParsing(false);
		registrar.setPrefHeight(26.0);
		registrar.setPrefWidth(146.0);
		registrar.setCursor(Cursor.HAND);

		cancelar = new Button("Cancelar");
		cancelar.setLayoutX(697.0);
		cancelar.setLayoutY(531.0);
		cancelar.setMnemonicParsing(false);
		cancelar.setPrefHeight(26.0);
		cancelar.setPrefWidth(146.0);
		cancelar.setCursor(Cursor.HAND);

		/////////////////////////////////////////////////////////

		AnchorPane cuerpo = new AnchorPane(
			parteCliente, partePedido, partePlantas,
			sepCliente, sepPedido,	sepPlanta,
			registrar, cancelar
		);
		cuerpo.setLayoutX(23.0);
		cuerpo.setLayoutY(105.0);
		cuerpo.setPrefHeight(590.0);
		cuerpo.setPrefWidth(1232.0);
		cuerpo.setStyle("-fx-border-color: #363837; -fx-background-color: #eeeeee;");

		AnchorPane formularios = new AnchorPane(
			titulo, cuerpo
		);
		formularios.setPrefHeight(720.0);
		formularios.setPrefWidth(1280.0);

		// pagoInicial.setOnMouseClicked(e -> {
		// 	pagoError.setVisible(false);
		// });

		// diasAprox.setOnMouseClicked(e -> {
		// 	diasError.setVisible(false);
		// });

		escena = new Scene(formularios, 1280, 720);

		mensajes = new Mensajes();
	}

	public AnchorPane agregaTabPlanta() {
		Label thl = new Label("Tipo de hortaliza");
		thl.setLayoutX(26.0);
		thl.setLayoutY(29.0);

		ChoiceBox<String> tiposHortaliza = new ChoiceBox<>();
		tiposHortaliza.setLayoutX(26.0);
		tiposHortaliza.setLayoutY(47.0);
		tiposHortaliza.setPrefHeight(26.0);
		tiposHortaliza.setPrefWidth(300.0);

		tiposHortaliza.getItems().addAll("Jitomate");
		tiposHortaliza.getItems().addAll("Cebolla");
		tiposHortaliza.getItems().addAll("Tomate de Cáscara");
		tiposHortaliza.getSelectionModel().selectFirst();
		/////

		Label tvl = new Label("Variedad");
		tvl.setLayoutX(26.0);
		tvl.setLayoutY(107.0);
		
		TextField variedad = new TextField();
		variedad.setLayoutX(26.0);
		variedad.setLayoutY(125.0);
		variedad.setPrefHeight(26.0);
		variedad.setPrefWidth(300.0);

		Text variedadError = new Text("Variedad requerida");
		variedadError.setFill(Color.web("#dc1515"));
		variedadError.setLayoutX(26.0);
		variedadError.setLayoutY(164.0);
		variedadError.setStrokeType(StrokeType.OUTSIDE);
		variedadError.setStrokeWidth(0.0);
		variedadError.setVisible(false);
		/////

		Label pl = new Label("Precio");
		pl.setLayoutX(26.0);
		pl.setLayoutY(187.0);

		TextField precioPagar = new TextField();
		precioPagar.setLayoutX(26.0);
		precioPagar.setLayoutY(205.0);
		precioPagar.setPrefHeight(26.0);
		precioPagar.setPrefWidth(300.0);

		Text precioError = new Text("Precio requerido");
		precioError.setFill(Color.web("#dc1515"));
		precioError.setLayoutX(26.0);
		precioError.setLayoutY(246.0);
		precioError.setStrokeType(StrokeType.OUTSIDE);
		precioError.setStrokeWidth(0.0);
		precioError.setVisible(false);
		/////

		Label ccl = new Label("Cantidad de charolas");
		ccl.setLayoutX(26.0);
		ccl.setLayoutY(270.0);

		TextField cantidadCharolas = new TextField();
		cantidadCharolas.setLayoutX(26.0);
		cantidadCharolas.setLayoutY(288.0);
		cantidadCharolas.setPrefHeight(26.0);
		cantidadCharolas.setPrefWidth(300.0);

		Text charolasError = new Text("Cantidad requerida");
		charolasError.setFill(Color.web("#dc1515"));
		charolasError.setLayoutX(26.0);
		charolasError.setLayoutY(327.0);
		charolasError.setStrokeType(StrokeType.OUTSIDE);
		charolasError.setStrokeWidth(0.0);
		charolasError.setVisible(false);
		/////
		
		AnchorPane contendorPlanta = new AnchorPane(
			thl, tiposHortaliza, tvl, variedad, variedadError,
			pl, precioPagar, precioError,
			ccl, cantidadCharolas, charolasError 
		);
		contendorPlanta.setMinHeight(0.0);
		contendorPlanta.setMinWidth(0.0);
		contendorPlanta.setPrefHeight(180.0);
		contendorPlanta.setPrefWidth(310.0);

		variedad.setOnMouseClicked(e -> {
			variedadError.setVisible(false);
		});

		precioPagar.setOnMouseClicked(e -> {
			precioError.setVisible(false);
		});

		cantidadCharolas.setOnMouseClicked(e -> {
			charolasError.setVisible(false);
		});

		return contendorPlanta;
	}

	public void abrir(Pedido pedido) {
		nombre.setText("Nombre: " + pedido.getCliente().getNombre() + " " + pedido.getCliente().getApellidos());
		telefonos.setText("Teléfono: ");
		telefonos.setText(telefonos.getText() + " " + pedido.getCliente().getTelefonos()[0]);
		poblacion.setText("Población: " + pedido.getCliente().getPoblacion());

		Tab planta1 = generaTabPlanta("Planta 1", pedido.getPlantas()[0]);
		planta1.setClosable(false);
		plantas.getTabs().clear();
		plantas.getTabs().add(planta1);
		for (int i = 1; i < pedido.getPlantas().length; i++) {
			Tab plantaN = generaTabPlanta("Planta " + (i + 1), pedido.getPlantas()[i]);
			plantas.getTabs().add(plantaN);
		}

		String[] fechaPartida = pedido.getFechaPedido().split("-");
		fecha.setValue(LocalDate.of(
			Integer.parseInt(fechaPartida[0]), Integer.parseInt(fechaPartida[1]), 
			Integer.parseInt(fechaPartida[2])
		));

		if (!pedido.getFechaSiembra().isEmpty()) {
			String[] fSiembra = pedido.getFechaSiembra().split("-");
			if (fSiembra.length > 0) {
				fechaSiembra.setValue(LocalDate.of(
					Integer.parseInt(fSiembra[0]), Integer.parseInt(fSiembra[1]), 
					Integer.parseInt(fSiembra[2])
				));
			}
		}

		if (!pedido.getFechaEntrega().isEmpty()) {
			String[] fEntrega = pedido.getFechaEntrega().split("-");
			if (fEntrega.length > 0) {
				fechaEntrega.setValue(LocalDate.of(
					Integer.parseInt(fEntrega[0]), Integer.parseInt(fEntrega[1]), 
					Integer.parseInt(fEntrega[2])
				));
			}
		}

		diasAprox.setText(pedido.getFechaAproximada());
		diasAprox.setDisable(true);
		pagoInicial.setText(pedido.getPagos()[0].getCantidad() + "");
		pagoInicial.setDisable(true);
	}

	public Tab generaTabPlanta(String nombre, Planta planta) {
		Tab plantaTab = new Tab(nombre);

		Label thl = new Label("Tipo de hortaliza");
		thl.setLayoutX(26.0);
		thl.setLayoutY(29.0);

		ChoiceBox<String> tiposHortaliza = new ChoiceBox<>();
		tiposHortaliza.setLayoutX(26.0);
		tiposHortaliza.setLayoutY(47.0);
		tiposHortaliza.setPrefHeight(26.0);
		tiposHortaliza.setPrefWidth(300.0);

		tiposHortaliza.getItems().add("Jitomate");
		tiposHortaliza.getItems().add("Cebolla");
		tiposHortaliza.getItems().add("Tomate de Cáscara");
		switch (planta.getIdTipoHortaliza()) {
			case 1:
				tiposHortaliza.getSelectionModel().select(0);
				break;
			case 2:
				tiposHortaliza.getSelectionModel().select(1);
				break;
			case 3:
				tiposHortaliza.getSelectionModel().select(2);
				break;
		}
		/////

		Label tvl = new Label("Variedad");
		tvl.setLayoutX(26.0);
		tvl.setLayoutY(107.0);
		
		TextField variedad = new TextField();
		variedad.setLayoutX(26.0);
		variedad.setLayoutY(125.0);
		variedad.setPrefHeight(26.0);
		variedad.setPrefWidth(300.0);
		variedad.setText(planta.getVariedad());

		Text variedadError = new Text("Variedad requerida");
		variedadError.setFill(Color.web("#dc1515"));
		variedadError.setLayoutX(26.0);
		variedadError.setLayoutY(164.0);
		variedadError.setStrokeType(StrokeType.OUTSIDE);
		variedadError.setStrokeWidth(0.0);
		variedadError.setVisible(false);
		/////

		Label pl = new Label("Precio");
		pl.setLayoutX(26.0);
		pl.setLayoutY(187.0);

		TextField precioPagar = new TextField();
		precioPagar.setLayoutX(26.0);
		precioPagar.setLayoutY(205.0);
		precioPagar.setPrefHeight(26.0);
		precioPagar.setPrefWidth(300.0);
		precioPagar.setText(planta.getPrecio() + "");

		Text precioError = new Text("Precio requerido");
		precioError.setFill(Color.web("#dc1515"));
		precioError.setLayoutX(26.0);
		precioError.setLayoutY(246.0);
		precioError.setStrokeType(StrokeType.OUTSIDE);
		precioError.setStrokeWidth(0.0);
		precioError.setVisible(false);
		/////

		Label ccl = new Label("Cantidad de charolas");
		ccl.setLayoutX(26.0);
		ccl.setLayoutY(270.0);

		TextField cantidadCharolas = new TextField();
		cantidadCharolas.setLayoutX(26.0);
		cantidadCharolas.setLayoutY(288.0);
		cantidadCharolas.setPrefHeight(26.0);
		cantidadCharolas.setPrefWidth(300.0);
		cantidadCharolas.setText(planta.getNumeroCharolas() + "");

		Text charolasError = new Text("Cantidad requerida");
		charolasError.setFill(Color.web("#dc1515"));
		charolasError.setLayoutX(26.0);
		charolasError.setLayoutY(327.0);
		charolasError.setStrokeType(StrokeType.OUTSIDE);
		charolasError.setStrokeWidth(0.0);
		charolasError.setVisible(false);
		/////
		
		AnchorPane contendorPlanta = new AnchorPane(
			thl, tiposHortaliza, tvl, variedad, variedadError,
			pl, precioPagar, precioError,
			ccl, cantidadCharolas, charolasError 
		);
		contendorPlanta.setMinHeight(0.0);
		contendorPlanta.setMinWidth(0.0);
		contendorPlanta.setPrefHeight(180.0);
		contendorPlanta.setPrefWidth(310.0);

		variedad.setOnMouseClicked(e -> {
			variedadError.setVisible(false);
		});

		precioPagar.setOnMouseClicked(e -> {
			precioError.setVisible(false);
		});

		cantidadCharolas.setOnMouseClicked(e -> {
			charolasError.setVisible(false);
		});

		plantaTab.setContent(contendorPlanta);

		return plantaTab;
	}

	public Scene getScene(){
		return escena;
	}
}
