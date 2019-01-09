package offer;

import utils.BiTree;
import utils.BiTreeNode;

public class Offer39判断一棵树是不是平衡二叉树 {
    public static void main(String[] args)
    {
        BiTree biTree=new BiTree();
        BiTreeNode root=biTree.creatTree1();
        //root=null;测试用例1-根节点为空
        //root.left=null;//测试用例2，只有一个根节点
        root.right=null;//测试用例2
        boolean result=IsBalannced(root);
        System.out.println(result);
    }
    //这种方法会重复遍历一个节点多遍。影响性能。前序遍历
    public static boolean IsBalannced(BiTreeNode root)
    {
        if (root==null)
            return true;
        int leftDepth= treeDepth(root.left);
        int rightDepth= treeDepth(root.right);
        int depthDiff=Math.abs(leftDepth-rightDepth);
        if (depthDiff>1)
            return false;
        else
            return IsBalannced(root.left)&&IsBalannced(root.right);
    }
    public static int treeDepth(BiTreeNode root)
    {
        if (root==null)
            return 0;
        int leftDepth= treeDepth(root.left);
        int rightDepth= treeDepth(root.right);
        return leftDepth>rightDepth?leftDepth+1:rightDepth+1;
    }
    //思考用后序遍历方法，遍历一个节点之前就已经遍历完节点的左右节点子树
    public static int IsBalannced2(BiTreeNode root, Integer depth)
    {
        if(root==null)
        {
            depth=0;
            //return true;
        }
        //IsBalannced(root.left,depth);
        return 0;

    }
    //不对，depth传不过去，程序栈之间无法共享，**********
    public static boolean isBalanced2(BiTreeNode root)
    {
        int depth = 0;
        return isBalanced2(root,depth);      }
    public static boolean isBalanced2(BiTreeNode root, int depth)
    {
        if(root == null){
            depth = 0;
            return true;
        }
        int left = 0,right = 0;
        if(isBalanced2(root.left,left) && isBalanced2(root.right,right)){
            int diff = left-right;
            if(diff <= 1 && diff >= -1){
                depth = 1+(left > right?left : right);
                return true;
            }
        }
        return false;
    }

}
