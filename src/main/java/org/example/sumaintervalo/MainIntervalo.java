package org.example.sumaintervalo;

import static org.example.sumaintervalo.SumadorIntervalos.sumIntervals;

public class MainIntervalo {
    public static void main(String[] args) {
        //int[][] intervalos = {{1, 5}, {6, 10}, {4, 7}};
        int [][] intervalos = {{1, 4}, {7, 10}, {3, 5}};
        //int [][] intervalos = {{4, 4}, {6, 6}, {8, 8}};
        int resultado = sumIntervals(intervalos);
        System.out.println("El resultado es: " + resultado);

    }
}
