package tooffer;

import utils.BiTree;
import utils.BiTreeQueue;
import utils.BinaryTreeNode;
import utils.LinkList;

import java.util.ArrayList;
import java.util.LinkedList;
import java.util.List;
import java.util.Queue;

public class Offer60把二叉树打印成多行 {
    public static void main(String[] args)
    {
        BiTree biTreeClass =new BiTree();
        BinaryTreeNode biTree=new BinaryTreeNode();
        biTree=biTreeClass.CreatTree4();
        HierarchicalTraversalOfBiTree(biTree);
    }
    public static void HierarchicalTraversalOfBiTree(BinaryTreeNode biTree)
    {
        //List和Queue均是接口
        //List<BinaryTreeNode> list=new ArrayList<BinaryTreeNode>();
        if (biTree==null)
            return;
        Queue<BinaryTreeNode> queue=new LinkedList<BinaryTreeNode>();
        ArrayList<Integer> arrayList=new ArrayList<Integer>();
        int level=1;
        int currentLevel=1;
        queue.add(biTree);
        arrayList.add(level);//第一层
        while (!queue.isEmpty())
        {
            BinaryTreeNode node=queue.remove();

            //if (currentLevel==arrayList[queue.rear])
        }
    }
}

