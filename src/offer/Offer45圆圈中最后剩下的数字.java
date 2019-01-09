package offer;

import java.util.Scanner;

public class Offer45圆圈中最后剩下的数字 {
    public static void main(String[] args)
    {
        System.out.print("请输入数字n：");
        Scanner scanner=new Scanner(System.in);
        int n=scanner.nextInt();
        System.out.print("请输入数字m：");
        int m=scanner.nextInt();
        scanner.close();
        int number=LastRemaining(n,m);
        System.out.println(number);
    }
    public static  int LastRemaining(int n,int m)
    {
        if (n<1||m<0)
        {
            System.out.println("数据出错！");
            return -1;
        }
        int last=0;
        for (int i=2;i<=m;i++)
            last=(last+m)%i;
        return last;
    }
}
