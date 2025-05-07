package co.edu.poli.modelo.chain;

import co.edu.poli.modelo.Pedido;

public class CantidadHandler extends AbstractHandler {
    @Override
    public String handle(Pedido pedido) {
        if (pedido.getCantidad() <= 0) {
            return "Error: Cantidad inválida.";
        }
        return super.handle(pedido);
    }
}
