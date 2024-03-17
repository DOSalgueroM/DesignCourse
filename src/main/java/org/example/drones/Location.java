package org.example.drones;

public class Location {
    private String nameLocation;
    private int packageWeightLocation;
    private boolean isVisitedLocation;

    public Location(String nameLocation, int packageWeightLocation) {
        this.nameLocation = nameLocation;
        this.packageWeightLocation = packageWeightLocation;
    }

    public String getNameLocation() {
        return this.nameLocation;
    }

    public int getPackageWeightLocation() {
        return this.packageWeightLocation;
    }
    public boolean getIsVisitedLocation() {
        return this.isVisitedLocation;
    }
    public void setIsVisitedLocation(boolean isVisitedLocation) {
        this.isVisitedLocation = isVisitedLocation;
    }

}
