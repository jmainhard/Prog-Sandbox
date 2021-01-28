package com.pooprueba2;
/**
 * @author Jorge M.
 */

public class Boleta implements Imprimible {
    String idBoleta;
    int[][] totalDescuentos;
    int total;
    Cliente cliente;

    public Boleta(Cliente cliente) {
        this.cliente = cliente;
        this.idBoleta = cliente.getRut() + " TODO + LocalDateTime";
    }

    @Override
    public void imprimir() {
        throw new UnsupportedOperationException("Not supported yet."); 
    }
    
    
    
    
    
    
    
}
