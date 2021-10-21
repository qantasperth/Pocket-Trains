package deliveries;

import network.RailwayStation;
import train.Car;

import java.util.ArrayList;

// TODO: reward per car

public class Delivery {

    private String id;
    private String contents;
    private RailwayStation origin;
    private RailwayStation destination;
    private int numCars;
    private ArrayList<Car> cars;
    private int reward;
    private String status; // open, loaded, in delivery, stopover, delivered

    public Delivery(String id, String contents, RailwayStation origin,
                    RailwayStation destination, int numCars, int reward) {
        this.id = id;
        this.contents = contents;
        this.origin = origin;
        this.destination = destination;
        this.numCars = numCars;
        this.reward = reward;
        this.status = "open";
        this.cars = createCarsForDelivery();
    }

    public ArrayList<Car> createCarsForDelivery() {
        cars = new ArrayList<>(numCars);
        for (int i = 0; i< numCars; i++) {
            Car car = new Car(this, Integer.toString(i+1));
            cars.add(car);
        }
        return cars;
    }

    public ArrayList<Car> getCars() {
        return cars;
    }

    public String getId() {
        return id;
    }

    public RailwayStation getOrigin() {
        return origin;
    }

    public RailwayStation getDestination() {
        return destination;
    }

    public void setStatus (String status) {
        this.status = status;
    }

    public void printDelivery() {
        System.out.println("Delivery: " + id);
        System.out.println("Contents: " + contents);
        System.out.println("Origin: " + origin.getName());
        System.out.println("Destination: " + destination.getName());
        System.out.println("Number of cars: " + numCars);
        System.out.println("Cars id: " + cars.get(0).getId() + " - " + cars.get(numCars-1).getId());
        System.out.println("Reward: " + reward + "\n");
    }
}
