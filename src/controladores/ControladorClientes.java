package controladores;

import Entidades.Cliente;
import conexiones.ConexionClientes;
import interfaces.FormularioAgregarCliente;
import javafx.scene.Scene;
import javafx.stage.Stage;

public class ControladorClientes {

	private FormularioAgregarCliente interfaz;
	private ConexionClientes conexion;
	private Cliente cliente;

	public ControladorClientes(Stage escenario, Scene anterior) {
		interfaz = new FormularioAgregarCliente();

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

		conexion = new ConexionClientes();
		cliente = new Cliente();

	}

	private void registrar() {
		String valor;

		// En caso de que algún campo esté vacío
		boolean contenido = true;
		if (interfaz.nombres.getText().isEmpty()) {
			interfaz.nombresError.setText("Nombre(s) requerido(s)");
			interfaz.nombresError.setVisible(true);
			contenido = false;
		}

		// En caso de que no se introduzcan solo letras
		valor = interfaz.nombres.getText().replaceAll("\\s+", "");
		if (!interfaz.nombres.getText().isEmpty() && !valor.matches("^[a-zA-Z\\Á\\á\\É\\é\\Í\\í\\Ó\\ó\\Ú\\ú\\Ñ\\ñ]+$")) {
			interfaz.nombresError.setText("Solo se aceptan letras");
			interfaz.nombresError.setVisible(true);
			contenido = false;
		}

		if (interfaz.apellidos.getText().isEmpty()) {
			interfaz.apellidosError.setText("Apellido(s) requerido(s)");
			interfaz.apellidosError.setVisible(true);
			contenido = false;
		}

		// En caso de que no se introduzcan solo letras
		valor = interfaz.apellidos.getText().replaceAll("\\s+", "");
		if (!interfaz.apellidos.getText().isEmpty() && !valor.matches("^[a-zA-Z\\Á\\á\\É\\é\\Í\\í\\Ó\\ó\\Ú\\ú\\Ñ\\ñ]+$")) {
			interfaz.apellidosError.setText("Solo se aceptan letras");
			interfaz.apellidosError.setVisible(true);
			contenido = false;
		}

		if (interfaz.telefono1.getText().isEmpty()) {
			interfaz.telefono1Error.setText("Teléfono requerido");
			interfaz.telefono1Error.setVisible(true);
			contenido = false;
		}

		// Telefono1: En caso de que no se introduzcan solo números
		if (!interfaz.telefono1.getText().isEmpty() && !interfaz.telefono1.getText().matches("[0-9]*")) {
			interfaz.telefono1Error.setText("Solo se aceptan valores númericos");
			interfaz.telefono1Error.setVisible(true);
			contenido = false;
		}

		// Telefono 2: En caso de que no se introduzcan solo números
		if (!interfaz.telefono2.getText().isEmpty() && !interfaz.telefono2.getText().matches("[0-9]*")) {
			interfaz.telefono2Error.setText("Solo se aceptan valores númericos");
			interfaz.telefono2Error.setVisible(true);
			contenido = false;
		}

		if (interfaz.poblacion.getText().isEmpty()) {
			interfaz.poblacionError.setVisible(true);
			contenido = false;
		}

		// Hay campos vacios o con datos incorrectos
		if (!contenido)
			return;

		// CAMPOS RELLENADOS CORRECTAMENTE

		// Guardar en Base de Datos
		cliente.setNombre(interfaz.nombres.getText());
		cliente.setApellidos(interfaz.apellidos.getText());
		cliente.setPoblacion(interfaz.poblacion.getText());
		String[] telefonos = {interfaz.telefono1.getText(), interfaz.telefono2.getText()};
		cliente.setTelefonos(telefonos);
		if (!conexion.guardarCliente(cliente)) {
			interfaz.mensajes.error("Error al guardar el cliente");
			return;
		}
		conexion.cerrarConexion();

		// Muestra alerta de éxito
		interfaz.mensajes.mensaje("Usuario agregado exitosamente");

		// Limpia inputs
		limpiaInputs();
	}

	private void limpiaInputs() {
		interfaz.nombres.setText("");
		interfaz.apellidos.setText("");
		interfaz.telefono1.setText("");
		interfaz.telefono2.setText("");
		interfaz.poblacion.setText("");
		interfaz.nombresError.setVisible(false);
		interfaz.apellidosError.setVisible(false);
		interfaz.telefono1Error.setVisible(false);
		interfaz.telefono2Error.setVisible(false);
		interfaz.poblacionError.setVisible(false);
	}

	public Scene getScene() {
		return interfaz.getScene();
	}
}