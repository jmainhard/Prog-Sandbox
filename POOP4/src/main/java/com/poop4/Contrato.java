package com.poop4;

import java.util.Date;

/**
 * //Nombre Contrato -> heredado de cliente
 * //Contenido Contrato
 * @author Jorge M.
 */

// 

public class Contrato { // extends Cliente
    
    private Date fechaContrato;
    private String idContrato;
    private String rutCliente;
    private byte tiempoContrato;
    private byte servicio1, servicio2; // servicios contratados
    private byte lvlService1, lvlService2; // nivel de cada servicio
    private int valor;
    
    public Contrato() {
        super();
        this.fechaContrato = fechaContrato;
        this.idContrato = "Nuevo Contrato";
        this.tiempoContrato = -1;
        this.servicio1 = -1;
        this.servicio2 = -1;
        this.lvlService1 = -1;
        this.lvlService2 = -1;
        this.valor = -1;
    }
    
    public Contrato(Date fechaContrato, String rutCliente) {
//        super(rutCliente);
        this.rutCliente = rutCliente;
        this.fechaContrato = fechaContrato;
        this.tiempoContrato = -1;
    }
    
    //getters
    public byte getTiempoContrato() { // 1 a 6
        return tiempoContrato;
    }
    
    public byte getServicio1() { // 0, 1, 2
        return servicio1;
    }
    
    public byte getServicio2() {
        return servicio2;
    }
    
    public byte getlvlService1() {
        return lvlService1;
    }
    
    public byte getlvlService2() {
        return lvlService2;
    }
    
    public int getValor() {
        return valor;
    }
    
    public String getIdContrato() {
        return idContrato;
    }

    //setters
    public void setTiempoContrato(byte tiempo) {
        
    }
    
    public void setIdContrato(String localDate, String rut) {
        idContrato = localDate+ "-"+ rut+ ".txt"; 
    }
    
    public void setServicio1() {

    }
    
    public void setServicio2() {

    }
    
    public void setLvlService1() {

    }
    
    public void setLvlService2() {

    }
    
    public void setValor() {

    }
    
    
}
