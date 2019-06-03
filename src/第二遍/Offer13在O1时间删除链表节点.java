package 第二遍;

import utils.LinkList;
import utils.Node;

/**
 * created by memory
 * on 2019/6/3 下午3:25
 */
public class Offer13在O1时间删除链表节点 {
    public static void main(String[] args) {
        Node head = LinkList.creatList(new char[]{'a', 'b', 'c', 'd', 'e'});
        Node p = head.next;
        while (!(p.info == 'e'))
            p = p.next;
        p = null;
        LinkList.traverseList(head);//输出链表信息
        deleteNode(head, p);
        LinkList.traverseList(head);//输出链表信息

    }

    /* 在O(1)在带头结点的链表中，删除链表中的节点p*/
    public static void deleteNode(Node head, Node p) {
        if (head == null || head.next == null || p == null) {
            System.out.println("节点为空！");
            return;
        }
        Node next = p.next;
        /*是链表最后一个节点*/
        if (next == null) {
            Node forwardNode = findForwardNode(head, p);
            if (forwardNode == null) {
                System.out.println("节点信息出错，找不到前驱节点！");
                return;
            }
            forwardNode.next = null;
        } else {
            /* p是中间节点*/
            p.info = next.info;
            p.next = next.next;
        }
    }

    public static Node findForwardNode(Node head, Node p) {
        Node currentNode = head;
        while (currentNode != null) {
            if (currentNode.next == p) {
                return currentNode;
            }
            currentNode = currentNode.next;
        }
        return null;
    }
}
