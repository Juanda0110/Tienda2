package co.edu.poli.app.state;


import co.edu.poli.app.model.Pedido;

public interface EstadoPedido {
    void procesar(Pedido pedido);
    void enviar(Pedido pedido);
}
