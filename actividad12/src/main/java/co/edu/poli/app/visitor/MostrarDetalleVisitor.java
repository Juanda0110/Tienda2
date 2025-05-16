package co.edu.poli.app.visitor;

import javafx.scene.control.TextArea;
import co.edu.poli.app.model.Producto;

public class MostrarDetalleVisitor implements ProductoVisitor {

    private TextArea log;

    public MostrarDetalleVisitor(TextArea log) {
        this.log = log;
    }

    @Override
    public void visit(Producto producto) {
        log.appendText("Producto: " + producto.getNombre() + " | Precio: $" + producto.getPrecio() + "\n");
    }
}
