package org.example.drone;

class Location {
    String name;
    int packageWeight;
    boolean isVisited;

    Location(String name, int packageWeight) {
        this.name = name;
        this.packageWeight = packageWeight;
        this.isVisited = false;
    }
}