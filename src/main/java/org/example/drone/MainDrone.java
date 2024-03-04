package org.example;


import java.util.ArrayList;
import java.util.List;
import java.util.Map;
import java.util.Scanner;

//TIP To <b>Run</b> code, press <shortcut actionId="Run"/> or
// click the <icon src="AllIcons.Actions.Execute"/> icon in the gutter.
public class Main {
    public static void main(String[] args) {
        // Introduce the drones
        //TIP Press <shortcut actionId="ShowIntentionActions"/> with your caret at the highlighted text
        // to see how IntelliJ IDEA suggests fixing it.
        List<Drone> drones = new ArrayList<>();
        Scanner scanner = new Scanner(System.in);
        System.out.println("Introduce the number of drones: ");
        int numberDrones = scanner.nextInt();
        for (int i = 0; i < numberDrones; i++) {
            System.out.println("Introduce the name of the drone: ");
            String name = scanner.next();
            System.out.println("Introduce the weight of the drone: ");
            int weight = scanner.nextInt();
            drones.add(new Drone(name, weight));
        }
        // introduce the deliveries
        List<Road> roads = new ArrayList<>();
        System.out.print("Enter the number of locations: ");
        int numberOfDeliveries = scanner.nextInt();
        scanner.nextLine();
        for (int i = 1; i <= numberOfDeliveries; i++) {
            System.out.print("Enter the location " + i + ": ");
            String location = scanner.nextLine();
            System.out.print("Enter the weight of package " + i + ": ");
            int packageWeight = scanner.nextInt();
            scanner.nextLine();
            roads.add(new Road(location, packageWeight));
        }

        // asign the deliveries to the drones
        for (Drone drone : drones) {
            System.out.println("Assigning deliveries to: " + drone.getName());
            makeDelivery(roads, drones);
            System.out.println("------------------------");
        }
        //test
        /*List<Drone> drones = new ArrayList<>();
        drones.add(new Drone("Drone1", 250));
        drones.add(new Drone("Drone2", 700));

        List<Road> roads = new ArrayList<>();
        roads.add(new Road("Location1", 250));
        roads.add(new Road("Location2", 100));
        roads.add(new Road("Location3", 150));*/


    }

    public static void makeDelivery(List<Road> roads, List<Drone> drones) {
        Drone dron = new Drone();
        int pesoTotalEntregado = 0;

        for (Drone drone : drones) {
            for (Road road : roads) {
                if (pesoTotalEntregado + road.getWeight() <= drone.getMaxWeight()) {
                    // do the delivery
                    System.out.println(drone.getName() + " deliver the package to " + road.getLocation());
                    pesoTotalEntregado += road.getWeight();
                } else {
                    // return to base to recharge
                    System.out.println(drone.getName() + " return to base to recharge");
                    pesoTotalEntregado = 0;
                }
            }
        }

            // if there are still packages to deliver return to base to recharge
            if (pesoTotalEntregado > 0) {
                System.out.println(dron.getName() + " return to base to recharge");
            }

    }
    public static void printDrones(Map<String, Integer> drones) {
        for (Map.Entry<String, Integer> entry : drones.entrySet()) {
            System.out.println(entry.getKey() + " " + entry.getValue());
        }
    }

}