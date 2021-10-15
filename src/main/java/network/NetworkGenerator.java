package network;

import java.util.ArrayList;

public class NetworkGenerator {

    public NetworkGenerator() {}

    public Network generateTestNetwork() {

        Network network = new Network("four cities network");

        RailwayStation station_1 = new RailwayStation("paris", 1, 1, 5);
        RailwayStation station_2 = new RailwayStation("amsterdam", 2, 5, 5);
        RailwayStation station_3 = new RailwayStation("berlin", 10, 4, 5);
        RailwayStation station_4 = new RailwayStation("munich", 6, 1, 5);

        network.getRailwayStations().put(station_1.getName(), station_1);
        network.getRailwayStations().put(station_2.getName(), station_2);
        network.getRailwayStations().put(station_3.getName(), station_3);
        network.getRailwayStations().put(station_4.getName(), station_4);

        Link link_12 = new Link("link_12", station_1, station_2);
        Link link_21 = new Link("link_21", station_2, station_1);
        Link link_23 = new Link("link_23", station_2, station_3);
        Link link_32 = new Link("link_32", station_3, station_2);
        Link link_34 = new Link("link_34", station_3, station_4);
        Link link_43 = new Link("link_43", station_4, station_3);
        Link link_41 = new Link("link_41", station_4, station_1);
        Link link_14 = new Link("link_14", station_1, station_4);
        Link link_24 = new Link("link_24", station_2, station_4);
        Link link_42 = new Link("link_42", station_4, station_2);

        network.getLinks().add(link_12);
        network.getLinks().add(link_21);
        network.getLinks().add(link_23);
        network.getLinks().add(link_32);
        network.getLinks().add(link_34);
        network.getLinks().add(link_43);
        network.getLinks().add(link_41);
        network.getLinks().add(link_14);
        network.getLinks().add(link_24);
        network.getLinks().add(link_42);

        return network;
    }
}
