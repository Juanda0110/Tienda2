package co.edu.poli.TiendaJJM.controlador;

import co.edu.poli.TiendaJJM.modelo.*;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.scene.control.Alert;
import javafx.scene.layout.AnchorPane;

public class ControladorFormulario {
    private FachadaCliente fachadaCliente;
    private ProductoInterface proxyProducto; // Cambiado a la interfaz ProductoInterface
    private ProductoConProveedor producto1;
    private ProductoConProveedor producto2;

    @FXML
    private AnchorPane fachadaPane;

    @FXML
    private AnchorPane proxyPane;

    @FXML
    private AnchorPane flyweightPane;

    public ControladorFormulario() {
        // Inicializar cliente y fachada
        fachadaCliente = new FachadaCliente("1", "Juan Pérez");

        // Crear el producto real y el proxy
        Producto producto = new Producto("Laptop", "Laptop Dell con 16GB RAM");
        proxyProducto = new ProxyProducto(producto, true); // Proxy con acceso permitido

        // Crear productos con proveedores compartidos
        producto1 = new ProductoConProveedor("Laptop", "Proveedor A");
        producto2 = new ProductoConProveedor("Mouse", "Proveedor A");
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
    void actualizarNombreCliente(ActionEvent event) {
        fachadaCliente.actualizarNombre("Nuevo Nombre");
        Alert alert = new Alert(Alert.AlertType.INFORMATION);
        alert.setTitle("Cliente");
        alert.setHeaderText("Actualización");
        alert.setContentText("El nombre del cliente ha sido actualizado.");
        alert.showAndWait();
    }

    @FXML
    void mostrarHistorialPedidos(ActionEvent event) {
        Alert alert = new Alert(Alert.AlertType.INFORMATION);
        alert.setTitle("Historial de Pedidos");
        alert.setHeaderText("Pedidos del Cliente");
        alert.setContentText(fachadaCliente.mostrarHistorialPedidos());
        alert.showAndWait();
    }

    @FXML
    void realizarPedido(ActionEvent event) {
        fachadaCliente.realizarPedido("Pedido Ejemplo");
        Alert alert = new Alert(Alert.AlertType.INFORMATION);
        alert.setTitle("Pedido");
        alert.setHeaderText("Nuevo Pedido");
        alert.setContentText("Se ha realizado un nuevo pedido.");
        alert.showAndWait();
    }

    @FXML
    void mostrarEstadoFormaPago(ActionEvent event) {
        Alert alert = new Alert(Alert.AlertType.INFORMATION);
        alert.setTitle("Forma de Pago");
        alert.setHeaderText("Estado de la Forma de Pago");
        alert.setContentText(fachadaCliente.mostrarEstadoFormaPago());
        alert.showAndWait();
    }

    @FXML
    void bloquearFormaPago(ActionEvent event) {
        fachadaCliente.bloquearFormaPago();
        Alert alert = new Alert(Alert.AlertType.INFORMATION);
        alert.setTitle("Forma de Pago");
        alert.setHeaderText("Bloqueo");
        alert.setContentText("La forma de pago ha sido bloqueada.");
        alert.showAndWait();
    }

    @FXML
    void activarFormaPago(ActionEvent event) {
        fachadaCliente.activarFormaPago();
        Alert alert = new Alert(Alert.AlertType.INFORMATION);
        alert.setTitle("Forma de Pago");
        alert.setHeaderText("Activación");
        alert.setContentText("La forma de pago ha sido activada.");
        alert.showAndWait();
    }

    @FXML
    void mostrarProducto(ActionEvent event) {
        Alert alert = new Alert(Alert.AlertType.INFORMATION);
        alert.setTitle("Producto");
        alert.setHeaderText("Detalles del Producto");
        alert.setContentText(proxyProducto.obtenerDetalles()); // Usar el proxy para obtener detalles
        alert.showAndWait();
    }

    @FXML
    void mostrarProductoConProveedor1(ActionEvent event) {
        Alert alert = new Alert(Alert.AlertType.INFORMATION);
        alert.setTitle("Producto con Proveedor");
        alert.setHeaderText("Detalles del Producto 1");
        alert.setContentText("Producto: Laptop\nProveedor: Proveedor A");
        producto1.operar();
        alert.showAndWait();
    }

    @FXML
    void mostrarProductoConProveedor2(ActionEvent event) {
        Alert alert = new Alert(Alert.AlertType.INFORMATION);
        alert.setTitle("Producto con Proveedor");
        alert.setHeaderText("Detalles del Producto 2");
        alert.setContentText("Producto: Mouse\nProveedor: Proveedor A");
        producto2.operar();
        alert.showAndWait();
    }

    @FXML
    void mostrarFachada() {
        fachadaPane.setVisible(true);
        proxyPane.setVisible(false);
        flyweightPane.setVisible(false);
    }

    @FXML
    void mostrarProxy() {
        fachadaPane.setVisible(false);
        proxyPane.setVisible(true);
        flyweightPane.setVisible(false);
    }

    @FXML
    void mostrarFlyweight() {
        fachadaPane.setVisible(false);
        proxyPane.setVisible(false);
        flyweightPane.setVisible(true);
    }
}