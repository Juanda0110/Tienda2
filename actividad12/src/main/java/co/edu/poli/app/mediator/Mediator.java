package co.edu.poli.app.mediator;

import co.edu.poli.app.model.Pedido;

public interface Mediator {
    void notificar(Pedido sender, String evento);
}
