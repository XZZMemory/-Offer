package offer;

import java.util.Scanner;
import java.util.Stack;

public class Offer21包含min函数的栈使用java原本有的Stack {
    public static void main(String[] args) {
        Stack<Integer> stack_data = new Stack<Integer>();
        Stack<Integer> stack_min = new Stack<Integer>();
        System.out.println("请输入操作，0-退出程序，1-出栈，2-最小元素，其他数据-进栈元素");
        Scanner scanner;
        scanner = new Scanner(System.in);
        int option = scanner.nextInt();
        while (option != 0) {
            switch (option) {
                case 1:
                    if (stack_data.empty())
                        System.out.println("栈空！请先输入数据");
                    else {
                        System.out.println("出栈元素是：" + stack_data.peek());
                        stack_data.pop();
                        stack_min.pop();
                    }
                    break;
                case 2:
                    if (stack_min.empty())
                        System.out.println("栈空！没有最小元素");
                    else
                        System.out.println("当前最小元素是：" + stack_min.peek());
                    break;
                default:
                    stack_data.push(option);
                    if (stack_min.empty())
                        stack_min.push(option);
                    else {
                        int currentMin = stack_min.peek();
                        if (currentMin > option)
                            stack_min.push(option);
                        else
                            stack_min.push(currentMin);
                    }
                    System.out.println("元素" + option + "已进栈");
                    break;
            }
            System.out.println("请输入操作，0-退出程序，1-出栈，2-最小元素，其他数据-进栈元素");
            scanner = new Scanner(System.in);
            option = scanner.nextInt();
        }
    }
}
