package com.mycompany.disenomodular;

/**
 * @author Jorge M. Control práctico 3 Traductor imprenta -> braille 08-09-2020
 * 12.50
 */
import static com.mycompany.disenomodular.Libreria.*;
import java.util.Scanner;

public class CPractico3 {

    public static char[] separar(String texto) {
        char[] asd = new char[texto.length()];
        return asd;
    }

    //13.00 Ingreso de textos
    public static void input() {
        Scanner teclado = new Scanner(System.in);
        String texto;

        try {
            System.out.println("Traducción Imprenta -> Braille\n");
            texto = teclado.nextLine();
            System.out.println(texto);
            traducir(separar(texto));
        } catch (Exception e) {
            teclado.next();
        }

    }

    public static int parser(char i) {
        //letra 0 1
        //punt 2
        //num 3
        //otro 4
        if (esLetra(i)) {
            return mayuscParser(i); //ver documentación
        } else if (esPunt(i)) {
            return 2;
        } else if (esNum(i)) {
            return 3;
        } else {
            return 4;
        }
    }

    public static boolean esLetra(char i) {
        if (!esPunt && !esNum) {
            return true;
        } //TODO incluir caso de 'otro'
        return true;
    }
    
    public static int mayuscParser(char i) {
        return 1;
    }

    public static boolean esPunt(char i) {
        //todo, tener una matriz de chars de puntuación
        //para identificar la presencia de alguno,
        //en caso contrario return false
        
        if (i == '.' || i == ',') {
            
        } if (i == ';' || i == ':') {
            
        } if (i == '-' || i == '¿') {
            
        } if (i == '.' || i == ',') {
            
        } if (i == '.' || i == ',') {
            
        } if (i == '.' || i == ',') {
            
        }
        return true;
    }

    public static boolean esNum(char i) {
        return true;
    }

    public static void traducir(char[] arr) {
        Libreria.printArray(arr);
        for (int i = 0; i < arr.length; i++) {
            switch (parser(i)) {
                case 0:
                    
                    break;
                default:
                    throw new AssertionError();
            }
        }
    }

    public static void main(String[] args) {
        input();
    }

}
