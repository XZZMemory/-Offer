package offer;

import utils.NodeWithParent;

public class Offer58二叉树的下一个节点 {
    public static void main(String[] args)
    {
        NodeWithParent root=new NodeWithParent(1);
        NodeWithParent node1=new NodeWithParent(2);
        NodeWithParent node2=new NodeWithParent(3);
        NodeWithParent node3=new NodeWithParent(4);
        NodeWithParent node4=new NodeWithParent(5);
        NodeWithParent node5=new NodeWithParent(6);
        NodeWithParent node6=new NodeWithParent(7);
        NodeWithParent node7=new NodeWithParent(8);
        NodeWithParent node8=new NodeWithParent(9);
        root.left=node1;
        root.right=node2;
        root.parent=null;
        node2.parent=root;
        node1.parent=root;
        node1.left=node3;
        node3.parent=node1;
        node1.right=node4;
        node4.parent=node1;

        node2.left=node5;
        node5.parent=node2;
        node2.right=node6;
        node6.parent=node2;
        node3.right=node7;
        node7.parent=node3;

        node4.right=node8;
        node8.parent=node4;
        NodeWithParent N1=node8;
        System.out.println(N1.info);
        NodeWithParent N2=node4;
        System.out.println(N2.info);
        NodeWithParent N3=node7;
        System.out.println(N3.info);
        NodeWithParent N4=node6;
        NodeWithParent nextNode1=GetNext(N1);
        NodeWithParent nextNodeN2=GetNext(N2);
        NodeWithParent nextNodeN3=GetNext(N3);
        NodeWithParent nextNodeN4=GetNext(null);

    }
    public static NodeWithParent GetNext(NodeWithParent node)
    {
        if (node==null)
            return null;
        if (node.right!=null)//有右子树
        {
            NodeWithParent nextNode=node.right;
            while(nextNode.left!=null)
                nextNode=nextNode.left;
            return nextNode;
        }
        else if (node.parent.left==node)//无右子树，且是父亲节点的左子树
            return node.parent;
        else //无右子树，且是父亲节点的右子树
        {
            NodeWithParent maybeNext=node.parent;
            NodeWithParent maybeNextParent=null;
            while(maybeNext!=null)
            {
                maybeNextParent=maybeNext.parent;
                if (maybeNextParent==null)
                    return null;
                else if (maybeNextParent.right==maybeNext)
                {
                    maybeNext=maybeNextParent;
                    maybeNextParent=maybeNext.parent;
                }
                else if (maybeNextParent.left==maybeNext)
                {
                    return maybeNextParent;
                }
            }
        }
        return null;
    }

}
