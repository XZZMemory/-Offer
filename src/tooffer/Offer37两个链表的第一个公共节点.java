package tooffer;
//输入连个链表，找出它们的第一个公共节点。
//1,2,3,6,7
//  4,5,6,7
import utils.*;
public class Offer37两个链表的第一个公共节点 {
    public static void main(String[] args)
    {
        LinkList linkList=new LinkList();
        int[] data1={1,2,3};
        int[] data2={4,5,6};
        int[] sameData={7,8,9,10};
        //带头结点的链表，数据是int型数据
        NodeInt head1=linkList.CreatLinklistWithIntData(data1);
        NodeInt head2=linkList.CreatLinklistWithIntData(data2);
        NodeInt sameDataHead=linkList.CreatLinklistWithIntData(sameData);
        NodeInt p=new NodeInt();
        for (p=head1;p.next!=null;p=p.next);
        p.next=sameDataHead.next;
        for (p=head2;p.next!=null;p=p.next);
        p.next=sameDataHead.next;
        /////创建两个链表完毕
        head1=null;
        head2=null;
        NodeInt sameNode=FindFirstCommonNode(head1,head2);
    }
    public static NodeInt FindFirstCommonNode(NodeInt head1,NodeInt head2)
    {
        NodeInt sameNode=new NodeInt();
        int length1=GetListLength(head1);
        int length2=GetListLength(head2);
        if (length1==0||length2==0)
        {
            System.out.println("存在链表节点为空！不存在公共节点");
            return null;
        }
        int nLengthDif=Math.abs(length1-length2);
        NodeInt pOfHead1=new NodeInt();
        pOfHead1=head1.next;
        NodeInt pOfHead2=new NodeInt();
        pOfHead2=head2.next;
        if (length1>length2)
        {
            for (int i=1;i<=nLengthDif;i++)
                pOfHead1=pOfHead1.next;

        }
        else
        {
            for (int i=1;i<=nLengthDif;i++)
                pOfHead2=pOfHead2.next;
        } //差出来的节点已经过滤掉
        while((pOfHead1!=null)&&(pOfHead2!=null)&&(pOfHead1!=pOfHead2))
        {
            pOfHead1=pOfHead1.next;
            pOfHead2=pOfHead2.next;
        }
        sameNode=pOfHead1;
        return sameNode;

    }
    public static int GetListLength(NodeInt head)
    {
        if (head==null||head.next==null)
            return 0;
        int length=0;
        NodeInt p=new NodeInt();
        p=head.next;
        while(p!=null)
        {
            length++;
            p=p.next;
        }
        return length;
    }


}
