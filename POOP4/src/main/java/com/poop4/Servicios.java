package com.poop4;
/**
 * @author Jorge M.
 */

public class Servicios extends Contrato{
    
    private byte tipoServicio;
    private byte nivelServicio;
    private int gold = 20000;
    
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
    
    public int getValor() {
        int valorServicio = 0;
        
        if (tipoServicio == 1) {
            switch (nivelServicio) {
                case 1: // soporte silver
                    return valorServicio = (int) (gold - (gold*0.1));
                case 2: // soporte gold
                    return valorServicio = gold;
                case 3: // soporte platinum
                    return valorServicio = (int) (gold + (gold*0.3)); 
                default:
                    throw new AssertionError();
            }
                    
        } else if (tipoServicio == 2) { // hosting values
            switch (nivelServicio) {
                case 1: // hosting silver
                    return valorServicio = (int) (gold - (gold*0.15));
                case 2: // gold
                    return valorServicio = gold;
                case 3: // platinum
                    return valorServicio = (int) (gold + (gold*0.1));
                default:
                    throw new AssertionError();
            }
        } else if (tipoServicio == 3) { // redes values
            switch (nivelServicio) {
                case 1: // silver
                    return valorServicio = (int) (gold - (gold*0.2));
                case 2: // gold
                    return valorServicio = gold;
                case 3: // platinum
                     return valorServicio = (int) (gold + (gold*0.4));
                default:
                    throw new AssertionError();
            }
        }
        
        return valorServicio;
    } 
    
    
}
