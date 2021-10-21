package router;

import network.Link;
import network.RailwayStation;

import java.util.ArrayList;

public class Route {

    private ArrayList<Link> links;
    private RailwayStation fromStation;
    private RailwayStation toStation;

    public Route(Link startLink) {
        this.links = new ArrayList<>();
        links.add(startLink);
        this.fromStation = startLink.getFromStation();
        this.toStation = startLink.getToStation();
    }

    public void addLink(Link nextLink) {
        Link lastLink = links.get(links.size()-1);
        if (nextLink.getFromStation().getName().equals(lastLink.getToStation().getName())) {
            links.add(nextLink);
            toStation = nextLink.getToStation();
        } else {
            System.out.println("next link must be adjacent to the last one");
        }
    }

    public void removeLastLink(Link lastLink) {
        links.remove(links.size()-1);
    }

    public RailwayStation getFromStation() {
        return fromStation;
    }

    public RailwayStation getToStation() {
        return toStation;
    }
}
