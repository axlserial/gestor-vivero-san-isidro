package controladores;

import javafx.stage.Stage;
import interfaces.*;
import javafx.scene.control.Button;

public class ControladorHomepage {

	private Stage escenario;
	private InterfazHomepage interfaz;
	private ControladorCliente rcc;
	private ControladorRegistrarPedido rp;

	private Button registrarCliente;
	private Button registrarPedido;
	public Button registrarAbono;
	
	public ControladorHomepage(Stage escenario){
		this.escenario = escenario;
		this.interfaz = new InterfazHomepage();
		this.escenario.setScene(this.interfaz.getScene());

		this.registrarCliente = this.interfaz.registrarCliente;
		this.registrarPedido = this.interfaz.registrarPedido;
		this.registrarAbono = this.interfaz.registrarAbono;

		rcc = new ControladorCliente(escenario, this.interfaz.getScene());
		rp = new ControladorRegistrarPedido(escenario, this.interfaz.getScene());

		this.registrarCliente.setOnAction(e -> {
			escenario.setScene(rcc.getScene());
		});

		this.registrarPedido.setOnAction(e -> {
			escenario.setScene(rp.getScene());
		});
	}
}
