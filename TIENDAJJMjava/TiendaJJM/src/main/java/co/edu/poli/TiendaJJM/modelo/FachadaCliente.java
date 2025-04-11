package co.edu.poli.TiendaJJM.modelo;

public class FachadaCliente {
    private InformacionPersonal informacionPersonal;
    private HistorialPedidos historialPedidos;
    private FormaPago formaPago;

    public FachadaCliente(String id, String nombre) {
        this.informacionPersonal = new InformacionPersonal(id, nombre);
        this.historialPedidos = new HistorialPedidos();
        this.formaPago = new FormaPago();
    }

    public String mostrarInformacionPersonal() {
        return informacionPersonal.mostrarInformacion();
    }

    public void actualizarNombre(String nuevoNombre) {
        informacionPersonal.actualizarNombre(nuevoNombre);
    }

    public String mostrarHistorialPedidos() {
        return historialPedidos.mostrarHistorial();
    }

    public void realizarPedido(String pedido) {
        historialPedidos.realizarPedido(pedido);
    }

    public String mostrarEstadoFormaPago() {
        return formaPago.mostrarEstado();
    }

    public void activarFormaPago() {
        formaPago.activar();
    }

    public void bloquearFormaPago() {
        formaPago.bloquear();
    }
}