package org.example.ordenarlista;

import java.util.List;
import java.util.Scanner;

public class Main {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        /*Estudiante[] estudiantes = {
                new Estudiante("Juan", 20, 55),
                new Estudiante("Pedro", 18, 85.3),
                new Estudiante("Ana", 19, 90.5),
                new Estudiante("María", 21, 70),
                new Estudiante("Luis", 22, 60.5),
        };*/
        List<Estudiante> estudiantes = List.of(
                new Estudiante("Juan", 20, 55),
                new Estudiante("Pedro", 18, 85.3),
                new Estudiante("Ana", 19, 90.5),
                new Estudiante("María", 21, 70),
                new Estudiante("Luis", 22, 60.5)
        );

        Menu();
        System.out.println("Ingrese los campos por los que desea ordenar la lista de estudiantes");
        System.out.println("nombre edad calificacion");
        String[] campos = scanner.nextLine().split(" ");
        for (String campo : campos) {
            switch (campo) {
                case "nombre":
                    ordenarEstudiantes(new OrdenarPorNombre(), estudiantes);
                    break;
                case "edad":
                    ordenarEstudiantes(new OrdenarPorEdad(), estudiantes);
                    break;
                case "calificacion":
                    ordenarEstudiantes(new OrdenarPorCalificacion(), estudiantes);
                    break;
                default:
                    System.out.println("Campo no válido");
                    break;
            }
        }
     /*   int opcion = scanner.nextInt();
        while (opcion != 4) {
            switch (opcion) {
                case 1:
                    ordenarEstudiantes(new OrdenarPorNombre(), estudiantes);
                    break;
                case 2:
                    ordenarEstudiantes(new OrdenarPorEdad(), estudiantes);
                    break;
                case 3:
                    ordenarEstudiantes(new OrdenarPorCalificacion(), estudiantes);
                    break;
                default:
                    System.out.println("Opción no válida");
                    break;
            }
            Menu();
            opcion = scanner.nextInt();
        }*/


    }
    public static void ordenarEstudiantes(IOrdenarDatosEstudiante ordenarDatosEstudiante, List<Estudiante> estudiantes) {
        ordenarDatosEstudiante.ordenar(estudiantes);
        ordenarDatosEstudiante.print();
    }
    public static void Menu(){
        System.out.println("Lista de estudiantes");
        System.out.println("---------------------------");
        System.out.println("Elija una opción para ordenar la lista de estudiantes");
        System.out.println("1. Ordenar por nombre");
        System.out.println("2. Ordenar por edad");
        System.out.println("3. Ordenar por calificacion");
        System.out.println("4. Salir");
    }
}
