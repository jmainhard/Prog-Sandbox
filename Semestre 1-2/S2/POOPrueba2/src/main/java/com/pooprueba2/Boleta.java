package com.pooprueba2;

import com.pooprueba2.helper.CanastaVaciaException;


/**
 * @author Jorge M.
 */

public class Boleta implements Imprimible {
    private String idBoleta;
    private int[][] totalDescuentos;
    private int total;
    private Cliente cliente;

    public Boleta(Cliente cliente) {
        this.cliente = cliente;
        this.idBoleta = cliente.getRut() + " TODO + LocalDateTime";
    }

    @Override
    public void imprimir() {
                    // TODO imprimir boleta y guardar archivo

        try {
            if (cliente.realizarCompra()) {
                
            }
        } catch (CanastaVaciaException e) {
            System.err.println(e.getMessage());
        } catch (Exception e) {
            System.err.println(e.getMessage());
        }
        
        throw new UnsupportedOperationException("TODO."); 
    }
    
    
    public void calcTotal() {
        
    }
    
    
    
    
    
    
    
}
