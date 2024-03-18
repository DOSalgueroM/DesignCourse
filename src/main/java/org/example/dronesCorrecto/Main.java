package org.example.dronesCorrecto;

import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

public class Main {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        List<Drone> drones = new ArrayList<>();
        List<Location> locaciones = new ArrayList<>();


        System.out.println("Bienvenido al sistema de drones");
        System.out.println("Ingrese la cantidad de drones");

        int cantidadDrones = scanner.nextInt();
        scanner.nextLine(); // Consume el salto de línea pendiente

        System.out.println("Ingrese el nombre y capacidad separados por coma");

        for (int i = 0; i < cantidadDrones; i++) {
            String input = scanner.nextLine();
            String[] dronesInformation = input.split(", ");
            String nombre = dronesInformation[0];
            int capacidad = Integer.parseInt(dronesInformation[1]);
            drones.add(new Drone(nombre, capacidad));
        }
        System.out.println("Ingrese las locaciones y peso de los paquetes separados por coma");
        System.out.println("Ejemplo: locacion1, 10 .. Escriba 'done' para terminar");
        while (true) {
            String input = scanner.nextLine();
            if (input.equalsIgnoreCase("done")) {
                break;
            }
            String[] locacionInformation = input.split(", ");
            String nombre = locacionInformation[0];
            int peso = Integer.parseInt(locacionInformation[1]);
            locaciones.add(new Location(nombre, peso));
        }
        distribuirPaquetes(drones, locaciones);
        mostrarViajes(drones);
    }
    public static void distribuirPaquetes(List<Drone> drones, List<Location> locaciones) {

        for (Drone droneActual : drones) {
            List<Location> locacionesAsignadas = new ArrayList<>();
            for (Location locacion : locaciones) {
                // Verificar si la locación ya fue asignada a algún dron
                if (!locacion.getIsVisitedLocation()) {
                    //Trip viajeActual;
                    if (droneActual.getMaxWeight() >= locacion.getPackageWeightLocation()) {

                        locacionesAsignadas.add(locacion);
                        droneActual.setMaxWeight(droneActual.getMaxWeight() - locacion.getPackageWeightLocation());
                        // Marcar la locación como asignada
                        locacion.setIsVisitedLocation(true);
                    }
                }

            }

            droneActual.addTrip(new Trip(locacionesAsignadas));

        }
    }


        public static void mostrarViajes(List< Drone> drones) {

            for (Drone drone : drones) {
                System.out.println("Drone: " + drone.getName());
                drone.mostrarViajeDrone(drone.getTrips());
            }
        }
    }
