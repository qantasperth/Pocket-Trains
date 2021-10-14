package deliveries;

import network.Network;
import network.RailwayStation;

import java.util.*;

public class DeliveriesGenerator {

    private final Random random = new Random();
    private int deliveriesCounter;
    private ArrayList<RailwayStation> railwayStations;
    private HashMap<String, Integer> contentsDatabase = new HashMap<>();

    public DeliveriesGenerator(Network network) {
        this.deliveriesCounter = 1;
        this.railwayStations = network.getRailwayStations();
        this.contentsDatabase.put("beer", 1);
        this.contentsDatabase.put("sausages", 1);
        this.contentsDatabase.put("coffee", 2);
        this.contentsDatabase.put("oil", 3);
    }

    public void generateDeliveries() {

        for (RailwayStation origin : railwayStations) {

            RailwayStation destination = chooseDestination(origin);
            String contents = contentsDatabase.keySet().toArray(String[]::new)
                    [random.nextInt(contentsDatabase.size())];
            Delivery delivery = new Delivery(
                    Integer.toString(deliveriesCounter),
                    contents, origin, destination,
                    random.nextInt(4)+1, 100 * contentsDatabase.get(contents));
            ArrayList<Delivery> deliveries = new ArrayList<>();
            deliveries.add(delivery);
            origin.setDeliveries(deliveries);
            deliveriesCounter++;
        }
    }

    public RailwayStation chooseDestination(RailwayStation origin) {

        RailwayStation destination = origin;
        while (destination == origin) {
            destination = railwayStations.get(random.nextInt(railwayStations.size()));
        }
        return destination;
    }
}
