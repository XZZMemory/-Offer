package tooffer;
//二叉树中任意节点的左右子树的深度相差不超过1，那么它就是一颗平衡二叉树
import utils.*;
public class Offer392判断一棵树是不是平衡二叉树 {
    public static void main(String[] args)
    {
        BiTree biTree=new BiTree();
        BinaryTreeNode root=biTree.CreatTree1();
        //root=null;测试用例1-根节点为空
        //root.left=null;测试用例2，只有一个根节点
        //root.right=null;测试用例2
        boolean result=IsBalannced(root);
        System.out.println(result);
    }
    //这种方法会重复遍历一个节点多遍。影响性能。前序遍历
    public static boolean IsBalannced(BinaryTreeNode root)
    {
        if (root==null)
            return true;
        int leftDepth=TreeDepth(root.left);
        int rightDepth=TreeDepth(root.right);
        int depthDiff=Math.abs(leftDepth-rightDepth);
        if (depthDiff>1)
            return false;
        else
            return IsBalannced(root.left)&&IsBalannced(root.right);
    }
    public static int TreeDepth(BinaryTreeNode root)
    {
        if (root==null)
            return 0;
        int leftDepth=TreeDepth(root.left);
        int rightDepth=TreeDepth(root.right);
        return leftDepth>rightDepth?leftDepth+1:rightDepth+1;
    }
    //思考用后序遍历方法，遍历一个节点之前就已经遍历完节点的左右节点子树
    public static int IsBalannced2(BinaryTreeNode root,Integer depth)
    {
        if(root==null)
        {
            depth=0;
            //return true;
        }
        //IsBalannced(root.left,depth);
return 0;

    }

}
