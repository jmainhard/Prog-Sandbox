package cl.ufro.dci.accesodatos;

import cl.ufro.dci.modelo.Mascota;
import cl.ufro.dci.modelo.Persona;
import cl.ufro.dci.accesodatos.ArchivoJson; // unused
import com.google.gson.reflect.TypeToken;
import java.util.ArrayList;
import java.util.Collection;

/**
 * @author Jorge M.
 */

public class Main {
    public static void main(String[] args) {
        Persona persona = new Persona("15.463.861-k", "Rodolfo Javier",
                "Lopez Bravo", "27-08-2001");
        Persona persona2 = new Persona("10.881.443-8", "Paulina Adriana",
                "Sepulveda Aedo", "30-05-1973");
        
        ArrayList<Persona> personas = new ArrayList();
        
        personas.add(persona);
        personas.add(persona2);
        
        System.out.println("Lista antes");
        personas.forEach(System.out::println);
        
        persona.agregarMascota(new Mascota("Wawa", "Golden Retriever"));
        persona.agregarMascota(new Mascota("Pepe", "Chihuahua"));
        persona.agregarMascota(new Mascota("Roble", "Pastor Alemán"));
        
        guardarPersonas(personas);
        
        personas = cargarPersonas();
        
        Persona personaNueva = new Persona("12345678-9", "Felipe Juan",
                "Tapia Acevedo", "12-03-1992");
        
        personas.add(personaNueva);
        
        System.out.println("Lista después");
        personas.forEach(System.out::println);
        
        guardarPersonas(personas);
        
        personas.forEach(p -> System.out.println(p.getNombres()));
        
        Mascota mascota1 = new Mascota("Pepe", "Gato montés");
        Mascota mascota2 = new Mascota("Sofía", "Gatito");
        Mascota mascota3 = new Mascota("Lucero", "Ojos de lucero");
        
        ArrayList mascotas = new ArrayList<>();
        
        mascotas.add(mascota1);
        mascotas.add(mascota2);
        mascotas.add(mascota3);
        
        guardarMascotas(mascotas);
        
    }
    
    public static void guardarPersonas(ArrayList<Persona> personas) {
        FilleController<Persona> jsonHandler = new FilleController<>(new TypeToken<Collection<Persona>>(){});
        try {
            if ( jsonHandler.guardarLista(personas, "data/personas.json") ) {
                System.out.println("Lista de personas guardada exitosamente\n");
            }
        } catch (NullPointerException ex) {
            System.err.println("Error al guardar: "+ ex);
        } catch (Exception ex) {
            System.err.println("Error al intentar guardar esta lista"+ ex);
        }
    }
    
    public static ArrayList<Persona> cargarPersonas() {
        // TODO revisar manejo de inventario específico profe marcelo github
        FilleController<Persona> jsonHandler = new FilleController<>(new TypeToken<Collection<Persona>>(){});
        return jsonHandler.cargarLista("data/personas.json");
    }
    
    public static void guardarMascotas(ArrayList<Mascota> mascotas) {
        FilleController<Mascota> jsonHandler = new FilleController<>(new TypeToken<Collection<Mascota>>(){});
        try {
            if ( jsonHandler.guardarLista(mascotas, "data/mascotas.json") ) {
                System.out.println("Lista de mascotas guardada exitosamente\n");
            }
        } catch (NullPointerException ex) {
            System.err.println("Error al guardar: "+ ex);
        } catch (Exception ex) {
            System.err.println("Error al intentar guardar esta lista"+ ex);
        }
    }
    
    public static ArrayList<Mascota> cargarMascotas() {
        FilleController<Mascota> jsonHandler = new FilleController<>(new TypeToken<Collection<Mascota>>(){});
        return jsonHandler.cargarLista("data/mascotas.json");
    }
    

}
