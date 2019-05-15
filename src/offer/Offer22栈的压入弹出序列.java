//第一个序列为栈的压入顺序，请判断第二个序列是否为该栈的弹出顺序
package offer;

public class Offer22栈的压入弹出序列 {
    public static void main(String[] args) {
        int[] push = {1, 2, 3, 4, 5};
        int[] pop = {4, 5, 2, 3, 1};
        System.out.println(isPopOrder(push, pop));
    }

    //使用java自带的栈
    public static boolean isPopOrder(int[] push, int[] pop) {
        java.util.Stack<Integer> stack = new java.util.Stack<Integer>();
        int j = 0;
        for (int i = 0; i < push.length; i++) {
            stack.push(push[i]);
            while (stack.peek() == pop[j]) {
                stack.pop();
                j++;
            }
        }
        if (stack.empty())
            return true;
        return false;
    }
}