package com.pooprueba2;

import com.pooprueba2.helper.CanastaVaciaException;
import com.pooprueba2.helper.EstadosCanastaEnum;
import java.util.ArrayList;

/**
 * Prueba 2 POO 28-enero-2021
 * @author Jorge M.
 * inicio codigo 20.15hrs
 * fin           22.31hrs
 */

public class Canasta {
    private EstadosCanastaEnum estado;
    private ArrayList<Producto> productos;

    public Canasta(EstadosCanastaEnum estado) {
        this.estado = estado;
        this.productos = new ArrayList<>();
    }
    
    public void addProducto(Producto p) {
        productos.add(p);
        p.asignarCodigo(productos.indexOf(p));
    }
    
    public void delProducto(Producto p) {
        try {
            String codigo = p.getCodigo();
            if (productos.remove(p)) {
                System.out.println("Producto eliminado de la canasta" + p.getCodigo());
            } else {
                System.err.println("Producto no encontrado");
            }
        } catch (Exception e) {
            System.err.println(e.getMessage());
        }
    }
    
    public void listarProductos(Class claseFiltro) {
        productos.stream().
                filter(p -> p.getClass().
                equals(claseFiltro)).
                forEach(System.out::println);
    }
    
    public void listarProductos() {
        productos.stream().
                forEach(System.out::println);
    }
    
      public int countProductos(Class c) throws CanastaVaciaException {
        // por ahora hago throw catch aquí por el Main
           try {
              if (!this.productos.isEmpty()) {
                int contadorProductos = (int) this.productos.stream().
                filter(t -> t.getClass().equals(c)).
                count();
                
                return contadorProductos;
            } else {
                throw new CanastaVaciaException("Error: Canasta vacía :-(");
            }
           } catch (CanastaVaciaException e) {
               System.err.println(e.getMessage());
           } catch (Exception e){
               System.err.println(e.getMessage());
           }
          
          return -1;
    }

    public ArrayList<Producto> getProductos() {
        return productos;
    }

    public void setProductos(ArrayList<Producto> productos) {
        this.productos = productos;
        this.productos.forEach(p -> p.asignarCodigo(this.productos.indexOf(p)));
    }
    
    
    
    
    
}
