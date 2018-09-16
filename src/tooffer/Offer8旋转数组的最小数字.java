package tooffer;

import java.util.Arrays;

public class Offer8旋转数组的最小数字 {
    public static void main(String[] args)
    {
        //首先考虑二分查找，特殊情况，当两个指针指向的数字以及它们中间的数字相等时

        //int[] number={3,4,5,1,2};
        //int[]
        int[] numbers={1};
        int[] number=new int[numbers.length];
        int position=FindMin(numbers);
        Copy(numbers,number,position);
        System.out.println("原始数组是：    "+Arrays.toString(numbers));
        System.out.println("排序后的数组是："+Arrays.toString( number));

        System.out.println(position);

    }

    public static int FindMin(int[] numbers)
    {
        int pre = 0;
        int post = numbers.length - 1;
        int position = pre;
        while (numbers[pre] >=numbers[post])
        {
            if (post - pre == 1)
            {
                return post;

            }
            if ((numbers[pre]==numbers[position])&&(numbers[position]==numbers[post]))
            {
                position=shunxuFind(numbers,pre,post);
                return position;
            }
            position = (int) (pre + post) / 2;
            if (numbers[pre] <= numbers[position])
                pre = position;
            if (numbers[pre] >= numbers[position])
                post = position;
        }
        return position;

    }
    public static int shunxuFind(int[] numbers,int pre,int post)
    {
        int num=numbers[pre];
        int position;
        for (position=pre;position<post;position++)
        {
            if(numbers[position]<numbers[pre])
            {
                return position;
            }
        }
        return position;
    }
    public static  void Copy(int[] numbers,int[] number,int position)
    {
        int j=0;
        for(int i=position;i<numbers.length;i++,j++)
        {
            number[j]=numbers[i];
        }
        for (int i=0;i<position;i++,j++)
        {
            number[j]=numbers[i];
        }
    }
}
