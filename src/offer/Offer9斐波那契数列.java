package offer;//写一个函数，输入数字n，要求求斐波那契数列的第n项

import java.util.Scanner;

public class Offer9斐波那契数列 {
    public static void main(String[] args) {
        System.out.println("请输入n：");
        Scanner in;
        in = new Scanner(System.in);
        int n;
        n = in.nextInt();//
        while (n < 0) {
            System.out.println("输入的数字是负数，请重新输入数字");
            in = new Scanner(System.in);
            n = in.nextInt();
        }
        int fibon = bFibonacci(n);
        System.out.println("斐波那契是" + fibon);
    }

    //递归方法求斐波那契数列,f(9),这一层递归需要计算f(8)、f(7)、f(6)、f(5)、、，需要一个递归专门计算，
    // 2而在计算f(8)时，需要计算f(7)、f(6)、f(5)、、、、这样f（5）需要计算两次，重复计算递归浪费空间，比较麻烦
    public static int fibonacci(int n) {
        if (n == 0)
            return 0;
        else if (n == 1)
            return 1;
        else
            return fibonacci(n - 1) + fibonacci(n - 2);
    }

    //数组方法求斐波那契数列,求得每一项，存在数组中
    public static void arrayFibonacci(int n) {
        int[] Fibonacci = new int[100];
        Fibonacci[0] = 0;
        Fibonacci[1] = 1;
        for (int i = 2; i < n + 1; i++) {
            Fibonacci[i] = Fibonacci[i - 1] + Fibonacci[i - 2];
        }
    }

    public static int bFibonacci(int n) {
        //0，1,1,2,3,5,8]
        int num = 0;
        int first = 0;
        int second = 1;
        if (n == 0)
            num = 0;
        else if (n == 1)
            num = 1;
        else {
            for (int i = 2; i <= n; i++) {
                num = first + second;
                first = second;
                second = num;
            }
        }
        return num;
    }
}
