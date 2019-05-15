package utils;

import java.util.Scanner;

public class BiTree {
    public static BiTreeNode CreatTree() {
        System.out.println("输入1-退出创建节点，其他数字输入节点内容：");
        Scanner sc = new Scanner(System.in);
        int option = sc.nextInt();
        if (option != 1) {
            BiTreeNode BiTree = new BiTreeNode();
            BiTree.info = option;
            System.out.println("创建节点" + option + "的左子树");
            BiTreeNode left1 = new BiTreeNode();
            BiTree.left = CreatTree();
            System.out.println("创建节点" + option + "的右子树");
            BiTree.left = CreatTree();
            return BiTree;
        } else {
            System.out.println("结束节点创建");
            return null;
        }
    }

    public static BiTreeNode creatTree1() {
        BiTreeNode BiTree = new BiTreeNode();
        BiTreeNode left1 = new BiTreeNode();
        BiTreeNode right1 = new BiTreeNode();
        BiTreeNode left2 = new BiTreeNode();
        BiTreeNode right2 = new BiTreeNode();
        BiTreeNode left3 = new BiTreeNode();
        BiTreeNode right3 = new BiTreeNode();
        BiTree.info = 8;
        BiTree.left = left1;
        BiTree.right = right1;
        right1.info = 7;
        right1.left = null;
        right1.right = null;
        left1.info = 8;
        left1.left = left2;
        left1.right = right2;
        left2.info = 9;
        left2.left = null;
        left2.right = null;
        right2.info = 2;
        right2.left = left3;
        right2.right = right3;
        left3.info = 4;
        left3.right = null;
        left3.left = null;
        right3.info = 7;
        right3.left = null;
        right3.right = null;
        return BiTree;
    }

    public static BiTreeNode creatTree2() {
        BiTreeNode BiTree = new BiTreeNode();
        BiTreeNode left1 = new BiTreeNode();
        BiTreeNode right1 = new BiTreeNode();
        BiTree.info = 8;
        BiTree.left = left1;
        BiTree.right = right1;
        left1.info = 9;
        left1.left = null;
        left1.right = null;
        right1.info = 2;
        right1.left = null;
        right1.right = null;
        return BiTree;
    }

    public static BiTreeNode creatTree3() {
        BiTreeNode biTree = new BiTreeNode();//根节点
        BiTreeNode left1 = new BiTreeNode();
        BiTreeNode right1 = new BiTreeNode();
        BiTreeNode left2 = new BiTreeNode();
        BiTreeNode right2 = new BiTreeNode();
        biTree.info = 10;
        biTree.left = left1;
        biTree.right = right1;
        left1.info = 5;
        left1.left = left2;
        left1.right = right2;
        right1.info = 12;
        right1.left = null;
        right1.right = null;
        left2.info = 4;
        left2.left = null;
        left2.right = null;
        right2.info = 7;
        right2.left = null;
        right2.right = null;
        return biTree;
    }

    public static BiTreeNode creatTree4() {
        BiTreeNode biTree = new BiTreeNode();
        BiTreeNode left1 = new BiTreeNode();
        BiTreeNode right1 = new BiTreeNode();
        BiTreeNode left2 = new BiTreeNode();
        BiTreeNode right2 = new BiTreeNode();
        biTree.info = 10;
        biTree.left = left1;
        biTree.right = right1;
        left1.info = 6;
        left1.left = left2;
        left1.right = right2;
        right1.info = 14;
        right1.left = null;
        right1.right = null;
        left2.info = 4;
        left2.left = null;
        left2.right = null;
        right2.info = 8;
        right2.left = null;
        right2.right = null;
        return biTree;
    }

    public static BiTreeNode creatTree5() {
        BiTreeNode biTree = new BiTreeNode();
        BiTreeNode left1 = new BiTreeNode();
        BiTreeNode right1 = new BiTreeNode();
        biTree.info = 2;
        biTree.left = left1;
        biTree.right = right1;
        left1.info = 1;
        left1.left = null;
        left1.right = null;
        right1.info = 3;
        right1.left = null;
        right1.right = null;
        return biTree;
    }

    public static void preOrder(BiTreeNode BiTree) {
        if (BiTree == null)
            return;
        System.out.print(BiTree.info);
        preOrder(BiTree.left);
        preOrder(BiTree.right);
    }

    public static void inOrder(BiTreeNode BiTree) {
        if (BiTree == null)
            return;
        inOrder(BiTree.left);
        System.out.println(BiTree.info);
        inOrder(BiTree.right);
    }

    public static void postOrder(BiTreeNode BiTree) {
        if (BiTree == null)
            return;
        postOrder(BiTree.left);
        postOrder(BiTree.right);
        System.out.print(BiTree.info + " ");
    }
}

