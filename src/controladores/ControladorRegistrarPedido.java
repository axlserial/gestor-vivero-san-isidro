package controladores;

import interfaces.FormularioRegistrarPedido;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.scene.control.RadioButton;
import javafx.scene.control.Tab;
import javafx.scene.control.TabPane;
import javafx.scene.layout.Pane;
import javafx.stage.Stage;

public class ControladorRegistrarPedido {

	private FormularioRegistrarPedido interfaz;

	private RadioButton rbExistente;
	private RadioButton rbNuevo;

	private Pane panelExistentes;
	private Pane panelNuevo;

	private Button agregarPlanta;
	private TabPane plantas;

	private Button principal;
	private Button registrar;
	private Button cancelar;

	public ControladorRegistrarPedido(Stage escenario, Scene anterior){
		interfaz = new FormularioRegistrarPedido();

		this.rbExistente = interfaz.rbExistente;
		this.rbNuevo = interfaz.rbNuevo;
		this.panelExistentes = interfaz.panelExistentes;
		this.panelNuevo = interfaz.panelNuevo;
		this.plantas = interfaz.plantas;
		this.agregarPlanta = interfaz.agregarPlanta;
		this.principal = interfaz.principal;
		this.registrar = interfaz.registrar;
		this.cancelar = interfaz.cancelar;

		this.rbExistente.setOnAction(e -> {
			panelNuevo.setVisible(false);
			panelExistentes.setVisible(true);
		});

		this.rbNuevo.setOnAction(e -> {
			panelExistentes.setVisible(false);
			panelNuevo.setVisible(true);
		});

		agregarPlanta.setOnAction(e -> {
			Tab planta = new Tab("Planta " + (plantas.getTabs().size() + 1));
			planta.setContent(interfaz.agregaTabPlanta());
			plantas.getTabs().add(planta);
		});

		principal.setOnAction(e -> {
			escenario.setScene(anterior);
		});

		registrar.setOnAction(e -> {
			// registrar();
		});

		cancelar.setOnAction(e -> {
			escenario.setScene(anterior);
		});

	}

	public Scene getScene(){
		return interfaz.getScene();
	}
}
