//二叉树的层次遍历
package offer;

import utils.BiTree;
import utils.BiTreeNode;

import java.util.LinkedList;
import java.util.Queue;

public class Offer23从上往下打印二叉树 {
    public static void main(String[] args) {
        BiTreeNode biTree = BiTree.creatTree1();
        hierarchicalTraversalOfBiTree(biTree);
    }

    //Queue是一个集合接口。在java5中新增加了java.util.Queue接口，用以支持队列的常见操作。该接口扩展了java.util.Collection接口。
    public static void hierarchicalTraversalOfBiTree(BiTreeNode root) {
        Queue<BiTreeNode> queue = new LinkedList<BiTreeNode>();
        if (root == null) {
            return;
        }
        queue.offer(root);//根节点进入队列
        while (!queue.isEmpty()) {
            BiTreeNode p = queue.poll();
            System.out.println("当前节点是：" + p.info);
            if (p.left != null)
                queue.offer(p.left);
            if (p.right != null)
                queue.offer(p.right);
        }
    }
}
