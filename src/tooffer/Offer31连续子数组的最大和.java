//输入一个整型数组，数组里有正数有负数。数组中一个或多个连续的多个数组成的一个自数组，求所有子数组和的最大值。时间复杂度：O(n)
package tooffer;
public class Offer31连续子数组的最大和 {
    public static void main(String[] args)
    {
        int[] numbers={1,-2,3,10,-4,7,2,-5};
        numbers=null;
        if (numbers==null||numbers.length<0)
        {
            System.out.println("无效输入!");
        }
        else
        {
            int max=FindGreatestSubArray(numbers);
            System.out.println(max);
        }
    }

    public static  int FindGreatestSubArray(int[] numbers)
    {
        if (numbers==null)
            return -1;
        int greatSum=0;
        int currentSum=0;
        for (int i=0;i<numbers.length;i++)
        {
            if (currentSum<0)
                currentSum = numbers[i];
            else //currentsSum>0
                currentSum+=numbers[i];
            if (currentSum>greatSum)
                    greatSum=currentSum;

        }
        return greatSum;

    }
}
