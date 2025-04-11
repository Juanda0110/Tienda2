package co.edu.poli.TiendaJJM.modelo;

public class ProxyProducto implements ProductoInterface {
    private Producto productoReal;
    private boolean accesoPermitido;

    public ProxyProducto(Producto productoReal, boolean accesoPermitido) {
        this.productoReal = productoReal;
        this.accesoPermitido = accesoPermitido;
    }

    @Override
    public String obtenerDetalles() {
        if (accesoPermitido) {
            return productoReal.obtenerDetalles();
        } else {
            return "Acceso denegado: No tienes el nivel de autorización adecuado.";
        }
    }
}