package co.edu.poli.TiendaJJM.modelo;

public class InformacionPersonal {
    private String id;
    private String nombre;

    public InformacionPersonal(String id, String nombre) {
        this.id = id;
        this.nombre = nombre;
    }

    public String mostrarInformacion() {
        return "ID: " + id + "\nNombre: " + nombre;
    }

    public void actualizarNombre(String nuevoNombre) {
        this.nombre = nuevoNombre;
    }
}