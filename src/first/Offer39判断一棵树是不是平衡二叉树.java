package first;

import utils.BiTreeUtil;
import utils.myObject.BiTree;

public class Offer39判断一棵树是不是平衡二叉树 {
    static int times = 0;

    public static void main(String[] args) {
        BiTree root = BiTreeUtil.creatTree1();
        //root=null;测试用例1-根节点为空
        //root.left=null;//测试用例2，只有一个根节点
        root.right = null;//测试用例2
        boolean result = isBalanced2(root);
        System.out.println(result);
    }

    /**
     * 1. 这种方法会重复遍历一个节点多遍。影响性能。前序遍历,普通的做法就是这样
     */
    public static boolean isBalannced(BiTree root) {
        if (root == null)
            return true;
        int leftDepth = treeDepth(root.left);
        int rightDepth = treeDepth(root.right);
        int depthDiff = Math.abs(leftDepth - rightDepth);
        if (depthDiff > 1)
            return false;
        else
            return isBalannced(root.left) && isBalannced(root.right);
    }

    public static int treeDepth(BiTree root) {
        if (root == null)
            return 0;
        int leftDepth = treeDepth(root.left);
        int rightDepth = treeDepth(root.right);
        return leftDepth > rightDepth ? leftDepth + 1 : rightDepth + 1;
    }

    //

    /**
     * 2. 思考用后序遍历方法，遍历一个节点之前就已经遍历完节点的左右节点子树，还未写出来。。。。
     * 不对，depth传不过去，程序栈之间无法共享，**********
     * 考虑，java是值传递，单纯的depth无法传递，递归中，修改了depth值，但退出递归返回上一层时，值没发生变化，考虑将depth封装到一个对象中。20190721
     */
    public static boolean isBalanced2Bad(BiTree root) {
        if (root == null || (root.left == null && root.right == null)) {
            return true;
        }
        int depth = 0;
        return isBalanced2Bad(root, depth);
    }

    public static boolean isBalanced2Bad(BiTree root, int depth) {
        if (root == null) {
            depth = 0;
            return true;
        }
        int left = 0, right = 0;
        if (isBalanced2Bad(root.left, left) && isBalanced2Bad(root.right, right)) {
            int diff = left - right;
            if (diff <= 1 && diff >= -1) {
                depth = 1 + (left > right ? left : right);
                return true;
            }
        }
        return false;
    }

    /**
     * 3. 考虑使用对象，这样程序栈之间能够传递信息
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
