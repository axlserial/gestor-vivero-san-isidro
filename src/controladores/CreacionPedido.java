package controladores;

import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;

import Entidades.Cliente;
import Entidades.Pedido;
import conexiones.ConexionClientes;
import conexiones.ConexionPedido;
import interfaces.FormularioRegistrarPedido;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.scene.control.ChoiceBox;
import javafx.scene.control.RadioButton;
import javafx.scene.control.Tab;
import javafx.scene.control.TabPane;
import javafx.scene.control.TextField;
import javafx.scene.layout.AnchorPane;
import javafx.scene.layout.Pane;
import javafx.stage.Stage;

public class CreacionPedido {

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
	
	private ConexionPedido conexionPedido;
	private ConexionClientes conexionClientes;
	private Pedido pedido;
	private Cliente cliente;
	private ArrayList<Cliente> clientes;

	public CreacionPedido(Stage escenario, Scene anterior){
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
			registrar();
		});

		cancelar.setOnAction(e -> {
			escenario.setScene(anterior);
		});

		// Obtener clientes
		cliente = new Cliente();
		conexionClientes = new ConexionClientes();
		ResultSet resultado = conexionClientes.buscarClientes("");
		clientes = new ArrayList<Cliente>();
		if (resultado != null) {
			try {
				while(resultado.next()) {
					String[] datos = new String[5];
					datos[0] = resultado.getString("nombres");
					datos[0] = resultado.getString("apellidos");
					datos[0] = resultado.getString("telefono1");
					datos[0] = resultado.getString("telefono2");
					datos[0] = resultado.getString("poblacion");
					clientes.add(cliente.crearObjeto(resultado.getInt("idCliente"), datos));
				}
				System.out.println(clientes);
			} catch (SQLException e1) {
				e1.printStackTrace();
			}
		}

	}

	void registrar() {
		plantas.getTabs().forEach(t -> {
			AnchorPane formulario = (AnchorPane)t.getContent();
			
			ChoiceBox<String> tipoHortaliza = (ChoiceBox)formulario.getChildren().get(1);
			TextField variedad = (TextField)formulario.getChildren().get(3);
			TextField precioPagar = (TextField)formulario.getChildren().get(6);
			TextField cantidadCharolas = (TextField)formulario.getChildren().get(9);

			
		});
	}

	public Scene getScene(){
		return interfaz.getScene();
	}
}
