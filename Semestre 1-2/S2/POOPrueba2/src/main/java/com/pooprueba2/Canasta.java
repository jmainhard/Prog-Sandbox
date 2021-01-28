package com.pooprueba2;

import java.util.ArrayList;

/**
 * Prueba 2 POO 28-enero-2021
 * @author Jorge M.
 * inicio codigo 20.15hrs
 */

public class Canasta {
    EstadosCanastaEnum estado;
    ArrayList<Producto> productos;

    public Canasta(EstadosCanastaEnum estado) {
        this.estado = estado;
        this.productos = new ArrayList<>();
    }
    
    public void addProducto(Producto p) {
        productos.add(p);
    }
    
    public void delProducto(Producto p) {
        try {
            if (productos.remove(p)) {
                System.out.println("Producto eliminado de la canasta" + p.codigo);
            } else {
                throw new NoSuchFieldException("Producto no encontrado");
            }
        } catch (NoSuchFieldException e) {
            System.err.println(e.getMessage());
        }
    }
    
    public void listarProductos() {
        
    }
    
}
