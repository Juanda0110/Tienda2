package co.edu.poli.app.model;

import co.edu.poli.app.mediator.Mediator;
import co.edu.poli.app.state.EstadoNuevo;
import co.edu.poli.app.state.EstadoPedido;

public class Pedido {
    private Producto producto;
    private EstadoPedido estado;
    private Mediator mediator;

    public Pedido(Producto producto) {
        this.producto = producto;
        this.estado = new EstadoNuevo();
    }

    public Producto getProducto() {
        return producto;
    }

    public void setEstado(EstadoPedido estado) {
        this.estado = estado;
    }

    public void procesar() {
        estado.procesar(this);
    }

    public void enviar() {
        estado.enviar(this);
    }

    public void setMediator(Mediator mediator) {
        this.mediator = mediator;
    }

    public Mediator getMediator() {
        return mediator;
    }
}
