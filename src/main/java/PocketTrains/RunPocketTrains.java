package PocketTrains;

import deliveries.DeliveriesGenerator;
import deliveries.Delivery;
import network.*;
import router.Route;
import router.Router;
import train.Locomotive;
import train.Train;

import java.util.Scanner;

public class RunPocketTrains {

    private static Scanner scanner = new Scanner(System.in);

    public static void main(String[] args) {

        // generate network and first deliveries
        Network network = new NetworkGenerator().generateTestNetwork();
        new DeliveriesGenerator(network).generateDeliveries();

        for (RailwayStation railwayStation : network.getRailwayStations().values()) {
            railwayStation.printDeliveries();
        }

        System.out.println("a new train is being created...");
        Locomotive ice_locomotive = new Locomotive("ICE", 8, 100);
        Train train = new Train("ICE 100", ice_locomotive);

        System.out.println("where do you want to put your train");
        String startStationName = scanner.nextLine();
        RailwayStation startStation = network.getRailwayStations().get(startStationName);
        System.out.println();
        startStation.addTrain(train);
        train.printTrainInfo();

        // load deliveries
        System.out.println("which delivery do you want to load in " + startStationName + "?");
        String input = scanner.nextLine();

        while (!input.equals("none")) {
            String deliveryId = input;
            Delivery delivery = startStation.getDeliveries().get(deliveryId);
            startStation.getDeliveries().remove(deliveryId);
            train.loadDelivery(delivery);
            train.printTrainInfo();

            System.out.println("anything else to load in " + startStationName + "?");
            System.out.println("if there are no deliveries to load, type \"none\"");
            input = scanner.nextLine();
            if (!input.equals("none"))
                startStation.printDeliveries();
        }

        System.out.println("choose link to start with");
        String startLink = scanner.nextLine();
        Route route = new Route(network.getLinks().get(startLink));
        Router router = new Router(train, route);

        System.out.println("starting route");
        router.startRoute();

        System.out.println("train info between stops");
        train.printTrainInfo();

        System.out.println("ending route");
        router.endRoute();

        System.out.println("train info at destination");
        train.printTrainInfo();

        System.out.println("which deliveries do you want to unload? if no, type \"none\"");
        String input_2 = scanner.nextLine();

        while (!input_2.equals("none")) {
            String deliveryId = input_2;
            Delivery delivery = train.getDeliveries().get(deliveryId);
            train.unloadDelivery(delivery);
            if (delivery.getDestination() != route.getToStation()) {
                route.getToStation().addDelivery(delivery);
            }

            System.out.println("anything else to unload in " + route.getToStation().getName() + "?");
            System.out.println("if there are no deliveries to unload, type \"none\"");
            input_2 = scanner.nextLine();
            if (!input_2.equals("none"))
                train.printTrainInfo();
        }
    }
}
