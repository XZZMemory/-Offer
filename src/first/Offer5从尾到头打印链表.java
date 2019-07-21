package first;//输入一个链表的头结点，从尾到头打印出每个节点的值(从尾到头，栈的特点，考虑用栈)

import utils.NodeUtil;
import utils.myObject.Node;

import java.util.Stack;

public class Offer5从尾到头打印链表 {
    public static void main(String[] args) {
        Node head = NodeUtil.creatList();
        System.out.print("利用栈，从尾到头访问：");
        printListReversinglyIterratively(head);
        System.out.println();
        System.out.print("利用递归，从尾到头访问：");
        printListReversinglyRecursively(head);
    }

    public static void printListReversinglyIterratively(Node head) {
        if (head == null || head.next == null)
            return;
        Node p = head.next;
        Stack<Node> stack = new Stack<>();
        while (p != null) {
            stack.push(p);
            p = p.next;
        }
        traversalOfStack(stack);
    }

    //遍历栈
    public static void traversalOfStack(Stack<Node> stack) {
        if (stack == null)
            return;
        while (!stack.isEmpty())
            System.out.print(stack.pop().info + " ");
    }

    public static void printListReversinglyRecursively(Node head) {
        if (head == null || head.next == null)
            return;
        printListReversinglyRecursivelyWithoutHead(head.next);
    }

    public static void printListReversinglyRecursivelyWithoutHead(Node p) {
        if (p == null)
            return;
        printListReversinglyRecursivelyWithoutHead(p.next);
        System.out.print(p.info + " ");
    }
}
