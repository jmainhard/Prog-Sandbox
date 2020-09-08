package com.mycompany.disenomodular;

/**
 * @author Jorge M. Control práctico 3 Traductor imprenta -> braille 08-09-2020
 * 12.50
 */
import static com.mycompany.disenomodular.Libreria.*;
import java.util.Scanner;

public class CPractico3 {
    
    //Colecciones de carácteres, usadas en la separación y traducción
    //todo, evaluar pasar char[] coleccion a char[][]
    public static char[] colMinusc = {'a', 'b', 'c', 'd', 'e', 'f', 'g', 'h',
                                      'i', 'j', 'k', 'l', 'm', 'n', 'o', 'p',
                                      'q', 'r', 's', 't', 'u', 'v', 'x', 'y',
                                      'z', 'ñ', 'w'};
    
    public static char[] colMayusc = {'A', 'B', 'C', 'D', 'E', 'F', 'G', 'H',
                                      'I', 'J', 'K', 'L', 'M', 'N', 'O', 'P',
                                      'Q', 'R', 'S', 'T', 'U', 'V', 'X', 'Y',
                                      'Z', 'N', 'W'};
    
    public static char[] colPunt = {'.', ',', ';', ':', '-', '¿',
                                    '?', '¡', '!', '"', '(', ')'};
    public static char[] colNum = {'1', '2', '3', '4', '5', '6',
                                   '6', '7', '8', '9', '0'};

    

    //13.00 Ingreso de textos
    public static void input() {
        Scanner teclado = new Scanner(System.in);
        String texto = "";
        while (texto.equals("")) {
           try {
                System.out.println("Traducción Imprenta -> Braille\n");
                texto = teclado.nextLine();
                traducirTexto(texto.toCharArray());
                printArray(texto.toCharArray());
           } catch (Exception e) { //esto (catch) no debiera pasar nunca xd
                teclado.next();
            } 
        }
    }
    
    public static int parser(char car) {
        //letra 0 1
        //punt 2
        //num 3
        //otro 4
        if (esLetra(car)) {
            return esMayusc(car); //ver documentación
        } else if (esPunt(car)) {
            return 2;
        } else if (esNum(car)) {
            return 3;
        } else {
            return -1;
        }
    }

    public static boolean esLetra(char car) {
        for (int i = 0; i < colMinusc.length; i++) {
            if (car == colMinusc[i]) {
                return true;
            }
        }
        return false;
    }
    
    public static int esMayusc(char car) {
        for (int i = 0; i < colMayusc.length; i++) {
            if (car == colMayusc[i]) {
                return 1;
            }    
        }
        return 0;
    }

    public static boolean esPunt(char car) {
        //array que funciona como colección de chars de puntuación
        //para identificar la presencia de alguno,
        //en caso contrario return false
        for (int i = 0; i < colPunt.length; i++) {
            if (car == colPunt[i]) {
                return true;
            }
        }
        return false;
    }

    public static boolean esNum(char car) {
        for (int i = 0; i < 10; i++) {
            if (car == colNum[i]) {
                return true;
            }
        }
        return false;
    }

    public static void traducirTexto(char[] arr) {
        for (int i = 0; i < arr.length; i++) {
            switch (parser(arr[i])) {
                case 0:
                    traducirMinusc(arr[i]);
                    //letra minusc
                    break;
                case 1:
                    traducirMayusc(arr[i]);
                    //letra mayusc
                    break;
                case 2:
                    traducirPunt(arr[i]);
                    //puntuación
                    break;
                case 3:
                    traducirNum(arr[i]);
                    //número
                    break;
                default:
                    System.out.println(" ");
                    //otro
            }
        }
    }
    
    //From here: QUE carácter traducir y como
    public static void traducirMinusc(char car) {
        int pos = -1;
        for (int i = 0; i < colMinusc.length; i++) {
            if (car == colMinusc[i]) {
                pos = i;
                switch (pos) {
                case 0://listo
                    char[][] a = {{'O', '°'}, {'°', '°'}, {'°', '°'}};
                    printMatrix(a);
                    break;
                case 1://listo
                    char[][] b = {{'O', '°'}, {'O', '°'}, {'°', '°'}};
                    printMatrix(b);
                    break;
                case 2://listo
                    char[][] c = {{'O', 'O'}, {'°', '°'}, {'°', '°'}};
                    printMatrix(c);
                    break;
                case 3://listo
                    char[][] d = {{'O', 'O'}, {'°', 'O'}, {'°', '°'}};
                    printMatrix(d);
                    break;
                case 4://listo
                    char[][] e = {{'O', '°'}, {'°', 'O'}, {'°', '°'}};
                    printMatrix(e);
                    break;
                case 5://listo
                    char[][] f = {{'O', 'O'}, {'O', '°'}, {'°', '°'}};
                    printMatrix(f);
                    break;
                case 6://listo
                    char[][] g = {{'O', 'O'}, {'O', 'O'}, {'°', '°'}};
                    printMatrix(g);
                    break;
                case 7://listo
                    char[][] h = {{'O', '°'}, {'O', 'O'}, {'°', '°'}};
                    printMatrix(h);
                    break;
                case 8:
                    char[][] ii = {{'O', '°'}, {'°', '°'}, {'°', '°'}};
                    printMatrix(ii);
                    break;
                case 9:
                    char[][] j = {{'O', '°'}, {'°', '°'}, {'°', '°'}};
                    printMatrix(j);
                    break;
                case 10:
                    char[][] k = {{'O', '°'}, {'°', '°'}, {'°', '°'}};
                    printMatrix(k);
                    break;
                case 11:
                    char[][] l = {{'O', '°'}, {'°', '°'}, {'°', '°'}};
                    printMatrix(l);
                    break;
                case 12:
                    char[][] m = {{'°', '°'}, {'°', '°'}, {'°', '°'}};
                    printMatrix(m);
                    break;
                case 13:
                    char[][] n = {{'°', '°'}, {'°', '°'}, {'°', '°'}};
                    printMatrix(n);
                    break;
                case 14:
                    char[][] o = {{'°', '°'}, {'°', '°'}, {'°', '°'}};
                    printMatrix(o);
                    break;
                case 15:
                    char[][] p = {{'°', '°'}, {'°', '°'}, {'°', '°'}};
                    printMatrix(p);
                    break;
                case 16:
                    char[][] q = {{'°', '°'}, {'°', '°'}, {'°', '°'}};
                    printMatrix(q);
                    break;
                case 17:
                    break;
                case 18:
                    break;
                case 19:
                    break;
                case 20:
                    break;
                case 21:
                    break;
                case 22:
                    break;
                case 23:
                    break;
                case 24:
                    break;
                case 25:
                    break;
                case 26:
                    break;
                case 27:
                    break;
                default:
                }
            
            }
        }
    }
    
    public static void traducirMayusc(char car) {
        for (int i = 0; i < colMayusc.length; i++) {
//            buscarTraduccion(1)
        }
    }
    
    public static void traducirPunt(char car) {
        for (int i = 0; i < colPunt.length; i++) {
//            buscarTraduccion(2)
        }
    }
    
    public static void traducirNum(char car) {
        for (int i = 0; i < colMinusc.length; i++) {
//            buscarTraduccion(3)
        }
    }

    public static void main(String[] args) {
        char a = 'a';
        char b = '?';
        char c = '8';
        char d = 'A';
        
        input();


    }

}
