package first;

import java.util.Arrays;

/**
 * 输出旋转数组的最小数字
 */
public class Offer8旋转数组的最小数字 {
    public static void main(String[] args) {
        //首先考虑二分查找，特殊情况，当两个指针指向的数字以及它们中间的数字相等时
        int[] numbers = {3, 4, 5, 1, 2};
        int position = findMin(numbers);
        System.out.println("原始数组是: " + Arrays.toString(numbers));
        System.out.println("最小数字的位置是：" + position);
        int[] numbersSorted = sortedArray(numbers, position);
        System.out.println("排序后的数组是：" + Arrays.toString(numbersSorted));
    }

    public static int findMin(int[] numbers) {
        if (numbers == null || numbers.length == 0)
            return -1;
        int pre = 0;
        int post = numbers.length - 1;
        int position = pre;
        while (numbers[pre] >= numbers[post]) {
            if (post - pre == 1)
                return post;
            if ((numbers[pre] == numbers[position]) && (numbers[position] == numbers[post]))//1 1 1 0 1
            {
                position = sequentialSearch(numbers, pre, post);
                return position;
            }
            position = (int) (pre + post) / 2;
            if (numbers[pre] <= numbers[position])
                pre = position;
            else if (numbers[pre] >= numbers[position])
                post = position;
        }
        return position;
    }

    public static int sequentialSearch(int[] numbers, int pre, int post) {
        int num = numbers[pre];
        int position;
        for (position = pre; position < post; position++) {
            if (numbers[position] < numbers[pre]) {
                return position;
            }
        }
        return position;
    }

    public static int[] sortedArray(int[] numbersOld, int position) {
        if (position < 1)
            return numbersOld;
        int[] numbersNew = new int[numbersOld.length];
        int j = 0;
        for (int i = position; i < numbersOld.length; i++, j++)
            numbersNew[j] = numbersOld[i];

        for (int i = 0; i < position; i++, j++)
            numbersNew[j] = numbersOld[i];
        return numbersNew;
    }
}
