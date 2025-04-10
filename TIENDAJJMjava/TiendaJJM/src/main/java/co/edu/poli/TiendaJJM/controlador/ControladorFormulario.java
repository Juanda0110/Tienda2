package co.edu.poli.TiendaJJM.controlador;
import co.edu.poli.TiendaJJM.modelo.*;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.scene.control.Alert;


public class ControladorFormulario {
    private FachadaCliente fachadaCliente;
    private ProxyProducto proxyProducto;
    private Proveedor proveedor;

    public ControladorFormulario() {
        Cliente cliente = new Cliente("1", "Juan Pérez");
        fachadaCliente = new FachadaCliente(cliente);

        Producto producto = new Producto("Laptop", "Laptop Dell con 16GB RAM");
        proxyProducto = new ProxyProducto(producto, true);

        proveedor = FlyweightProveedorFactory.getProveedor("Proveedor A");
    }

    @FXML
    void mostrarCliente(ActionEvent event) {
        Alert alert = new Alert(Alert.AlertType.INFORMATION);
        alert.setTitle("Cliente");
        alert.setHeaderText("Información del Cliente");
        alert.setContentText(fachadaCliente.mostrarInformacionPersonal());
        alert.showAndWait();
    }

    @FXML
    void mostrarProducto(ActionEvent event) {
        Alert alert = new Alert(Alert.AlertType.INFORMATION);
        alert.setTitle("Producto");
        alert.setHeaderText("Detalles del Producto");
        alert.setContentText(proxyProducto.obtenerDetalles());
        alert.showAndWait();
    }

    @FXML
    void mostrarProveedor(ActionEvent event) {
        Alert alert = new Alert(Alert.AlertType.INFORMATION);
        alert.setTitle("Proveedor");
        alert.setHeaderText("Detalles del Proveedor");
        alert.setContentText("Proveedor: " + proveedor.getNombre());
        alert.showAndWait();
    }
}