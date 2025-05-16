package co.edu.poli.app.model;

import co.edu.poli.app.visitor.ProductoVisitor;

public class Producto {
    private String nombre;
    private double precio;

    public Producto(String nombre, double precio) {
        this.nombre = nombre;
        this.precio = precio;
    }

    public String getNombre() {
        return nombre;
    }

    public double getPrecio() {
        return precio;
    }

    // Método para aceptar visitantes
    public void accept(ProductoVisitor visitor) {
        visitor.visit(this);
    }
}
