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
    // TODO evaluar donde sería mejor práctica la exception
    // en cliente o canasta
    // o ambos?o donde sería mejor hacer catch,
    // talvez hacer throw en canasta y solo hacer catch acá
    // realmente si hago throw y catch en Canasta jamás debiera propagarse acá,
    // diría
    public boolean realizarCompra() throws CanastaVaciaException {
        Boleta boleta = new Boleta(this);
        
        try {
            int productosCongelados = canastaCliente.countProductos(Congelado.class);
            int productosFrescos = canastaCliente.countProductos(Fresco.class);
            int productosFrios = canastaCliente.countProductos(Frio.class);
            
            System.out.println("Congelados: "+ productosCongelados +
                    "\nFrescos: "+ productosFrescos +
                    "\nFríos: "+ productosFrios);
        } catch (CanastaVaciaException e) {
            System.err.println(e.getMessage());
        } catch (Exception e) {
        }
        
        
        // TODO añdair control excepciones
        // si no existen elementos en la canasta, no se pueda comprar
        return false;
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
