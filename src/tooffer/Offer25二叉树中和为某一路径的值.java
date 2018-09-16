package tooffer;

import utils.*;

public class Offer25二叉树中和为某一路径的值 {
    public static void main(String[] args)
    {
        BiTree biTreeClass=new BiTree();
        BinaryTreeNode biTree=new BinaryTreeNode();
        biTree=biTreeClass.CreatTree3();
        Stack stack=new Stack();
        FindPath(biTree,22,0,stack);
    }
public static void FindPath(BinaryTreeNode biTree,int expectedSum,int currentSum,Stack stack)
{
    if(biTree==null)
        return;
    currentSum+=biTree.info;
    stack.Push(stack,biTree.info);
    if ((currentSum==expectedSum)&&(biTree.IsLeaf(biTree)))//叶子节点且和为需要找的和，则遍历栈并返回
    {
        System.out.println("当前路径为：");
        stack.TraversalOfStack(stack);
        currentSum-=biTree.info;
        stack.Pop(stack);
        return;
    }
    else
    {
        FindPath(biTree.left,expectedSum,currentSum,stack);
        FindPath(biTree.right,expectedSum,currentSum,stack);
        currentSum-=biTree.info;
        stack.Pop(stack);
    }
}
}
