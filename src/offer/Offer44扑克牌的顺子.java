package offer;

import java.util.Arrays;
import java.util.Scanner;

//从扑克牌中随机抽取5张牌，判断是不是一个顺子
public class Offer44扑克牌的顺子 {
    public static void main(String[] args)
    {
        Scanner scanner=new Scanner(System.in);
        System.out.print("请输入5张牌：");
        String string=scanner.nextLine();
        if (string=="") {
            System.out.println("数据输入错误！");
            return;
        }
        String[] str=string.split(" ");
        int[] data=new int[str.length];
        scanner.close();
        for (int i=0;i<str.length;i++)
            data[i]=Integer.parseInt(str[i]);
        boolean result=IsContinuous(data);
        System.out.println(result);
    }
    public static boolean IsContinuous(int[] data)
    {
        if (data==null||data.length!=5)
            return false;
        Arrays.sort(data);
        int numberOf0=0;
        for (int i=0;i<data.length&&data[i]==0;i++)
                numberOf0++;
        if (numberOf0>2)
        {
            System.out.println("0的个数大于2，数据出错！");
            return false;
        }
        for (int i=numberOf0+1;i<data.length;i++)
        {
            int current_daistance=data[i]-data[i-1];
            if (current_daistance==0)
            {
                System.out.println("有重复数据！");
                return false;
            }
            else
            {
                numberOf0-=current_daistance-1;
                if (numberOf0<0)
                    return false;
            }
        }
        return true;
    }
}
