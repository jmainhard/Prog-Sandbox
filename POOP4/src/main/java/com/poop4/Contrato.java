package com.poop4;

import java.io.File;
import java.util.ArrayList;
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
    private ArrayList listaServicios;
    
    public Contrato() {
        super();
        this.fechaContrato = fechaContrato;
        this.idContrato = "Nuevo Contrato";
        this.tiempoContrato = -1;
        this.servicio1 = -1;
        this.servicio2 = -1;
        this.lvlService1 = -1;
        this.lvlService2 = -1;
        this.valor = 0;
        this.listaServicios = new ArrayList();
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
    
    public ArrayList getServicios() {
        return listaServicios;
    }

    //setters
    public void setTiempoContrato(byte tiempo) {
        
    }
    
    public void setIdContrato(String localDate, String rut) {
        idContrato = localDate+ "-"+ rut;
        File file = new File("Archvos/Contratos" + idContrato + ".txt");
    }
    
    public void setServicio(byte numSer, byte tipoSer) {
        if (numSer == 1) {
            setServicio1(tipoSer);
        } else if (numSer == 2) {
            setServicio2(tipoSer);
        }
    }
    
    public void setNivel(byte numSer, byte nivelSer) {
        if (numSer == 1) {
            setLvlService1(nivelSer);
        } else if (numSer == 2) {
            setLvlService2(nivelSer);
        }
    }
    
    public void setServicio1(byte tipoSer) {
        this.servicio1 = tipoSer;
    }
    
    public void setServicio2(byte tipoSer) {
        this.servicio2 = tipoSer;
    }
    
    public void setLvlService1(byte nivelSer) {
        this.lvlService1 = nivelSer;
    }
    
    public void setLvlService2(byte nivelSer) {
        this.lvlService2 = nivelSer;
    }
    
    public void setValor() {

    }
    
    public void addServicio(String servicio, String nivel) {
        listaServicios.add(servicio);
        listaServicios.add(nivel);
    }
    
    public int calcularValorServicio(byte tipoSer, byte nvlSer) {
        Servicios servicio = new Servicios(tipoSer, nvlSer);
        int valorServicio = 0;
        valorServicio = (int) servicio.getValor();
        
        return valorServicio;
    }
    
    
}
