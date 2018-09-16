package utils;

public class ComplexNode {
    public char info;
    public ComplexNode next;
    public ComplexNode Sibling;
    public static ComplexNode CreatComplexNode()
    {
        ComplexNode head=new ComplexNode();
        ComplexNode b=new ComplexNode();
        ComplexNode c=new ComplexNode();
        ComplexNode d=new ComplexNode();
        ComplexNode e=new ComplexNode();
        head.info='A';
        head.next=b;
        head.Sibling=c;
        b.info='B';
        b.next=c;
        b.Sibling=e;
        c.info='C';
        c.next=d;
        c.Sibling=null;
        d.info='D';
        d.next=e;
        d.Sibling=b;
        e.info='E';
        e.next=null;
        e.Sibling=null;
        return head;
    }
    public static void TraversalOfComplexNode(ComplexNode head)
    {
        if (head==null)
        {
            System.out.println("复杂链表为空！");
            return;
        }
        ComplexNode p=new ComplexNode();
        p=head;
        while(p!=null)
        {
            System.out.print(p.info+" ");
            if (p.next!=null)
                System.out.print(p.next.info+" ");
            else
                System.out.print("空 ");
            if (p.Sibling==null)
                System.out.println("空");
            else
                System.out.println(p.Sibling.info);
            p=p.next;
        }
    }
}
