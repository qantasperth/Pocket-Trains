package network;

import deliveries.Delivery;
import train.Train;

import java.util.ArrayList;
import java.util.HashMap;

public class RailwayStation {

    private int xCoord;
    private int yCoord;
    private int capacity;
    private final String name;
    private HashMap<String, Delivery> deliveries;
    private ArrayList<Train> trains;
    boolean isActive;

    public RailwayStation(String name, int xCoord, int yCoord, int capacity) {
        this.xCoord = xCoord;
        this.yCoord = yCoord;
        this.name=name;
        this.capacity=capacity;
        this.deliveries = new HashMap<>();
        this.isActive = true;
    }

    public void changeCapacity(int num) {
        capacity += num;
    }

    public HashMap<String, Delivery> getDeliveries() {
        return deliveries;
    }

    public void setDeliveries(ArrayList<Delivery> deliveriesList) {
        for (Delivery delivery : deliveriesList) {
            deliveries.put(delivery.getId(), delivery);
        }
    }

    public void printDeliveries() {
        System.out.println("Railway Station: " + name + "\n");
        for (Delivery delivery : deliveries.values()) {
            delivery.printDelivery();
        }
    }

    public String getName() {
        return name;
    }
}
