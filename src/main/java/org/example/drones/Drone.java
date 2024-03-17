package org.example.drones;

import java.util.ArrayList;
import java.util.List;

public class Drone {

    private String name;
    private int maxWeight;
    private List<Trip> trips;
    public Drone (String name, int maxWeight) {
        this.name = name;
        this.maxWeight = maxWeight;
        this.trips = new ArrayList<>();
    }
    public String getName() {
        return name;
    }
    public int getMaxWeight() {
        return maxWeight;
    }
    public List<Trip> getTrips() {
        return trips;
    }

    public void setName(String name) {
        this.name = name;
    }

    public void setMaxWeight(int maxWeight) {
        this.maxWeight = maxWeight;
    }
    public void addTrip(Trip trip) {
        trips.add(trip);
    }
    public void mostrarViajeDrone(List<Trip> trips){
        int index = 1;
        for (Trip trip : trips) {
            System.out.println(" Viaje:  " + index);
            System.out.println(" Localizacion:  " + trip.getLocation().getNameLocation());
            index++;
        }

        System.out.println();

    }
}
