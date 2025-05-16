package co.edu.poli.app.visitor;

import javafx.scene.control.TextArea;
import co.edu.poli.app.model.Producto;

public class CalcularIVAVisitor implements ProductoVisitor {

    private TextArea log;

    public CalcularIVAVisitor(TextArea log) {
        this.log = log;
    }

    @Override
    public void visit(Producto producto) {
        double iva = producto.getPrecio() * 0.19;
        log.appendText("IVA del producto '" + producto.getNombre() + "': $" + iva + "\n");
    }
}
