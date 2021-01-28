package com.pooprueba2;
/**
 * @author Jorge M.
 */

public class Congelado extends Producto {
    TipoCongelacionEnum congelacion;

    public Congelado(TipoCongelacionEnum congelacion, String nombre,
            String codigo, double tempAlmacenamiento, int precio) {
        super(nombre, codigo, tempAlmacenamiento, precio);
        this.congelacion = congelacion;
    }

    @Override
    public void desc() {
        // TODO
        throw new UnsupportedOperationException("Not supported yet."); 
    }

    @Override
    public String toString() {
        return "Congelado{" + "congelacion=" + congelacion + '}';
    }
    
    
    
    
    
    
}
