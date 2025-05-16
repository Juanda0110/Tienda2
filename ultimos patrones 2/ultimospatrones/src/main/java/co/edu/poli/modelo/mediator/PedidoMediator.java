package co.edu.poli.modelo.mediator;

import co.edu.poli.modelo.Pedido;

public class PedidoMediator implements Mediator {
    @Override
    public void notificar(Object remitente, String evento) {
        if (remitente instanceof Pedido && evento.equals("pedidoEnviado")) {
            System.out.println("El pedido ha sido enviado (notificado por el Mediator).");
        }
        // Puedes agregar más lógica para otros eventos/remitentes
    }
}