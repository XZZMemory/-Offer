package Other;

import java.io.File;
import java.io.FileNotFoundException;

public class ExceptionTest {
    public static void main(String[] args)
    {
        ExceptionTest2();
    }
    //try-catch捕获异常
    public static void ExceptionTest1()
    {
        try {
            int[] a = {1, 2};
            int b = a[10];
        }
        catch (ArrayIndexOutOfBoundsException e)
        {
            System.out.println("错误类型是："+e);
        }
    }
    //finally
    public static void ExceptionTest2()
    {
        int[] data={1,2};
        try {
            System.out.println(data[10]);
        }
        catch (ArrayIndexOutOfBoundsException e)
        {
            System.out.println("错误信息是："+e);
        }
        finally {
            System.out.print("执行finally语句部分：");
            data[0]=11;
            System.out.print("data数组0位置存储的数据是："+data[0]);
        }

    }
}
