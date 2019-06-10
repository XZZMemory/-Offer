package first;

import utils.BiTreeUtil;
import utils.myObject.BiTree;

import java.util.ArrayList;
import java.util.LinkedList;
import java.util.Queue;

public class Offer60把二叉树打印成多行 {
    public static void main(String[] args) {
        BiTree biTree = BiTreeUtil.creatTree4();
        HierarchicalTraversalOfBiTree(biTree);
    }

    public static void HierarchicalTraversalOfBiTree(BiTree biTree) {
        //List和Queue均是接口
        //List<BiTree> list=new ArrayList<BiTree>();
        if (biTree == null)
            return;
        Queue<BiTree> queue = new LinkedList<BiTree>();
        ArrayList<Integer> arrayList = new ArrayList<Integer>();
        int level = 1;
        int currentLevel = 1;
        queue.add(biTree);
        arrayList.add(level);//第一层
        while (!queue.isEmpty()) {
            BiTree node = queue.remove();

            //if (currentLevel==arrayList[queue.rear])
        }
    }
}

