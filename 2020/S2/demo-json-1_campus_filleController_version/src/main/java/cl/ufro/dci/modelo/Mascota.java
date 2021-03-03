package cl.ufro.dci.modelo;

public class Mascota {

    private String nombres;
    private String raza;

    public Mascota() {
    }

    public Mascota(String nombres, String raza) {
        this.nombres = nombres;
        this.raza = raza;
    }
    
    public String getNombres() {
        return this.nombres;
    }

    public void setNombres(String nombres) {
        this.nombres = nombres;
    }

    public String getRaza() {
        return this.raza;
    }

    public void setRaza(String raza) {
        this.raza = raza;
    }

    @Override
    public String toString() {
        return "Mascota{" + "nombres=" + nombres + ", raza=" + raza + '}';
    }

}
