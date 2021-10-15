package train;

import network.RailwayStation;

public class Locomotive {

    private int capacity;
    private String name;
    private double speed;

    public Locomotive(String name, int capacity, double speed) {
        this.name = name;
        this.capacity = capacity;
        this.speed = speed;
    }

    public int getCapacity() {
        return capacity;
    }
}
