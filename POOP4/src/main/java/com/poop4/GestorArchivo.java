package com.poop4;

import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Path;
import java.nio.file.Paths;
import java.nio.file.StandardCopyOption;
import java.io.FileWriter;
import java.nio.file.StandardOpenOption;
import java.util.Scanner;
import java.util.ArrayList;
/**
 * @author Jorge M.
 */

public class GestorArchivo {

    private Scanner teclado = new Scanner(System.in);
    
    public void newDir() {
        System.out.println("Ingrese nombre para nuevo directorio");
        String ruta = teclado.next();
        Path directorio = Paths.get(ruta);
        if (Files.exists(directorio)) {
            System.out.println("El directorio ya existe");
        } else {
            try {
                Files.createDirectories(directorio);
                System.out.println("Directorio creado");
            } catch (IOException e) {
                System.out.println("Error: El directorio no pudo ser creado "+ e);
            }
        }
    }
    
    public void newFile() {
        System.out.println("Ingrese nombre de nuevo archivo");
        String ruta = teclado.next();
        Path archivo = Paths.get(ruta);
        System.out.println("Ingrese texto a guardar en el archivo");
        String texto = teclado.next();
        
        try {
            Files.write(archivo, texto.getBytes());
        } catch (IOException e) {
            System.out.println("Error: Archivo no creado "+ e);
        }
    }
    
    public void newFile(String[][] stock){
       StringBuilder builder = new StringBuilder();
        for (int i = 0; i < stock.length; i++) {
            for (int j = 0; j < stock[i].length; j++) {
                builder.append(stock[i][j]+"");
                if (j < stock.length - 1) {
                    builder.append(", ");
                }
            }
            builder.append("\n");
        }
        try {
            BufferedWriter writer = new BufferedWriter(new FileWriter("Carpeta/stock.txt"));
            writer.write(builder.toString());
            writer.close();
        } catch (IOException e) {
            System.out.println("Error: Archivo no creado "+ e);
        }
    }
    
    public String[][] readFile(String savedDir) {
        String[][] tablero = new String[6][3];
        try {
            BufferedReader reader = new BufferedReader(new FileReader(savedDir));
            String linea = "";
            int fila = 0;
            
            while ((linea = reader.readLine()) != null) {
                String[] cols = linea.split(", ");
                int col = 0;
                for (String c: cols) { // for mejorado
                  tablero[fila][col] = c;
                  col++;
                }
                fila++;
            }
            reader.close();
        } catch (IOException e) {
            System.out.println(e);
        }
        return tablero;    
    }
    
    public void readFile() {
        System.out.println("Ingrese ruta de lectura de archivo");
        String ruta = teclado.next();
        Path archivo = Paths.get(ruta);
        String texto = "";
        
        try {
            texto = new String(Files.readAllBytes(archivo));
            System.out.println("NOMBRE - RUT - DOMICILIO:\n" + texto+ "\n");
        } catch (IOException e) {
            System.out.println("Error: El archivo no se pudo leer "+ e);
        }
    }
    
    public void copyFile() {
        System.out.println("Ingrese ruta de origen del archivo");
        String rutaOr = teclado.next(); // ruta origen
        Path archivo = Paths.get(rutaOr);
        System.out.println("Ingrese ruta de destino del archivo");
        String rutaDes = teclado.next(); // ruta destino
        Path newArchivo = Paths.get(rutaDes);
        
        try {
            Files.copy(archivo, newArchivo, StandardCopyOption.REPLACE_EXISTING);
            System.out.println("El archivo fué copiado");
        } catch (IOException e) {
            System.out.println("El archivo no se pudo copiar");
        }
    }
    
    public void delFile() {
        System.out.println("Ingrese ruta para eliminar archivo");
        String ruta = teclado.next();
        Path archivo = Paths.get(ruta);
        
        try {
            Files.deleteIfExists(archivo);
            System.out.println("El archivo fué eliminado");
        } catch (FileNotFoundException e) {
            System.out.println("\nArchivo no encotrado");
        } catch (IOException e) {
            System.out.println("\nError: El archivo no se pudo eliminar "+ e);
        }
    }
    
    public void saveData(ArrayList dataClient) {
        try {
            Files.writeString(
                    Paths.get("Archivos/clientes.txt"), //dir lista clientes
                    dataClient.toString()+ "\r\n",
                    StandardOpenOption.APPEND); //añade al final
            
        } catch (Exception e) {
            System.out.println("Error: No pudo ser añadido "+ e);
        }
    }
    
}
