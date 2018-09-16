package tooffer;

import utils.Node;

public class Offer13在O1时间删除链表节点 {
    public static void main(String[] args) {
        Node head=new Node();
        Node p=new Node();
        head=creatList();
        p=head.next;
        while(!(p.info=='e'))
            p=p.next;
        TraversalOfLinkList(head);
        int ff=(int)p.info;
        if (ff==0)
        {System.out.println("节点p的信息错误");}
        else
        {
            System.out.println("节点p的信息是：");
            System.out.println(p.info);
            DeleteNode(head,p);
            System.out.println("删除节点p后的链表是：");
            TraversalOfLinkList(head);
        }

    }

    public static Node creatList() {
        char[] string = "abcde".toCharArray();
        Node head = new Node();
        Node p = new Node();
        head = p;
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
    public static void TraversalOfLinkList(Node head)
    {
        Node p=new Node();
        p=head.next;
        while(p!=null)
        {
            System.out.println(p.info);
            p=p.next;
        }
    }
    public static void DeleteNode(Node head, Node p)
    {
        if(p.info==' ')
            System.out.println("删除节点信息为空，数据出错！");
        //第一个节点,这种情况存在于，头结点就存储数据，但我创建的链表head是一个指针不存储数据，指向第一个存储数据的节点，所以不需要考虑这种情况
        //最后一个节点，需要顺序遍历所有节点，找到节点p的前驱节点
        else if(p.next==null)
        {
            Node q=new Node();
            q=FindForwardNodeOfP(head,p);
            if (q==null) {
                System.out.println("找不到节点");
                return;
            }
            q.next=null;

        }
        //中间节点
        else
        {
            p.info=p.next.info;
            p.next=p.next.next;
        }
    }
    public static Node FindForwardNodeOfP(Node head, Node p)
    {
        Node q=new Node();
        q=head.next;
        while(q.next!=p)
            q=q.next;
        if (q==null)
            return null;
        return q;
    }
}