package co.edu.poli.TiendaJJM.modelo;

import java.util.HashMap;
import java.util.Map;

public class FlyweightProveedorFactory {
    private static Map<String, Proveedor> cache = new HashMap<>();

    public static Proveedor getProveedor(String nombre) {
        if (!cache.containsKey(nombre)) {
            cache.put(nombre, new Proveedor(nombre));
        }
        return cache.get(nombre);
    }
}