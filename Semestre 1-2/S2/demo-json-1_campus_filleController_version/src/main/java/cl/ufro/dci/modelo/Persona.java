package cl.ufro.dci.modelo;

import java.util.ArrayList;
import cl.ufro.dci.modelo.Mascota;

public class Persona {

    private String rut;
    private String nombres;
    private String apellidos;
    private String fechaNacimiento;
    private ArrayList<Mascota> mascotas = new ArrayList<>();

    public Persona() {
        
    }

    public Persona(String rut, String nombres, String apellidos, String fechaNacimiento) {
        this.rut = rut;
        this.nombres = nombres;
        this.apellidos = apellidos;
        this.fechaNacimiento = fechaNacimiento;
    }
    
    public boolean agregarMascota(Mascota mascota) {
        return this.mascotas.add(mascota);
    }

    public String getRut() {
        return this.rut;
    }

    public void setRut(String rut) {
        this.rut = rut;
    }

    public String getNombres() {
        return this.nombres;
    }

    public void setNombres(String nombres) {
        this.nombres = nombres;
    }

    public String getApellidos() {
        return this.apellidos;
    }

    public void setApellidos(String apellidos) {
        this.apellidos = apellidos;
    }

    public String getFechaNacimiento() {
        return this.fechaNacimiento;
    }

    public void setFechaNacimiento(String fechaNacimiento) {
        this.fechaNacimiento = fechaNacimiento;
    }
    
    public ArrayList<Mascota> getMascotas() {
        return mascotas;
    }

    @Override
    public String toString() {
        return "Persona{" + "rut=" + rut + ", nombres=" + nombres + ", apellidos=" + apellidos + ", fechaNacimiento=" + fechaNacimiento + ", mascotas=" + mascotas + '}';
    }

}
