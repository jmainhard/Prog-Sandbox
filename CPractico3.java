package com.mycompany.disenomodular;

/**
 * @author Jorge M. Control práctico 3 Traductor imprenta -> braille 08-09-2020
 * 12.50
 */
import static com.mycompany.disenomodular.Libreria.printMatrix;//printMatrix
import java.util.Scanner;

public class CPractico3 {
    //Declaración de colecciones (de carácteres)
    //Usados en la separación y traducción del texto
    //todo, evaluar pasar char[] coleccion a char[][]
    public static char[] colMinusc = {'a', 'b', 'c', 'd', 'e', 'f', 'g', 'h',
                                      'i', 'j', 'k', 'l', 'm', 'n', 'ñ', 'o',
                                      'p', 'q', 'r', 's', 't', 'u', 'v', 'w', 
                                      'x', 'y', 'z', 'á', 'é', 'í', 'ó', 'ú',
                                      'ü'};
    
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
                System.out.println("Traducción de Imprenta a Braille\n");
                System.out.println("        Ingrese texto\n"+ 
                                   "         ----< >----");
                texto = teclado.nextLine();
                traducirTexto(texto.toCharArray());
           } catch (Exception e) { //esto (catch) no debiera pasar nunca xd
                teclado.next();
            } 
        }
    }
    
    /**
     * Analizador sintáctico de los carácteres
     * @param car Carácter individual del texto
     * @return 0, 1, 2, 3 o default -1
     */
    
    public static int parser(char car) {
        //letra minusc 0 
        //      mayusc 1
        //      punt   2
        //      num    3
        //      otro   -1
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
    
    /**
     * Retorna bool si es (o no) letra, no importan mayusc ni minusc
     * @param car Carácter individual del texto
     * @return boolean
     */
    
    public static boolean esLetra(char car) {
        for (int i = 0; i < colMinusc.length; i++) {
            if (car == colMinusc[i] ||
                car == Character.toUpperCase(colMinusc[i])) {
                return true;
            }
        } 
        return false;
    }
    
    /**
     * Retorna bool si es (o no) signo de puntuación
     * @param car Carácter individual del texto
     * @return boolean
     */
    
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
    
    /**
     * Retorna bool si es (o no) número
     * @param car Carácter individual del texto
     * @return boolean
     */
    
    public static boolean esNum(char car) {
        for (int i = 0; i < 10; i++) {
            if (car == colNum[i]) {
                return true;
            }
        }
        return false;
    }
    
    /**
     * Función de traducción, depende de los valores que tome parser(char car) 
     * @param arr Texto ingresado por teclado
     */
    
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
                    System.out.println(" (Espacio "+ arr[i]+ ")\n");
                    //otro
            }
        }
    }
    
    //From here: Alfabetos de carácteres
    /**
     * Retorna el arreglo (2d) de la traducción que corresponda según 
     * la posición del carácter relativo a su colección
     * @param pos Posición del char relativa a la colección de carácteres
     * @return Array de dos dimensiones en braille
     */
    
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
            case 33:
                char[][] ucremilla = {{'O', '.'}, {'O', 'O'}, {'.', 'O'}};
                traduccion = ucremilla;
                break;     
        }
                return traduccion;
    }
    
    /**
     * @param pos Posición del char relativa a la colección de carácteres
     * @return Array de dos dimensiones en braille
     */
    
    public static char[][] alfabetoPunt(int pos) {
        char[][] traduccion = new char[3][2];
        switch (pos) {
            case 0:
                char[][] punto  = {{'.', '.'}, {'.', '.'}, {'O', '.'}};
                traduccion = punto;
                break;
            case 1:
                char[][] coma  = {{'.', '.'}, {'O', '.'}, {'.', '.'}};
                traduccion = coma;
                break;
            case 2:
                char[][] puncoma  = {{'.', '.'}, {'O', '.'}, {'O', '.'}};
                traduccion = puncoma;
                break;
            case 3:
                char[][] dpuntos  = {{'.', '.'}, {'O', 'O'}, {'.', '.'}};
                traduccion = dpuntos;
                break;
            case 4:
                char[][] guion  = {{'.', '.'}, {'.', '.'}, {'O', 'O'}};
                traduccion = guion;
                break;
            case 5:
                char[][] interr1  = {{'.', '.'}, {'O', '.'}, {'.', 'O'}};
                traduccion = interr1;
                break;
            case 6:
                char[][] interr2  = {{'.', '.'}, {'O', '.'}, {'.', 'O'}};
                traduccion = interr2;
                break;
            case 7:
                char[][] exc1  = {{'.', '.'}, {'O', 'O'}, {'O', '.'}};
                traduccion = exc1;
                break;
            case 8:
                char[][] exc2  = {{'.', '.'}, {'O', 'O'}, {'O', '.'}};
                traduccion = exc2;
                break;
            case 9:
                char[][] comillas  = {{'.', '.'}, {'O', '.'}, {'O', 'O'}};
                traduccion = comillas;
                break;
            case 10:
                char[][] parentesis1  = {{'O', '.'}, {'O', '.'}, {'.', 'O'}};
                traduccion = parentesis1;
                break;
            case 11:
                char[][] parentesis2  = {{'.', 'O'}, {'.', 'O'}, {'O', '.'}};
                traduccion = parentesis2;
                break;
            case 12:
                char[][] apost  = {{'.', '.'}, {'.', '.'}, {'O', '.'}};
                traduccion = apost;
                break;      
        }
        return traduccion;
    }
    
    /**
     * @param pos Posición del char relativa a la colección de carácteres
     * @return Array de dos dimensiones en braille
     */
    
    public static char[][] alfabetoNum(int pos) {
        char[][] traduccion = new char[3][2];
        switch (pos) {
            case 0:
                char[][] cero  = {{'.', 'O'}, {'O', 'O'}, {'.', '.'}};
                traduccion = cero;
                break;
            case 1:
                char[][] uno  = {{'O', '.'}, {'.', '.'}, {'.', '.'}};
                traduccion = uno;
                break;
            case 2:
                char[][] dos  = {{'O', '.'}, {'O', '.'}, {'.', '.'}};
                traduccion = dos;
                break;
            case 3:
                char[][] tres  = {{'O', 'O'}, {'.', '.'}, {'.', '.'}};
                traduccion = tres;
                break;
            case 4:
                char[][] cuatro  = {{'O', 'O'}, {'.', 'O'}, {'.', '.'}};
                traduccion = cuatro;
                break;
            case 5:
                char[][] cinco  = {{'O', '.'}, {'.', 'O'}, {'.', '.'}};
                traduccion = cinco;
                break;
            case 6:
                char[][] seis  = {{'O', 'O'}, {'O', '.'}, {'.', '.'}};
                traduccion = seis;
                break;
            case 7:
                char[][] siete  = {{'O', 'O'}, {'O', 'O'}, {'.', '.'}};
                traduccion = siete;
                break;
            case 8:
                char[][] ocho  = {{'O', '.'}, {'O', 'O'}, {'.', '.'}};
                traduccion = ocho;
                break;
            case 9:
                char[][] nueve  = {{'.', 'O'}, {'O', '.'}, {'.', '.'}};
                traduccion = nueve;
                break;    
        }
        return traduccion;
    }
    
    //From here: Qué carácter traducir y como
    /**
     * me cansé de documentar
     * @param car Caracter que será traducido, entregado por ciclos
     */
    
    public static void traducirMinusc(char car) {
        char[][] traduccion = new char[3][2];
        /* importante: arr[][] traducción es el array que tomará cada traducción
         * que sea llamada
         */ 
        
        /** Esta estructura recorre las colecciones y mientras
            el caracter que se quiera traducir tenga su equivalente en la 
            respectiva colección (colMinusc, colPunt, colNum), 'traducción'
            tomará tomara los valores que entrege la búsqueda de alfabetoX(pos)
            importante: esto último hace al programa dependiente de la integridad
            de las posicicones de los carácteres en sus respectivas colecciones
                ***aplica para todas las funciones restantes***
        */
        for (int i = 0; i < colMinusc.length; i++) {
            if (car == colMinusc[i]) {
                traduccion = alfabetoMinusc(i); //traspaso de arrays
                System.out.println(colMinusc[i]); //muestra el caracter trad.
                printMatrix(traduccion); //Libreria.printMatrix
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
        input();
    }
    
}