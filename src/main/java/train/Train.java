package train;

import deliveries.Delivery;
import network.RailwayStation;

import java.util.ArrayList;
import java.util.HashMap;

public class Train {

    private String name;
    private Locomotive locomotive;
    private String location;
    private HashMap<String, Delivery> deliveries;

    public Train(String name, Locomotive locomotive) {
        this.name = name;
        this.locomotive = locomotive;
        this.location = "none";
        this.deliveries = new HashMap<>();
    }

    public void loadDelivery(Delivery deliveryToLoad) {
        if (this.getCars().size() + deliveryToLoad.getCars().size() > locomotive.getCapacity()) {
            System.out.println("impossible: locomotive capacity overload");
        } else {
            deliveries.put(deliveryToLoad.getId(), deliveryToLoad);
            deliveryToLoad.setStatus("loaded");
        }
    }

    public void unloadDelivery(Delivery deliveryToUnload) {
        deliveries.remove(deliveryToUnload.getId());

        if (deliveryToUnload.getOrigin().getName().equals(location)) {
            deliveryToUnload.setStatus("open");
        } else {
            deliveryToUnload.setStatus("stopover");
        }


    }

    public ArrayList<Car> getCars() {
        ArrayList<Car> cars = new ArrayList<>(locomotive.getCapacity());
        for (Delivery delivery : deliveries.values()) {
            cars.addAll(delivery.getCars());
        }
        return cars;
    }

    public HashMap<String, Delivery> getDeliveries() {
        return deliveries;
    }

    public void setLocation(String location) {
        this.location = location;
    }

    public void printTrainInfo() {
        System.out.println("Train: " + name);
        System.out.println("Location: " + location);
        System.out.print("Cars: ");
        if (this.getCars().size() == 0) {
            System.out.println("no cars");
        } else {
            for (Car car : this.getCars()) {
                System.out.print(car.getId() + ", ");
            }
        }
        System.out.println("\n");
    }
}
