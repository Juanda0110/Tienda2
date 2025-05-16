package co.edu.poli.modelo.mediator;

public interface Mediator {
    void notificar(Object remitente, String evento);
}