package train;

import deliveries.Delivery;
import network.RailwayStation;

import java.util.ArrayList;

public class Train {

    private String name;
    private Locomotive locomotive;
    private RailwayStation railwayStation = null;
    private ArrayList<Car> cars;

    public Train(String name, Locomotive locomotive) {
        this.name = name;
        this.locomotive = locomotive;
        this.cars = new ArrayList<>(locomotive.getCapacity());
    }

    public void loadDelivery(Delivery deliveryToLoad) {
        try {
            cars.addAll(deliveryToLoad.getCars());
        } catch (Exception ee) {
            System.out.println("train capacity overload");
        }
    }

    public void unloadDelivery(Delivery deliveryToUnload) {
        cars.removeAll(deliveryToUnload.getCars());
    }

    public void setRailwayStation(RailwayStation railwayStation) {
        this.railwayStation = railwayStation;
    }

    public void printTrainInfo() {
        System.out.println("Train: " + name);
        System.out.println("Location: " + railwayStation.getName());
        System.out.println("Cars: ");
        for (Car car : cars) {
            System.out.println(car.getId());
        }
        System.out.println("\n");
    }
}
