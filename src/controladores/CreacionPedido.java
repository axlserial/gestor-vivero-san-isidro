package controladores;

import java.sql.ResultSet;
import java.sql.SQLException;
import java.time.LocalDate;
import java.util.ArrayList;

import Entidades.AbonoPago;
import Entidades.Cliente;
import Entidades.Pedido;
import Entidades.Planta;
import conexiones.ConexionClientes;
import conexiones.ConexionPedido;
import interfaces.FormularioRegistrarPedido;
import javafx.scene.Scene;
import javafx.scene.control.ChoiceBox;
import javafx.scene.control.Tab;
import javafx.scene.control.TextField;
import javafx.scene.layout.AnchorPane;
import javafx.scene.text.Text;
import javafx.stage.Stage;

public class CreacionPedido {

	private FormularioRegistrarPedido interfaz;

	private boolean contenido;
	
	private ConexionPedido conexionPedido;
	private ConexionClientes conexionClientes;
	private Pedido pedido;
	private Cliente cliente;
	private ArrayList<Cliente> clientes;
	private ArrayList<Planta> plantas;

	public CreacionPedido(Stage escenario, Scene anterior){
		interfaz = new FormularioRegistrarPedido();
		
		interfaz.agregarPlanta.setOnAction(e -> {
			Tab planta = new Tab("Planta " + (interfaz.plantas.getTabs().size() + 1));
			planta.setContent(interfaz.agregaTabPlanta());
			interfaz.plantas.getTabs().add(planta);
		});

		interfaz.principal.setOnAction(e -> {
			escenario.setScene(anterior);
			limpiaInputs();
		});

		interfaz.registrar.setOnAction(e -> {
			registrar();
		});

		interfaz.cancelar.setOnAction(e -> {
			escenario.setScene(anterior);
			limpiaInputs();
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
					datos[1] = resultado.getString("apellidos");
					datos[2] = resultado.getString("telefono1");
					datos[3] = resultado.getString("telefono2");
					datos[4] = resultado.getString("poblacion");
					clientes.add(cliente.crearObjeto(resultado.getInt("idCliente"), datos));
				}
				
				clientes.forEach(cliente -> {
					interfaz.clientesExistentes.getItems()
					.add(cliente.getIdCliente() + " - " + cliente.getNombre() + " " + cliente.getApellidos());
				});
				interfaz.clientesExistentes.getSelectionModel().selectFirst();
			} catch (SQLException e1) {
				e1.printStackTrace();
			}
		}

	}

	@SuppressWarnings("unchecked")
	void registrar() {
		contenido = true;
		Double pagoInicial = Double.parseDouble("0.0");
		LocalDate fechaPedido;

		int id = Integer.parseInt(interfaz.clientesExistentes.getValue().split("-")[0].trim());

		plantas = new ArrayList<>();
		interfaz.plantas.getTabs().forEach(t -> {
			String valor;
			Double precio = 0.0;
			int cantidad = 0;

			AnchorPane formulario = (AnchorPane)t.getContent();
			
			ChoiceBox<String> tipoHortaliza = (ChoiceBox<String>)formulario.getChildren().get(1);
			String tipoElegido = tipoHortaliza.getSelectionModel().getSelectedItem();

			TextField variedad = (TextField)formulario.getChildren().get(3);
			Text variedadError = (Text)formulario.getChildren().get(4);

			// En caso de que esté vacío
			if (variedad.getText().isEmpty()) {
				variedadError.setText("Variedad requerida");
				variedadError.setVisible(true);
				contenido = false;
			}

			// En caso de que no se introduzcan solo letras
			valor = variedad.getText().replaceAll("\\s+", "");
			if (!variedad.getText().isEmpty() && !valor.matches("^[a-zA-Z\\Á\\á\\É\\é\\Í\\í\\Ó\\ó\\Ú\\ú\\Ñ\\ñ]+$")) {
				variedadError.setText("Solo se aceptan letras");
				variedadError.setVisible(true);
				contenido = false;
			}

			TextField precioPagar = (TextField)formulario.getChildren().get(6);
			Text precioError = (Text)formulario.getChildren().get(7);

			// En caso de que esté vacío
			if (precioPagar.getText().isEmpty()) {
				precioError.setText("Precio requerido");
				precioError.setVisible(true);
				contenido = false;
			}

			// Si no se metió un precio válido
			try {
				precio = Double.parseDouble(precioPagar.getText());
			} catch (Exception e) {
				precioError.setText("Valor incorrecto");
				precioError.setVisible(true);
				contenido = false;
			}

			TextField cantidadCharolas = (TextField)formulario.getChildren().get(9);
			Text charolasError = (Text)formulario.getChildren().get(10);

			// En caso de que esté vacío
			if (cantidadCharolas.getText().isEmpty()) {
				charolasError.setText("Cantidad requerida");
				charolasError.setVisible(true);
				contenido = false;
			}

			// Si no se metió una cantidad válida
			try {
				cantidad = Integer.parseInt(cantidadCharolas.getText());
			} catch (Exception e) {
				charolasError.setText("Valor incorrecto");
				charolasError.setVisible(true);
				contenido = false;
			}

			if (contenido) {
				Planta p = new Planta();
				p.setTipoHortaliza(tipoElegido);
				p.setVariedad(variedad.getText());
				p.setPrecio(precio);
				p.setNumeroCharolas(cantidad);
				plantas.add(p);
			}
		});

		fechaPedido = interfaz.fecha.getValue();

		// En caso de que esté vacío
		if (interfaz.pagoInicial.getText().isEmpty()) {
			interfaz.pagoError.setText("Pago requerido");
			interfaz.pagoError.setVisible(true);
			contenido = false;
		}

		// Si no se metió un pago válido
		try {
			pagoInicial = Double.parseDouble(interfaz.pagoInicial.getText());
		} catch (Exception e) {
			interfaz.pagoError.setText("Valor incorrecto");
			interfaz.pagoError.setVisible(true);
			contenido = false;
		}

		// Hay campos vacios o con datos incorrectos
		if (!contenido)
			return;

		// CAMPOS RELLENADOS CORRECTAMENTE
		pedido = new Pedido();
		// Buscar cliente
		clientes.forEach(c -> {
		});
		pedido.setCliente(cliente);
		pedido.setFechaPedido(fechaPedido.toString());
		AbonoPago pagos[] = new AbonoPago[1];
		pagos[0] = new AbonoPago();
		pagos[0].setCantidad(pagoInicial);
		pagos[0].setFecha(fechaPedido.toString());
		pedido.setPagos(pagos);
		pedido.setPlantas((Planta[] )plantas.toArray());

	}

	private void limpiaInputs() {
		interfaz.nombre.setText("");
		Tab planta1 = new Tab("Planta 1");
		planta1.setContent(interfaz.agregaTabPlanta());
		planta1.setClosable(false);
		interfaz.plantas.getTabs().clear();
		interfaz.plantas.getTabs().add(planta1);
		interfaz.fecha.setValue(LocalDate.now());
		interfaz.pagoInicial.setText("");
		interfaz.pagoError.setVisible(false);
	}

	public Scene getScene(){
		return interfaz.getScene();
	}
}