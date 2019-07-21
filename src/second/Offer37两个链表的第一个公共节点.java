package second;

import utils.NodeIntUtil;
import utils.myObject.NodeInt;

import java.util.Stack;

/**
 * created by memory
 * on 2019/7/21 11 18
 */
public class Offer37两个链表的第一个公共节点 {
    public static void main(String[] args) {
        int[] data1 = {1, 3};
        int[] data2 = {4, 5, 6};
        int[] sameData = {7, 8, 9, 10};
        /**
         * 创建带头结点的链表，创建初始链表
         */
        NodeInt head1 = NodeIntUtil.creatList(data1);
        NodeInt head2 = NodeIntUtil.creatList(data2);
        NodeInt sameDataHead = NodeIntUtil.creatList(sameData);
        NodeInt p;
        for (p = head1; p.next != null; p = p.next) ;
        p.next = sameDataHead.next;
        for (p = head2; p.next != null; p = p.next) ;
        p.next = sameDataHead.next;
        NodeInt same = findFirstCommonNode2(head1, head2);
        if (same != null) {
            System.out.println("公共节点的信息是：" + same.info);
        } else {
            System.out.println("未找到公共节点");
        }
    }

    /**
     * 得到两个链表的长度，一个走的快一个走得慢，找到公共节点，直至遍历两个链表
     *
     * @param head1
     * @param head2
     * @return
     */
    public static NodeInt findFirstCommonNode1(NodeInt head1, NodeInt head2) {
        if (head1 == null || head1.next == null || head2 == null || head2.next == null) {
            return null;
        }
        int length1 = getListLength(head1);
        int length2 = getListLength(head2);
        NodeInt p1 = head1;
        NodeInt p2 = head2;
        if (length1 > length2) {
            int dif = length1 - length2;
            for (int i = 0; i < dif; i++) {
                p1 = p1.next;
            }
        }
        if (length1 < length2) {
            int dif = length2 - length1;
            for (int i = 0; i < dif; i++) {
                p2 = p2.next;
            }
        }
        while (p1 != null && p2 != null) {
            if (p1 == p2) {
                return p1;
            }
            p1 = p1.next;
            p2 = p2.next;
        }
        return null;
    }

    public static int getListLength(NodeInt head) {
        if (head == null || head.next == null) {
            return 0;
        }
        int length = 0;
        NodeInt p = head.next;
        while (p != null) {
            ++length;
            p = p.next;
        }
        return length;
    }

    /**
     * 利用栈，分别存储两个链表的信息，利用栈倒叙遍历两个链表
     */
    public static NodeInt findFirstCommonNode2(NodeInt head1, NodeInt head2) {
        if (head1 == null || head1.next == null || head2 == null || head2.next == null) {
            return null;
        }
        Stack<NodeInt> stack1 = new Stack<>();
        Stack<NodeInt> stack2 = new Stack<>();
        NodeInt p1 = head1.next;
        while (p1 != null) {
            stack1.push(p1);
            p1 = p1.next;
        }
        NodeInt p2 = head2.next;
        while (p2 != null) {
            stack2.push(p2);
            p2 = p2.next;
        }
        NodeInt sameNode = null;
        while (!stack1.isEmpty() && !stack2.isEmpty()) {
            p1 = stack1.pop();
            p2 = stack2.pop();
            if (p1 == p2) {
                sameNode = p1;
            }
        }
        return sameNode;
    }
}
