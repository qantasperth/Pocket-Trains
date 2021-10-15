package deliveries;

import network.Network;
import network.RailwayStation;

import java.util.*;

public class DeliveriesGenerator {

    private final Random random = new Random();
    private int maxDeliveries;
    private Network network;
    private int deliveriesCounter;
    private HashMap<String, RailwayStation> railwayStations;
    private HashMap<String, Integer> contentsDatabase = new HashMap<>();

    public DeliveriesGenerator(Network network) {
        this.maxDeliveries = network.getRailwayStations().size();
        this.deliveriesCounter = 1;
        this.railwayStations = network.getRailwayStations();
        this.contentsDatabase.put("beer", 1);
        this.contentsDatabase.put("sausages", 1);
        this.contentsDatabase.put("coffee", 2);
        this.contentsDatabase.put("oil", 3);
    }

    public void generateDeliveries() {

        for (RailwayStation origin : railwayStations.values()) {

            ArrayList<Delivery> deliveries = new ArrayList<>();

            for (int i=0; i<random.nextInt(maxDeliveries); i++) {

                RailwayStation destination = chooseDestination(origin);
                String contents = contentsDatabase.keySet().toArray(String[]::new)
                        [random.nextInt(contentsDatabase.size())];
                Delivery delivery = new Delivery(
                        Integer.toString(deliveriesCounter),
                        contents, origin, destination,
                        random.nextInt(4)+1, 100 * contentsDatabase.get(contents));
                deliveries.add(delivery);
                deliveriesCounter++;

            }

            origin.setDeliveries(deliveries);
        }
    }

    public RailwayStation chooseDestination(RailwayStation origin) {

        RailwayStation destination = origin;
        while (destination == origin) {
            destination = new ArrayList<>(railwayStations.values()).get(random.nextInt(railwayStations.size()));
        }
        return destination;
    }
}
