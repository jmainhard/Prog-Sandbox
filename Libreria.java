package com.mycompany.disenomodular;

import java.util.*;
import java.math.BigInteger;

/**
 * @author Jorge M. Libreria de funciones para usarse en otros ejercicios
 * 01-09-2020
 */
public class Libreria {

    public static void printArray(int[] arr) {
        for (int i = 0; i < arr.length; i++) {
            System.out.print(arr[i]+ " ");
        }
        System.out.println("\n");
    }
    
    public static void printArray(char[] arr) {
        for (int i = 0; i < arr.length; i++) {
            System.out.print(arr[i]);
        }
    }

    public static void printMatrix(int[][] matrix) {
        for (int i = 0; i < matrix.length; i++) {
            for (int j = 0; j < matrix[i].length; j++) {
                System.out.print(matrix[i][j] + " ");
            }
            System.out.println();
        }
    }
    
    public static void printMatrix(int[][][] matrix) {
        for (int i = 0; i < matrix.length; i++) {
                for (int j = 0; j < matrix[i].length; j++) {
                    for (int k = 0; k < matrix[i][j].length; k++) {
                        System.out.print(matrix[i][j][k] + " ");
                    }
                }
                System.out.println();
            }
    }

    public static void fillArray(int[] arr) {
        Scanner input = new Scanner(System.in);
        int num;

        for (int i = 0; i < arr.length; i++) {
            num = 0;
            while (num < 1 || num > 9) { //validador
                try {
                    System.out.println("\nÍndice [" + i + ']');
                    arr[i] = input.nextInt();
                } catch (Exception e) {
                    System.out.println("No válido");
                    input.next();
                }
            }
            printArray(arr);
        }
    }

    public static void fillMatrix(int[][] matrix) {
        Scanner input = new Scanner(System.in);
        int num;
        for (int i = 0; i < matrix.length; i++) {
            for (int j = 0; j < matrix[i].length; j++) {
                num = 0;
                while (num < 1 || num > 9) { //validador
                    try {
                        System.out.println("\nÍndice [" + i + "][" + j + ']');
                        num = input.nextInt();
                        matrix[i][j] = num;
                    } catch (Exception e) {
                        System.out.println("Ingrese número");
                        num = 0;
                        input.next();
                    }
                }
                printMatrix(matrix);
            }
        }
    }

    public static void randomFill(int[] arr, int random) {
        for (int i = 0; i < arr.length; i++) {
            arr[i] = (int) (Math.random() * random);
        }
        System.out.println("Arreglo generado: ");
        System.out.println(Arrays.toString(arr)+"\n");
    }

    public static void randomFill(int[][] matrix, int random) {
        for (int i = 0; i < matrix.length; i++) {
            for (int j = 0; j < matrix[i].length; j++) {
                matrix[i][j] = (int) (Math.random() * random);
            }
        }
        System.out.println("Matriz generada: ");
        printMatrix(matrix);
    }

    public static BigInteger iterFact(int a) {
        BigInteger fact = new BigInteger("1");
        for (int i = 1; i < a + 1; i++) {
            fact = fact.multiply(new BigInteger(String.valueOf(i)));
        }
        return fact;
    }

    public static BigInteger recFact(int a) {
        if (a == 1) {
            return new BigInteger("1");
        } else {
            BigInteger fact = new BigInteger(String.valueOf(a));
            return (fact.multiply(recFact(a - 1)));
        }
    }

    public static void bubbleSort(int[] arr) {
        int aux = 0;
        for (int i = 2; i <= arr.length; i++) {
            for (int j = 0; j < arr.length-1; j++) {
                if (arr[j] > arr[j + 1]) {
                    aux = arr[j];
                    arr[j] = arr[j + 1];
                    arr[j + 1] = aux;
                }
            }
            printArray(arr);
        }
    }
    
    /**
    * Función recursiva, implementación de MergeSort.
    * @param arr Input del array
    * @param n Largo del array
    */
    public static void mergeSort(int[] arr, int n) {
        if (n < 2) { //condición base, arr length 1
            return;
        }
        
        int mid = n / 2;
        int[] left = new int[mid];
        int[] right = new int[n - mid];
        
//traspasa los valores de 'arr' los arrays (temporales) ('l' y 'r')
        for (int i = 0; i < mid; i++) {
            left[i] = arr[i];
        }
        for (int i = mid; i < n; i++) {
            right[i - mid] = arr[i];
        }
        
//llamada recursiva
        mergeSort(left, mid);
        mergeSort(right, n - mid);
        
//fusión
        merge(arr, left, right, mid, n - mid);
    }
    
    /**
     * Compara elmentos de ambos sub-arrays uno por uno y ubica el
     * menor elemento en el array de input.
     * @param arr Array original (paso por referencia)
     * @param left Sub-array izquierdo
     * @param right Sub-array derecho
     * @param l Índice de término array izquierdo
     * @param r Índice de inicio array derecho
     */
    public static void merge(int[] arr, int[] l, int[] r, int left, int right) {
        int i = 0, j = 0, k = 0;
        
//fusiona los elementos en el arr original según las condiciones
        while (i < left && j < right) {
            if (l[i] <= r[j]) {
                arr[k++] = l[i++];
            } else {
                arr[k++] = r[j++];
            }
        }
        
        while (i < left) {
            arr[k++] = l[i++];
        }
        while (j < right) {
            arr[k++] = r[j++];
        }
    }
    
    public static int fibIter(int n) {
        int fib1 = 1, fib2 = 1, fibon = 1;

        if (n == 1 || n == 2) {
            return 1;
        }
        
        for (int i = 3; i <= n; i++) {
            fibon = fib1 + fib2;
            fib1 = fib2;
            fib2 = fibon;
        }
        return fibon;
    }
    
    public static void randomFill(ArrayList arr, int random, int tamaño) {
        /* Nota a futuro:
        *  i < arr.size() no funcionaba porque no me generaba el ArrList 
         * con 10 (o más) elementos, como se supone que debería :(
         */
        int rand = 0;
        for (int i = 0; i < tamaño; i++) {
            rand = (int) (Math.random()* random);
            if (!(arr.contains(rand))) {
                arr.add(rand);
            } else {
                i--;
            }
        }
        System.out.println("Lista generada: "+ arr+ "\n");
    }
    
    public static void searchIn(ArrayList arr, int limInf, int limSup) {
        //buscar primera coincidencia
        Scanner input = new Scanner(System.in);
        boolean is = false;
        int x = limInf - 1;
        
        while (x < limInf || x > limSup || !is) {
            x = limInf - 1;
            try {
                System.out.println
                           ("Búsqueda de enteros entre "+ limInf+" y "+ limSup);
                x = input.nextInt();
                if (arr.contains(x)) {
                    System.out.print("\nEncontrado en el índice N°: ");
                    System.out.println(arr.indexOf(x));
                    is = true;
                    break;
                } else {
                    System.out.println("\nEl elemento no se encuentra en la "
                            + "lista \n");
                    is = false;
                }
            } catch (Exception e) {
                System.out.println("No válido\n");
                input.next();
            }
        }
    }
    
    public static int contar(String palabra) {
        int contador = 0;
        for (int i=0; i<palabra.length(); i++) {
           if (palabra.charAt(i)=='a') {
                contador ++;
            }
        }
        return contador;
    }
    
    public static int buscar(int[] arr, int x) {
        int pos = -1;
        for (int i=0; i < arr.length; i++) {
            if (arr[i] == x) {
                pos = i;
                break;
            }
        }
        return pos;
    }
    
}
