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
            handler.setNext(new ProductoHandler())
                   .setNext(new CantidadHandler());

            String resultadoValidacion = handler.handle(pedido);
            if (resultadoValidacion != null) {
                System.out.println("Validación fallida: " + resultadoValidacion);
                return;
            }

            // 2. Aplicar descuento con Strategy
            DiscountContext contextoDescuento = new DiscountContext();
            contextoDescuento.setStrategy(new PercentageDiscount());  // Puedes cambiar por FixedDiscount
            double totalConDescuento = contextoDescuento.executeStrategy(pedido.calcularTotal());

            // 3. Ejecutar el pedido con Command
            Command agregarPedido = new AgregarPedidoCommand(pedido);
            PedidoInvoker invoker = new PedidoInvoker();
            invoker.addCommand(agregarPedido);
            invoker.run();

            System.out.println("Total con descuento: $" + totalConDescuento);

        } catch (Exception e) {
            System.out.println("Error en el pedido: " + e.getMessage());
        }
    }
}
