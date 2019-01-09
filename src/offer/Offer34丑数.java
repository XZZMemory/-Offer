//只包含因子2，3，5的数称作丑数，求按从小到大的顺序的第1500个丑数
package offer;

public class Offer34丑数 {
    public static void main(String[] args)
    {
        int index=100;
        System.out.println("第"+index+"个丑数是："+GetUglyNumber(index));
    }
    public static int GetUglyNumber(int index)
    {
        if (index<1)
            return -1;
        int[] uglyArray=new int [index+1];
        uglyArray[0]=1;
        int m2_index=0;
        int m3_index=0;
        int m5_index=0;
        for (int i=1;i<index+1;i++)
        {
            int min=Min(uglyArray[m2_index]*2,uglyArray[m3_index]*3,uglyArray[m5_index]*5);
            uglyArray[i]=min;
            if (uglyArray[m2_index]*2<=min)
                m2_index++;
            if (uglyArray[m3_index]*3<=min)
                m3_index++;
            if (uglyArray[m5_index]*5<=min)
                m5_index++;
        }
        return uglyArray[index];
    }
    public static int Min(int number1,int number2,int number3)
    {
        int min=(number1<number2)?number1:number2;
        return (min<number3)?min:number3;
    }
}
