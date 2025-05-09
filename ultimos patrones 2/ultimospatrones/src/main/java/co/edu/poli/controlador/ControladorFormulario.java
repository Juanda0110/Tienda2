package co.edu.poli.controlador;

import co.edu.poli.modelo.Cliente;
import co.edu.poli.modelo.Pedido;
import co.edu.poli.modelo.Producto;
import co.edu.poli.modelo.chain.CantidadHandler;
import co.edu.poli.modelo.chain.ClienteHandler;
import co.edu.poli.modelo.chain.Handler;
import co.edu.poli.modelo.chain.ProductoHandler;
import co.edu.poli.modelo.command.AgregarPedidoCommand;
import co.edu.poli.modelo.command.Command;
import co.edu.poli.modelo.command.PedidoInvoker;
import co.edu.poli.modelo.strategy.DiscountContext;
import co.edu.poli.modelo.strategy.PercentageDiscount;
import javafx.fxml.FXML;
import javafx.scene.control.TextField;

public class ControladorFormulario {

    @FXML private TextField campoNombreCliente;
    @FXML private TextField campoCorreoCliente;
    @FXML private TextField campoNombreProducto;
    @FXML private TextField campoPrecioProducto;
    @FXML private TextField campoCantidad;
    @FXML private TextField campoDescuento; // Campo adicional para el descuento

    public void enviarPedido() {
        try {
            // Crear objetos de entrada
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

            // 1. Validación con Chain of Responsibility
            Handler handler = new ClienteHandler();
            handler.setNext(new ProductoHandler()).setNext(new CantidadHandler());
            handler.handle(pedido);

            // 2. Configurar el descuento dinámico
            DiscountContext discountContext = new DiscountContext();
            double porcentajeDescuento = Double.parseDouble(campoDescuento.getText()); // Campo adicional en el formulario
            discountContext.setStrategy(new PercentageDiscount(porcentajeDescuento));

            // 3. Comando para agregar el pedido
            Command agregarPedido = new AgregarPedidoCommand(pedido, discountContext);
            PedidoInvoker invoker = new PedidoInvoker();
            invoker.setCommand(agregarPedido);
            invoker.execute();

            System.out.println("Pedido enviado con éxito.");
        } catch (Exception e) {
            System.err.println("Error al enviar el pedido: " + e.getMessage());
        }
    }
}
