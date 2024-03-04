
package org.example.drone;

import java.util.ArrayList;
import java.util.List;

class Drone {
    String name;
    int maxWeight;
    List<Trip> trips;

    Drone(String name, int maxWeight) {
        this.name = name;
        this.maxWeight = maxWeight;
        this.trips = new ArrayList<>();
    }

    void addTrip(Trip trip) {
        trips.add(trip);
    }
}
