package co.edu.poli.modelo;

public class Pedido {
    private Cliente cliente;
    private Producto producto;
    private int cantidad;

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
}
