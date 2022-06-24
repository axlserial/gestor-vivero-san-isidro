package controladores;

import java.util.ArrayList;

import Entidades.AbonoPago;
import Entidades.Cliente;
import Entidades.Pedido;
import Entidades.Planta;
import interfaces.BusquedaRegistrarAbono;
import interfaces.FormularioRegistrarAbono;
import javafx.geometry.Pos;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.scene.control.Label;
import javafx.scene.layout.HBox;
import javafx.scene.layout.VBox;
import javafx.scene.text.Font;
import javafx.stage.Stage;

public class ControladorAbono {

	private BusquedaRegistrarAbono interfazBusqueda;
	private ArrayList<Pedido> pedidos;
	
	public ControladorAbono(Stage escenario, Scene anterior) {
		interfazBusqueda = new BusquedaRegistrarAbono();

		pedidos = new ArrayList<>();

		Pedido ped = new Pedido();
		Planta[] plants = new Planta[2];
		AbonoPago[] abpago = new AbonoPago[2];
		ped.setIdPedido(1);
		ped.setFechaPedido("2022-06-22");
		ped.setCliente(new Cliente());
		plants[0] = new Planta();
		plants[1] = new Planta();
		abpago[0] = new AbonoPago();
		abpago[1] = new AbonoPago();
		ped.setPlantas(plants);
		ped.setPagos(abpago);
		pedidos.add(ped);

		ped = new Pedido();
		plants = new Planta[2];
		abpago = new AbonoPago[2];
		ped.setIdPedido(2);
		ped.setFechaPedido("2022-06-22");
		ped.setCliente(new Cliente());
		plants[0] = new Planta();
		plants[1] = new Planta();
		abpago[0] = new AbonoPago();
		abpago[1] = new AbonoPago();
		ped.setPlantas(plants);
		ped.setPagos(abpago);
		pedidos.add(ped);

		ped = new Pedido();
		plants = new Planta[2];
		abpago = new AbonoPago[2];
		ped.setIdPedido(3);
		ped.setFechaPedido("2022-06-22");
		ped.setCliente(new Cliente());
		plants[0] = new Planta();
		plants[1] = new Planta();
		abpago[0] = new AbonoPago();
		abpago[1] = new AbonoPago();
		ped.setPlantas(plants);
		ped.setPagos(abpago);
		pedidos.add(ped);

		ped = new Pedido();
		plants = new Planta[2];
		abpago = new AbonoPago[2];
		ped.setIdPedido(4);
		ped.setFechaPedido("2022-06-22");
		ped.setCliente(new Cliente());
		plants[0] = new Planta();
		plants[1] = new Planta();
		abpago[0] = new AbonoPago();
		abpago[1] = new AbonoPago();
		ped.setPlantas(plants);
		ped.setPagos(abpago);
		pedidos.add(ped);

		ped = new Pedido();
		plants = new Planta[2];
		abpago = new AbonoPago[2];
		ped.setIdPedido(5);
		ped.setFechaPedido("2022-06-22");
		ped.setCliente(new Cliente());
		plants[0] = new Planta();
		plants[1] = new Planta();
		abpago[0] = new AbonoPago();
		abpago[1] = new AbonoPago();
		ped.setPlantas(plants);
		ped.setPagos(abpago);
		pedidos.add(ped);

		interfazBusqueda.principal.setOnAction(e -> {
			escenario.setScene(anterior);
		});

		interfazBusqueda.regresar.setOnAction(e -> {
			escenario.setScene(anterior);
		});

		interfazBusqueda.buscar.setOnAction(e -> {
			// Aqui se realiza la busqueda y se guarda en el arraylist pedidos
			String nombre = interfazBusqueda.busqueda.getText();
			String fechaIni = interfazBusqueda.fechaInicial.getValue().toString();
			String fechaFin = interfazBusqueda.fechaFinal.getValue().toString();

			// Establece cantidad de páginas
			int paginas = pedidos.size() / 4;
			if (paginas == 0)
				paginas = 1;
			else
				paginas = pedidos.size() % 2 == 0 ? paginas : paginas + 1;
			interfazBusqueda.pag.setPageCount(paginas);
		});

		interfazBusqueda.pag.setPageFactory((indice) -> {
			return creaPagina(indice);
        });
		
	}

    public VBox creaPagina(int indice) {
		HBox datos;
		VBox box = new VBox();
		box.setAlignment(Pos.CENTER);
		box.setSpacing(20);

        int indiceInicial = indice * 4, indiceFinal;
		if (indiceInicial == 0)
			indiceFinal = pedidos.size() <= 4 ? pedidos.size() : 4;
		else
			indiceFinal = pedidos.size() - indiceInicial;

		// Llena vbox con datos de lso resultados de pedidos
		for (int i = 0; i < indiceFinal; i++, indiceInicial++){
			int indicePedido = indiceInicial;
			Pedido actual = pedidos.get(indiceInicial);
			datos = new HBox();
			datos.setAlignment(Pos.CENTER);
			datos.setSpacing(20);

			Label info = new Label("Pedido #" + actual.getIdPedido() + " - Fecha: " + actual.getFechaPedido());
			info.setFont(new Font("Segoe UI", 18.0));
			
			Button regAbono = new Button("Registrar abono");
			regAbono.setOnAction(e -> {
				modificar(indicePedido);
			});

			datos.getChildren().addAll(info, regAbono);
			box.getChildren().add(datos);
		}

        return box;
    }

	private void modificar(int indice) {
		Pedido pedido = this.pedidos.get(indice);
		// aqui se abre ventana para agregar abono
		FormularioRegistrarAbono ff = new FormularioRegistrarAbono();
		Scene escenaAbonar = ff.abrir(pedido);
		Stage ventana = new Stage();
		ventana.setScene(escenaAbonar);
		
		ff.cancelar.setOnAction(e -> {
			ventana.close();
		});
		
		ff.registrar.setOnAction(e -> {
			boolean contenido = true;
			double precio;

			if (ff.pago.getText().isEmpty()) {
				ff.mensajes.error("Abono vacío");
				contenido = false;
			} else {
				try {
					precio = Double.parseDouble(ff.pago.getText());
				} catch (Exception exp) {
					ff.mensajes.error("Valor incorrecto");
					contenido = false;
				}
			}

			// Pasó varificación
			if (contenido) {

				// insersión del abono

				// mensaje de exito
				ff.mensajes.mensaje("Registro correcto");
				ventana.close();
			}
		});

		ventana.showAndWait();
	}

	public Scene getScene() {
		return interfazBusqueda.getScene();
	}
}
