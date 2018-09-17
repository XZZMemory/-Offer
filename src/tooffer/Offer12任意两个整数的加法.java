package tooffer;

import java.lang.reflect.Array;

public class Offer12任意两个整数的加法 {
    public static void main(String[] args)
    {
        char[] num1="99".toCharArray();
        char[] num2="-199".toCharArray();
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
            return AddPositiveNum(num1,num2);
        else//异号
        {
            int max=GetMax(DeletePlusMinus(num1),DeletePlusMinus(num2));
            if (max==0)
            {
                char[] result={'0'};
                return result;
            }
            else
            {
                char[] num1_=DeletePlusMinus(num1);
                char[] num2_=DeletePlusMinus(num2);
                if (max==1)//num1大,位数多
                {
                    if (num1[0]=='-')//num1是一个负值,num2是正值
                    {
                        char[] result_=Subtract(num1_,num2);
                        char[] result=new char[result_.length+1];
                        result[0]='-';
                        System.arraycopy(result_,0,result,1,result_.length);
                        return  result;
                    }
                    else
                        return Subtract(num1_,num2_);
                }
                else //num2大
                {
                    if (num2[0]=='-')//num2大，且num2是正值，num1是负值
                    {
                        char[] result_=Subtract(num2_,num1_);
                        char[] result=new char[result_.length+1];
                        result[0]='-';
                        System.arraycopy(result_,0,result,1,result_.length);
                        return  result;
                    }
                    else //num2大，但num2是正值
                        return Subtract(num2_,num1_);
                }
            }
        }
    }
    //删掉数据刚开始的正负号，-314 -》314  +45 -》45
    public static char[] DeletePlusMinus(char[] num)
    {
        if (num[0]=='-'||num[0]=='+') {
            char[] result = new char[num.length - 1];
            System.arraycopy(num,1,result,0,result.length);
            return result;
        }
        return num;
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
        char[] num1_=DeletePlusMinus(num1);
        char[] num2_=DeletePlusMinus(num2);
        char[] result=new char[num1_.length>num2_.length?num1_.length+1:num2_.length+1];//记录结果
        int index1=num1_.length-1;
        int index2=num2_.length-1;
        int indexResult=result.length-1;
        int takeOver=0;//进位
        while(index1>=0&&index2>=0&&indexResult>=0)
        {
            int data1=(int)(num1_[index1]-'0');
            int data2=(int)(num2_[index2]-'0');
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
                int data1=(int)(num1_[index1]-'0');
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
                int data2=(int)(num2_[index2]-'0');
                int data=data2+takeOver;
                result[indexResult]=(char)(data%10+(int)'0');//当前的值
                takeOver=data/10;//进位
                index2--;
                indexResult--;
            }
        }
        result[indexResult]=(char)(takeOver+(int)'0');
        char[] data=DeleteHead0(result);
        return data;

    }
    public static char[] Subtract(char[] num1,char[] num2)
    {//num1：正树，num2-负数 1大 2小
        char []result=new char[num1.length];//记录结果
        int index1=num1.length-1;
        int index2=num2.length-1;
        int indexResult=result.length-1;
        int borrow=0;
        while (index2>=0)
        {
            int data1=(int)num1[index1]-(int)'0';
            int data2=(int)num2[index2]-(int)'0'+borrow;
            if (data1>=data2)
            {
                result[indexResult] = (char) (data1 - data2 + (int) '0');
                borrow=0;
            }
            else
            {
                data1 += 10;
                borrow=1;
                result[indexResult] = (char) (data1 - data2 + (int) '0');
            }
            index1--;
            index2--;
            indexResult--;
        }
        while (index1>=0)
        {
            if (borrow != 0)
            {
                int data1 = (int) num1[index1] - '0';
                if (data1 >= borrow)
                {
                    result[indexResult] = (char) (data1 - borrow + (int) '0');
                    borrow=0;
                }
                else
                {
                    data1+=10;
                    result[indexResult]=(char)(data1-borrow+(int)'0');
                    borrow=1;
                }
            }
            else
                result[indexResult]=num1[index1];
            index1--;
            indexResult--;
        }
        char[] data =DeleteHead0(result);
        return data;
    }
    //正值 返回1 负值返回-1  数值错误返回0
    public static int Check(char[] num)
    {
        if (num==null||num.length==0)
            return 0;
        int flag=1;
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
        {
            System.out.print("字符串空！");
            return;
        }
        for (int i=0;i<num.length;i++)
        {
            System.out.print(num[i]);
        }
    }
    public static int  GetMax(char[] num1,char[] num2)
    {
        if (num1.length>num2.length)
            return 1;
        else if (num1.length<num2.length)
            return -1;
        for (int i=1;i<num1.length;i++)
        {
            if (num1[i]<num2[i])
                return -1;
            else if (num1[i]>num2[i])
                return 1;
        }
        return 0;
    }
    public static char[] DeleteHead0(char[] num)
    {
        int index=0;
        for (;index<num.length;index++)//统计0出现的位置
        {
            if (num[index]!='0')
                break;
        }
        char[] data=new char[num.length-index];
        System.arraycopy(num,index,data,0,data.length);

        return data;
    }
}
