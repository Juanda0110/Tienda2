package co.edu.poli.app.mediator;

import co.edu.poli.app.model.Pedido;

public class TiendaMediator implements Mediator {

    private Pedido pedido;
    private Inventario inventario;
    private Factura factura;

    public void setPedido(Pedido pedido) {
        this.pedido = pedido;
    }

    public void setInventario(Inventario inventario) {
        this.inventario = inventario;
    }

    public void setFactura(Factura factura) {
        this.factura = factura;
    }

    @Override
    public void notificar(Pedido sender, String evento) {
        if (evento.equals("PEDIDO_PROCESADO")) {
            inventario.actualizarStock(sender);
            factura.generarFactura(sender);
        }
    }
}
