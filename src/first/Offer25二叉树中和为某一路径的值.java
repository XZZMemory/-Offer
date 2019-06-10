package first;

import utils.BiTreeUtil;
import utils.myObject.BiTree;

import java.util.Stack;

//从树的跟节点开始往下一直到叶节点所经过的节点形成的一条路径。
public class Offer25二叉树中和为某一路径的值 {
    public static void main(String[] args) {
        BiTree biTree = BiTreeUtil.creatTree3();
        Stack<Integer> stack = new java.util.Stack<Integer>();
        findPath(biTree, 22, 0, stack);
    }

    public static void findPath(BiTree biTree, int expectedSum, int currentSum, Stack<Integer> stack) {
        if (biTree == null)
            return;
        currentSum += biTree.info;
        stack.push(biTree.info);
        if ((currentSum == expectedSum) && (biTree.isLeaf(biTree)))//叶子节点且和为需要找的和，则遍历栈并返回
        {
            System.out.println("当前路径为：");
            for (int i = 0; i < stack.size(); i++)
                System.out.println(stack.elementAt(i));
            stack.pop();
            return;//找到一条路径即可，找到就返回。
        } else {
            findPath(biTree.left, expectedSum, currentSum, stack);
            findPath(biTree.right, expectedSum, currentSum, stack);
            currentSum -= biTree.info;
            stack.pop();
        }
    }
}
