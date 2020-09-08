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

    public static int parser(char car) {
        //letra 0 1
        //punt 2
        //num 3
        //otro 4
        if (esLetra(car)) {
            return mayuscParser(car); //ver documentación
        } else if (esPunt(car)) {
            return 2;
        } else if (esNum(car)) {
            return 3;
        } else {
            return 4;
        }
    }

    public static boolean esLetra(char car) {
        //todo pasar char[] -> char[][]
        char[] coleccion = {'a', 'b', 'c', 'd', 'e', 'f', 'g', 'h',
                            'i', 'j', 'k', 'l', 'm', 'n', 'o', 'p',
                            'q', 'r', 's', 't', 'u', 'v', 'x', 'y',
                            'z', 'ñ', 'w'};
        
        for (int i = 0; i < coleccion.length; i++) {
            if (car == coleccion[i]) {
                return true;
            }
        }
        return false;
    }
    
    public static int mayuscParser(char car) {
        char[] coleccion = {'A', 'B', 'C', 'D', 'E', 'F', 'G', 'H',
                            'I', 'J', 'K', 'L', 'M', 'N', 'O', 'P',
                            'Q', 'R', 'S', 'T', 'U', 'V', 'X', 'Y',
                            'Z', 'N', 'W'};

        for (int i = 0; i < coleccion.length; i++) {
            if (car == coleccion[i]) {
                return 1;
            }    
        }
        return 0;
    }

    public static boolean esPunt(char car) {
        //array que funciona como colección de chars de puntuación
        //para identificar la presencia de alguno,
        //en caso contrario return false
        
        char[] coleccion = {'.', ',', ';', ':', '-', '¿',
                            '?', '¡', '!', '"', '(', ')'};
        
        for (int i = 0; i < coleccion.length; i++) {
            if (car == coleccion[i]) {
                return true;
            }
        }
        return false;
    }

    public static boolean esNum(char car) {
        char[] coleccion = {'1', '2', '3', '4', '5', '6',
                            '6', '7', '8', '9', '0'};
        for (int i = 0; i < 10; i++) {
            if (car == coleccion[i]) {
                return true;
            }
        }
        return false;
    }

    public static void traducir(char[] arr) {
        Libreria.printArray(arr);
        for (int i = 0; i < arr.length; i++) {
            switch (parser(arr[i])) {
                case 0:
                    
                    break;
                default:
                    throw new AssertionError();
            }
        }
    }

    public static void main(String[] args) {
        char a = 'a';
        char b = '?';
        char c = '8';
        char d = 'A';
        System.out.println(a);
        System.out.println("Es letra: "+ esLetra(a));
        System.out.println("Es punt: "+ esPunt(a));
        System.out.println("Es num: "+ esNum(a));
        
        System.out.println(b);
        System.out.println("Es letra: "+ esLetra(b));
        System.out.println("Es punt: "+ esPunt(b));
        System.out.println("Es num: "+ esNum(b));
        
        System.out.println(c);
        System.out.println("Es letra: "+ esLetra(c));
        System.out.println("Es punt: "+ esPunt(c));
        System.out.println("Es num: "+ esNum(c));
        
        System.out.println(mayuscParser(a));
        System.out.println(mayuscParser(d));
    }

}
