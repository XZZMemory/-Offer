package first;

import utils.NodeIntUtil;
import utils.myObject.NodeInt;

//两个递增排序的链表，合并两个链表并使新链表中的节点仍然是按照升序排列的。
public class Offer17合并两个排序的列表 {
    public static void main(String[] args) {
        int[] number1 = {1, 3, 5, 6, 7};
        int[] number2 = {2, 5, 8, 9};
        NodeInt head1 = NodeIntUtil.creatList(number1);
        NodeInt head2 = NodeIntUtil.creatList(number2);
        NodeInt head = merge(head1, head2);
        NodeIntUtil.traverseList(head);
    }

    public static NodeInt merge(NodeInt head1, NodeInt head2) {//head1 和head2均是带头节点的链表
        if ((head1 == null) || (head1.next == null)) {
            return head2;
        }
        if ((head2 == null) || (head2.next == null)) {
            return head1;
        }
        //以下操作均是在链表存储内容的前提下
        NodeInt p1 = head1.next;
        NodeInt p2 = head2.next;
        NodeInt p = head1;
        while ((p1 != null) && (p2 != null)) {
            if (p1.info < p2.info) {
                p.next = p1;
                p1 = p1.next;
            } else {
                p.next = p2;
                p2 = p2.next;
            }
            p = p.next;
        }
        if (p1 == null)
            p.next = p2;
        else if (p2 == null)
            p.next = p1;
        return head1;
    }
}
