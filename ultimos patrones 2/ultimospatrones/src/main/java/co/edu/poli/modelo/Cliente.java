package co.edu.poli.modelo;

import co.edu.poli.modelo.Visitor.Visitor;

public class Cliente {
    private String nombre;
    private String correo;

    public Cliente(String nombre, String correo) {
        this.nombre = nombre;
        this.correo = correo;
    }

    public String getNombre() {
        return nombre;
    }

    public String getCorreo() {
        return correo;
    }

    public void accept(Visitor visitor) {
        visitor.visitCliente(this);
    }
}