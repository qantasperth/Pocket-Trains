package network;

import deliveries.Delivery;
import train.Train;

import java.util.ArrayList;

public class RailwayStation {

    private int capacity;
    private String name;
    private Node node;
    private ArrayList<Delivery> deliveries;
    private ArrayList<Train> trains;
    boolean isActive;

    public RailwayStation(Node node, String name, int capacity) {
        this.node=node;
        this.name=name;
        this.capacity=capacity;
        this.deliveries = new ArrayList<Delivery>();
        this.isActive = true;
    }

    public void changeCapacity(int num) {
        capacity += num;
    }

    public ArrayList<Delivery> getDeliveries() {
        return deliveries;
    }

    public void setDeliveries(ArrayList<Delivery> deliveries) {
        this.deliveries = deliveries;
    }

    public void printDeliveries() {
        System.out.println("Railway Station: " + name);
        for (Delivery delivery : deliveries) {
            delivery.printDelivery();
        }
    }

    public String getName() {
        return name;
    }
}
