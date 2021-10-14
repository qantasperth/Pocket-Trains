package network;

public class NetworkGenerator {

    public NetworkGenerator() {}

    public Network generateTestNetwork() {

        Network network = new Network("four cities network");

        Node node_1 = new Node(1, 1, "node_1");
        Node node_2 = new Node(2, 5, "node_2");
        Node node_3 = new Node(10, 4, "node_3");
        Node node_4 = new Node(6, 1, "node_4");

        network.getNodes().add(node_1);
        network.getNodes().add(node_2);
        network.getNodes().add(node_3);
        network.getNodes().add(node_4);

        Link link_12 = new Link("link_12", node_1, node_2);
        Link link_23 = new Link("link_23", node_2, node_3);
        Link link_34 = new Link("link_34", node_3, node_4);
        Link link_41 = new Link("link_41", node_4, node_1);
        Link link_24 = new Link("link_24", node_2, node_4);

        network.getLinks().add(link_12);
        network.getLinks().add(link_23);
        network.getLinks().add(link_34);
        network.getLinks().add(link_41);
        network.getLinks().add(link_24);

        RailwayStation station_1 = new RailwayStation(node_1, "paris", 5);
        RailwayStation station_2 = new RailwayStation(node_2, "amsterdam", 5);
        RailwayStation station_3 = new RailwayStation(node_3, "berlin", 5);
        RailwayStation station_4 = new RailwayStation(node_4, "munich", 5);

        network.getRailwayStations().add(station_1);
        network.getRailwayStations().add(station_2);
        network.getRailwayStations().add(station_3);
        network.getRailwayStations().add(station_4);

        return network;
    }
}
