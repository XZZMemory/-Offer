//输入一颗二叉搜索树，将该二叉搜索树转换成一个排序的双向链表。要求不能创建任何新的节点，只能调整树中节点只指针的指向
package tooffer;
import utils.*;
public class Offer27二叉搜索树与双向链表 {
    public static BinaryTreeNode biLast;
    public static BinaryTreeNode head;
    public static void main(String[] args)
    {
        BinaryTreeNode biTree=new BinaryTreeNode();
        BiTree biTreeClass=new BiTree();
        biTree=biTreeClass.CreatTree5();
        Convert(biTree);
        while(head!=null)
        {
            System.out.println("信息是："+head.info);
            head=head.right;
        }
    }
    public static void Convert(BinaryTreeNode biTree)
    {//考虑中序遍历
        if(biTree==null)
            return ;
        //左子树
        if (biTree.left!=null)
            Convert(biTree.left);
        //中间处理
        biTree.left=biLast;
        if (biLast==null)
            head=biTree;
        if(biLast!=null)
            biLast.right=biTree;
        biLast=biTree;
        //右子树
        if (biTree.right!=null)
            Convert(biTree.right);

    }

}
