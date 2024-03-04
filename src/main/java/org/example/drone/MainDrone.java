
package org.example.drone;


import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

public class MainDrone {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        // Reading drone information
        List<Drone> drones = new ArrayList<>();

        while (true) {
            System.out.println("Enter drone information (name, max weight), type 'done' when finished:");
            String input = scanner.nextLine();

            if (input.equalsIgnoreCase("done")) {
                break;
            }

            String[] droneInfo = input.split(", ");
            if (droneInfo.length != 2) {
                System.out.println("Invalid input for drone. Please enter in the format 'name, max weight'.");
                continue;
            }

            String name = droneInfo[0];
            int maxWeight = Integer.parseInt(droneInfo[1]);
            drones.add(new Drone(name, maxWeight));
        }

        // Reading locations and package weights
        List<Location> locations = new ArrayList<>();
        while (true) {
            System.out.println("Enter location information (name, package weight), type 'done' when finished:");
            String input = scanner.nextLine();

            if (input.equalsIgnoreCase("done")) {
                break;
            }

            String[] locationInfo = input.split(", ");
            if (locationInfo.length != 2) {
                System.out.println("Invalid input for location. Please enter in the format 'name, package weight'.");
                continue;
            }

            String locationName = locationInfo[0];
            int packageWeight = Integer.parseInt(locationInfo[1]);
            locations.add(new Location(locationName, packageWeight));
        }

        // Distributing packages among drones
        int droneIndex = 0;
        for (Location location : locations) {
            Drone currentDrone = drones.get(droneIndex);
            Trip currentTrip;
            if (currentDrone.trips.isEmpty() || currentDrone.trips.get(currentDrone.trips.size() - 1).locations.size() == 2) {
                currentTrip = new Trip();
                currentDrone.addTrip(currentTrip);
            } else {
                currentTrip = currentDrone.trips.get(currentDrone.trips.size() - 1);
            }
            currentTrip.addLocation(location);
            droneIndex = (droneIndex + 1) % drones.size();
        }

        // Printing the output
        for (Drone drone : drones) {
            System.out.println(drone.name);

            for (int i = 0; i < drone.trips.size(); i++) {
                System.out.println("Trip #" + (i + 1));
                Trip trip = drone.trips.get(i);
                for (Location location : trip.locations) {
                    System.out.println(location.name);
                }
            }

            System.out.println();
        }
    }

}
