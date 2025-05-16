package co.edu.poli.app.state;

import javafx.scene.control.Alert;
import javafx.scene.control.Alert.AlertType;
import co.edu.poli.app.model.Pedido;

public class EstadoNuevo implements EstadoPedido {

    @Override
    public void procesar(Pedido pedido) {
        mostrarMensaje("El pedido está siendo procesado...");
        pedido.setEstado(new EstadoEnProceso());
    }

    @Override
    public void enviar(Pedido pedido) {
        mostrarMensaje("No se puede enviar un pedido nuevo. Primero debe procesarse.");
    }

    private void mostrarMensaje(String msg) {
        Alert alert = new Alert(AlertType.INFORMATION);
        alert.setTitle("Estado del Pedido");
        alert.setHeaderText(null);
        alert.setContentText(msg);
        alert.showAndWait();
    }
}
