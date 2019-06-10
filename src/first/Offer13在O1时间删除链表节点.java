package first;

import utils.Node;

//链表带头结点
public class Offer13在O1时间删除链表节点 {
    public static void main(String[] args) {
        Node head = Node.creatList(new char[]{'a', 'b', 'c', 'd', 'e'});
        Node p = head.next;
        while (!(p.info == 'a'))
            p = p.next;
        Node.traverseList(head);//输出链表信息
        if (p == null)
            System.out.println("没有找到这个节点！节点p的信息错误");
        else {
            System.out.println("节点p的信息是：" + p.info);
            deleteNode(head, p);
            System.out.println("删除节点p后的链表是：");
            Node.traverseList(head);
        }
    }

    public static void deleteNode(Node head, Node p) {
        if (p == null) {
            System.out.println("删除节点信息为空，数据出错！");
            return;
        }
        //第一个节点,这种情况存在于，头结点就存储数据，但我创建的链表head是一个指针,不存储数据，指向第一个存储数据的节点，所以不需要考虑这种情况
        //1-p是最后一个节点，需要顺序遍历所有节点，找到节点p的前驱节点
        if (p.next == null) {
            Node q = findForwardNodeOfP(head, p);
            if (q == null) {
                System.out.println("找不到节点");
                return;
            }
            q.next = null;
        }
        //2-p是中间节点
        else {
            p.info = p.next.info;
            p.next = p.next.next;
        }
    }

    //节点p没有后继节点，需要找到节点的前一个节点进行删除操作
    public static Node findForwardNodeOfP(Node head, Node p) {
        Node q = head.next;
        while (q != null && q.next != p)
            q = q.next;
        if (q == null)
            return null;
        return q;
    }
}