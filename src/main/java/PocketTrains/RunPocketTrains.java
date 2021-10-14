package PocketTrains;

import deliveries.DeliveriesGenerator;
import network.*;
import train.Locomotive;
import train.Train;

public class RunPocketTrains {

    public static void main(String[] args) {

        Network network = new NetworkGenerator().generateTestNetwork();
        new DeliveriesGenerator(network).generateDeliveries();

        network.getRailwayStations().get(0).printDeliveries();
        network.getRailwayStations().get(1).printDeliveries();
        network.getRailwayStations().get(2).printDeliveries();
        network.getRailwayStations().get(3).printDeliveries();

        RailwayStation startLocation = network.getRailwayStations().get(2);
        Locomotive ice_locomotive = new Locomotive("ICE", 8, 100, startLocation);
        Train train = new Train("ICE 100", ice_locomotive);

    }
}
