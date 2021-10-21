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
    private ArrayList<Train> trains = new ArrayList<>();
    boolean isActive;

    public RailwayStation(String name, int xCoord, int yCoord, int capacity) {
        this.xCoord = xCoord;
        this.yCoord = yCoord;
        this.name=name;
        this.capacity=capacity;
        this.deliveries = new HashMap<>();
        this.isActive = true;
    }

    public void addTrain(Train train) {
        train.setLocation(this.getName());
        trains.add(train);
    }

    public void removeTrain(Train train) {
        trains.remove(train);
    }

    public void changeCapacity(int num) {
        capacity += num;
    }

    public HashMap<String, Delivery> getDeliveries() {
        return deliveries;
    }

    public void setDeliveries(ArrayList<Delivery> deliveriesList) {
        for (Delivery delivery : deliveriesList)
            deliveries.put(delivery.getId(), delivery);
    }

    public void addDelivery(Delivery delivery) {
        deliveries.put(delivery.getId(), delivery);
    }

    public int getCurrentNumCars() {
        int currNumCars = 0;
        for (Delivery delivery : deliveries.values()) {
            currNumCars += delivery.getCars().size();
        }
        return currNumCars;
    }

    public void printDeliveries() {
        System.out.println("Railway Station: " + name);

        if (deliveries.size() == 0) {
            System.out.println("Deliveries: none");
        } else
            for (Delivery delivery : deliveries.values())
                delivery.printDelivery();
        System.out.println();
    }

    public ArrayList<Train> getTrains() {
        return trains;
    }

    public String getName() {
        return name;
    }
}
