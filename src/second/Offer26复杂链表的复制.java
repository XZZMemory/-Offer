package second;

import utils.ComplexNodeUtil;
import utils.myObject.ComplexNode;

/**
 * created by memory
 * on 2019/6/10 下午9:55
 */
public class Offer26复杂链表的复制 {
    public static void main(String[] args) {
        System.out.println("原始复杂链表是：");
        ComplexNode head = ComplexNodeUtil.creatComplexNode();
        ComplexNodeUtil.traversalOfComplexNode(head);
        ComplexNode newHead = cloneNodes(head);
        ComplexNodeUtil.traversalOfComplexNode(newHead);

    }

    public static ComplexNode cloneNodes(ComplexNode head) {
        if (head == null) {
            return null;
        }
        cloneNext(head);
        cloneSibling(head);
        return depart(head);
    }

    public static void cloneNext(ComplexNode head) {
        if (head == null) {
            return;
        }
        ComplexNode p = head;
        ComplexNode next;
        while (p != null) {
            next = p.next;
            ComplexNode newNode = new ComplexNode();
            newNode.info = p.info;
            p.next = newNode;
            newNode.next = next;
            p = next;
        }
    }

    public static void cloneSibling(ComplexNode head) {
        if (head == null) {
            return;
        }
        ComplexNode p = head;
        ComplexNode next;
        ComplexNode nextNext;
        while (p != null) {
            next = p.next;
            nextNext = p.next.next;
            if (p.sibling != null) {
                next.sibling = p.sibling.next;
            }
            p = nextNext;
        }
    }

    /*碰到一个问题：拆分的时候如何处理空指针问题*/
    public static ComplexNode depart(ComplexNode head) {
        if (head == null) {
            return null;
        }
        ComplexNode newHead = head.next;
        ComplexNode p = head;
        ComplexNode next;
        ComplexNode pNew;
        while (p != null) {
            pNew = p.next;
            next = pNew.next;
            p.next = pNew.next;
            if (next != null) {
                pNew.next = next.next;
            } else {
                pNew.next = null;
            }
            p = next;
        }
        return newHead;
    }
}
