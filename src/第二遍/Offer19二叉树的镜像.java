package 第二遍;

/**
 * created by memory
 * on 2019/6/3 下午8:37
 */

import utils.BiTree;

/**
 * 题目：输入一个二叉树，输出他的镜像
 * 每一步访问地址的时候都要注意是否为null，
 * 为空的话要注意处理写代码之前讲清思路，举例子和画图都是很好的办法，
 * 发现自己的错误和漏洞并加以改正
 */
public class Offer19二叉树的镜像 {
    public static void main(String[] args) {
        BiTree tree = BiTree.creatTree3();
        mirrorRecu(tree);
    }

    public static void mirrorRecu(BiTree tree) {
        if (tree == null) {
            return;
        }
        BiTree temp = tree.left;
        tree.left = tree.right;
        tree.right = temp;
        mirrorRecu(tree.left);
        mirrorRecu(tree.right);
    }
}
