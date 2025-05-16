package co.edu.poli.app.state;

import javafx.scene.control.Alert;
import javafx.scene.control.Alert.AlertType;
import co.edu.poli.app.model.Pedido;

public class EstadoEnviado implements EstadoPedido {

    @Override
    public void procesar(Pedido pedido) {
        mostrarMensaje("El pedido ya fue enviado. No se puede procesar.");
    }

    @Override
    public void enviar(Pedido pedido) {
        mostrarMensaje("El pedido ya está enviado.");
    }

    private void mostrarMensaje(String msg) {
        Alert alert = new Alert(AlertType.INFORMATION);
        alert.setTitle("Estado del Pedido");
        alert.setHeaderText(null);
        alert.setContentText(msg);
        alert.showAndWait();
    }
}
