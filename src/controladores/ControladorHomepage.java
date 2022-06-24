package controladores;

import javafx.stage.Stage;
import interfaces.*;

public class ControladorHomepage {

	private Stage escenario;
	private InterfazHomepage interfaz;
	private ControladorClientes rcc;
	private ControladorPedidos cpp;
	private CreacionPedido rp;
	private ControladorAbono ca;
	
	public ControladorHomepage(Stage escenario){
		this.escenario = escenario;
		this.interfaz = new InterfazHomepage();
		this.escenario.setScene(this.interfaz.getScene());

		interfaz.registrarCliente.setOnAction(e -> {
			rcc = new ControladorClientes(escenario, this.interfaz.getScene());
			escenario.setScene(rcc.getScene());
		});

		interfaz.registrarPedido.setOnAction(e -> {
			rp = new CreacionPedido(escenario, this.interfaz.getScene());
			escenario.setScene(rp.getScene());
		});
		
		interfaz.registrarAbono.setOnAction(e -> {
			ca = new ControladorAbono(escenario, this.interfaz.getScene());
			escenario.setScene(ca.getScene());
		});

		interfaz.administrarPedidos.setOnAction(e -> {
			cpp = new ControladorPedidos(escenario, this.interfaz.getScene());
			escenario.setScene(cpp.getScene());
		});
	}
}
