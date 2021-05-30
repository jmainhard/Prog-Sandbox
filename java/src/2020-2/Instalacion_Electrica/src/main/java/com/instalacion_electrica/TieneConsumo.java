package com.instalacion_electrica;

/**
 *
 * @author Lekot
 */
public interface TieneConsumo {
    double calcConsumo(double horas);
    // La única clase que estrictamente lo utiliza es InstalacionElectrica.java
    // pero consideré que todo ObjetoElectrico al tener consumoElectrico
    // se le dé la posibildiad de calcular el consumo dada una canitdad de horas
    
    // todo podría ser un String construido con mayores detalles para facilitar salida por consola
}
