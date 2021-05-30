/*
 *  Ejercicio de refactoring
 *  @author Jorge M.
 *  30-05-2021
 */

// entrada: largo del cuestionario int cantidad
// proceso: generar "cantidad" preguntas - mostrarlas al usuario - responderlas - evaluar
// salida: puntaje

import java.util.InputMismatchException;
import java.util.Scanner;
import java.lang.Math;

// refactor de: https://raw.githubusercontent.com/jlagosobando/ApuntesPrograJava/master/04%20Estructuras%20Avanzadas/0727_CuestionarioV4.java
public class CuestionarioV5 {
    public static void main(String[] args) {
        initCuestionario(getCantidadPreguntas());
    }

    private static void initCuestionario(int cantidadPreguntas) {
        boolean cumple;
        int correctAnswers = 0;
        int operandoUno, operandoDos, operador;
        double userResponse = Double.MIN_VALUE;
        double answer;
        Scanner input = new Scanner(System.in);

        for (int i = 0; i < cantidadPreguntas; i++) {
            cumple = false;
            operandoUno = (int) (Math.random() * 10);
            operandoDos = (int) (Math.random() * 10);
            operador = (int) (Math.random() * 4) + 1;
            answer = getAnswer(operandoUno, operandoDos, operador);

            while (!cumple) {
                try {
                    userResponse = input.nextDouble();
                    cumple = true;
                } catch (Exception e) {
                    System.out.println("Ingrese un valor adecuado");
                    input.next();
                }
            } // while

            if (userResponse == answer) {
                correctAnswers++;
            }
        } // for
        System.out.println("Su rendimiento fue " + correctAnswers + " de " + cantidadPreguntas);
    }

    public static double getAnswer(int operandoUno, int operandoDos, int operador) {
        switch (operador) {
            case 1 -> {
                printOperacion(operandoUno, " + ", operandoDos);
                return operandoUno + operandoDos;
            }
            case 2 -> {
                printOperacion(operandoUno, " - ", operandoDos);
                return operandoUno - operandoDos;
            }
            case 3 -> {
                printOperacion(operandoUno, " * ", operandoDos);
                return operandoUno * operandoDos;
            }
            case 4 -> {
                printOperacion(operandoUno, " / ", operandoDos);
                // se podría evitar div/0 generando reiterativamente operandoDos pero cambiará la funcionalidad del programa
                // se eliminó trycatch debido a que Java entrega la div/0 como Infinity
                double divTruncated = Math.floor(((double) operandoUno / operandoDos) * 10) / 10;
                return  divTruncated == Double.POSITIVE_INFINITY ? 0 : divTruncated;
            }
        }
        return Double.MIN_VALUE;
    }

    public static void printOperacion(int operandoUno, String operador, int operandoDos) {
        System.out.println(operandoUno + operador + operandoDos + " =");
    }

    public static int getCantidadPreguntas() {
        boolean cumple = false;
        int cantidad = 0;
        Scanner input = new Scanner(System.in);
        while (!cumple) {
            try {
                while (cantidad < 1) {
                    System.out.println("Ingresa cantidad de ejercicios");
                    cantidad = input.nextInt();
                }
                cumple = true;
            } catch (InputMismatchException e) {
                System.err.println(e + ": Ingrese un valor adecuado");
                input.next();
            } catch (Exception e) {
                System.err.println(e + "Ocurrió un error inesperado");
            }
        }
        return cantidad;
    } // getCantidad

} // fin class



