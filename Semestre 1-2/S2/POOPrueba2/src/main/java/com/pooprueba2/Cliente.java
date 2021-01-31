package com.pooprueba2;

import com.pooprueba2.helper.CanastaVaciaException;

/**
 * @author Jorge M.
 */

public class Cliente {
    private String nombre;
    private String rut;
    private Canasta canastaCliente;

    public Cliente(String nombre, String rut, Canasta canastaCliente) {
        this.nombre = nombre;
        this.rut = rut;
        this.canastaCliente = canastaCliente;
    }

    public String getRut() {
        return rut;
    }
    
    // este método deberia limpiar la canasta para un nuevo cliente.
    // llamar a un método que pregunte si se desea realizar otra compra
    // y pedir nuevo nombre y rut para la siguiente compra
    public boolean realizarCompra() throws CanastaVaciaException {
        Boleta boleta = new Boleta(this);
        
        if (canastaCliente.getProductos().isEmpty()) {
            throw new CanastaVaciaException("Canasta de cliente vacía");
        } else {
            int productosCongelados = countProductos(Congelado.class);
            int productosFrescos = countProductos(Fresco.class);
            int productosFrios = countProductos(Frio.class);
        }
        
        // TODO añdair control excepciones
        // si no existen elementos en la canasta, no se pueda comprar
        return false;
    }
    
    public int countProductos(Class c) {
        
        int contadoProductos = (int) canastaCliente.
                getProductos().
                stream().
                filter(t -> t.getClass().equals(c)).
                count();
        
        return contadoProductos;
    }
    
     
     public void mostrarDetalleCompra() {
         System.out.println("---- PRODUCTOS ----");

         for (Producto producto : canastaCliente.getProductos()) {
             System.out.println(producto.toString());
         }
     }

    public Canasta getCanastaCliente() {
        return canastaCliente;
    }
     
    
}
