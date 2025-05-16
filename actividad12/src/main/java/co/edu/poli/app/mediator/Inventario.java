package co.edu.poli.app.mediator;

import javafx.scene.control.TextArea;
import co.edu.poli.app.model.Pedido;

public class Inventario {
    private TextArea log;

    public Inventario(TextArea log) {
        this.log = log;
    }

    public void actualizarStock(Pedido pedido) {
        log.appendText("Inventario actualizado para el producto: " + pedido.getProducto().getNombre() + "\n");
    }
}
