package 第二遍;

import utils.NodeInt;

/**
 * created by memory
 * on 2019/6/3 下午7:36
 */
//两个递增排序的链表，合并两个链表并使新链表中的节点仍然是按照升序排列的。
public class Offer17合并两个排序的列表 {
    public static void main(String[] args) {
        int[] number1 = {1, 3, 5, 6, 7};
        int[] number2 = {2, 5, 8, 9};
        /*创建的是带头节点的链表*/
        NodeInt head1 = NodeInt.creatList(number1);
        NodeInt.traverseList(head1);
        NodeInt head2 = NodeInt.creatList(number2);
        NodeInt.traverseList(head2);
        NodeInt head = merge(head1, head2);
        NodeInt.traverseList(head);
    }

    public static NodeInt merge(NodeInt head1, NodeInt head2) {

        if (head1 == null || head1.next == null) {
            return head2;
        }
        if (head2 == null || head2.next == null) {
            return head1;
        }
        NodeInt p1 = head1.next;
        NodeInt p2 = head2.next;
        NodeInt p = head1;
        p.next = null;
        while (p1 != null && p2 != null) {
            if (p1.info < p2.info) {
                p.next = p1;
                p1 = p1.next;
            } else {
                p.next = p2;
                p2 = p2.next;
            }
            p = p.next;
            p.next = null;
        }
        if (p1 != null) {
            p.next = p1;
        }
        if (p2 != null) {
            p.next = p2;
        }
        return head1;
    }
}
