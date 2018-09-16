//二叉树的层次遍历
package tooffer;
import utils.*;
public class Offer23从上往下打印二叉树 {
    public static void main(String[] args)
    {
        BiTree biTreeClass =new BiTree();
        BinaryTreeNode biTree=new BinaryTreeNode();
        biTree=biTreeClass.CreatTree1();
        HierarchicalTraversalOfBiTree(biTree);
    }
    public static void HierarchicalTraversalOfBiTree(BinaryTreeNode biTree)
    {
        //队列的初始化
        BiTreeQueue queue=new BiTreeQueue();
        queue.Init(queue);
        BinaryTreeNode p=new BinaryTreeNode();
        if (biTree!=null)
            queue.InQueue(queue,biTree);//进队列
        while(!queue.IsEmpty(queue))
        {
            p=queue.DeQueue(queue);//出队列
            System.out.println("当前访问节点是："+p.info);
            //节点的左右孩子进栈
            if (p.left!=null)
                queue.InQueue(queue,p.left);
            if (p.right!=null)
                queue.InQueue(queue,p.right);
        }
    }
}
