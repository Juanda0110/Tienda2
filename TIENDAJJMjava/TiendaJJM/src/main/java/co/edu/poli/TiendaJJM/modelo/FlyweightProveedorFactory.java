package co.edu.poli.TiendaJJM.modelo;

import java.util.HashMap;
import java.util.Map;

public class FlyweightProveedorFactory {
    private static Map<String, Proveedor> proveedores = new HashMap<>();

    public static Proveedor getProveedor(String nombre) {
        if (!proveedores.containsKey(nombre)) {
            proveedores.put(nombre, new Proveedor(nombre));
        }
        return proveedores.get(nombre);
    }
}