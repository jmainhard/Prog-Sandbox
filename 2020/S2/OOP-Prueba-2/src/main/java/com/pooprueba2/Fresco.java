package com.pooprueba2;
/**
 * @author Jorge M.
 */

public class Fresco extends Producto {
    private double porcentajeHumedad;

    public Fresco(double porcentajeHumedad, String nombre, 
            double tempAlmacenamiento, int precio) {
        super(nombre, tempAlmacenamiento, precio);
        this.porcentajeHumedad = porcentajeHumedad;
    }
    
    public void asignarCodigo(int num) {
        this.codigo = "FRES-"+ (num + 1);
    }
    
    @Override
    public String toString() {
        String descripcion = super.toString();
        
        descripcion += ", descripcion=Fresco a "+
                this.getTempAlmacenamiento() + "°C";
        descripcion += " y " + this.porcentajeHumedad + "% humedad}";

        return descripcion;
    }
    

}
