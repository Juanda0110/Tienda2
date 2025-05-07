package co.edu.poli.modelo.command;

import co.edu.poli.modelo.Pedido;

public class AgregarPedidoCommand implements Command {
    private Pedido pedido;

    public AgregarPedidoCommand(Pedido pedido) {
        this.pedido = pedido;
    }

    @Override
    public void execute() {
        System.out.println("Pedido ejecutado: " + pedido.getProducto().getNombre() + 
                           ", cantidad: " + pedido.getCantidad());
    }
}
