package co.edu.poli.TiendaJJM.modelo;

public class Proveedor {
    private String nombre;

    public Proveedor(String nombre) {
        this.nombre = nombre;
    }

    public String getNombre() {
        return nombre;
    }

    public void operar(String producto) {
        System.out.println("Proveedor " + nombre + " está gestionando el producto: " + producto);
    }
}