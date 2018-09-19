package tooffer;

import utils.Node;

import java.util.Scanner;

//robost 代码的鲁棒性，程序能够判断是否合乎规范要求，并对不合要求的输入予以合理的处理
//访问单向链表倒数第k个节点
//s思考：期待的解法是只遍历链表一次
public class Offer15链表中倒数第k个节点 {
    public static void main(String[] args)
    {
        System.out.println("访问链表的倒数度k个节点，请输入n");
        Scanner scanner=new Scanner(System.in);
        int k=scanner.nextInt();//
        if(k<0)
        {
            System.out.println("参数k错误！");
            return;
        }
        else{

        }
        Node head=new Node();
        head=creatList();//创建带头结点的链表
        Node p=new Node();
        p=FindKNode(head,k);
        if(p!=null)
            System.out.println(p.info);

    }
    public static Node FindKNode(Node head, int k)
    {//传入的参数k一定大于0；带头结点的链表
        Node q=new Node();
        int kk=0;
        Node p=new Node();
        p=head;
        q=head;
        while((p!=null))
        {
            p=p.next;
            kk++;
            if(kk==k)
                break;
        }
        if (p==null)
        {System.out.println("链表的节点个数不足"+k+"个！，输入的k超出范围，应该在链表长度范围内");
        return null;}
        while(p!=null)
        {
            p=p.next;
            q=q.next;
        }
        return q;
    }
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
