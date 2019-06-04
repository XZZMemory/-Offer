package utils;

public class BiTreeNode {
    public int info;
    public BiTreeNode left;
    public BiTreeNode right;

    public BiTreeNode(int info) {
        this.info = info;
        this.left = null;
        this.right = null;
    }

    public BiTreeNode() {
    }

    public static boolean isLeaf(BiTreeNode biTree) {
        if ((biTree.right == null) && (biTree.left == null))
            return true;
        return false;
    }
}
