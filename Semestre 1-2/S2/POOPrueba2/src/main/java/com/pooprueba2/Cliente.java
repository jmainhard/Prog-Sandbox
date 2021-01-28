package com.pooprueba2;
/**
 * @author Jorge M.
 */

public class Cliente {
    String nombre;
    String rut;
    Canasta canastaCliente;

    public Cliente(String nombre, String rut, Canasta canastaCliente) {
        this.nombre = nombre;
        this.rut = rut;
        this.canastaCliente = canastaCliente;
    }

    public String getRut() {
        return rut;
    }
    
    
}
