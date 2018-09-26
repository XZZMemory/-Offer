package tooffer;
import utils.*;
//输入一颗二叉树的根节点，求该数的深度。
public class Offer39二叉树的深度 {
    public static void main(String[] args)
    {
        BiTree biTree=new BiTree();
        BinaryTreeNode root=biTree.CreatTree1();
        //root=null;测试1
        //root.left=null;测试2，只有一个根节点
        //root.right=null;测试2，只有一个根节点
        int depth=TreeDepth(root);
        System.out.println("树的深度是："+depth);
    }
    public static int TreeDepth(BinaryTreeNode root)
    {
        if (root==null)
            return 0;
        int leftDepth=TreeDepth(root.left);
        int rightDepth=TreeDepth(root.right);
        return leftDepth>rightDepth?leftDepth+1:rightDepth+1;
    }
}
