package co.edu.poli.modelo.chain;

import co.edu.poli.modelo.Pedido;

public abstract class AbstractHandler implements Handler {
    private Handler nextHandler;

    @Override
    public Handler setNext(Handler handler) {
        this.nextHandler = handler;
        return handler;
    }

    @Override
    public String handle(Pedido pedido) {
        if (nextHandler != null) {
            return nextHandler.handle(pedido);
        }
        return null;
    }
}