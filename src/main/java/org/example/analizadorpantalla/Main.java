package org.example.analizadorpantalla;

import java.util.Scanner;

public class Main {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        CreadorPantalla creadorPantalla = new CreadorPantalla();
        char[][] pantalla = creadorPantalla.crearPantalla();


        System.out.println("Ingrese la imagen final de la pantalla:");
        for (int i = 0; i < 20; i++) {
            String linea = scanner.nextLine();
            for (int j = 0; j < 50; j++) {
                pantalla[i][j] = linea.charAt(j);
            }
        }

        Result result = getResultado(pantalla);

        System.out.println("Número de cuadros encontrados: " + result.numCuadros());
        System.out.println("Coordenadas y tamaños de los cuadros:");
        System.out.print(result.coordenadasCuadros());
    }

    private static Result getResultado(char[][] pantalla) {
        AnalizadorPantalla analizador = new AnalizadorPantalla(pantalla);
        int numCuadros = analizador.contarCuadros();
        StringBuilder coordenadasCuadros = analizador.obtenerCoordenadasCuadros();
        Result result = new Result(numCuadros, coordenadasCuadros);
        return result;
    }

    private record Result(int numCuadros, StringBuilder coordenadasCuadros) {
    }
}
