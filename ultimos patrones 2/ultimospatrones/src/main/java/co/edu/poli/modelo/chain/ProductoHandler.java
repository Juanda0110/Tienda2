package co.edu.poli.modelo.chain;

import co.edu.poli.modelo.Pedido;

public class ProductoHandler extends AbstractHandler {
    @Override
    public String handle(Pedido pedido) {
        if (pedido.getProducto() == null || pedido.getProducto().getNombre().isEmpty()) {
            return "Error: Producto inválido.";
        }
        return super.handle(pedido);
    }
}
