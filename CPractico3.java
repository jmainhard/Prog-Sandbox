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
                                      'x', 'y', 'z', 'á', 'é', 'í', 'ó', 'ú',};
    
    public static char[] colMayusc = {'A', 'B', 'C', 'D', 'E', 'F', 'G', 'H',
                                      'I', 'J', 'K', 'L', 'M', 'N', 'Ñ', 'O',
                                      'P', 'Q', 'R', 'S', 'T', 'U', 'V', 'W',
                                      'X', 'Y', 'Z', 'Á', 'É', 'Í', 'Ó', 'Ú'};
    
    public static char[] colPunt = {'.', ',', ';', ':', '-', '¿',
                                    '?', '¡', '!', '"', '(', ')', '\''};
    
    public static char[] colNum = {'0', '1', '2', '3', '4', '5',
                                    '6', '7', '8', '9'};

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
                    System.out.println("es mayusc");
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
                    System.out.println(" (Espacio en blanco de "+arr[i]+ ")");
                    //otro
            }
        }
    }
    
    //From here: QUE carácter traducir y como
    public static void traducirMinusc(char car) {
        char[][] traduccion = new char[3][2];
        for (int i = 0; i < colMinusc.length; i++) {
            if (car == colMinusc[i]) {
                traduccion = alfabetoMinusc(i);
                System.out.println(colMinusc[i]);
                printMatrix(traduccion);
                }
            }
        }
    
    //alfabeto de letras minúsculas en braille
    public static char[][] alfabetoMinusc(int pos) {
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
        char[][] traduccion = new char[3][2];
        char[][] prefMayusc = {{'°', 'O'}, {'°', '°'}, {'°', 'O'}};
        for (int i = 0; i < colMayusc.length; i++) {
            if (car == colMayusc[i]) {
                traduccion = alfabetoMinusc(i);
                System.out.println(colMayusc[i]);
                printMatrix(prefMayusc);
                printMatrix(traduccion);
                }
            }
    }
    
    public static void traducirPunt(char car) {
        char[][] traduccion = new char[3][2];
        for (int i = 0; i < colPunt.length; i++) {
            if (car == colPunt[i]) {
                traduccion = alfabetoPunt(i);
                System.out.println(colPunt[i]);
                printMatrix(traduccion);
                }
            }
    }
    
    public static char[][] alfabetoPunt(int pos) {
        char[][] traduccion = new char[3][2];
        switch (pos) {
            case 0:
                char[][] punto  = {{'°', '°'}, {'°', '°'}, {'°', '°'}};
                traduccion = punto;
                break;
            case 1:
                char[][] coma  = {{'°', '°'}, {'°', '°'}, {'°', '°'}};
                traduccion = coma;
                break;
            case 2:
                char[][] puncoma  = {{'°', '°'}, {'°', '°'}, {'°', '°'}};
                traduccion = puncoma;
                break;
            case 3:
                char[][] dpuntos  = {{'°', '°'}, {'°', '°'}, {'°', '°'}};
                traduccion = dpuntos;
                break;
            case 4:
                char[][] guion  = {{'°', '°'}, {'°', '°'}, {'°', '°'}};
                traduccion = guion;
                break;
            case 5:
                char[][] interr1  = {{'°', '°'}, {'°', '°'}, {'°', '°'}};
                traduccion = interr1;
                break;
            case 6:
                char[][] interr2  = {{'°', '°'}, {'°', '°'}, {'°', '°'}};
                traduccion = interr2;
                break;
            case 7:
                char[][] exc1  = {{'°', '°'}, {'°', '°'}, {'°', '°'}};
                traduccion = exc1;
                break;
            case 8:
                char[][] exc2  = {{'°', '°'}, {'°', '°'}, {'°', '°'}};
                traduccion = exc2;
                break;
            case 9:
                char[][] comillas  = {{'°', '°'}, {'°', '°'}, {'°', '°'}};
                traduccion = comillas;
                break;
            case 10:
                char[][] parentesis1  = {{'°', '°'}, {'°', '°'}, {'°', '°'}};
                traduccion = parentesis1;
                break;
            case 11:
                char[][] parentesis2  = {{'°', '°'}, {'°', '°'}, {'°', '°'}};
                traduccion = parentesis2;
                break;
            case 12:
                char[][] apost  = {{'°', '°'}, {'°', '°'}, {'°', '°'}};
                traduccion = apost;
                break;      
        }
        return traduccion;
    }
    
    public static void traducirNum(char car) {
        char[][] prefijoNum = {{'°', 'O'}, {'°', 'O'}, {'O', 'O'}};
        char[][] traduccion = new char[3][2];
        for (int i = 0; i < colNum.length; i++) {
            if (car == colNum[i]) {
                traduccion = alfabetoNum(i);
                System.out.println(colNum[i]);
                printMatrix(prefijoNum);
                printMatrix(traduccion);
            }
        }
    }
    
    public static char[][] alfabetoNum(int pos) {
        char[][] traduccion = new char[3][2];
        switch (pos) {
            case 0:
                char[][] cero  = {{'°', '°'}, {'°', '°'}, {'°', '°'}};
                traduccion = cero;
                break;
            case 1:
                char[][] uno  = {{'°', '°'}, {'°', '°'}, {'°', '°'}};
                traduccion = uno;
                break;
            case 2:
                char[][] dos  = {{'°', '°'}, {'°', '°'}, {'°', '°'}};
                traduccion = dos;
                break;
            case 3:
                char[][] tres  = {{'°', '°'}, {'°', '°'}, {'°', '°'}};
                traduccion = tres;
                break;
            case 4:
                char[][] cuatro  = {{'°', '°'}, {'°', '°'}, {'°', '°'}};
                traduccion = cuatro;
                break;
            case 5:
                char[][] cinco  = {{'°', '°'}, {'°', '°'}, {'°', '°'}};
                traduccion = cinco;
                break;
            case 6:
                char[][] seis  = {{'°', '°'}, {'°', '°'}, {'°', '°'}};
                traduccion = seis;
                break;
            case 7:
                char[][] siete  = {{'°', '°'}, {'°', '°'}, {'°', '°'}};
                traduccion = siete;
                break;
            case 8:
                char[][] ocho  = {{'°', '°'}, {'°', '°'}, {'°', '°'}};
                traduccion = ocho;
                break;
            case 9:
                char[][] nueve  = {{'°', '°'}, {'°', '°'}, {'°', '°'}};
                traduccion = nueve;
                break;    
        }
        return traduccion;
    }

    public static void main(String[] args) {
        char a = 'A';
        char b = '?';
        char c = '8';
        char d = 'A';
        
        input();
        


    }

}
