package tooffer;
//求链表的中间节点。如果链表中节点总数为奇数，返回中间节点；如果节点总数是偶数，返回中间节点两个节点的任意一个节点

import utils.LinkList;
import utils.Node;
//链表带头结点
public class Offer15求链表的中间节点 {
    public static void main(String[] args)
    {
        Node head=LinkList.creatList();//类方法，可以不通过类实例来引用
        Node middle=GetMiddleNode(null);
    }
    public static Node GetMiddleNode(Node head)
    {
        if (head==null||head.next==null)
        {
            System.out.print("链表为空！没有中间节点！");
            return null;
        }
        Node slow=head.next;
        Node fast=slow.next;
        while(fast!=null&&slow!=null)
        {
            slow=slow.next;
            fast=fast.next;
            if (fast!=null)
                fast=fast.next;
        }
        return slow;
    }

}
