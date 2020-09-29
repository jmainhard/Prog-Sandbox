package com.poop4;

import java.util.Scanner;
import java.util.ArrayList;
import java.time.*;
import java.time.format.DateTimeFormatter;

/**
 * Control práctico N4, POO clases y herencia 29-09-2020
 * 
3 servicios, máximo 2 simultáneos
contrato mensual, extensión de tiempo máxima 6 meses

parte cliente:
nombre, rut, dirección (csv)

parte contrato:
nuevoContrato (archivos separados)
date + rut + .txt
Rut, servicio(s) contratado, valor total, tiempo (array to txt)
 * 
 * @author Jorge M.
 */

public class Main {
    
    public static Cliente cliente0 = new Cliente();
    public static Contrato contrato0 = new Contrato();
    public static Servicios servicio = new Servicios();
    
    public static void menuContrato() {
        boolean seleccionado;
        boolean repetir = true;
        int opcion = -1;
        Scanner teclado = new Scanner(System.in);
        GestorArchivo ga = new GestorArchivo();
        String respuesta = "";
        String hall = "Usted seleccionó: ";
        
        do {
            repetir = true;
            do {
                seleccionado = false;
                System.out.println("\nIngrese que acción desea realizar");
                System.out.println("       ----<>----\n");
                System.out.println("1 - Crear contrato para este cliente\n");
                System.out.println("2 - Leer contrato\n");
                System.out.println("3 - Ver lista de clientes\n");
                System.out.println("4 - Eliminar contrato\n");
                System.out.println("5 - Salir\n");
                opcion = teclado.nextInt();
                
                switch (opcion) {
                    case 1: // nuevo contrato
                        System.out.println(hall+ "Crear contrato");
                        llenarContrato();
                        seleccionado = true;
                        break;
                    case 2: // leer contrato
                        System.out.println(hall+ "Leer contrato");
                        ga.readFile();
                        seleccionado = true;
                        break;
                    case 3:
                        System.out.println(hall+ "Ver lista de clientes");
                        ga.readClientes(); // leer clientes
                        seleccionado = true;
                        break;
                    case 4:
                        System.out.println(hall+ "Eliminar contrato");
                        ga.delContrato(); // Eliminar archivo (contrato)
                        seleccionado = true;
                        break;
                    case 5:
                        seleccionado = true;
                        repetir = false;
                        break;  
                    default:
                        seleccionado = false;
                }

            } while (!seleccionado);
          
            if (repetir) {
                System.out.println("\nDesea realizar nueva acción?\n");
                System.out.println("y - Si");
                System.out.println("n - No\n");
                respuesta = teclado.next();
                if (respuesta.toLowerCase().charAt(0) == 'y') {
                    repetir = true;
                } else {
                    repetir = false;
                }
            }
        } while (repetir);

    }
    
    public static void llenarContrato() {
        GestorArchivo ga = new GestorArchivo();
        Scanner teclado = new Scanner(System.in);
        byte tipoSer = -1; // tipo de servicio, soporte web, hosting..
        byte nivelSer = -1; //nivel servicio, silver, gold, platinum
        byte cantSer = -1; // cantidad de servicios
        ga.readServicios(); // mostrar servicios
        
        
        while (cantSer < 0 || cantSer > 2) {
            cantSer = -1;
            try {
                System.out.println("Cuánto servicios desea contratar (MÁX 2)");
                cantSer = teclado.nextByte(); 
            } catch (Exception e) {
                System.out.println("Error: Ingrese número válido");
                teclado.next();
            }
        }
        
        for (int i = 1; i <= cantSer+1; i++) {
            
            while (tipoSer < 0 || tipoSer > 3) {
                tipoSer = -1;
                try {
                    System.out.println("Seleccione tipo servicio "+ i);
                    System.out.println("1 - Soporte Web");
                    System.out.println("2 - Hosting");
                    System.out.println("3 - Mantención de redes");
                    tipoSer = teclado.nextByte();
                    System.out.println("tipoSer "+ i+ ": "+ tipoSer);
                } catch (Exception e) {
                    System.out.println("Error: Ingrese número válido "+ e);
                    teclado.next();
                }
            }

            while (nivelSer < 0 || nivelSer > 3) {
                nivelSer = -1;
                try {
                    System.out.println("Seleccione nivel de servicio "+ i);
                    System.out.println("1 - Silver");
                    System.out.println("2 - Gold");
                    System.out.println("3 - Platinum");
                    nivelSer = teclado.nextByte();
                    System.out.println("nivelSer "+ i+ ": "+ nivelSer);
                } catch (Exception e) {
                    System.out.println("Error: Ingrese número válido "+ e);
                    teclado.next();
                }
            }
        
        } // fin for
        // contrato0.setServicio1(servicio.getTipo(tipoSer));
        // contrato0.setS
                  
            
        }
        
        
//        cliente0.getRut();
//        contrato0.getServicio1();
//        contrato0.getServicio2();
//i. Rut del Cliente (heredado o got)
//ii. Servicios contratados (Tabla 1)  Servicios.printServicios
//                                     switch(selectServicio())
//                                              1:
//iii. Valor total del plan
//iv. Tiempo del contrato
//        } while (repetir);
    

    
    
    public static void main(String[] args) {
        String nombreCliente = "";
        String domCliente = ""; // domicilio Cliente
        int rutCliente = -1;
        String rutString = "";
        Scanner teclado = new Scanner(System.in);
        GestorArchivo ga = new GestorArchivo();
        ArrayList<String> dataClient = new ArrayList();
        String lcd = LocalDateTime
                .now()
                .format(DateTimeFormatter.ofPattern("ddMMyyyy"));
        
        System.out.println("\nIngrese Datos del cliente");
        
//        // entrada de datos cliente
//        while (nombreCliente.equals("")) {
//            System.out.println("\n< Nombre del cliente >");
//            nombreCliente = teclado.nextLine();
//        }
//        while (domCliente.equals("")) {
//            System.out.println("\n< Domicilio cliente >");
//            domCliente = teclado.nextLine();
//        }
//        while (rutCliente <= -1) { // TODO cambiar por RUT válidos}
//            rutCliente = -1;
//            try {
//                System.out.println("\n< RUT cliente > Sin puntos ni guión");
//                rutCliente = teclado.nextInt();
//                rutString = String.valueOf(rutCliente);
//            } catch (Exception e) {
//                System.out.println("\nError: rut no válido "+ e+ "\n");
//                teclado.next();
//            }
//        }
        //set atributos cliente
//        cliente0.setRut(rutString);
//        System.out.println(cliente0.getRut());
//        cliente0.setDomicilio(domCliente);
//        cliente0.setNombre(nombreCliente);
        
        //guarda los datos en la base clientes a través del ArrayList dataClient
//        dataClient.add(nombreCliente);
//        dataClient.add(rutString);
//        dataClient.add(domCliente);
//        //añade al archivo client.txt
//        ga.saveData(dataClient);
        
        //este método creará el archivo de contrato para cada cliente nuevo
//        contrato0.setIdContrato(lcd, cliente0.getRut());
        
        // genera contrato
//        do {
            menuContrato();


        System.out.println("Contrato guardado como: "+ contrato0.getIdContrato());
        

        
        
    }

}
