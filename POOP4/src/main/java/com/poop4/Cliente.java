package com.poop4;

import java.util.Date;

/**
 * @author Jorge M.
 */

public class Cliente extends Contrato {

    private String nombre;
    private String rut;
    private String domicilio;
    
    public Cliente() {
        this.nombre = "Nuevo Cliente";
        this.rut = "";
        this.domicilio = "Domicilio cliente";
    }

    //constructor con rut, heredado a Contrato(date fecha, int rut)
    public Cliente(String rutCliente) {
        this.rut = rutCliente;
        this.nombre = "Nuevo Cliente";
        this.domicilio = "Domicilio Cliente";
    }
    
    public String getNombre() {
        return nombre;
    }
    
    public String getRut() {
        return rut;
    }
     
     public String getDomicilio() {
        return domicilio;
    }
     
    public void setNombre(String nombreCliente) {
        this.nombre = nombreCliente;
    }
    
    public void setRut(String rutCliente) {
        this.rut = rutCliente;
    }
    
    public void setDomicilio(String domicilioCliente) {
        this.domicilio = domicilioCliente;
    }
    
}
