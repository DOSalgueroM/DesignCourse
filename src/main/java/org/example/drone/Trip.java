package org.example.drone;

import java.util.ArrayList;
import java.util.List;

class Trip {
    List<Location> locations;

    Trip() {
        this.locations = new ArrayList<>();
    }

    void addLocation(Location location) {
        locations.add(location);
    }
}
