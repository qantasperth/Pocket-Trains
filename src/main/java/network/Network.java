package network;

import java.util.ArrayList;
import java.util.HashMap;

public class Network {

    private ArrayList<Link> links;
    private HashMap<String, RailwayStation> railwayStations;
    private String name;

    public Network(String name) {
        this.links = new ArrayList<>();
        this.railwayStations = new HashMap<>();
        this.name = name;
    }

    public ArrayList<Link> getLinks() {
        return links;
    }

    public HashMap<String, RailwayStation> getRailwayStations() {
        return railwayStations;
    }

}