package offer;

import utils.NodeInt;

public class Offer57删除链表中重复的节点 {
    public static void main(String[] args) {
        int[] data = {1, 2, 3, 3, 3, 4, 4, 5};//1，2，5
        NodeInt head = NodeInt.creatList(data);
        head = deleteDulicaption(head);
    }

    public static NodeInt deleteDulicaption(NodeInt head) {
        NodeInt pre = head;
        NodeInt p = head.next;
        while (p != null) {
            NodeInt q = p.next;
            boolean flag = false;
            while (q != null && p.info == q.info) {
                flag = true;
                q = q.next;
            }
            if (flag) {
                pre.next = q;
                p = q;
            } else {
                pre = p;
                p = q;
            }
        }
        return head;
    }
}
