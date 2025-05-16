package co.edu.poli.controlador;

import co.edu.poli.modelo.Cliente;
import co.edu.poli.modelo.Pedido;
import co.edu.poli.modelo.Producto;
import co.edu.poli.modelo.Visitor.ImprimirVisitor;
import co.edu.poli.modelo.Visitor.Visitor;
import co.edu.poli.modelo.mediator.Mediator;
import co.edu.poli.modelo.mediator.PedidoMediator;
import co.edu.poli.modelo.strategy.DiscountContext;
import co.edu.poli.modelo.strategy.PercentageDiscount;
import javafx.fxml.FXML;
import javafx.scene.control.TextField;
import javafx.scene.control.Alert;
import javafx.scene.control.Alert.AlertType;

public class ControladorFormulario {

    @FXML private TextField campoNombreCliente;
    @FXML private TextField campoCorreoCliente;
    @FXML private TextField campoNombreProducto;
    @FXML private TextField campoPrecioProducto;
    @FXML private TextField campoCantidad;
    @FXML private TextField campoDescuento;

    @FXML
    public void enviarPedido() {
        try {
            // 1. Crear objetos de entrada
            Cliente cliente = new Cliente(
                campoNombreCliente.getText(),
                campoCorreoCliente.getText()
            );

            Producto producto = new Producto(
                campoNombreProducto.getText(),
                Double.parseDouble(campoPrecioProducto.getText())
            );

            Pedido pedido = new Pedido(
                cliente,
                producto,
                Integer.parseInt(campoCantidad.getText())
            );

            // 2. VISITOR: Imprimir información en consola
            Visitor imprimirVisitor = new ImprimirVisitor();
            cliente.accept(imprimirVisitor);
            producto.accept(imprimirVisitor);
            pedido.accept(imprimirVisitor);

            // 3. MEDIATOR: Notificar envío de pedido
            Mediator mediator = new PedidoMediator();
            pedido.setMediator(mediator);
            pedido.enviar();

            // 4. Descuento (opcional, si tienes esta lógica)
            DiscountContext discountContext = new DiscountContext();
            double porcentajeDescuento = Double.parseDouble(campoDescuento.getText());
            discountContext.setStrategy(new PercentageDiscount(porcentajeDescuento));
            double totalConDescuento = discountContext.executeStrategy(pedido.calcularTotal());

            // 5. Mostrar confirmación en pantalla
            Alert alert = new Alert(AlertType.INFORMATION);
            alert.setTitle("Pedido Enviado");
            alert.setHeaderText("¡Pedido enviado con éxito!");
            alert.setContentText("Total con descuento: $" + totalConDescuento);
            alert.showAndWait();

        } catch (Exception e) {
            Alert alert = new Alert(AlertType.ERROR);
            alert.setTitle("Error");
            alert.setHeaderText("Error al enviar el pedido");
            alert.setContentText(e.getMessage());
            alert.showAndWait();
        }
    }
}