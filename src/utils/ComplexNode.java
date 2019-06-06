package utils;

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

    public static ComplexNode creatComplexNode() {
        ComplexNode head = new ComplexNode('A');
        ComplexNode b = new ComplexNode('B');
        ComplexNode c = new ComplexNode('C');
        ComplexNode d = new ComplexNode('D');
        ComplexNode e = new ComplexNode('E');
        head.next = b;
        head.sibling = c;
        b.next = c;
        b.sibling = e;
        c.next = d;
        d.next = e;
        d.sibling = b;
        return head;
    }

    public static void traversalOfComplexNode(ComplexNode head) {
        if (head == null) {
            System.out.println("复杂链表为空！");
            return;
        }
        ComplexNode p = head;
        while (p != null) {
            System.out.print(p.info + " ");
            if (p.next != null)
                System.out.print(p.next.info + " ");
            else
                System.out.print("空 ");
            if (p.sibling == null)
                System.out.println("空");
            else
                System.out.println(p.sibling.info);
            p = p.next;
        }
    }
}
