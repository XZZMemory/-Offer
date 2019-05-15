//在复杂链表中，每个节点除了有一个next指针外，还有一个指针Sibling指向链表的任意节点或者null
//指向下一节点的指针和指向任意节点的指针
package offer;

import utils.ComplexNode;

public class Offer26复杂链表的复制 {
    public static void main(String[] args) {
        System.out.println("原始复杂链表是：");
        ComplexNode head = ComplexNode.creatComplexNode();
        head.traversalOfComplexNode(head);
        System.out.println("把每个节点复制一遍之后是：");
        cloneNodes(head);
        connectSiblingNodes(head);
        head.traversalOfComplexNode(head);
        ComplexNode head2 = reConnectNodes(head);
        System.out.println("复制之后头节点链表是：");
        head.traversalOfComplexNode(head);
        System.out.println("复制之后复制的头节点链表是");
        head2.traversalOfComplexNode(head2);
    }

    //分为三步，next，silbing-复制下一节点，分离
    public static void cloneNodes(ComplexNode head) {
        if (head == null)
            return;
        ComplexNode p = head;
        while (p != null) {
            ComplexNode pCloned = new ComplexNode();
            pCloned.info = p.info;
            pCloned.next = p.next;
            pCloned.sibling = null;
            p.next = pCloned;
            p = pCloned.next;
        }
    }

    public static void connectSiblingNodes(ComplexNode head) {
        if (head == null)
            return;
        ComplexNode p = head;
        while (p != null) {
            if (p.sibling == null) ;
            else
                p.next.sibling = p.sibling.next;
            p = p.next.next;
        }
    }

    public static ComplexNode reConnectNodes(ComplexNode head) {//时刻考虑指针为空
        if (head == null || head.next == null) {
            return null;
        }
        ComplexNode p = head;
        ComplexNode pCloned = p.next;
        ComplexNode head2 = pCloned;
        p.next = pCloned.next;
        p = p.next;
        while (p != null) {
            pCloned.next = p.next;
            pCloned = pCloned.next;
            p.next = pCloned.next;
            p = p.next;
        }
        return head2;
    }
}
