package offer;
//输入连个链表，找出它们的第一个公共节点。
//1,2,3,6,7
//  4,5,6,7

import utils.LinkList;
import utils.NodeInt;

import java.util.Stack;

public class 第37两个链表的第一个公共节点 {
    public static void main(String[] args) {
        int[] data1 = {1, 2, 3};
        int[] data2 = {4, 5, 6};
        int[] sameData = {7, 8, 9, 10};
        //带头结点的链表，数据是int型数据
        NodeInt head1 = LinkList.creatList(data1);
        NodeInt head2 = LinkList.creatList(data2);
        NodeInt sameDataHead = LinkList.creatList(sameData);
        NodeInt p = new NodeInt();
        for (p = head1; p.next != null; p = p.next) ;
        p.next = sameDataHead.next;
        for (p = head2; p.next != null; p = p.next) ;
        p.next = sameDataHead.next;
        /////创建两个链表完毕
        //head1=null;
        //head2=null;
        NodeInt sameNode = findFirstCommonNode1(head1, head2);
    }

    //解法1-时间复杂度O(m+n),不需要辅助空间
    public static NodeInt findFirstCommonNode1(NodeInt head1, NodeInt head2) {
        NodeInt sameNode = new NodeInt();
        int length1 = getListLength(head1);
        int length2 = getListLength(head2);
        if (length1 == 0 || length2 == 0) {
            System.out.println("链表节点为空！不存在公共节点");
            return null;
        }
        int nLengthDif = Math.abs(length1 - length2);
        NodeInt pOfHead1 = head1.next;
        NodeInt pOfHead2 = head2.next;
        if (length1 > length2) {
            for (int i = 1; i <= nLengthDif; i++)
                pOfHead1 = pOfHead1.next;
        } else {
            for (int i = 1; i <= nLengthDif; i++)
                pOfHead2 = pOfHead2.next;
        } //差出来的节点已经过滤掉
        while ((pOfHead1 != null) && (pOfHead2 != null) && (pOfHead1 != pOfHead2)) {
            pOfHead1 = pOfHead1.next;
            pOfHead2 = pOfHead2.next;
        }
        sameNode = pOfHead1;
        return sameNode;
    }

    public static int getListLength(NodeInt head) {
        if (head == null || head.next == null)
            return 0;
        int length = 0;
        NodeInt p = new NodeInt();
        p = head.next;
        while (p != null) {
            length++;
            p = p.next;
        }
        return length;
    }

    //解法2-时间复杂度O(m+n),需要用到辅助空间栈
    public static NodeInt findFirstCommonNode2(NodeInt head1, NodeInt head2) {
        if (head1 == null || head2 == null)
            return null;
        Stack<NodeInt> stack1 = new Stack<>();
        Stack<NodeInt> satck2 = new Stack<>();
        NodeInt p1 = head1.next;
        NodeInt p2 = head2.next;
        while (p1 != null) {
            stack1.push(p1);
            p1 = p1.next;
        }
        while (p2 != null) {
            satck2.push(p2);
            p2 = p2.next;
        }
        NodeInt sameNode = null;
        /**
         *    Node  a=new Node(); a不是null，a.next是null
         */
        p1 = stack1.pop();
        p2 = satck2.pop();
        while (p1 == p2 && (!stack1.isEmpty()) && (!satck2.isEmpty())) {
            if (sameNode == null)
                sameNode = new NodeInt();
            sameNode = p1;
            p1 = stack1.pop();
            p2 = satck2.pop();
        }
        return sameNode;
    }
}
