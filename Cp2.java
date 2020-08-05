package com.mycompany.disenomodular;

/**
 * @author Jorge M. 04/08/2020 Programa para evaluar un clavadista según input
 * de siete jueces
 */
import java.util.Scanner;

public class Cp2 {

    public static int numeroJuez;
    public static double grado;

    //todo, matar la evaluación más alta y las más baja
    public static int validadorJuez() {
        int evaluacion = 0;
        boolean ejecutar = false;
        Scanner userInput = new Scanner(System.in);

        while (ejecutar == false) {
            try {
                while (evaluacion < 1 || evaluacion > 10) {
                    System.out.println("Evalúe al/la clavadista de 1 a 10 (Número entero):");
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

    //todo idea, almacenar todas las notas (array hechizo) y compararlas para cortar
    public static int cortarEvaluaciones(int puntajeIngresado) {
        int nuevaSuma = 0, n1, n2, n3, n4, n5, n6, n7;//nX -> n° evaluación
//        puntajeIngresado
        return nuevaSuma;
    }

    //recibe cada evaluación, calcular y retornar el puntaje total
    public static double procesaEvaluacion(int evaluacion) {
        double contador = 0;
        contador += evaluacion;
        contador *= (double) 0.6;
        return contador;
    }

    public static void main(String[] args) {
        Scanner mainInput = new Scanner(System.in);
        int numeroJuez = 0;
        double evaluacionMain = 0;//almacena evaluacion F. calculada

        System.out.println("Bienvenido/a, evalúe el/la clavadista segun grado de dificultad");
        System.out.println("ingrese grado de dificultad del salto para este clavadista");

        System.out.println("Grado de dificultad:");
        grado = mainInput.nextDouble();//grado de dificultad que tendrá este salto

        for (numeroJuez = 1; numeroJuez < 8; numeroJuez++) {
            System.out.println("\n" + "Juez N°" + numeroJuez + " Ingrese su evaluación");
            //procesaEvaluacion(validadorJuez());//recibe evaluacion
            evaluacionMain += procesaEvaluacion(validadorJuez());//añade evaluacion al stack
        }

        evaluacionMain *= (double)grado;//ajusta evaluación según grado
        evaluacionMain = Math.floor(evaluacionMain*100); //truncar a la centésima
        evaluacionMain /= 100;
        
        //output de puntaje
        System.out.println("Puntaje del clavadista:" + evaluacionMain);

    }

}
