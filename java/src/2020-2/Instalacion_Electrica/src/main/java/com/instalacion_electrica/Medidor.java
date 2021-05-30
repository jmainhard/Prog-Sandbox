package com.instalacion_electrica;
/**
 * @author Jorge M.
 */

public class Medidor extends ObjetoElectrico {
    private InstalacionElectrica instalacion;
    private double costo;

    public Medidor() {
        super();
    }

    public InstalacionElectrica getInstalacion() {
        return instalacion;
    }

    public void setInstalacion(InstalacionElectrica instalacion) {
        this.instalacion = instalacion;
    }
    
    @Override
    public String toString() {
        String str = new String();
        
        str += "Consumo Acumulado: "+ consumoElectrico + "Watt\n";
        str += "Costo calculado ($100*KWh): $"+ costo+ "\n";        
        
        return str;
    }
    
    public void updateConsumoAcumulado() {
        double nuevoConsumo = 0;
        for (Aparato aparato : instalacion.getAparatos()) {
            nuevoConsumo += aparato.getConsumoElectrico();
        }
        this.consumoElectrico = nuevoConsumo;
        updateCosto();
    }
    
    public void updateCosto() {
        costo = (consumoElectrico / 1000) * 100;
    }
    
    // calcular costo dado una hora, no utilizado
    public void calcCosto(double horas) {
        costo = (consumoElectrico / 1000) * (100 * horas);
    }
    
    
    
    
}
