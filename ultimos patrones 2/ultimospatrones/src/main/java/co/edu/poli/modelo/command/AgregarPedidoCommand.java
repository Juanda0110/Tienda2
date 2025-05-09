package co.edu.poli.modelo.command;

import co.edu.poli.modelo.Pedido;
import co.edu.poli.modelo.strategy.DiscountContext;

public class AgregarPedidoCommand implements Command {
    private Pedido pedido;
    private DiscountContext discountContext;

    public AgregarPedidoCommand(Pedido pedido, DiscountContext discountContext) {
        this.pedido = pedido;
        this.discountContext = discountContext;
    }

    @Override
    public void execute() {
        double totalConDescuento = discountContext.executeStrategy(pedido.calcularTotal());
        System.out.println("Pedido ejecutado: " + pedido.getProducto().getNombre() +
                           ", cantidad: " + pedido.getCantidad() +
                           ", total con descuento: " + totalConDescuento);
    }
}
