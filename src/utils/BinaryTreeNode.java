package utils;

public class BinaryTreeNode {
    public  int info;
    public BinaryTreeNode left;
    public BinaryTreeNode right;
    public static boolean IsLeaf(BinaryTreeNode biTree)
    {
        if ((biTree.right==null)&&(biTree.left==null))
            return true;
        return false;
    }
}
