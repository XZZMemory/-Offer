package offer;

import utils.BiTree;
import utils.BiTreeNode;

//需要改
//import java.util.stream;
public class Offer6根据前序中序遍历重建二叉树 {
    public static void main(String[] args)
    {
        char[] preOrder={'1','2','4','7','3','5','6','8'};
        char[] inOrder={'4','7','2','1','5','3','8','6'};
        BiTreeNode t=new BiTreeNode();
        creatTree(t,preOrder,inOrder);
        BiTree.postOrder(t);
    }
    public static void creatTree(BiTreeNode root, char[] preOrderArray, char[] inOrderArray)
    {
        if(preOrderArray.length==0)
        {
            root=null;
            return;
        }
        int position=findPositionInInOrder(inOrderArray,preOrderArray[0]);
        if(position==-1)
        {
            root=null;
        }
        int leftLength=position;//例如0 1 2 3   4    5 6
        int rightLength=inOrderArray.length-position-1;

        char rootvalue=preOrderArray[0];
        root.info=rootvalue;
        BiTreeNode right=new BiTreeNode();
        BiTreeNode left=new BiTreeNode();
        root.left=left;
        root.right=right;
        if(leftLength>0)//构建左子树
        {

            char[] left_PreOrder=new char[leftLength];
            char[] left_InOrder=new char[leftLength];
            System.arraycopy(inOrderArray,0,left_InOrder,0,leftLength);
            System.arraycopy(preOrderArray,1,left_PreOrder,0,leftLength);
            creatTree(left,left_PreOrder,left_InOrder);
        }
        else
            left=null;
        if(rightLength>0)//构建右子树
        {

            char[] right_preOrder=new char[rightLength];
            char[] right_InOrder=new char[rightLength];
            System.arraycopy(inOrderArray,position+1,right_InOrder,0,rightLength);
            System.arraycopy(preOrderArray,1+leftLength,right_preOrder,0,rightLength);
            creatTree(right,right_preOrder,right_InOrder);

        }
        else
            right=null;
    }
    public static int findPositionInInOrder(char[]InOrder,char root)
    {
        if(InOrder.length==0)
        {
            return -1;
        }
        int position;
        for(int i=0;i<InOrder.length;i++)
        {
            if (InOrder[i]==root)
            {
                return i;
            }
        }
        return -1;
    }
}

