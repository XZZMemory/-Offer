package tooffer;

import java.lang.reflect.Array;

public class Offer12任意两个整数的加法 {
    public static void main(String[] args)
    {
        char[] num1="-9999999999990".toCharArray();
        char[] num2="".toCharArray();
        char[] result=Add(num1,num2);
        Print(result);
    }
    public static char[]  Add(char[]num1,char[] num2)
    {
        if (num1==null||num1.length==0)
            return num2;
        if (num2==null||num2.length==0)
            return num1;
        //num1和num2均不为空！
        int flag1=Check(num1);
        int flag2=Check(num2);
        if (flag1==0||flag2==0)
            return null;
        if(flag1*flag2>0)//同号
            return AddTwoSimpleNum(num1,num2);
        else//异号
        {
            if (flag1==1)
                return Subtract(num1,num2);
            else //flag2=1
                return Subtract(num2,num1);
        }
    }
    public static char[] AddTwoSimpleNum(char[] num1,char[] num2)
    {
        if (num1[0]=='-')
        {
            char[] num1_=new char[num1.length-1];
            char[] num2_=new char[num2.length-1];
            System.arraycopy(num1,1,num1_,0,num1.length-1);
            System.arraycopy(num2,1,num2_,0,num2.length-1);
            char[] result1=AddPositiveNum(num1_,num2_);
            char[] result=new char[num1.length>num2.length?num1.length+1:num2.length+1];
            result[0]='-';
            System.arraycopy(result1,0,result,1,result1.length);
            return result;
        }
        return AddPositiveNum(num1,num2);
    }
    public static char[] AddPositiveNum(char[] num1,char[] num2)
    {
        char[] result=new char[num1.length>num2.length?num1.length+1:num2.length+1];//记录结果
        int index1=num1.length-1;
        int index2=num2.length-1;
        int indexResult=result.length-1;
        int takeOver=0;//进位
        while(index1>=0&&index2>=0&&indexResult>=0)
        {
            int data1=(int)(num1[index1]-'0');
            int data2=(int)(num2[index2]-'0');
            int data=data1+data2+takeOver;
            result[indexResult]=(char)(data%10+(int)'0');//当前的值
            takeOver=data/10;//进位
            index1--;
            index2--;
            indexResult--;
        }
        if (index1>=0)
        {
            while(index1>=0&&indexResult>=0)
            {
                int data1=(int)(num1[index1]-'0');
                int data=data1+takeOver;
                result[indexResult]=(char)(data%10+(int)'0');//当前的值
                takeOver=data/10;//进位
                index1--;
                indexResult--;
            }
        }
        else if (index2>=0)
        {
            while(index2>=0&&indexResult>=0)
            {
                int data2=(int)(num2[index2]-'0');
                int data=data2+takeOver;
                result[indexResult]=(char)(data%10+(int)'0');//当前的值
                takeOver=data/10;//进位
                index2--;
                indexResult--;
            }
        }
        result[indexResult]=(char)(takeOver+(int)'0');
        return result;

    }
    public static char[] Subtract(char[] num1,char[] num2)
    {//num1：正树，num2-负数
        char []result=new char[num1.length>num2.length?num1.length+1:num2.length+1];//记录结果
        return null;
    }
    //正值 返回1 负值返回-1  数值错误返回0
    public static int Check(char[] num)
    {
        if (num==null||num.length==0)
            return 0;
        int flag=0;
        for (int i=0;i<num.length;i++)
        {
            if ((num[i]>'9')||(num[i]<'0'))
            {
                if((i==0)&&(num[i]=='+'||num[i]=='-'))
                {
                    if (num[i] == '-')
                    {flag = -1;}
                    else
                    {flag = 1;}
                }
                else{
                        System.out.println("参数错误");
                        return 0;
                }
            }
        }
        return flag;
    }
    public static void Print(char[] num)
    {
        if (num==null||num.length==0)
            return;
        for (int i=0;i<num.length;i++)
        {
            System.out.print(num[i]);
        }
    }
}
