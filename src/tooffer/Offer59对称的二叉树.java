package tooffer;

import utils.BinaryTreeNode;
import utils.BinaryTreeNode2;

public class Offer59对称的二叉树 {
    public static void main(String[] args) {
        BinaryTreeNode2 biTree1=CreatBiTree1();
        BinaryTreeNode2 biTree2=CreatBiTree2();
        boolean result1=IsSy(biTree1);
        boolean result2=IsSy(biTree2);
        boolean result3=IsSy(null);

    }

    public static BinaryTreeNode2 CreatBiTree1() {
        BinaryTreeNode2 node1 = new BinaryTreeNode2(8);
        BinaryTreeNode2 node2 = new BinaryTreeNode2(6);
        BinaryTreeNode2 node3 = new BinaryTreeNode2(6);
        BinaryTreeNode2 node4 = new BinaryTreeNode2(5);
        BinaryTreeNode2 node5 = new BinaryTreeNode2(7);
        BinaryTreeNode2 node6 = new BinaryTreeNode2(7);
        BinaryTreeNode2 node7 = new BinaryTreeNode2(5);
        node1.left = node2;
        node1.right = node3;
        node2.left = node4;
        node2.right = node5;
        node3.left = node6;
        node3.right = node7;
        node4.left = null;
        node4.right = null;
        node5.left = null;
        node5.right = null;
        node6.left = null;
        node6.right = null;
        node7.left = null;
        node7.right = null;
        return node1;
    }

    public static BinaryTreeNode2 CreatBiTree2() {
        BinaryTreeNode2 node1 = new BinaryTreeNode2(7);
        BinaryTreeNode2 node2 = new BinaryTreeNode2(7);
        BinaryTreeNode2 node3 = new BinaryTreeNode2(7);
        BinaryTreeNode2 node4 = new BinaryTreeNode2(7);
        BinaryTreeNode2 node5 = new BinaryTreeNode2(7);
        BinaryTreeNode2 node6 = new BinaryTreeNode2(7);
        node1.left = node2;
        node1.right = node3;
        node2.left = node4;
        node2.right = node5;
        node3.left = node6;
        node3.right = null;
        node4.left = null;
        node4.right = null;
        node5.left = null;
        node5.right = null;
        node6.left = null;
        node6.right = null;
        return node1;
    }
    public static boolean IsSy(BinaryTreeNode2 root)
    {
        if (root==null)
            return true;
        return IsSymmetrical(root.left,root.right);
    }
    public static boolean IsSymmetrical(BinaryTreeNode2 node1,BinaryTreeNode2 node2)
    {
        if (node1==null&&node2==null)
            return true;
        else if(node1==null||node2==null)
            return false;
        else
        {
            if (node1.info==node2.info)
                return  IsSymmetrical(node1.left,node2.right)&&IsSymmetrical(node1.right,node2.left);
            else
                return false;
        }
    }
}
