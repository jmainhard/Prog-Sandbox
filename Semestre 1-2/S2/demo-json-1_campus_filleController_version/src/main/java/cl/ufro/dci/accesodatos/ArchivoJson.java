package cl.ufro.dci.accesodatos;

import java.util.ArrayList;
import cl.ufro.dci.modelo.Persona;
import com.google.gson.Gson;
import com.google.gson.GsonBuilder;
import com.google.gson.reflect.TypeToken;
import com.google.gson.stream.JsonWriter;
import java.io.BufferedReader;
import java.io.FileReader;
import java.io.FileWriter;
import java.lang.reflect.Type;
import java.util.List;

public class ArchivoJson {

    private static final String RUTA = "data/";
    private static final String NOMBRE = "objetos.json";

    public static boolean almacenarObjetos(ArrayList<Persona> personas) {
        
        boolean respuesta = false;
        Type listType = new TypeToken<List<Persona>>() {}.getType();
        Gson gson = new GsonBuilder().setPrettyPrinting().create();
//        String json = gson.toJson(personas, listType); -- DCI
        String json = gson.toJson(personas);
        
        try (FileWriter file = new FileWriter(RUTA+NOMBRE)){
            
            file.write(json);
            respuesta = true;
            
        } catch (Exception e) {
            System.out.println(e.getMessage());
        }
        
        return respuesta;
    }

    public static ArrayList<Persona> recurperarObjetos() {
        Gson gson = new Gson();
        BufferedReader br = null;
        try {
            br = new BufferedReader(new FileReader(RUTA+NOMBRE));
        } catch (Exception e) {
            e.printStackTrace();
        }
        ArrayList<Persona> persona = gson.fromJson(br, new TypeToken<List<Persona>>() {}.getType());
//        ArrayList<Persona> persona2 = gson.fromJson(br, );
        
        
        return persona;
        
    }
}
