package second;

import utils.BiTreeUtil;
import utils.myObject.BiTree;

import java.util.Stack;

/**
 * created by memory
 * on 2019/6/10 下午9:35
 */

/*从树的跟节点开始往下一直到叶节点所经过的节点形成的一条路径,找到所有路径*/
public class Offer25二叉树中和为某一路径的值 {
    public static void main(String[] args) {
        BiTree root = BiTreeUtil.creatTree3();
        findPath(root, 22, 0, new Stack<BiTree>());
    }

    public static void findPath(BiTree root, int expectedSum, int currentSum, Stack<BiTree> stack) {
        if (root == null) {
            return;
        }
        currentSum += root.info;
        stack.push(root);
        if (currentSum == expectedSum && BiTreeUtil.isLeaf(root)) {
            /*遍历栈*/
            System.out.println("当前路径为：");
            for (int i = 0; i < stack.size(); i++) {
                System.out.println(stack.elementAt(i).info);
            }
            stack.pop();
            return;
        }
        findPath(root.left, expectedSum, currentSum, stack);
        findPath(root.right, expectedSum, currentSum, stack);
        stack.pop();
    }
}
