package co.edu.poli.TiendaJJM.modelo;

import java.util.ArrayList;
import java.util.List;

public class HistorialPedidos {
    private List<String> pedidos;

    public HistorialPedidos() {
        this.pedidos = new ArrayList<>();
    }

    public void realizarPedido(String pedido) {
        pedidos.add(pedido);
    }

    public String mostrarHistorial() {
        if (pedidos.isEmpty()) {
            return "No hay pedidos en el historial.";
        }
        return String.join("\n", pedidos);
    }
}
