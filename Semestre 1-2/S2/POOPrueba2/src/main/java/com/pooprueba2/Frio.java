package com.pooprueba2;
/**
 * @author Jorge M.
 */

public class Frio extends Producto {

    public Frio(String nombre, String codigo, double tempAlmacenamiento,
            int precio) {
        super(nombre, tempAlmacenamiento, precio);
    }
    
    public void asignarCodigo(int num) {
        this.codigo = "FRIO-"+ num;
    }
    
    @Override
    public String desc() {
        String descripcion = super.desc(); // equivalente a super.toString();
        
        descripcion += ", descripcion=frío a "+
                this.getTempAlmacenamiento() + "°C}";

        return descripcion;
    }
    
    
    
    

}
