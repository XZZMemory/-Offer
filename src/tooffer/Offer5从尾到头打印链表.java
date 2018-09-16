package tooffer;//输入一个链表的头结点，从尾到头打印出每个节点的值(从尾到头，栈的特点，考虑用栈)
import utils.Node;

public class Offer5从尾到头打印链表 {
    public static void main(String[] args)
    {
        Node head=new Node();
        Node p=new Node();
        head=creatList();
        p=head.next;
        char[] stack=new char[100];
        int top=0;
        while(p!=null)
        {
            stack[++top]=p.info;
            p=p.next;
        }
        TraversalOfStack(stack,top);



    }
    //遍历栈
    public static  void TraversalOfStack(char[] stack,int top)
    {
        while(top>0)
        {
            System.out.println(stack[top--]);
        }
    }
    //创建带头结点的链表
    public static Node creatList()
    {
        char[] string="abcde".toCharArray();
        Node head=new Node();
        Node p=new Node();
        head=p;
        Node q;
        for (int i=0;i<string.length;i++)
        {
            q=new Node();
            q.info=string[i];
            q.next=null;
            p.next=q;
            p=q;
        }
        return head;
    }
}
