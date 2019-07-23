package second;

import utils.BiTreeUtil;
import utils.myObject.BiTree;

/**
 * created by memory
 * on 2019/7/21 16 52
 * 普通做法
 */
public class Offer39判断一棵树是不是平衡二叉树 {
    public static void main(String[] args) {
        BiTree root = BiTreeUtil.creatTree1();
        root.left = null;
        System.out.println(isBalanced2(root));
    }

    /**
     * 1.1 传统做法，时间一个节点会被遍历多次时间效率低  先根遍历
     */
    public static boolean isBalanced1(BiTree root) {
        if (root == null) {
            return true;
        }
        int leftDepth = getDepth(root.left);
        int rightDepth = getDepth(root.right);
        if (Math.abs(leftDepth - rightDepth) <= 1) {
            return (isBalanced1(root.left) && isBalanced1(root.right));
        } else {
            return false;
        }
    }

    /**
     * 1.2  传统做法，时间一个节点会被遍历多次时间效率低  后根遍历
     */
    public static boolean isBanlanced2(BiTree root) {
        if (root == null) {
            return true;
        }
        if (isBanlanced2(root.left) && isBanlanced2(root.right)) {
            int left = getDepth(root.left);
            int right = getDepth(root.right);
            int dif = Math.abs(left - right);
            if (dif > 1) {
                return false;
            } else {
                return true;
            }
        }
        return false;
    }

    public static int getDepth(BiTree root) {
        if (root == null) {
            return 0;
        }
        int left = getDepth(root.left);
        int right = getDepth(root.right);
        return left > right ? left + 1 : right + 1;
    }

    /**
     * 2. 考虑使用对象，这样程序栈之间能够传递信息，所有的节点均只遍历一次。在遍历节点时，根据子节点的高度获取到当前节点的高度
     */
    public static boolean isBalanced2(BiTree root) {
        if (root == null || (root.left == null && root.right == null)) {
            return true;
        }
        Depth depth = new Depth(0);
        return isBalanced2(root, depth);
    }

    public static boolean isBalanced2(BiTree root, Depth depth) {
        if (root == null) {
            depth.setDepth(0);
            return true;
        }
        Depth leftDepth = new Depth(0);
        Depth rightDepth = new Depth(0);
        if (isBalanced2(root.left, leftDepth) && isBalanced2(root.right, rightDepth)) {
            int diff = Math.abs(leftDepth.getDepth() - rightDepth.getDepth());
            depth.setDepth(Math.max(leftDepth.getDepth(), rightDepth.getDepth()) + 1);
            if (diff > 1) {
                return false;
            } else {
                return true;
            }
        } else {
            return false;
        }
    }
}

class Depth {
    private int depth;

    public Depth(int depth) {
        this.depth = depth;
    }

    public int getDepth() {
        return depth;
    }

    public void setDepth(int depth) {
        this.depth = depth;
    }
}
