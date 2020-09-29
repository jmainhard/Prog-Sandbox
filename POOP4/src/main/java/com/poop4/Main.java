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
    
    public static void menu() {
        boolean seleccionado = false;
        boolean repetir = true;
        int opcion = -1;
        Scanner teclado = new Scanner(System.in);
        GestorArchivo ga = new GestorArchivo();
        String respuesta = "";
        
        do {
            do {
                seleccionado = false;
                System.out.println("Ingrese que desea realizar");
                System.out.println("       ----<>----\n");
                System.out.println("1 - Crear directorio\n");
                System.out.println("2 - Crear archivo\n");
                System.out.println("3 - Leer archivo\n");
                System.out.println("4 - Copiar archivo\n");
                System.out.println("5 - Eliminar archivo\n");
                System.out.println("6 - Salir\n");

                opcion = teclado.nextInt();

                switch (opcion) {
                    case 1: // nuevo dir
                        ga.newDir();
                        seleccionado = true;
                        break;
                    case 2: // new file
                        ga.newFile();
                        seleccionado = true;
                        break;
                    case 3:
                        ga.readFile(); // leer archivo
                        seleccionado = true;
                        break;
                    case 4:
                        ga.copyFile(); // copiar archivo
                        seleccionado = true;
                        break;
                    case 5:
                        ga.delFile(); // delete file
                        seleccionado = true;
                        break;
                    case 6:
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
    
    public static void main(String[] args) {
        String nombreCliente = "";
        String domCliente = ""; // domicilio Cliente
        int rutCliente = -1;
        String rutString = "";
        Scanner teclado = new Scanner(System.in);
        GestorArchivo ga = new GestorArchivo();
        ArrayList<String> dataClient = new ArrayList();
        Cliente cliente0 = new Cliente();
        Contrato contrato0 = new Contrato();
        String lcd = LocalDateTime
                .now()
                .format(DateTimeFormatter.ofPattern("ddMMyyyy"));
        
        System.out.println("\nIngrese Datos del cliente");
        
        // entrada de datos cliente
        while (nombreCliente.equals("")) {
            System.out.println("\n< Nombre del cliente >");
            nombreCliente = teclado.nextLine();
        }
        while (domCliente.equals("")) {
            System.out.println("\n< Domicilio cliente >");
            domCliente = teclado.nextLine();
        }
        while (rutCliente <= -1) { // TODO cambiar por RUT válidos}
            rutCliente = -1;
            try {
                System.out.println("\n< RUT cliente >");
                rutCliente = teclado.nextInt();
                rutString = String.valueOf(rutCliente);
            } catch (Exception e) {
                System.out.println("\nError: rut no válido "+ e+ "\n");
                teclado.next();
            }
        }
        //set atributos cliente
        cliente0.setRut(rutString);
        System.out.println(cliente0.getRut());
        cliente0.setDomicilio(domCliente);
        cliente0.setNombre(nombreCliente);
        
        //guarda los datos en la base clientes a través del ArrayList dataClient
        dataClient.add(nombreCliente);
        dataClient.add(rutString);
        dataClient.add(domCliente);
        //añade al archivo client.txt
        ga.saveData(dataClient);
        
        contrato0.setIdContrato(lcd, cliente0.getRut());
        
        // genera contrato
        do {
            System.out.println("\n");
//i. Rut del Cliente (heredado o got)
//ii. Servicios contratados (Tabla 1)  Servicios.printServicios
//                                     selectServicio()
//iii. Valor total del plan
//iv. Tiempo del contrato
//        } while (repetir);
        
        
        System.out.println("Contrato guardado como: "+ contrato0.getIdContrato());
        
//        menu();

        
        
    }

}
