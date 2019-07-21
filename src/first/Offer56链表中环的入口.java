package first;

import utils.myObject.NodeInt;

//一个链表中有环，如何找出环的入口节点
public class Offer56链表中环的入口 {
    public static void main(String[] args) {
        int[] data = {1, 2, 3, 4, 5, 6, 7, 8};
        NodeInt head = creatLinklist(null);
        NodeInt entryNode = findEntryNode(head);
        if (entryNode != null)
            System.out.println(entryNode.info);
    }

    //没有头结点，有环
    public static NodeInt creatLinklist(int[] number) {
        if (number == null || number.length == 0) {
            System.out.println("数据为空！");
            return null;
        }

        NodeInt p = new NodeInt();
        NodeInt q;
        NodeInt head = p;
        int middle = number.length / 2;
        NodeInt middleNode = new NodeInt();
        for (int i = 0; i < number.length; i++) {
            q = new NodeInt();
            q.info = number[i];
            q.next = null;
            if (i == 0) {
                p = q;
                head = p;
            } else {
                p.next = q;
                p = q;
            }
            if (middle == i)
                middleNode = p;
        }
        p.next = middleNode;
        return head;
    }

    //找到环中的某个节点
    public static NodeInt FindLoopNode(NodeInt head) {
        if (head == null)
            return null;
        NodeInt fast = head.next;
        NodeInt slow = head;
        while (slow != null && fast != null) {
            if (slow == fast)
                return fast;
            slow = slow.next;
            fast = fast.next;
            if (fast.next != null)
                fast = fast.next;
        }
        return null;
    }

    //找到入口节点
    public static NodeInt findEntryNode(NodeInt head) {
        if (head == null) {
            System.out.println("链表为空!");
            return null;
        }
        NodeInt mettingNode = FindLoopNode(head);
        if (mettingNode == null) {
            System.out.println("此链表中没有环！");
            return null;
        }
        //找到环的长度
        int lengthOfLinkList = 1;
        NodeInt fast = mettingNode.next;
        while (fast != mettingNode) {
            fast = fast.next;
            lengthOfLinkList++;
        }
        NodeInt index = head;
        while (lengthOfLinkList > 0) {
            index = index.next;
            lengthOfLinkList--;
        }
        NodeInt p = head;
        while (p != index) {
            p = p.next;
            index = index.next;
        }
        return p;
    }
}
