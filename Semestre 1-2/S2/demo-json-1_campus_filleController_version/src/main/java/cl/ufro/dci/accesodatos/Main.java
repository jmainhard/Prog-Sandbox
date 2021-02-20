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
        
        persona.agregarMascota(new Mascota("Wawa", "Golden Retriever"));
        persona.agregarMascota(new Mascota("Pepe", "Chihuahua"));
        persona.agregarMascota(new Mascota("Roble", "Pastor Alemán"));
        
        FilleController<Persona> personasJson = new FilleController<>(new TypeToken<Collection<Persona>>(){}, Persona.class);
        
        personasJson.guardarLista(personas, "data/personas.json");
        
        ArrayList<Persona> personasGet = personasJson.cargarLista("data/personas.json");
        
        personasGet.forEach(System.out::println);
        
        System.out.println(personasGet.get(1).getNombres());
        System.out.println(personasGet.get(1).getMascotas());
        
        
    }

}
