package utils;

import utils.myObject.Node;

import java.util.Objects;

/**
 * 链表工具类
 * created by memory
 * on 2019/6/10 下午8:59
 */
public class NodeUtil {
    /**
     * 创建无头节点的链表
     *
     * @return
     */
    public static Node createListWithoutHead(char... charArray) {
        if (Objects.isNull(charArray) || charArray.length < 1) {
            charArray = "abde".toCharArray();
        }
        Node p = new Node();
        Node head = p;
        head.info = charArray[0];
        Node q;
        for (int i = 1; i < charArray.length; i++) {
            q = new Node();
            q.info = charArray[i];
            q.next = null;
            p.next = q;
            p = q;
        }
        return head;
    }

    /**
     * 创建带头节点的链表
     *
     * @param charArray
     * @return
     */
    public static Node createListWithHead(char... charArray) {
        if (Objects.isNull(charArray) || charArray.length < 1) {
            charArray = "abde".toCharArray();
        }
        Node p = new Node();
        Node head = p;
        Node q;
        for (int i = 0; i < charArray.length; i++) {
            q = new Node();
            q.info = charArray[i];
            q.next = null;
            p.next = q;
            p = q;
        }
        return head;
    }

    /**
     * 创建环形-无头节点链表
     *
     * @param charArray
     * @return
     */
    public static Node createCircularListWithoutHead(char... charArray) {
        if (Objects.isNull(charArray) || charArray.length < 1) {
            charArray = "abcde".toCharArray();
        }
        Node p = new Node();
        Node head = p;
        Node q;
        for (char info : charArray) {
            q = new Node();
            q.info = info;
            q.next = null;
            p.next = q;
            p = q;
        }
        p.next = head;
        return head;
    }

    /**
     * 遍历带头结点的链表
     *
     * @param head
     */
    public static void traverseListWithHead(Node head) {
        if (head == null) {
            System.out.println("链表为空！");
            return;
        }
        Node p = head.next;
        while (p != null) {
            if (p.next != null) {
                System.out.print(p.info + " -> ");
            } else {
                System.out.println(p.info);
            }
            p = p.next;
        }
        System.out.println();
    }

    /**
     * 遍历无头节点的链表
     *
     * @param head
     */
    public static void traverseListWithoutHead(Node head) {
        if (Objects.isNull(head)) {
            System.out.println("链表为空!");
            return;
        }
        Node p = head;
        while (Objects.nonNull(p)) {
            System.out.print(p.info + " ");
            p = p.next;
        }
        System.out.println();
    }
}
