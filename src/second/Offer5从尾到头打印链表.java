package second;

import utils.NodeUtil;
import utils.myObject.Node;

import java.util.Stack;

/**
 * created by memory
 * on 2019/5/30 下午3:50
 */
public class Offer5从尾到头打印链表 {
    public static void main(String[] args) {
        Node head = NodeUtil.creatListNoHead();
        System.out.println("原始链表信息是：");
        NodeUtil.traverseListNoHead(head);
        System.out.println("利用栈方法从尾到有打印链表信息是：");
        printListReverCircularly(head);
        System.out.println("递归方法从尾到有打印链表信息是：");
        printListReverRecursively(head);
    }

    public static void printListReverCircularly(Node p) {
        if (p == null) {
            System.out.println("链表为空！");
            return;
        }
        Stack<Node> stack = new Stack<>();
        while (p != null) {
            stack.push(p);
            p = p.next;
        }
        while (!stack.isEmpty()) {
            System.out.print(stack.pop().info + " ");
        }
        System.out.println();
    }

    public static void printListReverRecursively(Node p) {
        if (p == null) {
            return;
        }
        printListReverRecursively(p.next);
        System.out.print(p.info + " ");
    }
}
