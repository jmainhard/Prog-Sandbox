package com.mycompany.disenomodular;

/**
 * @author Jorge M. 04/08/2020 Programa para evaluar un clavadista según input
 * de siete jueces
 */
import java.util.Scanner;

public class Cp2 {

    public static int numeroJuez;
    public static double grado;

//función: validar el input hasta que se cumpla ejectuar = true;
    public static int validadorJuez() {
        int evaluacion = 0;
        boolean ejecutar = false;
        Scanner userInput = new Scanner(System.in);

        while (ejecutar == false) {
            try {
                while (evaluacion < 1 || evaluacion > 10) {
                    System.out.println("Evalúe el/la clavadista de 1 a 10 (Número entero):");
                    evaluacion = userInput.nextInt();
                }
                ejecutar = true;
            } catch (Exception e) {
                System.out.println("Ingreso no permitido, intente nuevamente" + "\n");
                userInput.next();
            }
        }
        return evaluacion;
    }

//evalúa y elimina el número en caso de ser el menor o mayor, intento de corte
    public static int puntajeCorte(int varEvaluacion) {
        int nuevaSuma = 0, mayor = 0, menor = 0;
        
        if (varEvaluacion>mayor) {
            mayor = varEvaluacion;
            varEvaluacion = 0;
        } else {
            menor = varEvaluacion;
            varEvaluacion = 0;
        }
        
        return varEvaluacion;
    }
    
//recibe cada evaluación, calcular y retornar el puntaje total
    public static double procesaEvaluacion(int evaluacion) {
        double contador = 0;
        int mayor = 0, menor = 0;

        contador += evaluacion;
        contador *= (double) 0.6;
        return contador;
    }

    public static void main(String[] args) {
        Scanner mainInput = new Scanner(System.in);
        int numeroJuez = 0;
        double evaluacionMain = 0;//almacena evaluacion calculada

        System.out.println("Bienvenido/a, evalúe el/la clavadista segun grado de dificultad");
        System.out.println("ingrese grado de dificultad del salto para este clavadista");

//todo agregar validador de 1.6<grados<3.6
        System.out.println("Grado de dificultad:");
        grado = mainInput.nextDouble();//grado de dificultad que tendrá este salto

        for (numeroJuez = 1; numeroJuez < 8; numeroJuez++) {
            System.out.println("\n" + "Juez N°" + numeroJuez + " Ingrese su evaluación");
            evaluacionMain += procesaEvaluacion(validadorJuez());//añade evaluacion al stack
        }

        evaluacionMain *= (double) grado;//ajusta evaluación según grado
        evaluacionMain = Math.floor(evaluacionMain * 100); //truncar a la centésima
        evaluacionMain /= 100;

        //output de puntaje
        System.out.println("Puntaje del clavadista: " + evaluacionMain);
    }

}
