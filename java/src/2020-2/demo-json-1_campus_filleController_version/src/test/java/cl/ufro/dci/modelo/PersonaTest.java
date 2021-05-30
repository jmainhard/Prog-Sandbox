/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package cl.ufro.dci.modelo;

import cl.ufro.dci.accesodatos.ArchivoJson;
import com.google.gson.Gson;
import com.google.gson.reflect.TypeToken;
import java.util.ArrayList;
import java.util.List;
import org.junit.Test;
import static org.junit.Assert.*;
import org.junit.Before;

/**
 *
 * @author dci
 */
public class PersonaTest {

    ArrayList<Persona> personas = new ArrayList<>();
    String textoJson;

    @Before
    public void setUp() {

        Persona p1 = new Persona();
        p1.setRut("11.111.111-1");
        p1.setNombres("Diego");
        p1.setApellidos("Mayorga");
        p1.setFechaNacimiento("11-11-1991");

        Mascota m1 = new Mascota();
        m1.setNombres("Boby");
        m1.setRaza("CANINO");

        Mascota m2 = new Mascota();
        m2.setNombres("Felix");
        m2.setRaza("FELINO");

        p1.agregarMascota(m1);
        p1.agregarMascota(m2);

        Persona p2 = new Persona();
        p2.setRut("22.222.222-2");
        p2.setNombres("Armin");
        p2.setApellidos("Rodriguez");
        p2.setFechaNacimiento("23-11-1996");

        Mascota m3 = new Mascota();
        m3.setNombres("Duky");
        m3.setRaza("CANINO");

        p2.agregarMascota(m3);

        personas.add(p1);
        personas.add(p2);

    }

    @Test
    public void testToJson() {

        textoJson = new Gson().toJson(personas);
        System.out.println(textoJson);

    }

    @Test
    public void testJsonJava() {
        textoJson = new Gson().toJson(personas);
        ArrayList<Persona> listobj = new Gson().fromJson(textoJson, new TypeToken<List<Persona>>() {
        }.getType());
        
        for (Persona p : listobj) {
            System.out.println(""+p.getRut());
        }
        
     }
    
    @Test
    public void testAlmacenarObjetos(){
    
        assertTrue(ArchivoJson.almacenarObjetos(personas));
    }
    
    @Test
    public void testRecuperarObjetos(){
    
        int cantidadRegistros = 2;
        int cantidadObtenida = ArchivoJson.recurperarObjetos().size();
        assertEquals(cantidadRegistros, cantidadObtenida);
    }

}
