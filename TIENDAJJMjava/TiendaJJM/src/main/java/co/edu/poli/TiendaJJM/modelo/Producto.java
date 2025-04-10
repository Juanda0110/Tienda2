package co.edu.poli.TiendaJJM.modelo;

public class Producto {
    private String nombre;
    private String detalles;

    public Producto(String nombre, String detalles) {
        this.nombre = nombre;
        this.detalles = detalles;
    }

    public String getDetalles() {
        return detalles;
    }

    public String getNombre() {
        return nombre;
    }
}