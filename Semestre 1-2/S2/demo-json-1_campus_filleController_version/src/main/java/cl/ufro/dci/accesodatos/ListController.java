package cl.ufro.dci.accesodatos;

import com.google.gson.reflect.TypeToken;
import java.util.Collection;
import cl.ufro.dci.modelo.*;
import java.util.ArrayList;

/**
 * @author Jorge M.
 * Clase genérica de métodos estáticos para controlar Listas de objetos
 * utiliza FilleController
 * @param <E> tipo de elementos en esta listas
 * 
 * 
 */

public class ListController<E> {
    
    private static final String RUTA = "data/";
    private final String archivoJson;

    public ListController(String archivoJson) {
        this.archivoJson = archivoJson;
    }
    
    public void guardarObjetos(ArrayList<E> listaObjetos) {
        FilleController<E> jsonHandler = new FilleController<>(new TypeToken<Collection<E>>(){});
         try {
            if ( jsonHandler.guardarLista(listaObjetos, RUTA+archivoJson) ) {
                System.out.println("Lista guardada exitosamente\n");
            }
        } catch (NullPointerException ex) {
            System.err.println("Error al guardar: "+ ex);
        } catch (Exception ex) {
            System.err.println("Error al intentar guardar esta lista "+ ex);
        }
    }
    
    public ArrayList<E> cargarObjetos() {
        FilleController<E> jsonHandler = new FilleController<>(new TypeToken<Collection<E>>(){});
        return jsonHandler.cargarLista(RUTA+archivoJson);
    }
}
