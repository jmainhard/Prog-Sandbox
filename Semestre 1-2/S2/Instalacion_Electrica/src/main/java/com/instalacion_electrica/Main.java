package com.instalacion_electrica;
/**
 * @author Jorge M.
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
        // no alcanzo a hacer el resto de las pruebas pero diría que quedó funcional (creo)
        
        aparato1.pressPowerButton();
        aparato2.pressPowerButton();
        System.out.println("Consumo de watts aparatos apagados: "+ instalacion.getConsumoElectrico());

        
    }

}
