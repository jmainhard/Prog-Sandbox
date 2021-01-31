package com.pooprueba2;
/**
 * @author Jorge M.
 */

public abstract class Producto  { /* implements Describible */
    protected String nombre;
    protected String codigo;
    protected double tempAlmacenamiento;
    protected double precio;

    public Producto(String nombre, double tempAlmacenamiento, int precio) {
        this.nombre = nombre;
        this.tempAlmacenamiento = tempAlmacenamiento;
        this.precio = precio;
        this.codigo = "PROD-UNDEFINED";
    }
    
    @Override
    public String toString() {
        return "Producto{" + "codigo=" + codigo + ", precio=" + precio + ", nombre=" + nombre;
    }

    public String getCodigo() {
        return codigo;
    }

    public String getNombre() {
        return nombre;
    }

    public double getTempAlmacenamiento() {
        return tempAlmacenamiento;
    }

    public double getPrecio() {
        return precio;
    }
    
    public abstract void asignarCodigo(int num);

    
    
    
    
    
    
    
}
