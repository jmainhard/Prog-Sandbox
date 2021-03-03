package com.instalacion_electrica;
/**
 * @author Jorge M.
 * Prueba 1 POO
 * 21-diciembre-2020
 * Contenidos:
 *  Fundamentos POO
 *  Dependencia, Asociación, Agregación, Composición
 *  Herencia. Abtractas
 *  Interfaces
 * 
 * Modele un programa en java que simule una instalación eléctrica y los aparatos conectados a ella
 */

public class Main {
    public static void main(String[] args) {
        Aparato aparato1 = new Aparato(TipoAparato.PLANCHA, 1000);
        Aparato aparato2 = new Aparato(TipoAparato.ASPIRADORA, 675);
        Aparato aparato3 = new Aparato(TipoAparato.TELEVISOR, 760);
        InstalacionElectrica instalacion = new InstalacionElectrica();
        
        instalacion.addAparato(aparato1);
        instalacion.addAparato(aparato2);
        instalacion.addAparato(aparato3);
        System.out.println("Consumo de watts pasivos: "+ instalacion.getConsumoElectrico());
        
        // encender aparatos
        aparato1.pressPowerButton();
        aparato2.pressPowerButton();
        System.out.println("Consumo de watts aparatos encendidos: "+ instalacion.getConsumoElectrico());
        
        aparato1.pressPowerButton();
        aparato2.pressPowerButton();
        System.out.println("Consumo de watts aparatos apagados: "+ instalacion.getConsumoElectrico());

        
    }

}
