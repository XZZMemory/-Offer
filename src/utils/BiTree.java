package utils;
import java.util.Scanner;

public class BiTree {
    public static BinaryTreeNode CreatTree()
    {
        System.out.println("输入1-退出创建节点，其他数字输入节点内容：");
        Scanner sc=new Scanner(System.in);
        int option=sc.nextInt();
        if (option!=1)
        {
            BinaryTreeNode BiTree=new BinaryTreeNode();
            BiTree.info=option;
            System.out.println("创建节点"+option+"的左子树");
            BinaryTreeNode left1=new BinaryTreeNode();
            BiTree.left=CreatTree();
            System.out.println("创建节点"+option+"的右子树");
            BiTree.left=CreatTree();
            return BiTree;
        }
        else
        {
            System.out.println("结束节点创建");
            return null;}
    }
    public static BinaryTreeNode CreatTree1()
    {
        BinaryTreeNode BiTree=new BinaryTreeNode();
        BinaryTreeNode left1=new BinaryTreeNode();
        BinaryTreeNode right1=new BinaryTreeNode();
        BinaryTreeNode left2=new BinaryTreeNode();
        BinaryTreeNode right2=new BinaryTreeNode();
        BinaryTreeNode left3=new BinaryTreeNode();
        BinaryTreeNode right3=new BinaryTreeNode();
        BiTree.info=8;
        BiTree.left=left1;
        BiTree.right=right1;
        right1.info=7;
        right1.left=null;
        right1.right=null;
        left1.info=8;
        left1.left=left2;
        left1.right=right2;
        left2.info=9;
        left2.left=null;
        left2.right=null;
        right2.info=2;
        right2.left=left3;
        right2.right=right3;
        left3.info=4;
        left3.right=null;
        left3.left=null;
        right3.info=7;
        right3.left=null;
        right3.right=null;
        return BiTree;
    }
    public static BinaryTreeNode CreatTree2()
    {
        BinaryTreeNode BiTree=new BinaryTreeNode();
        BinaryTreeNode left1=new BinaryTreeNode();
        BinaryTreeNode right1=new BinaryTreeNode();
        BiTree.info=8;
        BiTree.left=left1;
        BiTree.right=right1;
        left1.info=9;
        left1.left=null;
        left1.right=null;
        right1.info=2;
        right1.left=null;
        right1.right=null;
        return BiTree;
    }
    public static BinaryTreeNode CreatTree3()
    {
        BinaryTreeNode biTree=new BinaryTreeNode();//根节点
        BinaryTreeNode left1=new BinaryTreeNode();
        BinaryTreeNode right1=new BinaryTreeNode();
        BinaryTreeNode left2=new BinaryTreeNode();
        BinaryTreeNode right2=new BinaryTreeNode();
        biTree.info=10;
        biTree.left=left1;
        biTree.right=right1;
        left1.info=5;
        left1.left=left2;
        left1.right=right2;
        right1.info=12;
        right1.left=null;
        right1.right=null;
        left2.info=4;
        left2.left=null;
        left2.right=null;
        right2.info=7;
        right2.left=null;
        right2.right=null;
        return biTree;
    }
    public static BinaryTreeNode CreatTree4()
    {
        BinaryTreeNode biTree=new BinaryTreeNode();
        BinaryTreeNode left1=new BinaryTreeNode();
        BinaryTreeNode right1=new BinaryTreeNode();
        BinaryTreeNode left2=new BinaryTreeNode();
        BinaryTreeNode right2=new BinaryTreeNode();
        biTree.info=10;
        biTree.left=left1;
        biTree.right=right1;
        left1.info=6;
        left1.left=left2;
        left1.right=right2;
        right1.info=14;
        right1.left=null;
        right1.right=null;
        left2.info=4;
        left2.left=null;
        left2.right=null;
        right2.info=8;
        right2.left=null;
        right2.right=null;
        return biTree;
    }
    public static BinaryTreeNode CreatTree5()
    {
        BinaryTreeNode biTree=new BinaryTreeNode();
        BinaryTreeNode left1=new BinaryTreeNode();
        BinaryTreeNode right1=new BinaryTreeNode();
        biTree.info=2;
        biTree.left=left1;
        biTree.right=right1;
        left1.info=1;
        left1.left=null;
        left1.right=null;
        right1.info=3;
        right1.left=null;
        right1.right=null;
        return biTree;
    }
    public static void  PreOrder(BinaryTreeNode BiTree )
    {
        if(BiTree==null)
            return;
        System.out.print(BiTree.info);
        PreOrder(BiTree.left);
        PreOrder(BiTree.right);
    }
    public static void InOrder(BinaryTreeNode BiTree)
    {
        if (BiTree==null)
            return;
        InOrder(BiTree.left);
        System.out.println(BiTree.info);
        InOrder(BiTree.right);

    }
    public static void PostOrder(BinaryTreeNode BiTree)
    {
        if (BiTree==null)
            return;
        PreOrder(BiTree.left);
        PreOrder(BiTree.right);
        System.out.println(BiTree.info);
    }
}

