package com.pooprueba2;

import com.pooprueba2.helper.CanastaVaciaException;
import com.pooprueba2.helper.EstadosCanastaEnum;
import java.util.ArrayList;
import java.util.List;
import java.util.stream.Collectors;

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
        int nProducto;
        p.asignarCodigo(groupProductos(p.getClass()).indexOf(p));
    }
    
    public void delProducto(Producto p) {
        try {
            String codigo = p.getCodigo();
            if (productos.remove(p)) {
                System.out.println("Producto eliminado de la canasta exitosamente (" + p.getCodigo() + ')');
            } else {
                System.err.println("Producto no encontrado");
            }
        } catch (NullPointerException e) {
            System.err.println("Producto no válido");
        } catch (Exception e) {
            System.err.println(e);
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
    
    public int countProductos(Class c) {
              if (!this.productos.isEmpty()) {
                int contadorProductos = (int) this.productos.stream().
                filter(t -> t.getClass().equals(c)).
                count();
                return contadorProductos;
            } else {
                System.err.println("Error: Canasta vacía");
            }
          
          return -1;
    }
      
    public List<Producto> groupProductos(Class c) {
       List<Producto> groupedProducts = new ArrayList<>();
        
              if (!this.productos.isEmpty()) {
                groupedProducts = this.productos.stream().
                filter(t -> t.getClass().equals(c)).
                        collect(Collectors.toList());
                
                return groupedProducts;
            } else {
                System.err.println("Error: Canasta vacía");
            }
          
          return groupedProducts;
    }

    public ArrayList<Producto> getProductos() {
        return productos;
    }

    public void setProductos(ArrayList<Producto> productos) {
        this.productos = productos;
        this.productos.
                forEach(
                        p -> p.asignarCodigo(
                                groupProductos(p.getClass()).indexOf(p)
                        )
                );
        // alabada sea la programación funcional
    }
    
    
    
    
    
}
