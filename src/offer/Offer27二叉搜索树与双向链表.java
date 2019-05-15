//输入一颗二叉搜索树，将该二叉搜索树转换成一个排序的双向链表。要求不能创建任何新的节点，只能调整树中节点只指针的指向
package offer;

import utils.BiTree;
import utils.BiTreeNode;

public class Offer27二叉搜索树与双向链表 {
    public static BiTreeNode biLast;
    public static BiTreeNode head;

    public static void main(String[] args) {
        BiTreeNode biTree = BiTree.creatTree5();
        convert(biTree);
        while (head != null) {
            System.out.println("信息是：" + head.info);
            head = head.right;
        }
    }

    public static void convert(BiTreeNode biTree) {//考虑中序遍历
        if (biTree == null)
            return;
        //左子树
        if (biTree.left != null)
            convert(biTree.left);
        //中间处理
        biTree.left = biLast;
        if (biLast == null)
            head = biTree;
        else
            biLast.right = biTree;
        biLast = biTree;
        //右子树
        if (biTree.right != null)
            convert(biTree.right);
    }
}
