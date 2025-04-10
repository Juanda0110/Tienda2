package co.edu.poli.TiendaJJM.modelo;

public class Cliente {
    private String id;
    private String nombre;
    private String historialPedidos;
    private boolean formaPagoActiva;

    public Cliente(String id, String nombre) {
        this.id = id;
        this.nombre = nombre;
        this.historialPedidos = "Sin pedidos";
        this.formaPagoActiva = true;
    }

    public String getId() {
        return id;
    }

    public String getNombre() {
        return nombre;
    }

    public String getHistorialPedidos() {
        return historialPedidos;
    }

    public void realizarPedido(String pedido) {
        this.historialPedidos += "\n" + pedido;
    }

    public boolean isFormaPagoActiva() {
        return formaPagoActiva;
    }

    public void activarFormaPago() {
        this.formaPagoActiva = true;
    }

    public void bloquearFormaPago() {
        this.formaPagoActiva = false;
    }
}