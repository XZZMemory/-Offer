package tooffer;

public class Offer47不用加减乘除做加法 {
    public static void main(String[] args)
    {
        int num1=20;
        int num2=99;
        int result=Add(num1,num2);
    }

    public static int Add(int num1,int num2)
    {
        int sum=0;
    while(num2!=0)
    {
        sum=(num1^num2);
        num2=(num1&num2)<<1;
        num1=sum;

    }
    return num1;
    }
//不使用新的变量，交换两个变量的值，1.正常的加减，2.使用位运算

}
