package network;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.HashSet;

public class Network {

    private HashMap<String, Link> links;
    private HashMap<String, RailwayStation> railwayStations;
    private String name;

    public Network(String name) {
        this.links = new HashMap<>();
        this.railwayStations = new HashMap<>();
        this.name = name;
    }

    public HashMap<String, Link> getLinks() {
        return links;
    }

    public HashMap<String, RailwayStation> getRailwayStations() {
        return railwayStations;
    }

}