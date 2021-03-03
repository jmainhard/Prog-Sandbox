package com.instalacion_electrica;

import java.util.ArrayList;

/**
 * @author Jorge M.
 */

public class InstalacionElectrica { 
// talvez InstalacionElectrica podria no heredar de ObjetoElectrico y sólo tener un medidor quien se haga cargo
// de la revisión y de mantener actualizado el consumo, Medidor si heredaría de ObjetoElectrico
    
    private Medidor medidor;
    private ArrayList<Aparato> aparatos;

    public InstalacionElectrica() { // para Asociación: InstalacionElectrica(Medidor medidor) | setMedidor()
        super();
        this.aparatos = new ArrayList();
        this.medidor = new Medidor(); // para Asociación: this.medidor = medidor;
        medidor.setInstalacion(this);
    }
    
    public void addAparato(Aparato aparato) {
        this.aparatos.add(aparato);
        medidor.updateConsumoAcumulado();
    }
    
    // borra un aparato y lo resta del medidor
    public void delAparato(int indice) {
        this.aparatos.remove(indice);
        medidor.consumoElectrico -= aparatos.get(indice).getConsumoElectrico();
        medidor.updateCosto();
    }
    
    public double getConsumoElectrico() {
        medidor.updateConsumoAcumulado();
        return medidor.consumoElectrico;
    }
    
    public double calcConsumoHora(double horas) {
        return medidor.calcConsumo(horas);
    }
    
    public ArrayList<Aparato> getAparatos() {
        return aparatos;
    }

    public void setAparatos(ArrayList<Aparato> aparatos) {
        this.aparatos = aparatos;
    }
    
    
    
    
}
