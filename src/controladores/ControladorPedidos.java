package controladores;

import java.util.ArrayList;
import Entidades.AbonoPago;
import Entidades.Cliente;
import Entidades.Pedido;
import Entidades.Planta;
import interfaces.BusquedaAdministrarPedidos;
import interfaces.FormularioModificarPedido;
import javafx.geometry.Pos;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.scene.control.ChoiceBox;
import javafx.scene.control.Label;
import javafx.scene.control.TextField;
import javafx.scene.layout.AnchorPane;
import javafx.scene.layout.HBox;
import javafx.scene.layout.VBox;
import javafx.scene.text.Font;
import javafx.scene.text.Text;
import javafx.stage.Stage;

public class ControladorPedidos {

	private BusquedaAdministrarPedidos interfazBusqueda;
	private ArrayList<Pedido> pedidos;
	private boolean contenido;
	
	public ControladorPedidos(Stage escenario, Scene anterior) {
		interfazBusqueda = new BusquedaAdministrarPedidos();
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
			interfazBusqueda.pag.setPageCount(paginas + 1);
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
			
			Button modBtn = new Button("Modificar");
			modBtn.setOnAction(e -> {
				modificar(indicePedido);
			});

			Button eliBtn = new Button("Eliminar");
			eliBtn.setOnAction(e -> {
				eliminar(indicePedido);
			});

			datos.getChildren().addAll(info, modBtn, eliBtn);
			box.getChildren().add(datos);
		}

        return box;
    }

	private void modificar(int indice) {
		Pedido pedido = this.pedidos.get(indice);
		FormularioModificarPedido fmp = new FormularioModificarPedido();
		fmp.abrir(pedido);
		Stage ventana = new Stage();
		ventana.setScene(fmp.getScene());

		fmp.cancelar.setOnAction(e -> {
			ventana.close();
		});

		fmp.registrar.setOnAction(e -> {
			contenido = true;
			// int id, diasInt;
			Double pagoInicial = Double.parseDouble("0.0");
			String fechaPedido, fechaSiembra, fechaEntrega;
			// String dias = "";
	
			// id = Integer.parseInt(interfaz.clientesExistentes.getValue().split("-")[0].trim());
	
			ArrayList<Planta> plantas = new ArrayList<>();
			fmp.plantas.getTabs().forEach(t -> {
				String valor;
				Double precio = 0.0;
				int cantidad = 0, tipo = 0;
	
				AnchorPane formulario = (AnchorPane) t.getContent();
	
				ChoiceBox<String> tipoHortaliza = (ChoiceBox<String>) formulario.getChildren().get(1);
				String tipoElegido = tipoHortaliza.getSelectionModel().getSelectedItem();
	
				TextField variedad = (TextField) formulario.getChildren().get(3);
				Text variedadError = (Text) formulario.getChildren().get(4);
	
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
	
				TextField precioPagar = (TextField) formulario.getChildren().get(6);
				Text precioError = (Text) formulario.getChildren().get(7);
	
				// En caso de que esté vacío
				if (precioPagar.getText().isEmpty()) {
					precioError.setText("Precio requerido");
					precioError.setVisible(true);
					contenido = false;
				}
	
				// Si no se metió un precio válido
				try {
					precio = Double.parseDouble(precioPagar.getText());
				} catch (Exception exc) {
					precioError.setText("Valor incorrecto");
					precioError.setVisible(true);
					contenido = false;
				}
	
				TextField cantidadCharolas = (TextField) formulario.getChildren().get(9);
				Text charolasError = (Text) formulario.getChildren().get(10);
	
				// En caso de que esté vacío
				if (cantidadCharolas.getText().isEmpty()) {
					charolasError.setText("Cantidad requerida");
					charolasError.setVisible(true);
					contenido = false;
				}
	
				// Si no se metió una cantidad válida
				try {
					cantidad = Integer.parseInt(cantidadCharolas.getText());
				} catch (Exception exp) {
					charolasError.setText("Valor incorrecto");
					charolasError.setVisible(true);
					contenido = false;
				}
	
				if (contenido) {
					Planta p = new Planta();
					// switch (tipoElegido) {
					// 	case "Jitomate":
					// 		tipo = 1;
					// 		break;
					// 	case "Cebolla":
					// 		tipo = 2;
					// 		break;
					// 	case "Tomate de Cáscara":
					// 		tipo = 3;
					// 		break;
					// }
					p.setTipoHortaliza(tipo);
					p.setVariedad(variedad.getText());
					p.setPrecio(precio);
					p.setNumeroCharolas(cantidad);
					plantas.add(p);
				}
			});
	
			fechaPedido = fmp.fecha.getValue().toString();
			fechaSiembra = fmp.fechaSiembra.getValue() == null ? "" : fmp.fechaSiembra.getValue().toString();
			fechaEntrega = fmp.fechaEntrega.getValue() == null ? "" : fmp.fechaEntrega.getValue().toString();
	
			// En caso de que esté vacío
			if (fmp.pagoInicial.getText().isEmpty()) {
				fmp.pagoError.setText("Pago requerido");
				fmp.pagoError.setVisible(true);
				contenido = false;
			}
	
			// Si no se metió un pago válido
			try {
				pagoInicial = Double.parseDouble(fmp.pagoInicial.getText());
			} catch (Exception exp) {
				fmp.pagoError.setText("Valor incorrecto");
				fmp.pagoError.setVisible(true);
				contenido = false;
			}
	
			// En caso de que esté vacío
			// if (fmp.diasAprox.getText().isEmpty()) {
			// 	fmp.diasError.setText("Número de días requerido");
			// 	fmp.diasError.setVisible(true);
			// 	contenido = false;
			// }
	
			// // Si no se metió una cantidad válida
			// try {
			// 	diasInt = Integer.parseInt(fmp.diasAprox.getText());
			// 	dias = LocalDate.now().plusDays(diasInt).toString();
			// } catch (Exception exp) {
			// 	fmp.diasError.setText("Valor incorrecto");
			// 	fmp.diasError.setVisible(true);
			// 	contenido = false;
			// }
	
			// Hay campos vacios o con datos incorrectos
			if (!contenido)
				return;
	
			// CAMPOS RELLENADOS CORRECTAMENTE
			Pedido ped = new Pedido();
			// Buscar cliente
			// clientes.forEach(c -> {
			// 	if (c.getIdCliente() == id)
			// 		cliente = c;
			// });
			ped.setCliente(pedido.getCliente());
			ped.setFechaPedido(fechaPedido);
			ped.setFechaSiembra(fechaSiembra);
			ped.setFechaEntrega(fechaEntrega);
			// ped.setFechaAproximada(dias);
			AbonoPago pagos[] = new AbonoPago[1];
			pagos[0] = new AbonoPago();
			pagos[0].setCantidad(pagoInicial);
			pagos[0].setFecha(fechaPedido.toString());
			pedido.setPagos(pagos);
			pedido.setPlantas((plantas.toArray(new Planta[0])));
	
			// Aqui va actualizar pedido
	
			fmp.mensajes.mensaje("Pedido Actualizado Exitosamente");
		});

		ventana.show();
	}

	private void eliminar(int indice) {
		int id = this.pedidos.get(indice).getIdPedido();
		boolean eleccion = interfazBusqueda.mensajes.confirmacion("¿Seguro de querer eliminar el pedido?");

		// se elimina el pedido
		if (eleccion) {
			// aqui se realiza la eliminación del pedido

			// mensaje de exito
			interfazBusqueda.mensajes.mensaje("Pedido borrado con éxito");

			// dependiendo de como se quiera, se elimina el pedido del arraylist
			// o se vuelven a pedir los pedidos a la bd
		}
	}

	public Scene getScene() {
		return interfazBusqueda.getScene();
	}
}