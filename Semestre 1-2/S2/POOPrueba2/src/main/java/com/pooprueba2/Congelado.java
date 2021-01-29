package com.pooprueba2;
/**
 * @author Jorge M.
 */

public class Congelado extends Producto {
    private TipoCongelacionEnum congelacion;

    public Congelado(TipoCongelacionEnum congelacion, String nombre,
            String codigo, double tempAlmacenamiento, int precio) {
        super(nombre, tempAlmacenamiento, precio);
        this.congelacion = congelacion;
    }
    
    public void asignarCodigo(int num) {
        this.codigo = "CONG-"+ num;
    }

    @Override
    public String desc() {
        String descripcion = super.toString();
        
        descripcion += ", descripcion=congelación lenta a "+
                this.getTempAlmacenamiento() + "°C}";

        return descripcion;
    }

    
    
    
    
    
    
}
