package co.edu.poli.TiendaJJM.modelo;

public class FachadaCliente {
    private Cliente cliente;

    public FachadaCliente(Cliente cliente) {
        this.cliente = cliente;
    }

    public String mostrarInformacionPersonal() {
        return "ID: " + cliente.getId() + "\nNombre: " + cliente.getNombre();
    }

    public String mostrarHistorialPedidos() {
        return cliente.getHistorialPedidos();
    }

    public void realizarPedido(String pedido) {
        cliente.realizarPedido(pedido);
    }

    public String mostrarEstadoFormaPago() {
        return cliente.isFormaPagoActiva() ? "Forma de pago activa" : "Forma de pago bloqueada";
    }

    public void activarFormaPago() {
        cliente.activarFormaPago();
    }

    public void bloquearFormaPago() {
        cliente.bloquearFormaPago();
    }
}