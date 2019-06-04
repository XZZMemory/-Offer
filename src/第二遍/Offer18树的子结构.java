package 第二遍;

import utils.BiTree;
import utils.BiTreeNode;

/**
 * created by memory
 * on 2019/6/3 下午7:59
 */
/* 定义两棵二叉树A和B，判断B是不是A的子结构*/
public class Offer18树的子结构 {
    public static void main(String[] args) {
        BiTreeNode tree1 = BiTree.creatTree1();
        BiTreeNode tree2 = BiTree.creatTree2();
        System.out.println(isSubTree(tree1, tree2));
    }

    public static boolean isSubTree(BiTreeNode tree1, BiTreeNode tree2) {
        boolean result = false;
        if (tree1 == null) {
            return false;
        }
        if (tree1.info == tree2.info) {
            result = isSimilar(tree1, tree2);
        }
        if (!result) {
            result = isSubTree(tree1.left, tree2);
        }
        if (!result) {
            result = isSubTree(tree1.right, tree2);
        }
        return result;
    }

    public static boolean isSimilar(BiTreeNode tree1, BiTreeNode tree2) {
        if (tree2 == null) {
            return true;
        }
        if (tree1 == null) {
            return false;
        }
        if (tree1.info == tree2.info) {
            return isSimilar(tree1.left, tree2.left) && isSimilar(tree1.right, tree2.right);
        } else {
            return false;
        }
    }
}
