//输入一个二叉树，输出他的镜像
package offer;
import utils.*;

import java.util.Stack;

//每一步访问地址的时候都要注意是否为null，为空的话要注意处理写代码之前讲清思路，举例子和画图都是很好的办法，发现自己的错误和漏洞并加以改正
public class Offer19二叉树的镜像 {
    public static void main(String[] args)
    {
        BiTreeNode biTree=new BiTreeNode();
        biTree=BiTree.creatTree3();
        BiTree.inOrder(biTree);
        //biTree=null;
        mirrorRecursivelyLoop(biTree);
        BiTree.inOrder(biTree);
    }
    //使用递归
    public static void mirrorRecursively(BiTreeNode biTree)
    {
        if (biTree==null)
            return ;
        if ((biTree.left==null)&&(biTree.right==null))//左右子树均为空，则不再需要任何操作，直接返回。
            return ;
        //树的左右子树有一个不为空，需要进行交换
        BiTreeNode temp=new BiTreeNode();
        temp=biTree.left;
        biTree.left=biTree.right;
        biTree.right=temp;
        //左右子树节点交换完毕，继续交换左右子树
        mirrorRecursively(biTree.left);
        mirrorRecursively(biTree.right);
    }
    //使用循环
    public static void mirrorRecursivelyLoop(BiTreeNode root) {
        Stack<BiTreeNode> stack=new Stack<BiTreeNode>();
        if (root==null)
            return;
        stack.push(root);
        while (!stack.empty())
        {
            BiTreeNode p=stack.pop();
            if (!(p.left==null&&p.right==null))
            {
                if (p.left!=null)
                    stack.push(p.left);
                if (p.right!=null)
                    stack.push(p.right);
                BiTreeNode temp = p.left;
                p.left = p.right;
                p.right=temp;
            }
        }
    }
}
