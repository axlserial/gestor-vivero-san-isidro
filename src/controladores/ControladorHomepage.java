package controladores;

import javafx.stage.Stage;
import interfaces.*;
import javafx.scene.control.Button;

public class ControladorHomepage {

	private Stage escenario;
	private InterfazHomepage interfaz;
	private ControladorClientes rcc;
	private CreacionPedido rp;

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


		this.registrarCliente.setOnAction(e -> {
			rcc = new ControladorClientes(escenario, this.interfaz.getScene());
			escenario.setScene(rcc.getScene());
		});

		this.registrarPedido.setOnAction(e -> {
			rp = new CreacionPedido(escenario, this.interfaz.getScene());
			escenario.setScene(rp.getScene());
		});
	}
}
