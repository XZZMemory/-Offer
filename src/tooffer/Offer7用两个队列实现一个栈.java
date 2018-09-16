package tooffer;

import utils.Queue;

import java.util.Scanner;

public class Offer7用两个队列实现一个栈 {
    public static void main(String[] args)
    {
        System.out.println("请输入操作，1-进栈，2-出栈，3-退出");
        int[] operationList={1,2,3};
        Queue queue1=new Queue();
        Queue queue2=new Queue();
        Scanner scanner=new Scanner(System.in);
        int operation=scanner.nextInt();
        while(operation!=3)
        {
            if (IsContain(operationList,operation))
            {
                switch (operation)
                {
                    case 1:

                        System.out.println("请输入进栈元素:");
                        Scanner scanner2=new Scanner(System.in);
                        int data=scanner2.nextInt();
                        Push(queue1,queue2,data);
                        break;
                    case 2:
                        Pop(queue1,queue2);
                        break;
                }
            }
            else
                System.out.println("操作错误，请重新输入操作数");
            System.out.println("请输入操作，1-进栈，2-出栈，3-退出");
            Scanner s=new Scanner(System.in);
            operation=s.nextInt();
        }
        System.out.println("退出程序！");

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
    public static void Push(Queue queue1,Queue queue2,int data)
    {
        if (queue1==null||queue2==null)
        {
            System.out.println("队列不存在！");
            return;
        }
        if (!Queue.IsEmpty(queue1))//队1不空
        {
            if (queue1.rear==queue1.queue.length)
            {
                System.out.println("栈已满！请先出栈");
                return;
            }
            queue1.queue[++queue1.rear]=data;
            System.out.println("进栈元素是："+data);
        }
        else //队列2不空
        {
            if (queue2.rear==queue2.queue.length)
            {
                System.out.println("栈已满，请先出栈！");
                return;
            }
            queue2.queue[++queue2.rear]=data;
            System.out.println("进栈元素是："+data);
        }
    }
    //出栈
    public static void Pop(Queue queue1,Queue queue2)
    {
        if (queue1==null||queue2==null)
        {
            System.out.println("队列不存在");
            return;
        }
        if (!Queue.IsEmpty(queue1))//队列1不空！
        {
            if (!Queue.IsEmpty(queue2))
            {
                System.out.println("对列有误！！");
                return;
            }
            while(queue1.front<queue1.rear-1)
                queue2.queue[++queue2.rear]=queue1.queue[++queue1.front];
            //queue1.front=queue1.rear-1
            System.out.println("当前出栈元素是："+queue1.queue[++queue1.front]);//
            queue1.front=queue1.rear=-1;//初始化，队首队尾均为-1
        }
        else if (!Queue.IsEmpty(queue2))//队列2不空
        {
            if (!Queue.IsEmpty(queue1))
            {
                System.out.println("对列有误！");
                return;
            }
            while (queue2.front<queue2.rear-1)
                queue1.queue[++queue1.rear]=queue2.queue[++queue2.front];
            System.out.println("当前出栈元素是："+queue2.queue[++queue2.front]);
            queue2.front=queue2.rear=-1;//初始化，队首队尾均为-1
        }
        else
        {
            System.out.println("栈内没有元素，请先进栈！");
        }
    }
}
