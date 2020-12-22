package com.instalacion_electrica;
/**
 * @author Jorge M.
 */

public class Aparato extends ObjetoElectrico {
    private boolean encendido;
    private TipoAparato tipo;
    private int timesPressedPowerButton;
    private double CONST_CONSUMO;

    public Aparato(TipoAparato tipo, double consumoElectrico) {
        super(consumoElectrico);
        this.tipo = tipo;
        this.encendido = false;
        this.CONST_CONSUMO = super.consumoElectrico;
    }

    public void pressPowerButton() { // encender/apagar 0 1 2
        // 0 apagado
        // 1 prendido
        // 2 apagado
        // 3 prendido
        // 4 apagado
        // 5 prendido
        // ...
        encendido = !encendido; // enseñado por el profe Juan
        timesPressedPowerButton++;
        if (encendido) {
            System.out.println(" Prendido " + tipo);
        } else if (!encendido) {
            System.out.println(" Apagado "+ tipo);
        }
        setConsumoElectrico();
    }
    
    // sobrecarga de métodos, mismo nombre distintos parámetros
    // asigna nuevo valor de consumo en base a lo realizado en pressPowerButton()
    // y su valor base de consumo CONST_CONSUMO, si las veces prendido es par, disminuye consumo
    public void setConsumoElectrico() {
        if (encendido) {
            this.consumoElectrico += CONST_CONSUMO * 0.3; //30% más de consumo para cualquier aparato, valor arbitrario 
        } else if (timesPressedPowerButton % 2 == 0) { // siempre comprobará números mayores o iguales que uno
            this.consumoElectrico -= CONST_CONSUMO * 0.3; //-30%, vuelta al valor normal TODO 0.3 podría ser una variable atributo de cada aparato, asignada al ser construido
        }
    }
    
    
    
}
