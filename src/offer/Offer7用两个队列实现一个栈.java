package offer;

import java.util.LinkedList;
import java.util.Queue;
import java.util.Scanner;

public class Offer7用两个队列实现一个栈 {
    public static void main(String[] args) {
        //这两个queue1是等价的，来回用，类似于GC的复制算法
        System.out.println("请输入操作，1-进栈，2-出栈，3-退出");
        int[] operationList = {1, 2, 3};
        Queue<Integer> queue1 = new LinkedList<Integer>();
        Queue<Integer> queue2 = new LinkedList<Integer>();
        Scanner scanner = new Scanner(System.in);
        int operation = scanner.nextInt();
        while (operation != 3) {
            if (IsContain(operationList, operation)) {
                switch (operation) {
                    case 1:
                        System.out.println("请输入进栈元素:");
                        Scanner scanner2 = new Scanner(System.in);
                        int data = scanner2.nextInt();
                        Push(queue1, queue2, data);
                        break;
                    case 2:
                        Pop(queue1, queue2);
                        break;
                }
            } else
                System.out.println("操作错误，请重新输入操作数");
            System.out.println("请输入操作，1-进栈，2-出栈，3-退出");
            Scanner s = new Scanner(System.in);
            operation = s.nextInt();
        }
        System.out.println("退出程序！");
    }

    public static boolean IsContain(int[] list, int a) {
        boolean flag = false;
        for (int i = 0; i < list.length; i++) {
            if (list[i] == a) {
                flag = true;
                break;
            }
        }
        return flag;
    }

    //进栈
    public static void Push(Queue queue1, Queue queue2, int data) {
        if (queue1 == null || queue2 == null) {
            System.out.println("队列不存在！");
            return;
        }
        if (!queue1.isEmpty())//队1不空
            queue1.offer(data);
        else //队列2不空
            queue2.offer(data);
        System.out.println("进栈元素是：" + data);
    }

    //出栈
    public static void Pop(Queue queue1, Queue queue2) {
        if (queue1 == null || queue2 == null) {
            System.out.println("队列不存在");
            return;
        }
        if (!queue1.isEmpty())//队列1不空！
        {
            if (!queue2.isEmpty()) {
                System.out.println("对列有误！！");
                return;
            }
            while (queue1.size() > 1)//int size()返回元素个数
                queue2.offer(queue1.poll());
            System.out.println("当前出栈元素是：" + queue1.poll());
        } else if (!queue2.isEmpty())//队列2不空
        {
            if (!queue1.isEmpty()) {
                System.out.println("对列有误！");
                return;
            }
            while (queue2.size() > 1)
                queue1.offer(queue2.poll());
            System.out.println("当前出栈元素是：" + queue2.poll());
        } else {
            System.out.println("栈内没有元素，请先进栈！");
        }
    }
}
