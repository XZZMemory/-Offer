package first;

import utils.myObject.BiTree;

public class Offer59对称的二叉树 {
    public static void main(String[] args) {
        BiTree biTree1 = creatBiTree1();
        BiTree biTree2 = creatBiTree2();
        boolean result1 = isSy(biTree1);
        boolean result2 = isSy(biTree2);
        boolean result3 = isSy(null);
    }

    public static boolean isSy(BiTree root) {
        if (root == null)
            return true;
        return isSymmetrical(root.left, root.right);
    }

    public static boolean isSymmetrical(BiTree node1, BiTree node2) {
        if (node1 == null && node2 == null)
            return true;
        else if (node1 == null || node2 == null)
            return false;
        else {
            if (node1.info == node2.info)
                return isSymmetrical(node1.left, node2.right) && isSymmetrical(node1.right, node2.left);
            else
                return false;
        }
    }

    public static BiTree creatBiTree1() {
        BiTree node1 = new BiTree(8);
        BiTree node2 = new BiTree(6);
        BiTree node3 = new BiTree(6);
        BiTree node4 = new BiTree(5);
        BiTree node5 = new BiTree(7);
        BiTree node6 = new BiTree(7);
        BiTree node7 = new BiTree(5);
        node1.left = node2;
        node1.right = node3;
        node2.left = node4;
        node2.right = node5;
        node3.left = node6;
        node3.right = node7;
        return node1;
    }

    public static BiTree creatBiTree2() {
        BiTree node1 = new BiTree(7);
        BiTree node2 = new BiTree(7);
        BiTree node3 = new BiTree(7);
        BiTree node4 = new BiTree(7);
        BiTree node5 = new BiTree(7);
        BiTree node6 = new BiTree(7);
        node1.left = node2;
        node1.right = node3;
        node2.left = node4;
        node2.right = node5;
        node3.left = node6;
        return node1;
    }
}
