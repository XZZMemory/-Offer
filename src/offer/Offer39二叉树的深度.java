package offer;
import utils.*;
//输入一颗二叉树的根节点，求该数的深度。
public class Offer39二叉树的深度 {
    public static void main(String[] args)
    {
        BiTree biTree=new BiTree();
        BiTreeNode root=biTree.creatTree1();
        //root=null;测试1
        //root.left=null;测试2，只有一个根节点
        //root.right=null;测试2，只有一个根节点
        int depth= treeDepth(root);
        System.out.println("树的深度是："+depth);
    }
    public static int treeDepth(BiTreeNode root)
    {
        if (root==null)
            return 0;
        int leftDepth= treeDepth(root.left);
        int rightDepth= treeDepth(root.right);
        return leftDepth>rightDepth?leftDepth+1:rightDepth+1;
    }
}
