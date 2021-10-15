package train;

import deliveries.Delivery;
import network.RailwayStation;

public class Car {

    private String id;

    public Car(Delivery delivery, String carNum) {
        this.id = delivery.getId() + "." + carNum;
    }

    public String getId() {
        return id;
    }
}
