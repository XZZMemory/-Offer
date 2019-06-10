package second;

import java.util.Arrays;

/**
 * created by memory
 * on 2019/6/3 下午3:47
 */
//输入一个整数数组，实现一个函数来调整数组中数字的顺序使得所有奇数位于数组的前半部分 ，所有偶数位于数组的后半部分
//                                            使得数组中的数按照大小分为两部分，所有的负数均位于非负数的前面
//                                            能被3整除的数都在不能被3整除的数前面
//若需要实现这三个函数，则考虑扩展性，在这个模式下方便的把已有的解决方案扩展到同类型的问题上
//********  可扩展性*`解耦，可以提高代码的重用性**************
public class Offer14调整数组顺序使奇数位于偶数前面 {
    public static void main(String[] args) {
        int[] num = {1, -3, 4, -5, 6, 7, 8, 9};
        System.out.println(Arrays.toString(num));
        record(num);
        System.out.println(Arrays.toString(num));
    }

    public static void record(int[] num) {
        if (num == null || num.length == 1) {
            return;
        }
        int start = 0;
        int end = num.length - 1;
        while (start < end) {
            while (start < end && (isFunOf3(num[start]))) {
                ++start;
            }
            while (start < end && (!isFunOf3(num[end]))) {
                --end;
            }
            int temp = num[start];
            num[start] = num[end];
            num[end] = temp;
            ++start;
            --end;
        }
    }

    public static boolean isEven(int num) {
        if ((num & 1) == 0) {
            return true;
        }
        return false;
    }

    public static boolean isPositive(int num) {
        if (num > 0) {
            return true;
        }
        return false;
    }

    public static boolean isFunOf3(int num) {
        if (num % 3 == 0) {
            return true;
        }
        return false;
    }

}