package com.instalacion_electrica;
/**
 * @author Jorge M.
 */

public abstract class ObjetoElectrico implements TieneConsumo {
    protected double consumoElectrico;

    public ObjetoElectrico(double consumoElectrico) {
        this.consumoElectrico = consumoElectrico;
    }
    
    public ObjetoElectrico() {
        this.consumoElectrico = 0;
    }

    public double getConsumoElectrico() {
        return consumoElectrico;
    }

    public void setConsumoElectrico(double consumoElectrico) {
        this.consumoElectrico = consumoElectrico;
    }

    @Override
    public double calcConsumo(double horas) {
        return consumoElectrico * horas;
    }
    
    
       
}
