package org.example.ordenarlista;

import java.util.Arrays;
import java.util.List;
import java.util.Scanner;

public class Main {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        List<Estudiante> estudiantes = getEstudiantes();

        while (true) {

            System.out.println("Ingrese los campos a ordenar separados por espacios (nombre, edad, calificacion):");
            String campos = scanner.nextLine();

            ordenar(campos, estudiantes);
            show(estudiantes);

            System.out.println("¿Desea ordenar por otro campo? (s/n)");
            if (scanner.nextLine().equals("n")) {
                break;
            }
        }
    }

    private static void ordenar(String campos, List<Estudiante> estudiantes) {
        IComparador comparador = ComparadorFactory.getInstance().crearComparador(campos);

        Ordenador ordenador = new Ordenador(comparador);
        ordenador.sort(estudiantes);
    }

    private static void show(List<Estudiante> estudiantes) {
        for (Estudiante estudiante : estudiantes) {
            System.out.println(estudiante);
        }
    }


    private static List<Estudiante> getEstudiantes() {
        List<Estudiante> estudiantes = Arrays.asList(
                new Estudiante("Juan", 20, 55),
                new Estudiante("Juan", 20, 54),
                new Estudiante("Juan", 21, 60),
                new Estudiante("Pedro", 18, 85.3),
                new Estudiante("Pedro", 18, 84),
                new Estudiante("Pedro", 17, 90),
                new Estudiante("Ana", 19, 90.5),
                new Estudiante("Ana", 21, 84),
                new Estudiante("María", 21, 70),
                new Estudiante("María", 23, 87),
                new Estudiante("Luis", 22, 60.5),
                new Estudiante("Luis", 22, 60.5),
                new Estudiante("Luis", 25, 70)

        );
        return estudiantes;
    }

}
