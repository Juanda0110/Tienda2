package co.edu.poli.TiendaJJM.modelo;

public class FormaPago {
    private boolean activa;

    public FormaPago() {
        this.activa = true;
    }

    public String mostrarEstado() {
        return activa ? "Forma de pago activa" : "Forma de pago bloqueada";
    }

    public void activar() {
        this.activa = true;
    }

    public void bloquear() {
        this.activa = false;
    }
}