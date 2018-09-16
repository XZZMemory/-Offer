package utils;

public class Stack {
    public int[] stack=new int[100];
    public int top=-1;
    public static void TraversalOfStack(Stack stack)
    {
        for (int i=0;i<=stack.top;i++)
        {
            System.out.println(stack.stack[i]);
        }
    }
    public static  void Push(Stack stack,int data)
    {
        stack.stack[++stack.top]=data;
    }
    public  static int  PushWithData(Stack stack)
    {
        int data=stack.stack[stack.top--];
        return data;
    }
    public static void Pop(Stack stack)
    {
        stack.top--;
    }
}
