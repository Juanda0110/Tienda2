package co.edu.poli.modelo.chain;

import co.edu.poli.modelo.Pedido;

public interface Handler {
    Handler setNext(Handler handler);
    String handle(Pedido pedido);
}
