package utils.myObject;

public class ComplexNode {
    public char info;
    public ComplexNode next;
    public ComplexNode sibling;

    public ComplexNode(char info) {
        this.info = info;
        this.next = null;
        this.sibling = null;
    }

    public ComplexNode() {
    }
}
