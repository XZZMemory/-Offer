package second;

import utils.BiTreeUtil;
import utils.myObject.BiTree;

import java.util.LinkedList;
import java.util.Queue;

/**
 * created by memory
 * on 2019/6/6 下午8:15
 */
public class Offer23从上往下打印二叉树 {
    public static void main(String[] args) {
        BiTree biTree = BiTreeUtil.creatTree1();
        levelTraverse(biTree);
    }

    //Queue是一个集合接口。在java5中新增加了java.util.Queue接口，用以支持队列的常见操作。该接口扩展了java.util.Collection接口。
    public static void levelTraverse(BiTree root) {
        if (root == null) {
            return;
        }
        Queue<BiTree> queue = new LinkedList<>();
        queue.offer(root);
        while (!queue.isEmpty()) {
            BiTree current = queue.poll();
            System.out.print(current.info + " ");
            if (current.left != null) {
                queue.offer(current.left);
            }
            if (current.right != null) {
                queue.offer(current.right);
            }
        }
    }
}
