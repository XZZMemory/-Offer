//输入一个二叉树，输出他的镜像
package tooffer;
import utils.*;
//每一步访问地址的时候都要注意是否为null，为空的话要注意处理写代码之前讲清思路，举例子和画图都是很好的办法，发现自己的错误和漏洞并加以改正
public class Offer19二叉树的镜像 {
    public static void main(String[] args)
    {
        BiTree biTreeClass=new BiTree();//实例化一个对象
        BinaryTreeNode biTree=new BinaryTreeNode();
        biTree=biTreeClass.CreatTree1();
        biTree=null;
        MirrorRecursively(biTree);
    }
    public static void MirrorRecursively(BinaryTreeNode biTree)
    {
        if (biTree==null)
            return ;
        if ((biTree.left==null)&&(biTree.right==null))
            return ;
        //树的左右子树有一个不为空，需要进行交换
        BinaryTreeNode temp=new BinaryTreeNode();
        temp=biTree.left;
        biTree.left=biTree.right;
        biTree.right=temp;
        //左右子树节点交换完毕，继续交换左右子树
        MirrorRecursively(biTree.left);
        MirrorRecursively(biTree.right);
    }
}
