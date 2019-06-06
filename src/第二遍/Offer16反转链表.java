package 第二遍;

import utils.Node;

/**
 * created by memory
 * on 2019/6/3 下午7:22
 */
/*输入一个链表的头结点，反转该链表并输出反转后的链表节点内容，不需创建新的节点复制链表再进行反转
 * 链表带头结点*/
public class Offer16反转链表 {
    public static void main(String[] args) {
        Node head = Node.creatList();
        Node.traverseList(head);//类方法可以直接用类名.方法访问，不需要类的实例就可以访问
        Node head2 = reverse(head);
        Node.traverseList(head2);
    }

    public static Node reverse(Node head) {
        if (head == null || head.next == null) {
            return head;
        }
        Node head2 = head;
        Node p = head.next;
        head2.next = null;
        Node q;
        while (p != null) {
            q = p.next;
            p.next = head2.next;
            head2.next = p;
            p = q;
        }
        return head2;
    }
}
