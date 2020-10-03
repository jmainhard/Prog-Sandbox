package com.poop4;

import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.File;
import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Path;
import java.nio.file.Paths;
import java.nio.file.StandardCopyOption;
import java.io.FileWriter;
import java.nio.file.NoSuchFileException;
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
    
    public void newFile(String dir) {
        String ruta = "Archivos/Contratos/"+ dir + ".txt";
        Path archivo = Paths.get(ruta);
        
        try {
            Files.createFile(archivo);
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
    
    // Buscar contrato
    public void readFile() {
        System.out.println("Ingrese [ddMMyyy-rutCliente]");
        String ruta = "Archivos/Contratos/"+ teclado.next() + ".txt";
        Path archivo = Paths.get(ruta);
        String texto = "";
        
        try {
            System.out.println("    \n----< Contrato encontrado >----");
            texto = new String(Files.readAllBytes(archivo));
            System.out.println("\n"+ texto+ "\n");
        } catch (FileNotFoundException e) {
            System.out.println("Error: Ese contrato no existe :( "+ e);
        } catch (NoSuchFileException e) {
            System.out.println("Error: El archivo no se pudo leer "+ e);
        } catch (IOException e) {
            System.out.println("Error: El archivo no se pudo leer "+ e);
        }
    }
    
    // leer clientes
    public void readClientes() {
        String ruta = "Archivos/Clientes.txt";
        Path archivo = Paths.get(ruta);
        String texto = "";
        
        try {
            texto = new String(Files.readAllBytes(archivo));
            System.out.println("    \n----< Registro de clientes >----");
            System.out.println("\n   [NOMBRE, RUT, DOMICILIO]\n" + texto+ "\n");
        } catch (FileNotFoundException e) {
            System.out.println("Error: Archivo no encontrado :( "+ e);
        } catch (NoSuchFileException e) {
            System.out.println("Error: Ese archivo no existe :( "+ e);
        } catch (IOException e) {
            System.out.println("Error: El archivo no se pudo leer "+ e);
        }
    }
    
       public void readServicios() {
   // se podria poner ruta directamente en Path archivo posiblemente. TODO, test
        String ruta = "Archivos/Servicios.txt";
        Path archivo = Paths.get(ruta);
        String texto = "";
        
        try {
            System.out.println("          \n----< Servicios disponibles >----");
            texto = new String(Files.readAllBytes(archivo));
            System.out.println("\n"+ texto+ "\n");
        } catch (IOException e) {
            System.out.println("Error: Error al leer archivo "+ e);
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
    
        public void delContrato() {
        System.out.println("Ingrese nombre del contrato");
        String ruta = "Archivos/Contratos/"+ teclado.next()+ ".txt";
        Path archivo = Paths.get(ruta);
        
        try {
            Files.deleteIfExists(archivo);
            System.out.println("El archivo fué eliminado");
        } catch (FileNotFoundException e) {
            System.out.println("\nArchivo no encontrado");
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
    
    public void saveData(String rut
            , ArrayList serviciosContratados
            , int valorServicio
            , byte tiempoContrato
            , String idContrato) {
            
        try {
            String ruta = "Archivos/Contratos/"+ idContrato+ ".txt";
            Path archivo = Paths.get(ruta);
            Files.writeString(
                    archivo, //dir contrato
                    "Rut Cliente: "+ rut+ "\r\n"
                    + "Servicios Contratados: "+ serviciosContratados.toString() + "\r\n"
                    + "Valor total plan: "+ String.valueOf(valorServicio)+ "\r\n" //todo, probar total pelao int
                    + "Tiempo vigencia: "+ String.valueOf(tiempoContrato)+ "\r\n",
                    StandardOpenOption.APPEND); //lo añade al final
            
        } catch (IOException e) {
            System.out.println("Error: No pudo ser añadido "+ e);
        }
    }
    
    // second save service data, para evitar repetir info
    public void saveData(ArrayList serviciosContratados
            , int valorServicio // valor individual
            , byte tiempoContrato // tiempo en meses
            , int valorTotalS // agrega valor total servicios
            , String idContrato) { // id correspondiente 
            
        try {
            String ruta = "Archivos/Contratos/"+ idContrato+ ".txt";
            Path archivo = Paths.get(ruta);
            Files.writeString(
                    archivo, //dir contrato (id)
                    "\r\nServicios Contratados: "+ serviciosContratados.toString()+ "\r\n"
                    + "Valor servicio: "+ String.valueOf(valorServicio)+ "\r\n" //todo, probar total pelao int
                    + "Tiempo vigencia: "+ String.valueOf(tiempoContrato)+ "\r\n"
                    + "\r\nTotal servicios: "+ String.valueOf(valorTotalS)+ "\r\n",
                    StandardOpenOption.APPEND); //añade al final
            
        } catch (IOException e) {
            System.out.println("Error: No pudo ser añadido "+ e);
        }
    }
    
    // enlista todos los archivos de un directorio
    //no funcional java.lang.NullPointerException
    public void fileList() {
        // Array para almacenar direcciones de archivo
        String[] pathnames;
        String pathname = "";
        
        //instanciar File f para convertir el path entregado
        //en un nombre de path abstracto (y usar sus métodos)
        File f = new File("Carpeta/Contratos/");

        // llenar el array con los nombres de archivos (y directorios)
        pathnames = f.list();

        // para cada path en el arreglo de paths
        for (int i = 0; i < pathnames.length; i++) {
            System.out.println(pathnames[i] + "\n");
        }
    }
    
}
