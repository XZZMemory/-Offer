
package utils.myObject;

public class Node {
    public char info;
    public Node next;


    /**
     * 无参构造方法
     */
    public Node() {
    }

    /**
     * 全参构造方法
     * @param info 节点值
     * @param next next节点
     */
    public Node(char info, Node next) {
        this.info = info;
        this.next = next;
    }

    public Node(char info) {
        this.info = info;
        this.next = null;
    }

    public char getInfo() {
        return info;
    }

    public void setInfo(char info) {
        this.info = info;
}

    public Node getNext() {
        return next;
    }

    public void setNext(Node next) {
        this.next = next;
    }
}
