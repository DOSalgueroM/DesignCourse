package org.example;

import java.util.List;

public class Road {
    private String location;
    private int weight;

    public Road(String location, int weight) {
        this.location = location;
        this.weight = weight;
    }

    public String getLocation() {
        return location;
    }

    public int getWeight() {
        return weight;
    }

}
