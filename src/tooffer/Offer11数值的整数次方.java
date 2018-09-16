package tooffer;

import java.util.Scanner;

//输入double n、int a，求n的a次方。考虑边界值
public class Offer11数值的整数次方 {
    public static void main(String[] args)
    {
        double result=0.0;
        System.out.println("请输入底数：");
        Scanner scanner=new Scanner(System.in);
        double n=scanner.nextDouble();
        System.out.println("请输入整数型指数：");
        Scanner scanner2=new Scanner(System.in);
        int exponent=scanner2.nextInt();
        result=Power(n,exponent);
        System.out.println("计算结果是："+result);

    }
    public static double Power(double n,int exponent)
    {

        double result;
        int absExponent;
        //当底数是0，指数是负数，没有任何意义，是不允许出现的
        if(Equal(n,0)&&(exponent<0))
        {
            return 0.0;
        }
        absExponent=Math.abs(exponent);
        result=PowerWithUnsignedExponent2(n, absExponent);
        if (exponent<0)
            result=1.0 / result;
        return result;
    }
    public static double PowerWithUnsignedExponent(double n,int exponent)
    {
        double result=1.0;
        for(int i=0;i<exponent;i++)
        {
            result*=n;
        }
        return result;
    }
    public static double PowerWithUnsignedExponent2(double n,int exponent)
    {
        if (exponent==0)
            return 1;
        else if (exponent==1)
            return n;
        else
        {
            double result=PowerWithUnsignedExponent2(n,exponent>>1);
            result*=result;
            if ((exponent&1)==1)//是基数
                result*=n;
            return result;
        }
    }
    public static boolean Equal(double a,double b)
    {
        if (Math.abs(a-b)<0.0000001)
            return true;
        return false;
    }
}
