package co.edu.poli.app.mediator;

import javafx.scene.control.TextArea;
import co.edu.poli.app.model.Pedido;

public class Factura {
    private TextArea log;

    public Factura(TextArea log) {
        this.log = log;
    }

    public void generarFactura(Pedido pedido) {
        log.appendText("Factura generada para el producto: " + pedido.getProducto().getNombre() + "\n");
    }
}
