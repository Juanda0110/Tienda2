package co.edu.poli.TiendaJJM.modelo;

public class Producto implements ProductoInterface {
    private String nombre;
    private String detalles;

    public Producto(String nombre, String detalles) {
        this.nombre = nombre;
        this.detalles = detalles;
    }

    @Override
    public String obtenerDetalles() {
        return "Producto: " + nombre + "\nDetalles: " + detalles;
    }
}