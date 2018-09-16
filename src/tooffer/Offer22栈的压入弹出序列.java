//第一个序列为栈的压入顺序，请判断第二个序列是否为该栈的弹出顺序
package tooffer;
import utils.*;
public class Offer22栈的压入弹出序列 {
    public static void main(String[] args){
        int[] push={1,2,3,4,5};
        int[] pop={4,5,2,3,1};
        System.out.println(IsPopOrder(push,pop));
    }
    public static boolean IsPopOrder(int[] push,int[] pop)
    {
        boolean IsPossible=false;
        Stack stack=new Stack();
        int j=0;
        for (int i=0;i<push.length;i++)
        {
            stack.stack[++stack.top]=push[i];
            while((stack.top>-1)&&(stack.stack[stack.top]==pop[j]))
            {
                stack.top--;
                j++;
            }
        }
        if (stack.top==-1)
            IsPossible=true;
        return  IsPossible;
    }
}