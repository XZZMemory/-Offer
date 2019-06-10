package utils.myObject;

public class BiTree {
    public int info;
    public BiTree left;
    public BiTree right;

    public BiTree(int info) {
        this.info = info;
        this.left = null;
        this.right = null;
    }

    public BiTree() {
    }

    public static boolean isLeaf(BiTree biTree) {
        if ((biTree.right == null) && (biTree.left == null))
            return true;
        return false;
    }


}
