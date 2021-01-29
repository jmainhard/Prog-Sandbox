package com.pooprueba2;
/**
 * @author Jorge M.
 */

public class Fresco extends Producto{
    private double porcentajeHumedad;

    public Fresco(double porcentajeHumedad, String nombre, String codigo,
            double tempAlmacenamiento, int precio) {
        super(nombre, tempAlmacenamiento, precio);
        this.porcentajeHumedad = porcentajeHumedad;
    }
    
    public void asignarCodigo(int num) {
        this.codigo = "FRES-"+ num;
    }
    
    @Override
    public String desc() {
        String descripcion = super.desc(); // equivalente a super.toString();
        
        descripcion += ", descripcion=fresco a "+
                this.getTempAlmacenamiento() + "°C";
        descripcion += " y " + this.porcentajeHumedad + "% humedad}";

        return descripcion;
    }
    

}
