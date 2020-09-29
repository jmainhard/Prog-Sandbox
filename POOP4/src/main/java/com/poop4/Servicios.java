package com.poop4;
/**
 * @author Jorge M.
 */

public class Servicios extends Contrato{
    
    private byte tipoServicio;
    private byte nivelServicio;
    
    public Servicios() {
        this.tipoServicio = -1;
        this.nivelServicio = -1;
    }
    
    public Servicios(byte tipoServicio, byte nivelServicio) {
        this.tipoServicio = tipoServicio;
        this.nivelServicio = nivelServicio;
    }
    
    public void setTipo(byte tipoSer) {
        this.tipoServicio = tipoSer;
    }
    
    public void setNivel(byte nvlSer) {
        this.nivelServicio = nvlSer;
    }
    
    public byte getTipo() {
        return tipoServicio;
    }

    public byte getNvl() {
        return nivelServicio;
    }
    
    //returns String tipoServicio
    public String getTipo(byte tipoSer) {
        String servicio = "";
        if (tipoSer == 1) {
            servicio = "Soporte Web";
        } else if (tipoSer == 2) {
            servicio = "Hosting";
        } else if (tipoSer == 3) {
            servicio = "Mantención de redes";
        }
        
        return servicio;
    }
    
    //returns String nvlServicio
    public String getNvl(byte nivelSer) {
        String nvl = "";
        if (nivelSer == 1) {
            nvl = "Silver";
        } else if (nivelSer == 2) {
            nvl = "Gold";
        } else if (nivelSer == 3) {
            nvl = "Platinum";
        }
        
        return nvl;
    }
    
    
}
