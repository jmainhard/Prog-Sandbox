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
                                      'i', 'j', 'k', 'l', 'm', 'n', 'ñ', 'o',
                                      'p', 'q', 'r', 's', 't', 'u', 'v', 'w', 
                                      'x', 'y', 'z', 'á', 'é', 'í', 'ó', 'ú',
                                     };
    
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
        char[][] traduccion = new char[3][2];
        for (int i = 0; i < colMinusc.length; i++) {
            if (car == colMinusc[i]) {
                pos = i;
                traduccion = traduccionMinusc(i);
                System.out.println(colMinusc[i]);
                printMatrix(traduccion);
                }
            }
        }
    
    //alfabeto de letras minúsculas en braille
    public static char[][] traduccionMinusc(int pos) {
        char[][] traduccion = new char[3][2];
                switch (pos) {
                case 0:
                    char[][] a  = {{'O', '°'}, {'°', '°'}, {'°', '°'}};
                    traduccion = a;
                    break;
                case 1:
                    char[][] b = {{'O', '°'}, {'O', '°'}, {'°', '°'}};
                    traduccion = b;
                    break;
                case 2:
                    char[][] c = {{'O', 'O'}, {'°', '°'}, {'°', '°'}};
                    traduccion = c;
                    break;
                case 3://listo
                    char[][] d = {{'O', 'O'}, {'°', 'O'}, {'°', '°'}};
                    traduccion = d;
                    break;
                case 4://listo
                    char[][] e = {{'O', '°'}, {'°', 'O'}, {'°', '°'}};
                    traduccion = e;
                    break;
                case 5://listo
                    char[][] f = {{'O', 'O'}, {'O', '°'}, {'°', '°'}};
                    traduccion = f;
                    break;
                case 6://listo
                    char[][] g = {{'O', 'O'}, {'O', 'O'}, {'°', '°'}};
                    traduccion = g;
                    break;
                case 7://listo
                    char[][] h = {{'O', '°'}, {'O', 'O'}, {'°', '°'}};
                    traduccion = h;
                    break;
                case 8:
                    char[][] ii = {{'O', '°'}, {'°', '°'}, {'°', '°'}};
                    traduccion = ii;
                    break;
                case 9:
                    char[][] j = {{'O', '°'}, {'°', '°'}, {'°', '°'}};
                    traduccion = j;
                    break;
                case 10:
                    char[][] k = {{'O', '°'}, {'°', '°'}, {'°', '°'}};
                    traduccion = k;
                    break;
                case 11:
                    char[][] l = {{'O', '°'}, {'°', '°'}, {'°', '°'}};
                    traduccion = l;
                    break;
                case 12:
                    char[][] m = {{'°', '°'}, {'°', '°'}, {'°', '°'}};
                    traduccion = m;
                    break;
                case 13:
                    char[][] n = {{'°', '°'}, {'°', '°'}, {'°', '°'}};
                    traduccion = n;
                    break;
                case 14:
                    char[][] ñ = {{'°', '°'}, {'°', '°'}, {'°', '°'}};
                    traduccion = ñ;
                    break;
                case 15:
                    char[][] o = {{'°', '°'}, {'°', '°'}, {'°', '°'}};
                    traduccion = o;
                    break;    
                case 16:
                    char[][] p = {{'°', '°'}, {'°', '°'}, {'°', '°'}};
                    traduccion = p;
                    break;
                case 17:
                    char[][] q = {{'°', '°'}, {'°', '°'}, {'°', '°'}};
                    traduccion = q;
                    break;
                case 18:
                    char[][] r = {{'°', '°'}, {'°', '°'}, {'°', '°'}};
                    traduccion = r;
                    break;
                case 19:
                    char[][] s = {{'°', '°'}, {'°', '°'}, {'°', '°'}};
                    traduccion = s;
                    break;
                case 20:
                    char[][] t = {{'°', '°'}, {'°', '°'}, {'°', '°'}};
                    traduccion = t;
                    break;
                case 21:
                    char[][] u = {{'°', '°'}, {'°', '°'}, {'°', '°'}};
                    traduccion = u;
                    break;
                case 22:
                    char[][] v = {{'°', '°'}, {'°', '°'}, {'°', '°'}};
                    traduccion = v;
                    break;
                case 23:
                    char[][] w = {{'°', '°'}, {'°', '°'}, {'°', '°'}};
                    traduccion = w;
                    break;
                case 24:
                    char[][] x = {{'°', '°'}, {'°', '°'}, {'°', '°'}};
                    traduccion = x;
                    break;
                case 25:
                    char[][] y = {{'°', '°'}, {'°', '°'}, {'°', '°'}};
                    traduccion = y;
                    break;
                case 26:
                    char[][] z = {{'°', '°'}, {'°', '°'}, {'°', '°'}};
                    traduccion = z;
                    break;
                case 27:
                    char[][] aa = {{'°', '°'}, {'°', '°'}, {'°', '°'}};
                    traduccion = aa;
                    break;
                case 28:
                    char[][] ee = {{'°', '°'}, {'°', '°'}, {'°', '°'}};
                    traduccion = ee;
                    break;
                case 29:
                    char[][] iii = {{'°', '°'}, {'°', '°'}, {'°', '°'}};
                    traduccion = iii;
                    break;
                case 30:
                    char[][] oo = {{'°', '°'}, {'°', '°'}, {'°', '°'}};
                    traduccion = oo;
                    break;
                case 31:
                    char[][] uu = {{'°', '°'}, {'°', '°'}, {'°', '°'}};
                    traduccion = uu;
                    break; 
                case 32:
                    char[][] uuu = {{'°', '°'}, {'°', '°'}, {'°', '°'}};
                    traduccion = uuu;
                    break;    
        }
                return traduccion;
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
