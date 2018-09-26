package tooffer;

import utils.LinkList;
import utils.Node;

/*输入一个链表的头结点，反转该链表并输出反转后的链表节点内容，不需创建新的节点复制链表再进行反转
* 链表带头结点*/
public class Offer16反转链表 {
    public static void main(String[] args)
    {
        Node head=new Node();
        head=LinkList.creatList();
        LinkList.TraversalOfLinklistWithHead(head);//类方法可以直接用类名.方法访问，不需要类的实例就可以访问
        Node head2=new Node();
        head2=Reverse(head);
        if(head2==null)
            return;
        System.out.println("反转后的链表为：");
        LinkList.TraversalofLinklistWithoutHead(head2);
    }
    public static Node Reverse(Node head)
    {
        if (head==null)
        {
            return null;
        }
        Node p,q,r;
        p=new Node();
        q=new Node();
        r=new Node();
        p=head.next;
        if(p==null)
        {
            System.out.println("链表为空！");
            return null;
        }
        q=p.next;
        if(q==null)
        {
            System.out.println("链表只有一个节点！不需要反转");
            return p;
        }
        p.next=null;
        r=q.next;
        while (q!=null)
        {
            q.next=p;
            p=q;
            q=r;
            r=r.next;
            if (r==null)
                break;;
        }
        q.next=p;
        return q;
    }

}
