package train;

import network.RailwayStation;

public class Locomotive {

    private int capacity;
    private String name;
    private double speed;
    private RailwayStation location;

    public Locomotive(String name, int capacity, double speed, RailwayStation location) {
        this.name = name;
        this.capacity = capacity;
        this.speed = speed;
        this.location = location;
    }

    public void setLocation(RailwayStation location) {
        this.location = location;
    }

    public int getCapacity() {
        return capacity;
    }
}
