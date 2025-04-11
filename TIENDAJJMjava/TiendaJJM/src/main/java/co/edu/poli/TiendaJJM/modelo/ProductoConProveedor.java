package co.edu.poli.TiendaJJM.modelo;

public class ProductoConProveedor {
    private String nombreProducto;
    private Proveedor proveedor;

    public ProductoConProveedor(String nombreProducto, String nombreProveedor) {
        this.nombreProducto = nombreProducto;
        this.proveedor = FlyweightProveedorFactory.getProveedor(nombreProveedor);
    }

    public void mostrarDetalles() {
        System.out.println("Producto: " + nombreProducto + " | Proveedor: " + proveedor.getNombre());
    }

    public void operar() {
        proveedor.operar(nombreProducto);
    }
}