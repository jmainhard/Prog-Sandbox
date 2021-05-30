package com.instalacion_electrica;
/**
 * @author Jorge M.
 */

public class Aparato extends ObjetoElectrico {
    private boolean encendido;
    private TipoAparato tipo;
    private double CONST_CONSUMO;

    public Aparato(TipoAparato tipo, double consumoElectrico) {
        super(consumoElectrico);
        this.tipo = tipo;
        this.encendido = false;
        this.CONST_CONSUMO = super.consumoElectrico;
    }

    public void pressPowerButton() { // encender/apagar
        encendido = !encendido; // enseñado por el profe Juan
        if (encendido) {
            System.out.println(" Prendido " + tipo);
        } else if (!encendido) {
            System.out.println(" Apagado "+ tipo);
        }
        setConsumoElectrico();
    }
    
    // sobrecarga de métodos, mismo nombre distintos parámetros
    // asigna nuevo valor de consumo en base a lo realizado en pressPowerButton()
    // y su valor base de consumo CONST_CONSUMO
    public void setConsumoElectrico() {
        if (encendido) {
            this.consumoElectrico += CONST_CONSUMO * 0.3; //30% más de consumo para cualquier aparato, valor arbitrario 
        } else if (!encendido) { 
            this.consumoElectrico -= CONST_CONSUMO * 0.3; //-30%, vuelta al valor normal TODO 0.3 podría ser una variable atributo de cada aparato, asignada al ser construido
        }
    }
    
    
    
}
