package tooffer;

import java.util.Scanner;

//传统方法不能解决大数问题，利用数组存储数据，可以解决大数问题
public class Offer12打印1到最大的n位数 {
    public static void main(String[] args)
    {
        System.out.println("请输入多少位数-n:");
        Scanner scanner=new Scanner(System.in);
        int n=scanner.nextInt();
        Print1ToMaxOfNDigits(n);
    }
    //传统的方法，如果输入的n较大，1~99999999999999999，即大数问题，不能直接整型数据存储，会产生溢出。
    public static void Print1ToMaxOfNDigits_1(int n)
    {
        int number=1;
        for (int i=0;i<n;i++)
        {
            number*=10;
        }
        for (int i=0;i<number;i++)
            System.out.println("数字是："+i);
    }
    public static void Print1ToMaxOfNDigits(int n)
    {
        if (n<=0)
            return;
        char[] number=new char[n];
        for (int i=0;i<number.length;i++)
            number[i]='0';
        while(!Increment(number))//当没有达到最大值时 函数Increment实现number加1并返回true，若达到最大值，则返回false
        {
            PrintNumber(number);
            System.out.println("  ");

        }
    }
    //每次数字变大均是在个位上加1，其他位则判断有没有进位，如果是最左面第一位进位，则说明数据已经达到最大，返回false，退出程序
    public static boolean Increment(char[] number)
    {
        boolean isOverFlow=false;//是否溢出，初始化为false
        int nTakeOver=0;//进位是多少
        for (int i=number.length-1;i>=0;i--)//i数字的第多少位
        {
            int nSum=(int)number[i]-(int)'0'+nTakeOver;//nSum：当前i位的值是：=number[i]+上一位的进位值
            if(i==number.length-1)//即数组的最后一位，即数字的个位，每次数字变大，均是在个位上加1
                nSum++;
            if(nSum>=10)//当前i位的值>10，所以发生进位
            {
                if (i==0)
                    isOverFlow=true;
                else
                {
                    nSum-=10;
                    nTakeOver=1;
                    number[i]=(char) (nSum+(int)'0');
                }
            }
            else//当前i位的值<10,不发生进位，
            {
                number[i]=(char)(nSum+(int)'0');
                break;
            }
        }
        return isOverFlow;
    }
    public static void PrintNumber(char[] number)
    {
        boolean isBeginningOf0=true;
        for(int i=0;i<number.length;i++)
        {
            if (isBeginningOf0&&(number[i]!='0'))
                isBeginningOf0=false;
            if (!isBeginningOf0)
                System.out.print(number[i]);
        }
    }
}
