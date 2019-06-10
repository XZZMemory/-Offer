package first;

import utils.BiTreeUtil;
import utils.myObject.BiTree;

/* 定义两棵二叉树A和B，判断B是不是A的子结构*/
public class Offer18树的子结构 {
    public static void main(String[] args) {
        BiTree biTree1 = BiTreeUtil.creatTree1();
        BiTree biTree2 = BiTreeUtil.creatTree2();
        System.out.println(isSubTree(biTree1, biTree2));
    }

    //首先找到与树2根节点一样的节点，然后判断之后的节点是否一样
    public static boolean isSubTree(BiTree tree1, BiTree tree2) {
        boolean result = false;
        if ((tree1 == null) || (tree2 == null)) {
            return false;
        }
        if (tree1.info == tree2.info)//判断左右子树只有根节点信息一样，才会判断
            result = isSimilar(tree1, tree2);
        if (!result)
            result = isSubTree(tree1.left, tree2);
        if (!result)
            result = isSubTree(tree1.right, tree2);
        return result;
    }

    /* 判断两个树的树的左右子树是否一样*/
    public static boolean isSimilar(BiTree BiTree1, BiTree BiTree2) {
        if (BiTree2 == null) {//说明BiTree2已查找完毕
            return true;
        } else if (BiTree1 == null) {//BiTree1查找完毕，
            return false;
        }
        if (BiTree1.info == BiTree2.info) {//两节点信息一样，查找左右子树是否一致
            return ((isSimilar(BiTree1.left, BiTree2.left)) && (isSimilar(BiTree1.right, BiTree2.right)));
        } else {//两棵树的节点信息不同
            return false;
        }
    }
}
