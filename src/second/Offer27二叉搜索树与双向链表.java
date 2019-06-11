package second;

import utils.BiTreeUtil;
import utils.myObject.BiTree;

/**
 * created by memory
 * on 2019/6/11 下午3:26
 */
/*输入一颗二叉搜索树，将该二叉搜索树转换成一个排序的双向链表。要求不能创建任何新的节点，只能调整树中节点只指针的指向*/
public class Offer27二叉搜索树与双向链表 {
    public static void main(String[] args) {
        BiTree biTree = BiTreeUtil.creatTree5();
    }

    public static BiTree convert(BiTree root) {
        if (root == null) {
            return null;
        }
        /*中序遍历*/
        return null;
    }
}
