package utils;

import utils.myObject.NodeInt;

/**
 * created by memory
 * on 2019/6/10 下午9:00
 */
public class NodeIntUtil {
    /*创建的是带头结点的链表，链表数据是int型数据*/
    public static NodeInt creatList(int[] number) {
        NodeInt p = new NodeInt();
        NodeInt q;
        NodeInt head = p;
        for (int i = 0; i < number.length; i++) {
            q = new NodeInt(number[i]);
            p.next = q;
            p = q;
        }
        return head;
    }

    public static void traverseList(NodeInt head) {
        if ((head == null) || (head.next == null)) {
            System.out.println("链表为空！");
            return;
        }
        NodeInt p = head.next;
        while (p != null) {
            if (p.next != null) {
                System.out.print(p.info + " -> ");
            } else {
                System.out.println(p.info);
            }
            p = p.next;
        }
    }
}
