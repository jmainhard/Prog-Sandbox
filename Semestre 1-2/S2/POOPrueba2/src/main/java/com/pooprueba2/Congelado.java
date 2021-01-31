package com.pooprueba2;

import com.pooprueba2.helper.TipoCongelacionEnum;

/**
 * @author Jorge M.
 */

public class Congelado extends Producto {
    private TipoCongelacionEnum congelacion;

    public Congelado(TipoCongelacionEnum congelacion, String nombre,
            double tempAlmacenamiento, int precio) {
        super(nombre, tempAlmacenamiento, precio);
        this.congelacion = congelacion;
    }
    
    public void asignarCodigo(int num) {
        this.codigo = "CONG-"+ (num + 1);
    }

    @Override
    public String toString() {
        String descripcion = super.toString();
        
        descripcion += ", descripcion=Congelación "+ this.congelacion+" a "+
                this.getTempAlmacenamiento() + "°C}";

        return descripcion;
    }

    
    
    
    
    
    
}
