//二叉树的层次遍历
package first;

import utils.BiTreeUtil;
import utils.myObject.BiTree;

import java.util.LinkedList;
import java.util.Queue;

public class Offer23从上往下打印二叉树 {
    public static void main(String[] args) {
        BiTree biTree = BiTreeUtil.creatTree1();
        levelTraverse(biTree);
    }

    //Queue是一个集合接口。在java5中新增加了java.util.Queue接口，用以支持队列的常见操作。该接口扩展了java.util.Collection接口。
    public static void levelTraverse(BiTree root) {
        Queue<BiTree> queue = new LinkedList<BiTree>();
        if (root == null) {
            return;
        }
        queue.offer(root);//根节点进入队列
        while (!queue.isEmpty()) {
            BiTree p = queue.poll();
            System.out.println("当前节点是：" + p.info);
            if (p.left != null)
                queue.offer(p.left);
            if (p.right != null)
                queue.offer(p.right);
        }
    }
}
