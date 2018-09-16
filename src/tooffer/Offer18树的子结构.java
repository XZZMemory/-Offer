package tooffer;//定义两棵二叉树A和B，判断B是不是A的子结构
import utils.*;
public class Offer18树的子结构 {
    public static void main(String[] args) {
        BiTree biTreeClass=new BiTree();
        BinaryTreeNode biTree1=new BinaryTreeNode();
        BinaryTreeNode biTree2=new BinaryTreeNode();
        biTree1=biTreeClass.CreatTree1();
        biTree2=biTreeClass.CreatTree2();
        System.out.println(HasSubTree(biTree1,biTree2));

    }
    //s首先找到与树2根节点一样的节点，然后判断之后的节点是否一样
    public  static boolean HasSubTree(BinaryTreeNode BiTree1,BinaryTreeNode BiTree2)
    {
        boolean result=false;
        if ((BiTree1==null)||(BiTree2==null))
            return false;
        if (BiTree1.info==BiTree2.info)//判断左右子树只有根节点信息一样，才会判断
            result=DoesTree1HasTree2(BiTree1,BiTree2);
        if (!result)
            result =HasSubTree(BiTree1.left,BiTree2);
        if(!result)
            result=HasSubTree(BiTree1.right,BiTree2);
        return result;
    }
    public static boolean DoesTree1HasTree2(BinaryTreeNode BiTree1,BinaryTreeNode BiTree2)
    {//判断两个树的树的左右子树是否一样
        if(BiTree2==null)//说明BiTree2已查找完毕
            return true;
        else if(BiTree1==null)//BiTree1查找完毕，
            return false;
        if(BiTree1.info==BiTree2.info)//两节点信息一样，查找左右子树是否一致
            return ((DoesTree1HasTree2(BiTree1.left,BiTree2.left))&&(DoesTree1HasTree2(BiTree1.right,BiTree2.right)));
        else//两棵树的节点信息不同
                return false;
    }

}
