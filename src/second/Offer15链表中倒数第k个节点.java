package second;

import utils.Node;

/**
 * created by memory
 * on 2019/6/3 下午4:36
 */
public class Offer15链表中倒数第k个节点 {
    public static void main(String[] args) {
        char[] data = "12345".toCharArray();
        Node head = Node.creatList(data);//创建带头结点的链表
        Node.traverseList(head);
        Node lastKNode = lastK(head, 1);
        if (lastKNode == null) {
            System.out.println("找不到节点");
        } else {
            System.out.println("节点信息是： " + lastKNode.info);
        }
    }


    public static Node lastK(Node head, int k) {
        if (head == null || k < 1) {
            return null;
        }
        Node fast = head;
        Node slow = head;
        while (k > 0 && fast != null) {
            fast = fast.next;
            k--;
        }
        if (fast == null) {
            return null;
        }
        while (fast != null) {
            fast = fast.next;
            slow = slow.next;
        }
        return slow;
    }
}
