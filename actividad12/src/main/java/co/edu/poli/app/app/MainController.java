package co.edu.poli.app.app;


import javafx.fxml.FXML;
import javafx.scene.control.Button;
import javafx.scene.control.TextArea;
import co.edu.poli.app.model.Pedido;
import co.edu.poli.app.model.Producto;
import co.edu.poli.app.mediator.*;
import co.edu.poli.app.visitor.*;
import co.edu.poli.app.state.*;

public class MainController {

    @FXML private Button btnVisitor;
    @FXML private Button btnState;
    @FXML private Button btnMediator;
    @FXML private TextArea logArea;

    private Producto producto;
    private Pedido pedido;
    private TiendaMediator mediator;

    @FXML
    public void initialize() {
        producto = new Producto("Laptop", 2500.0);
        pedido = new Pedido(producto);
        mediator = new TiendaMediator();
        pedido.setMediator(mediator);
        mediator.setPedido(pedido);
        mediator.setInventario(new Inventario(logArea));
        mediator.setFactura(new Factura(logArea));

        btnVisitor.setOnAction(e -> {
            logArea.appendText("--- Visitor Pattern ---\n");
            producto.accept(new CalcularIVAVisitor(logArea));
            producto.accept(new MostrarDetalleVisitor(logArea));
        });

        btnState.setOnAction(e -> {
            logArea.appendText("--- State Pattern ---\n");
            pedido.procesar();
            pedido.enviar();
        });

        btnMediator.setOnAction(e -> {
            logArea.appendText("--- Mediator Pattern ---\n");
            mediator.notificar(pedido, "PEDIDO_PROCESADO");
        });
    }
}
