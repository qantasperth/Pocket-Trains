package network;

public class Link {

    private String id;
    private RailwayStation fromStation;
    private RailwayStation toStation;
    private int length;

    public Link(String id, RailwayStation fromStation, RailwayStation toStation) {
        this.id=id;
        this.fromStation = fromStation;
        this.toStation = toStation;
    }

    public RailwayStation getFromStation() {
        return fromStation;
    }

    public RailwayStation getToStation() {
        return toStation;
    }

    public String getId() {
        return id;
    }

    public int getLength() {
        return length;
    }
}
