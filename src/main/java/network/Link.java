package network;

public class Link {

    private String id;
    private Node fromNode;
    private Node toNode;
    private int length;

    public Link(String id, Node fromNode, Node toNode) {
        this.id=id;
        this.fromNode=fromNode;
        this.toNode=toNode;
    }

    public Node getFromNode() {
        return fromNode;
    }

    public Node getToNode() {
        return toNode;
    }

    public int getLength() {
        return length;
    }
}
