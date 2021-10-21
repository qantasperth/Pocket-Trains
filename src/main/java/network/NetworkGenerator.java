package network;

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

        network.getLinks().put(link_12.getId(), link_12);
        network.getLinks().put(link_21.getId(), link_21);
        network.getLinks().put(link_23.getId(), link_23);
        network.getLinks().put(link_32.getId(), link_32);
        network.getLinks().put(link_34.getId(), link_34);
        network.getLinks().put(link_43.getId(), link_43);
        network.getLinks().put(link_41.getId(), link_41);
        network.getLinks().put(link_14.getId(), link_14);
        network.getLinks().put(link_24.getId(), link_24);
        network.getLinks().put(link_42.getId(), link_42);

        return network;
    }
}
