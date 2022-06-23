package controladores;

import Entidades.Cliente;
import conexiones.ConexionClientes;
import interfaces.FormularioAgregarCliente;
import javafx.scene.Scene;
import javafx.scene.control.Alert;
import javafx.scene.control.Button;
import javafx.scene.control.TextField;
import javafx.scene.image.Image;
import javafx.scene.text.Text;
import javafx.stage.Stage;

public class ControladorCliente {

	private FormularioAgregarCliente interfaz;
	private Button principal;
	private Button registrar;
	private Button cancelar;
	private TextField nombres;
	private TextField apellidos;
	private TextField[] telefono;
	private TextField poblacion;

	private Text nombresError;
	private Text apellidosError;
	private Text telefonoError;
	private Text poblacionError;

	private Alert alerta;

	private ConexionClientes conexion;
	private Cliente cliente;

	public ControladorCliente(Stage escenario, Scene anterior) {
		interfaz = new FormularioAgregarCliente();

		principal = interfaz.principal;
		registrar = interfaz.registrar;
		cancelar = interfaz.cancelar;
		nombres = interfaz.nombres;
		apellidos = interfaz.apellidos;
		telefono = interfaz.telefono;
		poblacion = interfaz.poblacion;
		nombresError = interfaz.nombresError;
		apellidosError = interfaz.apellidosError;
		telefonoError = interfaz.telefonoError;
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

		if (telefono[0].getText().isEmpty()) {
			telefonoError.setText("Teléfono requerido");
			telefonoError.setVisible(true);
			contenido = false;
		}

		// En caso de que no se introduzcan solo números
		if (!telefono[0].getText().isEmpty() && !telefono[0].getText().matches("[0-9]*")) {
			telefonoError.setText("Solo se aceptan valores númericos");
			telefonoError.setVisible(true);
			contenido = false;
		}

		if (poblacion.getText().isEmpty()) {
			poblacionError.setVisible(true);
			contenido = false;
		}

		// Hay campos vacios
		if (!contenido)
			return;

		// CAMPOS RELLENADOS CORRECTAMENTE

		// Guardar en Base de Datos
		cliente.setNombre(nombres.getText());
		cliente.setApellidos(apellidos.getText());
		cliente.setPoblacion(poblacion.getText());
		String[] telefonos = {telefono[0].getText(), ""};
		cliente.setTelefonos(telefonos);
		if (!conexion.guardarCliente(cliente)) {
			System.err.println("Error al guardar el cliente");
			return;
		}

		// Muestra alerta de confirmación
		alerta = new Alert(Alert.AlertType.INFORMATION);
		Stage alertaStage = (Stage) alerta.getDialogPane().getScene().getWindow();
		alertaStage.getIcons()
				.add(new Image(getClass().getResource("/assets/logo.png").toExternalForm()));
		alerta.setTitle("Confirmación");
		alerta.setHeaderText("Usuario registrado con éxito");
		alerta.setContentText("Ya puede cerrar esté menú");
		alerta.showAndWait();

		// Limpia inputs
		limpiaInputs();
	}

	private void limpiaInputs() {
		nombres.setText("");
		apellidos.setText("");
		telefono[0].setText("");
		poblacion.setText("");
	}

	public Scene getScene() {
		return interfaz.getScene();
	}
}