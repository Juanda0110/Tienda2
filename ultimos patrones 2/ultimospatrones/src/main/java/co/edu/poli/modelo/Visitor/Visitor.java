package co.edu.poli.modelo.Visitor;

import co.edu.poli.modelo.Cliente;
import co.edu.poli.modelo.Producto;
import co.edu.poli.modelo.Pedido;

public interface Visitor {
    void visitCliente(Cliente cliente);
    void visitProducto(Producto producto);
    void visitPedido(Pedido pedido);
}