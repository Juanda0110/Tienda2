package co.edu.poli.app.visitor;

import co.edu.poli.app.model.Producto;

public interface ProductoVisitor {
    void visit(Producto producto);
}
