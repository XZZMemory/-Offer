package offer;//定义两棵二叉树A和B，判断B是不是A的子结构
import utils.*;
public class Offer18树的子结构 {
    public static void main(String[] args) {
        BiTreeNode biTree1=new BiTreeNode();
        BiTreeNode biTree2=new BiTreeNode();
        biTree1=BiTree.creatTree1();
        biTree2=BiTree.creatTree2();
        System.out.println(hasSubTree(biTree1,biTree2));

    }
    //首先找到与树2根节点一样的节点，然后判断之后的节点是否一样
    public  static boolean hasSubTree(BiTreeNode BiTree1, BiTreeNode BiTree2)
    {
        boolean result=false;
        if ((BiTree1==null)||(BiTree2==null))
            return false;
        if (BiTree1.info==BiTree2.info)//判断左右子树只有根节点信息一样，才会判断
            result= doesTree1HasTree2(BiTree1,BiTree2);
        if (!result)
            result = hasSubTree(BiTree1.left,BiTree2);
        if(!result)
            result= hasSubTree(BiTree1.right,BiTree2);
        return result;
    }
    public static boolean doesTree1HasTree2(BiTreeNode BiTree1, BiTreeNode BiTree2)
    {//判断两个树的树的左右子树是否一样
        if(BiTree2==null)//说明BiTree2已查找完毕
            return true;
        else if(BiTree1==null)//BiTree1查找完毕，
            return false;
        if(BiTree1.info==BiTree2.info)//两节点信息一样，查找左右子树是否一致
            return ((doesTree1HasTree2(BiTree1.left,BiTree2.left))&&(doesTree1HasTree2(BiTree1.right,BiTree2.right)));
        else//两棵树的节点信息不同
                return false;
    }

}
