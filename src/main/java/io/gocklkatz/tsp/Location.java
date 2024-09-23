package io.gocklkatz.tsp;

public class Location {
    private final String name;
    private final double latitude;
    private final double longitude;

    public Location(String name, double latitude, double longitude) {
        this.name = name;
        this.latitude = latitude;
        this.longitude = longitude;
    }

    public String getName() {
        return name;
    }

    public double getLatitude() {
        return latitude;
    }

    public double getLongitude() {
        return longitude;
    }

    public double distanceTo(Location other) {
        double deltaLat = this.latitude - other.latitude;
        double deltaLon = this.longitude - other.longitude;
        return Math.sqrt(deltaLat * deltaLat + deltaLon * deltaLon);
    }
}