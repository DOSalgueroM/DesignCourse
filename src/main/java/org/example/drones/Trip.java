package org.example.drones;

public class Trip {
    private Drone drone;
    private Location location;

    public Trip(Drone drone, Location location) {
        this.drone = drone;
        this.location = location;
    }

    public Drone getDrone() {
        return drone;
    }

    public void setDrone(Drone drone) {
        this.drone = drone;
    }

    public Location getLocation() {
        return location;
    }

    public void setLocation(Location location) {
        this.location = location;
    }

}
