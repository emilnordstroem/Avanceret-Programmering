package lektion01KoeDatastruktur.queue;

public class Node {
    private Object data;
    private Node nextNode;

    public Node(Object data) {
        this.data = data;
    }

    public Object getData() {
        return data;
    }

    public Node getNextNode() {
        return nextNode;
    }

    public void setData(Object data) {
        this.data = data;
    }

    public void setNextNode(Node nextNode) {
        this.nextNode = nextNode;
    }

}
