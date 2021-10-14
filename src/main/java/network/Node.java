package network;

public class Node {

    int x;
    int y;
    String id;

    public Node(int x, int y, String id) {
        this.x=x;
        this.y=y;
        this.id=id;
    }

    public void setX(int x) {
        this.x = x;
    }

    public void setY(int y) {
        this.y=y;
    }

    public void setId(String id) {
        this.id = id;
    }

    public int getX() {
        return x;
    }

    public int getY() {
        return y;
    }

    public String getId() {
        return id;
    }
}
