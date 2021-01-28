package com.pooprueba2;
/**
 * @author Jorge M.
 */

public abstract class Producto implements Describible {
    String nombre;
    String codigo;
    double tempAlmacenamiento;
    int precio;

    public Producto(String nombre, String codigo, double tempAlmacenamiento, int precio) {
        this.nombre = nombre;
        this.codigo = codigo;
        this.tempAlmacenamiento = tempAlmacenamiento;
        this.precio = precio;
    }

    @Override
    public String toString() {
        return "Producto{" + "nombre=" + nombre + ", codigo=" + codigo + ", tempAlmacenamiento=" + tempAlmacenamiento + ", precio=" + precio + '}';
    }

    @Override
    public void desc() {
        throw new UnsupportedOperationException("Not supported yet."); 
    }
    
    
    
    
}
