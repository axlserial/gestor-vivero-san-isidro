package controladores;

import Entidades.Cliente;
import conexiones.ConexionClientes;
import interfaces.FormularioAgregarCliente;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.scene.control.TextField;
import javafx.scene.text.Text;
import javafx.stage.Stage;

public class ControladorClientes {

	private FormularioAgregarCliente interfaz;
	private Button principal;
	private Button registrar;
	private Button cancelar;
	private TextField nombres;
	private TextField apellidos;
	private TextField telefono1;
	private TextField telefono2;
	private TextField poblacion;

	private Text nombresError;
	private Text apellidosError;
	private Text telefono1Error;
	private Text telefono2Error;
	private Text poblacionError;

	private ConexionClientes conexion;
	private Cliente cliente;

	public ControladorClientes(Stage escenario, Scene anterior) {
		interfaz = new FormularioAgregarCliente();

		principal = interfaz.principal;
		registrar = interfaz.registrar;
		cancelar = interfaz.cancelar;
		nombres = interfaz.nombres;
		apellidos = interfaz.apellidos;
		telefono1 = interfaz.telefono1;
		telefono2 = interfaz.telefono2;
		poblacion = interfaz.poblacion;
		nombresError = interfaz.nombresError;
		apellidosError = interfaz.apellidosError;
		telefono1Error = interfaz.telefono1Error;
		telefono2Error = interfaz.telefono2Error;
		poblacionError = interfaz.poblacionError;

		principal.setOnAction(e -> {
			escenario.setScene(anterior);
			limpiaInputs();
		});

		registrar.setOnAction(e -> {
			registrar();
		});

		cancelar.setOnAction(e -> {
			escenario.setScene(anterior);
			limpiaInputs();
		});

		conexion = new ConexionClientes();
		cliente = new Cliente();

	}

	private void registrar() {
		String valor;

		// En caso de que algún campo esté vacío
		boolean contenido = true;
		if (nombres.getText().isEmpty()) {
			nombresError.setText("Nombre(s) requerido(s)");
			nombresError.setVisible(true);
			contenido = false;
		}

		// En caso de que no se introduzcan solo letras
		valor = nombres.getText().replaceAll("\\s+", "");
		if (!nombres.getText().isEmpty() && !valor.matches("^[a-zA-Z\\Á\\á\\É\\é\\Í\\í\\Ó\\ó\\Ú\\ú\\Ñ\\ñ]+$")) {
			nombresError.setText("Solo se aceptan letras");
			nombresError.setVisible(true);
			contenido = false;
		}

		if (apellidos.getText().isEmpty()) {
			apellidosError.setText("Apellido(s) requerido(s)");
			apellidosError.setVisible(true);
			contenido = false;
		}

		// En caso de que no se introduzcan solo letras
		valor = apellidos.getText().replaceAll("\\s+", "");
		if (!apellidos.getText().isEmpty() && !valor.matches("^[a-zA-Z\\Á\\á\\É\\é\\Í\\í\\Ó\\ó\\Ú\\ú\\Ñ\\ñ]+$")) {
			apellidosError.setText("Solo se aceptan letras");
			apellidosError.setVisible(true);
			contenido = false;
		}

		if (telefono1.getText().isEmpty()) {
			telefono1Error.setText("Teléfono requerido");
			telefono1Error.setVisible(true);
			contenido = false;
		}

		// Telefono1: En caso de que no se introduzcan solo números
		if (!telefono1.getText().isEmpty() && !telefono1.getText().matches("[0-9]*")) {
			telefono1Error.setText("Solo se aceptan valores númericos");
			telefono1Error.setVisible(true);
			contenido = false;
		}

		// Telefono 2: En caso de que no se introduzcan solo números
		if (!telefono2.getText().isEmpty() && !telefono2.getText().matches("[0-9]*")) {
			telefono2Error.setText("Solo se aceptan valores númericos");
			telefono2Error.setVisible(true);
			contenido = false;
		}

		if (poblacion.getText().isEmpty()) {
			poblacionError.setVisible(true);
			contenido = false;
		}

		// Hay campos vacios o con datos incorrectos
		if (!contenido)
			return;

		// CAMPOS RELLENADOS CORRECTAMENTE

		// Guardar en Base de Datos
		cliente.setNombre(nombres.getText());
		cliente.setApellidos(apellidos.getText());
		cliente.setPoblacion(poblacion.getText());
		String[] telefonos = {telefono1.getText(), telefono2.getText()};
		cliente.setTelefonos(telefonos);
		if (!conexion.guardarCliente(cliente)) {
			interfaz.mensajes.error("Error al guardar el cliente");
			return;
		}

		// Muestra alerta de éxito
		interfaz.mensajes.mensaje("Usuario agregado exitosamente");

		// Limpia inputs
		limpiaInputs();
	}

	private void limpiaInputs() {
		nombres.setText("");
		apellidos.setText("");
		telefono1.setText("");
		telefono2.setText("");
		poblacion.setText("");
	}

	public Scene getScene() {
		return interfaz.getScene();
	}
}