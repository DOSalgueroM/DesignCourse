package org.example.dronesCorrecto;

import java.util.List;

public class Trip {
    private Drone drone;
    private List<Location> location;

    public Trip(List<Location> location) {
        //this.drone = drone;
        this.location = location;
    }

    public Drone getDrone() {
        return drone;
    }

    public void setDrone(Drone drone) {
        this.drone = drone;
    }

    public List<Location> getLocation() {
        return location;
    }
    public void setLocation(List<Location> location) {
        this.location = location;
    }

}
