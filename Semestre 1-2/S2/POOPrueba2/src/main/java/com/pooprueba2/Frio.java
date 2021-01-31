package com.pooprueba2;
/**
 * @author Jorge M.
 */

public class Frio extends Producto {

    public Frio(String nombre, double tempAlmacenamiento, int precio) {
        super(nombre, tempAlmacenamiento, precio);
    }
    
    public void asignarCodigo(int num) {
        this.codigo = "FRIO-"+ (num + 1);
    }
    
    @Override
    public String toString() {
        String descripcion = super.toString();
        
        descripcion += ", descripción=frío a "+
                this.getTempAlmacenamiento() + "°C}";

        return descripcion;
    }
    
    
    
    

}
