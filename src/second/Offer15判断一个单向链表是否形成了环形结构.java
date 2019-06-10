package second;

import utils.NodeUtil;
import utils.myObject.Node;

/**
 * created by memory
 * on 2019/6/3 下午4:09
 */
public class Offer15判断一个单向链表是否形成了环形结构 {
    public static void main(String[] args) {
        Node head1 = NodeUtil.creatList(); //无环
        Node head2 = NodeUtil.creatListCircle();    //有环
        System.out.println(isCircle(head1));
        System.out.println(isCircle(head2));
        System.out.println(isCircle(null));
    }

    public static boolean isCircle(Node head) {
        if (head == null) {
            return false;
        }
        Node slow = head;
        Node fast = head.next;
        while (fast != null && fast.next != null) {
            if (fast == slow) {
                return true;
            }
            slow = slow.next;
            fast = fast.next.next;
        }
        return false;
    }
}
