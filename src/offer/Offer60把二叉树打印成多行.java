package offer;

import utils.BiTree;
import utils.BiTreeNode;

import java.util.ArrayList;
import java.util.LinkedList;
import java.util.Queue;

public class Offer60把二叉树打印成多行 {
    public static void main(String[] args)
    {
        BiTreeNode biTree=BiTree.creatTree4();
        HierarchicalTraversalOfBiTree(biTree);
    }
    public static void HierarchicalTraversalOfBiTree(BiTreeNode biTree)
    {
        //List和Queue均是接口
        //List<BiTreeNode> list=new ArrayList<BiTreeNode>();
        if (biTree==null)
            return;
        Queue<BiTreeNode> queue=new LinkedList<BiTreeNode>();
        ArrayList<Integer> arrayList=new ArrayList<Integer>();
        int level=1;
        int currentLevel=1;
        queue.add(biTree);
        arrayList.add(level);//第一层
        while (!queue.isEmpty())
        {
            BiTreeNode node=queue.remove();

            //if (currentLevel==arrayList[queue.rear])
        }
    }
}

