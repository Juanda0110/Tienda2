package co.edu.poli.modelo;

import co.edu.poli.modelo.Visitor.Visitor;
import co.edu.poli.modelo.mediator.Mediator;

public class Pedido {
    private Cliente cliente;
    private Producto producto;
    private int cantidad;
    private Mediator mediator;

    public Pedido(Cliente cliente, Producto producto, int cantidad) {
        this.cliente = cliente;
        this.producto = producto;
        this.cantidad = cantidad;
    }

    public Cliente getCliente() {
        return cliente;
    }

    public Producto getProducto() {
        return producto;
    }

    public int getCantidad() {
        return cantidad;
    }

    public double calcularTotal() {
        return producto.getPrecio() * cantidad;
    }

    public void setMediator(Mediator mediator) {
        this.mediator = mediator;
    }

    public void enviar() {
        if (mediator != null) {
            mediator.notificar(this, "pedidoEnviado");
        }
    }

    public void accept(Visitor visitor) {
        visitor.visitPedido(this);
    }
}