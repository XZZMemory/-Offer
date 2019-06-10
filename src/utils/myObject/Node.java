package utils.myObject;

public class Node {
    public char info;
    public Node next;

    public Node(char info, Node next) {
        this.info = info;
        this.next = next;
    }

    public Node(char info) {
        this.info = info;
        this.next = null;
    }

    public Node() {
    }
}
