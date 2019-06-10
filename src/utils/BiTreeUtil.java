package utils;

import utils.myObject.BiTree;

/**
 * created by memory
 * on 2019/6/10 下午8:55
 */
public class BiTreeUtil {
    public static BiTree creatTree1() {
        BiTree root = new BiTree(8);
        BiTree left1 = new BiTree(8);
        BiTree right1 = new BiTree(7);
        BiTree left2 = new BiTree(9);
        BiTree right2 = new BiTree(2);
        BiTree left3 = new BiTree(4);
        BiTree right3 = new BiTree(7);
        root.left = left1;
        root.right = right1;
        left1.left = left2;
        left1.right = right2;
        right2.left = left3;
        right2.right = right3;
        return root;
    }

    public static BiTree creatTree2() {
        BiTree root = new BiTree(8);
        BiTree left1 = new BiTree(9);
        BiTree right1 = new BiTree(2);
        root.left = left1;
        root.right = right1;
        return root;
    }

    public static BiTree creatTree3() {
        BiTree biTree = new BiTree(10);//根节点
        BiTree left1 = new BiTree(5);
        BiTree right1 = new BiTree(12);
        BiTree left2 = new BiTree(4);
        BiTree right2 = new BiTree(7);
        biTree.left = left1;
        biTree.right = right1;
        left1.left = left2;
        left1.right = right2;
        return biTree;
    }

    public static BiTree creatTree4() {
        BiTree root = new BiTree(10);
        BiTree left1 = new BiTree(6);
        BiTree right1 = new BiTree(14);
        BiTree left2 = new BiTree(4);
        BiTree right2 = new BiTree(8);
        root.left = left1;
        root.right = right1;
        left1.info = 6;
        left1.left = left2;
        left1.right = right2;
        return root;
    }

    public static BiTree creatTree5() {
        BiTree biTree = new BiTree(2);
        BiTree left1 = new BiTree(1);
        BiTree right1 = new BiTree(3);
        biTree.info = 2;
        biTree.left = left1;
        biTree.right = right1;
        return biTree;
    }

    public static void preOrder(BiTree BiTree) {
        if (BiTree == null)
            return;
        System.out.print(BiTree.info + " ");
        preOrder(BiTree.left);
        preOrder(BiTree.right);
    }

    public static void inOrder(BiTree BiTree) {
        if (BiTree == null)
            return;
        inOrder(BiTree.left);
        System.out.println(BiTree.info);
        inOrder(BiTree.right);
    }

    public static void postOrder(BiTree BiTree) {
        if (BiTree == null)
            return;
        postOrder(BiTree.left);
        postOrder(BiTree.right);
        System.out.print(BiTree.info + " ");
    }
}
