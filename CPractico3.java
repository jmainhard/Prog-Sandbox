package com.mycompany.disenomodular;

/**
 * @author Jorge M. Control práctico 3 Traductor imprenta -> braille 08-09-2020
 * 12.50
 */
import static com.mycompany.disenomodular.Libreria.*;//printMatrix y printArray
import java.util.Scanner;

public class CPractico3 {
    
    //Colecciones de carácteres, usadas en la separación y traducción
    //todo, evaluar pasar char[] coleccion a char[][]
    public static char[] colMinusc = {'a', 'b', 'c', 'd', 'e', 'f', 'g', 'h',
                                      'i', 'j', 'k', 'l', 'm', 'n', 'ñ', 'o',
                                      'p', 'q', 'r', 's', 't', 'u', 'v', 'w', 
                                      'x', 'y', 'z', 'á', 'é', 'í', 'ó', 'ú',};
    
//    public static char[] colMayusc = {'A', 'B', 'C', 'D', 'E', 'F', 'G', 'H',
//                                      'I', 'J', 'K', 'L', 'M', 'N', 'Ñ', 'O',
//  Alto ahorro de memoria              'P', 'Q', 'R', 'S', 'T', 'U', 'V', 'W',
//           (char.toUppercase)         'X', 'Y', 'Z', 'Á', 'É', 'Í', 'Ó', 'Ú'};
    
    public static char[] colPunt = {'.', ',', ';', ':', '-', '¿',
                                    '?', '¡', '!', '"', '(', ')', '\''};
    
    public static char[] colNum = {'0', '1', '2', '3', '4', '5',
                                    '6', '7', '8', '9'};

    //Función principal, validador de entrada
    public static void input() {
        Scanner teclado = new Scanner(System.in);
        String texto = "";
        while (texto.equals("")) {
           try {
                System.out.println("Traducción Imprenta a Braille\n");
                texto = teclado.nextLine();
                traducirTexto(texto.toCharArray());
                printArray(texto.toCharArray());
           } catch (Exception e) { //esto (catch) no debiera pasar nunca xd
                teclado.next();
            } 
        }
    }
    
    public static int parser(char car) {
        //letra minusc 0 
        //      mayusc 1
        //      punt   2
        //      num    3
        //      otro   4
        if (esLetra(car)) {
            if (Character.isUpperCase(car)) {
                return 1;
            } else {
                return 0;
            }
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
            if (car == colMinusc[i] ||
                car == Character.toUpperCase(colMinusc[i])) {
                return true;
            }
        } 
        return false;
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
                    //caso minusc
                    break;
                case 1:
                    traducirMayusc(arr[i]);
                    //caso mayusc
                    break;
                case 2:
                    traducirPunt(arr[i]);
                    //caso puntuación
                    break;
                case 3:
                    traducirNum(arr[i]);
                    //caso número
                    break;
                default:
                    System.out.println(" -> (Espacio"+ arr[i]+ ")\n");
                    //otro
            }
        }
    }
    
    //alfabeto de letras minúsculas en braille (como)
    public static char[][] alfabetoMinusc(int pos) {
        char[][] traduccion = new char[3][2];
        switch (pos) {
            case 0:
                char[][] a  = {{'O', '.'}, {'.', '.'}, {'.', '.'}};
                traduccion = a;
                break;
            case 1:
                char[][] b = {{'O', '.'}, {'O', '.'}, {'.', '.'}};
                traduccion = b;
                break;
            case 2:
                char[][] c = {{'O', 'O'}, {'.', '.'}, {'.', '.'}};
                traduccion = c;
                break;
            case 3://listo
                char[][] d = {{'O', 'O'}, {'.', 'O'}, {'.', '.'}};
                traduccion = d;
                break;
            case 4://listo
                char[][] e = {{'O', '.'}, {'.', 'O'}, {'.', '.'}};
                traduccion = e;
                break;
            case 5://listo
                char[][] f = {{'O', 'O'}, {'O', '.'}, {'.', '.'}};
                traduccion = f;
                break;
            case 6://listo
                char[][] g = {{'O', 'O'}, {'O', 'O'}, {'.', '.'}};
                traduccion = g;
                break;
            case 7://listo
                char[][] h = {{'O', '.'}, {'O', 'O'}, {'.', '.'}};
                traduccion = h;
                break;
            case 8:
                char[][] ii = {{'.', 'O'}, {'O', '.'}, {'.', '.'}};
                traduccion = ii;
                break;
            case 9:
                char[][] j = {{'.', 'O'}, {'O', 'O'}, {'.', '.'}};
                traduccion = j;
                break;
            case 10:
                char[][] k = {{'O', '.'}, {'.', '.'}, {'O', '.'}};
                traduccion = k;
                break;
            case 11:
                char[][] l = {{'O', '.'}, {'O', '.'}, {'O', '.'}};
                traduccion = l;
                break;
            case 12:
                char[][] m = {{'O', 'O'}, {'.', '.'}, {'O', '.'}};
                traduccion = m;
                break;
            case 13:
                char[][] n = {{'O', 'O'}, {'.', 'O'}, {'O', '.'}};
                traduccion = n;
                break;
            case 14:
                char[][] ñ = {{'O', 'O'}, {'O', 'O'}, {'.', 'O'}};
                traduccion = ñ;
                break;
            case 15:
                char[][] o = {{'O', '.'}, {'.', 'O'}, {'O', '.'}};
                traduccion = o;
                break;    
            case 16:
                char[][] p = {{'O', 'O'}, {'O', '.'}, {'O', '.'}};
                traduccion = p;
                break;
            case 17:
                char[][] q = {{'O', 'O'}, {'O', 'O'}, {'O', '.'}};
                traduccion = q;
                break;
            case 18:
                char[][] r = {{'O', '.'}, {'O', 'O'}, {'O', '.'}};
                traduccion = r;
                break;
            case 19:
                char[][] s = {{'.', 'O'}, {'O', '.'}, {'O', '.'}};
                traduccion = s;
                break;
            case 20:
                char[][] t = {{'.', 'O'}, {'O', 'O'}, {'O', '.'}};
                traduccion = t;
                break;
            case 21:
                char[][] u = {{'O', '.'}, {'.', '.'}, {'O', 'O'}};
                traduccion = u;
                break;
            case 22:
                char[][] v = {{'O', '.'}, {'O', '.'}, {'O', 'O'}};
                traduccion = v;
                break;
            case 23:
                char[][] w = {{'.', 'O'}, {'O', 'O'}, {'.', 'O'}};
                traduccion = w;
                break;
            case 24:
                char[][] x = {{'O', 'O'}, {'.', '.'}, {'O', 'O'}};
                traduccion = x;
                break;
            case 25:
                char[][] y = {{'O', 'O'}, {'.', 'O'}, {'O', 'O'}};
                traduccion = y;
                break;
            case 26:
                char[][] z = {{'O', '.'}, {'.', 'O'}, {'O', 'O'}};
                traduccion = z;
                break;
            case 27:
                char[][] aa = {{'O', '.'}, {'O', 'O'}, {'O', 'O'}};
                traduccion = aa;
                break;
            case 28:
                char[][] ee = {{'.', 'O'}, {'O', '.'}, {'O', 'O'}};
                traduccion = ee;
                break;
            case 29:
                char[][] iii = {{'.', 'O'}, {'.', '.'}, {'O', '.'}};
                traduccion = iii;
                break;
            case 30:
                char[][] oo = {{'.', 'O'}, {'.', '.'}, {'O', 'O'}};
                traduccion = oo;
                break;
            case 31:
                char[][] uu = {{'.', 'O'}, {'O', 'O'}, {'O', 'O'}};
                traduccion = uu;
                break; 
            case 32:
                char[][] uuu = {{'O', '.'}, {'O', 'O'}, {'.', 'O'}};
                traduccion = uuu;
                break;    
        }
                return traduccion;
    }
    
    public static char[][] alfabetoPunt(int pos) {
        char[][] traduccion = new char[3][2];
        switch (pos) {
            case 0:
                char[][] punto  = {{'.', '.'}, {'.', '.'}, {'.', '.'}};
                traduccion = punto;
                break;
            case 1:
                char[][] coma  = {{'.', '.'}, {'.', '.'}, {'.', '.'}};
                traduccion = coma;
                break;
            case 2:
                char[][] puncoma  = {{'.', '.'}, {'.', '.'}, {'.', '.'}};
                traduccion = puncoma;
                break;
            case 3:
                char[][] dpuntos  = {{'.', '.'}, {'.', '.'}, {'.', '.'}};
                traduccion = dpuntos;
                break;
            case 4:
                char[][] guion  = {{'.', '.'}, {'.', '.'}, {'.', '.'}};
                traduccion = guion;
                break;
            case 5:
                char[][] interr1  = {{'.', '.'}, {'.', '.'}, {'.', '.'}};
                traduccion = interr1;
                break;
            case 6:
                char[][] interr2  = {{'.', '.'}, {'.', '.'}, {'.', '.'}};
                traduccion = interr2;
                break;
            case 7:
                char[][] exc1  = {{'.', '.'}, {'.', '.'}, {'.', '.'}};
                traduccion = exc1;
                break;
            case 8:
                char[][] exc2  = {{'.', '.'}, {'.', '.'}, {'.', '.'}};
                traduccion = exc2;
                break;
            case 9:
                char[][] comillas  = {{'.', '.'}, {'.', '.'}, {'.', '.'}};
                traduccion = comillas;
                break;
            case 10:
                char[][] parentesis1  = {{'.', '.'}, {'.', '.'}, {'.', '.'}};
                traduccion = parentesis1;
                break;
            case 11:
                char[][] parentesis2  = {{'.', '.'}, {'.', '.'}, {'.', '.'}};
                traduccion = parentesis2;
                break;
            case 12:
                char[][] apost  = {{'.', '.'}, {'.', '.'}, {'.', '.'}};
                traduccion = apost;
                break;      
        }
        return traduccion;
    }
    
    public static char[][] alfabetoNum(int pos) {
        char[][] traduccion = new char[3][2];
        switch (pos) {
            case 0:
                char[][] cero  = {{'.', '.'}, {'.', '.'}, {'.', '.'}};
                traduccion = cero;
                break;
            case 1:
                char[][] uno  = {{'.', '.'}, {'.', '.'}, {'.', '.'}};
                traduccion = uno;
                break;
            case 2:
                char[][] dos  = {{'.', '.'}, {'.', '.'}, {'.', '.'}};
                traduccion = dos;
                break;
            case 3:
                char[][] tres  = {{'.', '.'}, {'.', '.'}, {'.', '.'}};
                traduccion = tres;
                break;
            case 4:
                char[][] cuatro  = {{'.', '.'}, {'.', '.'}, {'.', '.'}};
                traduccion = cuatro;
                break;
            case 5:
                char[][] cinco  = {{'.', '.'}, {'.', '.'}, {'.', '.'}};
                traduccion = cinco;
                break;
            case 6:
                char[][] seis  = {{'.', '.'}, {'.', '.'}, {'.', '.'}};
                traduccion = seis;
                break;
            case 7:
                char[][] siete  = {{'.', '.'}, {'.', '.'}, {'.', '.'}};
                traduccion = siete;
                break;
            case 8:
                char[][] ocho  = {{'.', '.'}, {'.', '.'}, {'.', '.'}};
                traduccion = ocho;
                break;
            case 9:
                char[][] nueve  = {{'.', '.'}, {'.', '.'}, {'.', '.'}};
                traduccion = nueve;
                break;    
        }
        return traduccion;
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
    
    public static void traducirMayusc(char car) {
        char[][] traduccion = new char[3][2];
        char[][] prefMayusc = {{'.', 'O'}, {'.', '.'}, {'.', 'O'}};
        char lowerCar = Character.toLowerCase(car);
        for (int i = 0; i < colMinusc.length; i++) {
            if (lowerCar == colMinusc[i]) {
                traduccion = alfabetoMinusc(i);
                System.out.println(car);
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
    
    public static void traducirNum(char car) {
        char[][] prefijoNum = {{'.', 'O'}, {'.', 'O'}, {'O', 'O'}};
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
    
    public static void main(String[] args) {
        char a = 'A';
        char b = '?';
        char c = '8';
        char d = 'A';
        
        input();
        


    }

}
