package offer;

import utils.BiTree;

//输入一颗二叉树的根节点，求该数的深度。
public class 第39二叉树的深度 {
    public static void main(String[] args) {
        BiTree biTree = new BiTree();
        BiTree root = biTree.creatTree1();
        //root=null;测试1
        //root.left=null;测试2，只有一个根节点
        //root.right=null;测试2，只有一个根节点
        int depth = getTreeDepth(root);
        System.out.println("树的深度是：" + depth);
    }

    public static int getTreeDepth(BiTree root) {
        if (root == null)
            return 0;
        int leftDepth = getTreeDepth(root.left);
        int rightDepth = getTreeDepth(root.right);
        return leftDepth > rightDepth ? leftDepth + 1 : rightDepth + 1;
    }
}
