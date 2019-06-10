package utils;

import utils.myObject.Node;

/**
 * created by memory
 * on 2019/6/10 下午8:59
 */
public class NodeUtil {
    /* 默认创建的是带头结点的链表，无头结点的函数名中会特殊说明*/
    public static Node creatList() {
        char[] string = "abde".toCharArray();
        Node p = new Node();
        Node head = p;
        Node q;
        for (int i = 0; i < string.length; i++) {
            q = new Node();
            q.info = string[i];
            q.next = null;
            p.next = q;
            p = q;
        }
        return head;
    }

    public static Node creatListNoHead() {
        char[] string = "abde".toCharArray();
        Node p = new Node();
        Node head = p;
        head.info = string[0];
        Node q;
        for (int i = 1; i < string.length; i++) {
            q = new Node();
            q.info = string[i];
            q.next = null;
            p.next = q;
            p = q;
        }
        return head;
    }

    public static Node creatListNoHead(char[] string) {
        Node p = new Node();
        Node head = p;
        head.info = string[0];
        Node q;
        for (int i = 1; i < string.length; i++) {
            q = new Node();
            q.info = string[i];
            q.next = null;
            p.next = q;
            p = q;
        }
        return head;
    }

    public static Node creatList(char[] data) {
        Node p = new Node();
        Node head = p;
        Node q;
        for (int i = 0; i < data.length; i++) {
            q = new Node();
            q.info = data[i];
            q.next = null;
            p.next = q;
            p = q;
        }
        return head;
    }

    public static Node creatListCircle() {
        char[] string = "abcde".toCharArray();
        Node p = new Node();
        Node head = p;
        Node q;
        for (int i = 0; i < string.length; i++) {
            q = new Node();
            q.info = string[i];
            q.next = null;
            p.next = q;
            p = q;
        }
        p.next = head;
        return head;
    }

    public static void traverseList(Node head) {
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

    public static void traverseListNoHead(Node head) {
        if (head == null) {
            System.out.println("链表为空!");
            return;
        }
        Node p = head;
        while (p != null) {
            System.out.print(p.info + " ");
            p = p.next;
        }
        System.out.println();
    }
}
