package co.edu.poli.modelo.chain;

import co.edu.poli.modelo.Pedido;

public class ClienteHandler extends AbstractHandler {
    @Override
    public String handle(Pedido pedido) {
        if (pedido.getCliente() == null || pedido.getCliente().getNombre().isEmpty()) {
            return "Error: Cliente inválido.";
        }
        return super.handle(pedido);
    }
}
