package network;

import java.util.ArrayList;
import java.util.HashSet;

public class Network {

    private ArrayList<Link> links;
    private ArrayList<Node> nodes;
    private ArrayList<RailwayStation> railwayStations;
    private String name;

    public Network(String name) {
        this.links = new ArrayList<Link>();
        this.nodes = new ArrayList<Node>();
        this.railwayStations = new ArrayList<RailwayStation>();
        this.name = name;
    }

    public ArrayList<Link> getLinks() {
        return links;
    }

    public ArrayList<Node> getNodes() {
        return nodes;
    }

    public ArrayList<RailwayStation> getRailwayStations() {
        return railwayStations;
    }
}