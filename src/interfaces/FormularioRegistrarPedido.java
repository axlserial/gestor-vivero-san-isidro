package interfaces;

import javafx.scene.Cursor;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.scene.control.ChoiceBox;
import javafx.scene.control.DatePicker;
import javafx.scene.control.Label;
import javafx.scene.control.RadioButton;
import javafx.scene.control.Separator;
import javafx.scene.control.Tab;
import javafx.scene.control.TabPane;
import javafx.scene.control.TextField;
import javafx.scene.control.ToggleGroup;
import javafx.scene.control.TabPane.TabClosingPolicy;
import javafx.scene.image.ImageView;
import javafx.scene.layout.AnchorPane;
import javafx.scene.layout.Pane;
import javafx.scene.paint.Color;
import javafx.scene.shape.StrokeType;
import javafx.scene.text.Font;
import javafx.scene.text.Text;

public class FormularioRegistrarPedido {

	private Scene escena;
	public Button principal;
	public Button registrar;
	public Button cancelar;

	public RadioButton rbExistente;
	public RadioButton rbNuevo;

	public Pane panelExistentes;
	public Pane panelNuevo;

	public TextField nombres;
	public TextField apellidos;
	public TextField telefono;
	public TextField poblacion;

	public Text nombresError;
	public Text apellidosError;
	public Text telefonoError;
	public Text poblacionError;

	public TabPane plantas;
	public Button agregarPlanta;
	
	public FormularioRegistrarPedido(){
		
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

		Text titulo =  new Text("Registrar Pedido");
		titulo.setLayoutX(553.0);
		titulo.setLayoutY(76.0);
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

		ToggleGroup fuenteCliente = new ToggleGroup();

		rbExistente = new RadioButton("Seleccionar de cartera de clientes");
		rbExistente.setToggleGroup(fuenteCliente);
		rbExistente.setId("1");
		rbExistente.setLayoutX(50.0);
		rbExistente.setLayoutY(70.0);
		rbExistente.setMnemonicParsing(false);
		
		rbNuevo = new RadioButton("Registrar cliente nuevo");
		rbNuevo.setToggleGroup(fuenteCliente);
		rbNuevo.setId("2");
		rbNuevo.setLayoutX(50.0);
		rbNuevo.setLayoutY(94.0);
		rbNuevo.setMnemonicParsing(false);

		fuenteCliente.selectToggle(rbNuevo);
		/////

		ChoiceBox clientesExistentes = new ChoiceBox<>();
		clientesExistentes.setLayoutX(53.0);
		clientesExistentes.setLayoutY(29.0);
		clientesExistentes.setPrefHeight(25.0);
		clientesExistentes.setPrefWidth(300.0);

		panelExistentes = new Pane(clientesExistentes);
		panelExistentes.setLayoutY(126.0);
		panelExistentes.setPrefHeight(323.0);
		panelExistentes.setPrefWidth(384.0);
		panelExistentes.setVisible(false);
		/////

		Label nombresLabel = new Label("Nombre(s)");
		nombresLabel.setLayoutX(72.0);
		nombresLabel.setLayoutY(10.0);

		nombres = new TextField();
		nombres.setLayoutX(72.0);
		nombres.setLayoutY(28.0);
		nombres.setPrefHeight(26.0);
		nombres.setPrefWidth(300.0);

		nombresError = new Text();
		nombresError.setFill(Color.web("#dc1515"));
		nombresError.setLayoutX(72.0);
		nombresError.setLayoutY(67.0);
		nombresError.setStrokeType(StrokeType.OUTSIDE);
		nombresError.setStrokeWidth(0.0);
		nombresError.setVisible(false);
		/////

		Label apellidosLabel = new Label("Apellido(s)");
		apellidosLabel.setLayoutX(72.0);
		apellidosLabel.setLayoutY(88.0);

		apellidos = new TextField();
		apellidos.setLayoutX(72.0);
		apellidos.setLayoutY(106.0);
		apellidos.setPrefHeight(26.0);
		apellidos.setPrefWidth(300.0);

		apellidosError = new Text();
		apellidosError.setFill(Color.web("#dc1515"));
		apellidosError.setLayoutX(72.0);
		apellidosError.setLayoutY(145.0);
		apellidosError.setStrokeType(StrokeType.OUTSIDE);
		apellidosError.setStrokeWidth(0.0);
		apellidosError.setVisible(false);
		/////

		Label telefonoLabel = new Label("Teléfono");
		telefonoLabel.setLayoutX(72.0);
		telefonoLabel.setLayoutY(168.0);

		telefono = new TextField();
		telefono.setLayoutX(72.0);
		telefono.setLayoutY(186.0);
		telefono.setPrefHeight(26.0);
		telefono.setPrefWidth(300.0);

		telefonoError = new Text();
		telefonoError.setFill(Color.web("#dc1515"));
		telefonoError.setLayoutX(72.0);
		telefonoError.setLayoutY(227.0);
		telefonoError.setStrokeType(StrokeType.OUTSIDE);
		telefonoError.setStrokeWidth(0.0);
		telefonoError.setVisible(false);
		/////

		Label poblacionLabel = new Label("Población");
		poblacionLabel.setLayoutX(72.0);
		poblacionLabel.setLayoutY(251.0);

		poblacion = new TextField();
		poblacion.setLayoutX(72.0);
		poblacion.setLayoutY(269.0);
		poblacion.setPrefHeight(26.0);
		poblacion.setPrefWidth(300.0);

		poblacionError = new Text("Población requerida");
		poblacionError.setFill(Color.web("#dc1515"));
		poblacionError.setLayoutX(72.0);
		poblacionError.setLayoutY(308.0);
		poblacionError.setStrokeType(StrokeType.OUTSIDE);
		poblacionError.setStrokeWidth(0.0);
		poblacionError.setVisible(false);
		/////

		panelNuevo = new Pane(
			nombres, nombresLabel, nombresError,
			apellidos, apellidosLabel, apellidosError,
			telefono, telefonoLabel, telefonoError,
			poblacion, poblacionLabel, poblacionError
		);
		panelNuevo.setLayoutX(1.0);
		panelNuevo.setLayoutY(129.0);
		panelNuevo.setPrefHeight(323.0);
		panelNuevo.setPrefWidth(384.0);

		Pane parteCliente = new Pane(
			titleCliente,rbExistente, rbNuevo,
			panelExistentes, panelNuevo
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

		DatePicker fecha = new DatePicker();
		fecha.setLayoutX(42.0);
		fecha.setLayoutY(87.0);
		fecha.setPrefHeight(25.0);
		fecha.setPrefWidth(300.0);
		/////

		Label pi = new Label("Pago inicial");
		pi.setLayoutX(42.0);
		pi.setLayoutY(140.0);

		TextField pagoInicial = new TextField();
		pagoInicial.setLayoutX(42.0);
		pagoInicial.setLayoutY(157.0);
		pagoInicial.setPrefHeight(26.0);
		pagoInicial.setPrefWidth(300.0);
		/////

		Pane partePedido = new Pane(
			titlePedido, fp, fecha, pi, pagoInicial
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

		cancelar = new Button("Cancelar");
		cancelar.setLayoutX(697.0);
		cancelar.setLayoutY(531.0);
		cancelar.setMnemonicParsing(false);
		cancelar.setPrefHeight(26.0);
		cancelar.setPrefWidth(146.0);

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
			navbar, titulo, cuerpo
		);
		formularios.setPrefHeight(720.0);
		formularios.setPrefWidth(1280.0);

		escena = new Scene(formularios, 1280, 720);
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

		tiposHortaliza.getItems().addAll("Tipo 1");
		tiposHortaliza.getItems().addAll("Tipo 2");
		tiposHortaliza.getItems().addAll("Tipo 3");
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

		return contendorPlanta;
	}

	public Scene getScene(){
		return escena;
	}

}
