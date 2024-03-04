package org.example.drone;

class Drone {
    private String name;
    private int maxWeight;

    public Drone() {
        this.name = "";
        this.maxWeight = 0;
    }
    public Drone(String name, int maxWeight) {
        this.name = name;
        this.maxWeight = maxWeight;
    }

    public String getName() {
        return name;
    }

    public int getMaxWeight() {
        return maxWeight;
    }

}