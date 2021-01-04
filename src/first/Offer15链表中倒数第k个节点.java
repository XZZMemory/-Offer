package first;

import utils.NodeUtil;
import utils.myObject.Node;

import java.util.Scanner;

/*robost 代码的鲁棒性，程序能够判断是否合乎规范要求，并对不合要求的输入予以合理的处理
 *访问单向链表倒数第k个节点
 *思考：期待的解法是只遍历链表一次
 * 当我们用一个指针遍历链表不能解决问题时，可以尝试用两个指针来遍历链表，可以让其中一个指针遍历的速度快一些，或者让它先在链表上走若干步*/
public class Offer15链表中倒数第k个节点 {
    public static void main(String[] args) {
        char[] data = "12345".toCharArray();
        Node head = NodeUtil.createListWithHead(data);//创建带头结点的链表
        System.out.println("访问链表的倒数度k个节点，请输入n，在0和" + data.length + "之间");
        Scanner scanner = new Scanner(System.in);
        int k = scanner.nextInt();//
        if (k < 0 || k > data.length) {
            System.out.println("参数k错误！");
            return;
        }
        Node p = findKNode(head, k);
        if (p != null)
            System.out.println(p.info);
    }

    public static Node findKNode(Node head, int k) {//传入的参数k一定大于0；带头结点的链表
        if (head == null || head.next == null) {
            return null;
        }
        int kk = 0;
        Node p = head;
        Node q = head;
        while ((p != null)) {
            p = p.next;
            kk++;
            if (kk == k)
                break;
        }
        if (p == null) {
            System.out.println("链表的节点个数不足" + k + "个！，输入的k超出范围，应该在链表长度范围内");
            return null;
        }
        while (p != null) {
            p = p.next;
            q = q.next;
        }
        return q;
    }
}
