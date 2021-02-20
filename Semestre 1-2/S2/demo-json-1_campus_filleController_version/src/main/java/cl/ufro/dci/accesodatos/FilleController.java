package cl.ufro.dci.accesodatos;

import com.google.gson.Gson;
import com.google.gson.GsonBuilder;
import com.google.gson.JsonIOException;
import com.google.gson.reflect.TypeToken;
import java.io.BufferedReader;
import java.io.FileReader;
import java.io.FileWriter;
import java.io.IOException;
import java.util.ArrayList;
import java.util.Collection;
import java.util.List;

/**
 * 
 * Clase genérica para controlar archivos json del proyecto
 * 
 * @param <E> tipo de elementos contenidos en este archivo  
 * @author Jorge M.
 * 20-02-2021
 * 
 * Documentación de clases genéricas: 
 *   https://docs.oracle.com/javase/tutorial/java/generics/index.html
 */

public class FilleController<E> {
    private TypeToken<Collection<E>> collectionType;
    private Class<E> tipoElementos;

    public FilleController(TypeToken<Collection<E>> collectionType, Class<E> tipoElementos) {
        this.collectionType = collectionType;
        this.tipoElementos = tipoElementos;
    }
    
    public Class<E> getE() { 
        return tipoElementos; 
    }

    public void setE(Class<E> tipoElementos) { 
        this.tipoElementos = tipoElementos; 
    }
    
    public void guardarLista(List<E> lista, String ruta) {
            FileWriter writer;
            try {
                writer = new FileWriter(ruta);
                Gson gson = new GsonBuilder().setPrettyPrinting().create();
                gson.toJson(lista, writer);
                writer.close();
            } catch (IOException ex) {
                System.out.println("Error al crear el archivo");
            } catch (JsonIOException ex) {
                System.err.println("Error al guardar lista (Json)");
            } catch (Exception e) {
                System.err.println("Error "+ e);
            }
    }

    public ArrayList<E> cargarLista(String ruta) {
            ArrayList<E> lista = new ArrayList<E>();
            try {
                BufferedReader br = new BufferedReader(new FileReader(ruta));
                Gson gson = new Gson();
                lista = gson.fromJson(br, collectionType.getType());
            }catch (IOException e) {
                System.err.println("Error "+ e);
            }
            return lista;
    }

}
