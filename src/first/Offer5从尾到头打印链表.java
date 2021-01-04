package first;

import utils.NodeUtil;
import utils.myObject.Node;

import java.util.Objects;
import java.util.Stack;


/**
 * 问题:输入一个链表的头结点,从尾到头打印出每个节点的值(从尾到头,栈的特点,考虑用栈)
 */
public class Offer5从尾到头打印链表 {
    public static void main(String[] args) {
        Node head = NodeUtil.createListWithoutHead();
        System.out.print("原始链表信息: ");
        NodeUtil.traverseListWithoutHead(head);
        System.out.print("利用栈特性,从尾到头访问: ");
        printListReverselyWithStack(head);
        System.out.println();
        System.out.print("利用递归,从尾到头访问: ");
        printListReverselyRecursively(head);
    }

    public static void printListReverselyWithStack(Node head) {
        if (head == null || head.next == null)
            return;
        Node p = head;
        Stack<Node> stack = new Stack<>();
        while (p != null) {
            stack.push(p);
            p = p.next;
        }
        traversalOfStack(stack);
    }

    //遍历栈
    public static void traversalOfStack(Stack<Node> stack) {
        if (Objects.isNull(stack))
            return;
        while (!stack.isEmpty())
            System.out.print(stack.pop().info + " ");
    }

    public static void printListReverselyRecursively(Node p) {
        if (Objects.isNull(p))
            return;
        printListReverselyRecursively(p.next);
        System.out.print(p.info + " ");
    }
}