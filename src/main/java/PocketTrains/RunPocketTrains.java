package PocketTrains;

import deliveries.DeliveriesGenerator;
import deliveries.Delivery;
import network.*;
import train.Locomotive;
import train.Train;

import java.util.Scanner;

public class RunPocketTrains {

    private static Scanner scanner = new Scanner(System.in);

    public static void main(String[] args) {

        Network network = new NetworkGenerator().generateTestNetwork();
        new DeliveriesGenerator(network).generateDeliveries();

        for (RailwayStation railwayStation : network.getRailwayStations().values()) {
            railwayStation.printDeliveries();
        }

        System.out.println("where do you want to put your train");
        String startStationName = scanner.nextLine();
        RailwayStation startStation = network.getRailwayStations().get(startStationName);
        System.out.println();

        Locomotive ice_locomotive = new Locomotive("ICE", 8, 100);
        Train train = new Train("ICE 100", ice_locomotive);
        train.setRailwayStation(startStation);
        train.printTrainInfo();

        System.out.println("which delivery do you want to load in " + startStationName + "?");
        String deliveryId_1 = scanner.nextLine();
        Delivery delivery_1 = startStation.getDeliveries().get(deliveryId_1);
        startStation.getDeliveries().remove(deliveryId_1);
        train.loadDelivery(delivery_1);

        train.printTrainInfo();

        System.out.println("anything else to load in " + startStationName + "?");
        String deliveryId_2 = scanner.nextLine();
        Delivery delivery_2 = startStation.getDeliveries().get(deliveryId_2);
        startStation.getDeliveries().remove(deliveryId_2);
        train.loadDelivery(delivery_2);

        train.printTrainInfo();

        startStation.printDeliveries();

    }
}
