package com.pooprueba2;
/**
 * @author Jorge M.
 */

public class Fresco extends Producto{
    double porcentajeHumedad;

    public Fresco(double porcentajeHumedad, String nombre, String codigo,
            double tempAlmacenamiento, int precio) {
        super(nombre, codigo, tempAlmacenamiento, precio);
        this.porcentajeHumedad = porcentajeHumedad;
    }
    
    

}
