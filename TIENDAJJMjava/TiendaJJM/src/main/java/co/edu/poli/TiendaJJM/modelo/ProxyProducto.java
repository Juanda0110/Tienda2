package co.edu.poli.TiendaJJM.modelo;

public class ProxyProducto {
    private Producto producto;
    private boolean accesoPermitido;

    public ProxyProducto(Producto producto, boolean accesoPermitido) {
        this.producto = producto;
        this.accesoPermitido = accesoPermitido;
    }

    public String obtenerDetalles() {
        if (accesoPermitido) {
            return producto.getDetalles();
        } else {
            return "Acceso denegado: No tienes el nivel de autorización adecuado.";
        }
    }
}