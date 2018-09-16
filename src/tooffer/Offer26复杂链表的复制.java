//在复杂链表中，每个节点除了有一个next指针外，还有一个指针Sibling指向链表的任意节点或者null
//指向下一节点的指针和指向任意节点的指针
package tooffer;
import utils.*;
public class Offer26复杂链表的复制 {
    public static void main(String[] args)
    {
        ComplexNode head=new ComplexNode();
        ComplexNode head2=new ComplexNode();
        head=head.CreatComplexNode();
        System.out.println("原始复杂链表是：");
        head.TraversalOfComplexNode(head);
        CloneNodes(head);
        ConnectSiblingNodes(head);
        System.out.println("加入任意节点之后的信息为：");
        head.TraversalOfComplexNode(head);
        head2=ReConnectNodes(head);
        System.out.println("复制之后头节点链表是：");
        head.TraversalOfComplexNode(head);
        System.out.println("复制之后复制的头节点链表是");
        head2.TraversalOfComplexNode(head2);
    }
    //分为三步，next，silbing，分离
    public static void CloneNodes(ComplexNode head)
    {
        ComplexNode p=new ComplexNode();
        p=head;
        while(p!=null)
        {
            ComplexNode pCloned=new ComplexNode();
            pCloned.info=p.info;
            pCloned.next=p.next;
            pCloned.Sibling=null;
            p.next=pCloned;
            p=pCloned.next;
        }
    }
    public static void ConnectSiblingNodes(ComplexNode head)
    {
        ComplexNode p=new ComplexNode();
        p=head;
        while(p!=null)
        {
            if (p.Sibling==null);
            else
                p.next.Sibling=p.Sibling.next;
            p=p.next.next;
        }
    }
    public static ComplexNode ReConnectNodes(ComplexNode head)
    {//时刻考虑指针为空
        ComplexNode head2=new ComplexNode();
        ComplexNode p=new ComplexNode();
        ComplexNode pCloned=new ComplexNode();
        if (head!=null) {
            p=head;
            pCloned=p.next;
            head2=pCloned;
            p.next=pCloned.next;
            p=p.next;
        }
        else
            return null;
        //p=head;
        //pCloned=head2;
        while(p!=null)
        {
            pCloned.next=p.next;
            pCloned=pCloned.next;
            p.next=pCloned.next;
            p=p.next;

      //      p.next=pCloned.next;
    //        pCloned.next=p.next.next;
  //          p=p.next;
//            pCloned=pCloned.next;
        }
        return head2;
    }
}
