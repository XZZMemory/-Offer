package 第二遍;

import java.util.Stack;

/**
 * created by memory
 * on 2019/6/4 下午3:33
 */
public class Offer22栈的压入弹出序列 {
    public static void main(String[] args) {
        int[] push = {1, 2, 3, 4, 5};
        int[] pop = {4, 5, 2, 3, 1};
        System.out.println(isPopOrder(push, pop));
    }

    public static boolean isPopOrder(int[] push, int[] pop) {
        if (push == null || pop == null || (push.length != pop.length)) {
            return false;
        }
        int indexPush = 0;
        int indexPop = 0;
        Stack<Integer> stack = new Stack<>();
        stack.push(push[indexPush]);
        indexPush++;
        for (int i = 0; i <push.length ; i++) {
            if (push[i]== )
        }
    }

}
