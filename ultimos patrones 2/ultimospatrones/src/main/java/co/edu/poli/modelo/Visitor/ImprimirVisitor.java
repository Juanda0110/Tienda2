package co.edu.poli.modelo.Visitor;

import co.edu.poli.modelo.Cliente;
import co.edu.poli.modelo.Producto;
import co.edu.poli.modelo.Pedido;

public class ImprimirVisitor implements Visitor {
    @Override
    public void visitCliente(Cliente cliente) {
        System.out.println("Cliente: " + cliente.getNombre() + ", Correo: " + cliente.getCorreo());
    }

    @Override
    public void visitProducto(Producto producto) {
        System.out.println("Producto: " + producto.getNombre() + ", Precio: " + producto.getPrecio());
    }

    @Override
    public void visitPedido(Pedido pedido) {
        System.out.println("Pedido de " + pedido.getCliente().getNombre() +
                " - Producto: " + pedido.getProducto().getNombre() +
                " x" + pedido.getCantidad());
    }
}