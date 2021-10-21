package router;

import deliveries.Delivery;
import train.Car;
import train.Train;

import java.util.ArrayList;

public class Router {

    private Train train;
    private Route route;

    public Router(Train train, Route route) {
        this.train = train;
        this.route = route;
    }

    public void startRoute() {
        route.getFromStation().getTrains().remove(train);
        train.getDeliveries().forEach((id, delivery) -> delivery.setStatus("in delivery"));
        train.setLocation(route.getFromStation().getName() + " - " + route.getToStation().getName());
    }

    public void endRoute() {
        train.setLocation(route.getToStation().getName());
        route.getToStation().getTrains().add(train);

        ArrayList<Delivery> deliveriesToUnload = new ArrayList<>();
        for (Delivery delivery : train.getDeliveries().values()) {
            if (delivery.getDestination() == route.getToStation()) {
                deliveriesToUnload.add(delivery);
            }
        }

        System.out.print("automatically unloaded deliveries: ");
        for (Delivery delivery : deliveriesToUnload) {
            train.unloadDelivery(delivery);
            delivery.setStatus("delivered");
            System.out.println(delivery.getId() + ", ");
        }




    }
}
