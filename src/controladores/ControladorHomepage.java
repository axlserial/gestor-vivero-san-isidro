package controladores;

import javafx.stage.Stage;
import interfaces.InterfazHomepage;
import javafx.scene.control.Button;

public class ControladorHomepage {

	private Stage escenario;
	private InterfazHomepage interfaz;
	private ControladorCliente rcc;

	private Button registrarCliente;
	
	public ControladorHomepage(Stage escenario){
		this.escenario = escenario;
		this.interfaz = new InterfazHomepage();
		this.escenario.setScene(this.interfaz.getScene());
		this.registrarCliente = this.interfaz.registrarCliente;

		rcc = new ControladorCliente(escenario, this.interfaz.getScene());

		this.registrarCliente.setOnAction(e -> {
			escenario.setScene(rcc.getScene());
		});
	}
}
