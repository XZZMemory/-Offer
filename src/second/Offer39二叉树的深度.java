package second;

import utils.BiTreeUtil;
import utils.myObject.BiTree;

/**
 * created by memory
 * on 2019/7/21 16 31
 */
public class Offer39二叉树的深度 {
    public static void main(String[] args) {
        BiTree root = BiTreeUtil.creatTree1();
        System.out.println(getDepth(root));
    }

    public static int getDepth(BiTree root) {
        if (root == null) {
            return 0;
        }
        int left = getDepth(root.left);
        int right = getDepth(root.right);
        System.out.println("根："+root.info);
        System.out.println("左："+left);
        System.out.println("右："+right);
        return left > right ? left + 1 : right + 1;
    }
}
