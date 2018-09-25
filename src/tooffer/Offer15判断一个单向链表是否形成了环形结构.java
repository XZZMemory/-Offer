package tooffer;

import utils.LinkList;
import utils.Node;

public class Offer15判断一个单向链表是否形成了环形结构 {
    public static void main(String[] args)
    {
        Node head1=LinkList.creatList(); //无环
        Node head2=LinkList.creatListCircle();    //有环
        boolean isCircle1=IsCircle(head1);
        boolean isCircle2=IsCircle(head2);
    }
    public static boolean IsCircle(Node head)
    {

            Node slow=head;
            Node fast=head.next;
            while(fast!=null&&slow!=null)
            {
                if (fast==slow)
                    return true;
                slow=slow.next;
                fast=fast.next;
                if (fast!=null)
                    fast=fast.next;
            }
        return false;

    }
}
