package Java虚拟机内存模型测试;

public class Java虚拟机栈 {
    public static int count=1;
    public static void main(String[] args) {

        try {
            Recursion(1l,2l,3l);
        }
        catch (Throwable e)
        {
            System.out.println("当前栈的深度是："+count);
            e.printStackTrace();//输出错误流
        }

    }

    public static void Recursion(long a,long b,long c)
    {
        long d=0,e=0,f=0;
        count++;
        Recursion(a,b,c);
    }
}
