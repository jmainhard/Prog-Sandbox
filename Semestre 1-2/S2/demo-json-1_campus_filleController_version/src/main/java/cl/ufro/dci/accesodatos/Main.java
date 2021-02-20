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
//        // Rescatando Objetos tipo persona desde archivo json (uso de Clase genérica)
//        ListController<Persona> personasHandler;
//        personasHandler = new ListController<>("personas.json",
//                new TypeToken<Collection<Persona>>(){});
//        ArrayList<Persona> personasGet = new ArrayList<>();
//        
//        personasGet = personasHandler.cargarObjetos();
//        System.out.println("== Personas ==");
//        personasGet.forEach(p -> System.out.println(p.getNombres()));
//        
//        // --------------------------------------------------------
//        // Rescatando objetos de tipo Mascota desde archivo json (uso de Clase genérica)
//        ListController<Mascota> mascotasHandler;
//        mascotasHandler = new ListController<>("mascotas.json",
//                new TypeToken<Collection<Mascota>>(){});
//        ArrayList<Mascota> mascotasGet = new ArrayList<>();
//        
//        mascotasGet = mascotasHandler.cargarObjetos();
//        System.out.println("== Mascotas ==");
//        mascotasGet.forEach(p -> System.out.println(p.getNombres()));
        
        // Guardando Objetos de tipo persona a archivo JSON
//        ArrayList<Persona> personas = new ArrayList<>();
//        personas.add(new Persona("12312321", "asdasd", "aweqeqw", "dd-mm-yyy"));
//        personas.add(new Persona("54645645", "dsfsdf", "sdfsdf", "dd-mm-yyy"));
//        personas.add(new Persona("78878768", "bgfhfgbgf", "cbvbcvb", "dd-mm-yyy"));
//        
//        personasHandler.guardarObjetos(personas);

        // ------------------------------------------------------------
        // Guardando Objetos de tipo Mascota a archivo JSON
//        ArrayList<Mascota> mascotas = new ArrayList<>();
//        mascotas.add(new Mascota("Sillón", "Mueble"));
//        mascotas.add(new Mascota("Perrito", "Gran Danés"));
//        mascotas.add(new Mascota("Gato", "Británico Azul"));
//        
//        mascotasHandler.guardarObjetos(mascotas);
        
        // -------------------------------------------------------------
// guardando y cargando objetos con métodos personalizados (no genéricos)
//        guardarPersonas(personas);
//        
//        personas = cargarPersonas();
//        
//        Persona personaNueva = new Persona("12345678-9", "Felipe Juan",
//                "Tapia Acevedo", "12-03-1992");
//        
//        personas.add(personaNueva);
//        
//        System.out.println("Lista después");
//        personas.forEach(System.out::println);
//        
//        guardarPersonas(personas);
//        
//        personas.forEach(p -> System.out.println(p.getNombres()));
//        
//        Mascota mascota1 = new Mascota("Pepe", "Gato montés");
//        Mascota mascota2 = new Mascota("Sofía", "Gatito");
//        Mascota mascota3 = new Mascota("Lucero", "Ojos de lucero");
//        
//        ArrayList mascotas = new ArrayList<>();
//        
//        mascotas.add(mascota1);
//        mascotas.add(mascota2);
//        mascotas.add(mascota3);
//        
//        guardarMascotas(mascotas);
        
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
