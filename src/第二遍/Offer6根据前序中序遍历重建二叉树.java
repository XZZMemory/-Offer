package 第二遍;

import utils.BiTree;
import utils.BiTreeNode;

/**
 * created by memory
 * on 2018/12/28 下午4:20
 */
public class Offer6根据前序中序遍历重建二叉树 {
    public static int CON=0;//类变量，统计出错信息（-1）
    public static void main(String[] args)
    {
        int[] preOrder={1,2,4,7,3,5,6,8};
        int[] inOrder={4,7,2,1,5,3,8,6};
        BiTreeNode t=creatTree(preOrder,inOrder,0,preOrder.length-1,0,inOrder.length-1);
        BiTree.postOrder(t);
    }
    public static BiTreeNode creatTree(int[] preOrderArray, int[] inOrderArray,
                                       int preOrderStart,int preOrderEnd,int inOrderStart,int inOrderEnd )
    {
        if (preOrderArray==null||preOrderArray.length==0||preOrderStart>preOrderEnd) {
            return null;
        }
        int currentData=preOrderArray[preOrderStart];
        BiTreeNode currentNode=new BiTreeNode(currentData);
        int dataPosInOrder= findPositionInInOrder(inOrderArray,currentData);
        if (dataPosInOrder==-1||dataPosInOrder<inOrderStart||dataPosInOrder>inOrderEnd) {
            CON=-1;
            return null;
        }
        int leftLength=dataPosInOrder-inOrderStart;
        int rightLength=inOrderEnd-dataPosInOrder;
        currentNode.left=creatTree(preOrderArray,inOrderArray,preOrderStart+1,preOrderStart+leftLength,
                inOrderStart,dataPosInOrder-1);
        currentNode.right=creatTree(preOrderArray,inOrderArray,preOrderStart+leftLength+1,preOrderEnd,
                dataPosInOrder+1,inOrderEnd);
        if (CON==-1)
            return null;
        return currentNode;
    }
    public static int findPositionInInOrder(int[]InOrder,int data)
    {
        if(InOrder.length==0)
        {
            return -1;
        }
        for(int i=0;i<InOrder.length;i++)
        {
            if (InOrder[i]==data)
            {
                return i;
            }
        }
        return -1;
    }

}
