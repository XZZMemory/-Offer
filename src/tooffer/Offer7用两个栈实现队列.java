package tooffer;
import  utils.*;
import java.util.Scanner;

public class Offer7用两个栈实现队列 {
    public static void main(String[] args)
    {
        System.out.println("请输入操作，1-进队列，2-出队列,3-退出");
        //int j=(int)System.in.read();
        Stack stack1=new Stack();
        Stack stack2=new Stack();
        int[] operationList={1,2,3};
        Scanner in;
        in=new Scanner(System.in);
        int i;
        i=in.nextInt();
        while(i!=3)
        {
                if(IsContain(operationList,i))
                {
                    switch (i)
                    {
                        case 1://进栈
                            System.out.println("请输入进栈数据");
                            Scanner Data=new Scanner(System.in);
                            int data=Data.nextInt();
                            InQueue(stack1,data);
                            break;
                        case 2://出栈
                            DeQueue(stack1,stack2);
                            break;

                    }
                System.out.println("请输入操作，1-进栈，2-出栈,3-退出");

                }
                else
                    System.out.println("输入数字不正确，请输入操作，1-进栈，2-出栈,3-退出");
                in=new Scanner(System.in);
                i=in.nextInt();

        }
        if(i==3)
        {
            System.out.println("退出程序");
        }


    }
    public static boolean IsContain(int[] list,int a)
    {
        boolean flag=false;
        for (int i=0;i<list.length;i++)
        {
            if (list[i]==a)
            {
                flag=true;
                break;
            }
        }
        return flag;
    }
    //进栈
    public static void InQueue(Stack stack1, int data)
    {
        System.out.println("执行进栈操作");
        if(stack1.top==stack1.stack.length)
        {
            System.out.println("栈已满，请先出栈");
        }
        else
        {
            stack1.stack[++stack1.top]=data;
        }
        System.out.println("进栈数据是："+stack1.stack[stack1.top]);
    }
    //出栈
    public static void DeQueue(Stack stack1, Stack stack2)
    {
        System.out.println("执行出栈操作");
        if(stack2.top==-1)//第二个栈是空的，已经没有数据了
        {
            if (stack1.top==-1)
                System.out.println("栈空，请先进栈");
            else//栈1的数据需要进入栈2
            {
                for(;stack1.top>-1;)
                {
                    stack2.stack[++stack2.top]=stack1.stack[stack1.top--];
                }
                System.out.println("出栈元素是："+stack2.stack[stack2.top--]);
            }
        }
        else
        {
            System.out.println("出栈元素是："+stack2.stack[stack2.top--]);
        }
    }

}
