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
        
//FIXME sólo números enteros !Fixed, p1 y p2 cambiados a double
        System.out.println("Bienvenido, el siguiente programa calcula");
        System.out.println("distancia entre dos puntos.");
        System.out.println("----< >----");
        
//Entrada
        System.out.println("A continuación Ingrese las coordenadas del P1(A)");
        System.out.println("X=");
        x1 = input.nextDouble();
        System.out.println("A = "+ "("+(int)x1+","+"Y"+")");
        y1 = input.nextDouble();
        System.out.println("A = "+ "("+(int)x1+","+(int)y1+")");
        
        System.out.println("A continuación Ingrese las coordenadas del P2(B)");
        System.out.println("X=");
        x2 = input.nextDouble();
        System.out.println("B = "+ "("+(int)x2+","+"Y"+")");
        y2 = input.nextDouble();
        System.out.print("B = "+ "("+(int)x2+","+(int)y2+") ");
        System.out.println("A = "+ "("+(int)x1+","+(int)y1+")");
//Proceso
        dX = x2-x1;//calcular distancia en eje x e y
        dY = y2-y1;
//        dX = Math.pow(dX, 2);
//        dY = Math.pow(dY, 2);
        resultado = Math.hypot(dX, dY);
        
//Salida
        System.out.println("La distancia entre A y B es:");
        System.out.println("d(A,B) = "+ resultado); 
        
        /**hypot​(double x, double y) Returns sqrt(x^2 +y^2) 
         * without intermediate overflow or underflow.
         */

    }

}
