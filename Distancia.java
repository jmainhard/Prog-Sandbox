package com.mycompany.distanciaentredospuntos;

import java.lang.Math;
import java.util.Scanner;

/**
 * @author Jorge M.
 * Idea:
 * Algoritmo que calcule distancia entre dos puntos
 * √(x2-x1)^2(y2-y1)^2
 */

public class Distancia {
    public static void main(String[] args) {
        double x1, y1, dX=0;
        double x2, y2, dY=0;
        double resultado;
        Scanner input = new Scanner(System.in);
        
//todo/fixme ciclo iterativo para evitar string inputs
        System.out.println("Bienvenido, el siguiente programa calcula");
        System.out.println("distancia entre dos puntos.");
        System.out.println("----< >----");
        
//Entrada
        System.out.println("A continuación Ingrese las coordenadas del P1(A)");
        System.out.println("X =");
        x1 = input.nextDouble();
        System.out.println("A = "+ "("+(int)x1+","+"Y"+")");
        System.out.println("Y =");
        y1 = input.nextDouble();
        System.out.println("A = "+ "("+(int)x1+","+(int)y1+")");
        
        System.out.println("A continuación Ingrese las coordenadas del P2(B)");
        System.out.println("X =");
        x2 = input.nextDouble();
        System.out.println("B = "+ "("+(int)x2+","+"Y"+")");
        System.out.println("Y =");
        y2 = input.nextDouble();
        System.out.print("A = "+ "("+(int)x1+","+(int)y1+") ");
        System.out.println("B = "+ "("+(int)x2+","+(int)y2+")");
//Proceso
        dX = x2-x1;//calcular distancia en eje x
        dY = y2-y1;//d(y)
        resultado = Math.hypot(dX, dY);
        resultado=Math.floor(resultado*100); //truncar a la centésima
        resultado/=100;
//Salida
        System.out.println("La distancia entre A y B es:");
        System.out.println("d(A,B) = "+ resultado); 
        
        /**hypot​(double x, double y) Returns sqrt(x^2 +y^2) 
         * without intermediate overflow or underflow.
         */

    }

}
