package second;

import java.util.Random;

/**
 * created by memory
 * on 2019/6/12 下午8:20
 */
public class Offer30最小的k个数 {
    public static void main(String[] args) {
        int[] numbers = {4, 5, 1, 6, 2, 7, 3, 8};
        int k = 4;
        findLeastNumbers(numbers, k);
        for (int i = 0; i < numbers.length; i++)
            System.out.print(numbers[i] + " ");
    }

    /*当我们可以修改输入数组时，可以用这种方法,利用快排*/
    public static void findLeastNumbers(int[] numbers, int k) {
        if (numbers == null || numbers.length < k) {
            System.out.println("参数异常！");
            return;
        }
        int start = 0;
        int end = numbers.length - 1;
        int index = quickSort(numbers, start, end);
        while (index != (k - 1)) {
            if (index < (k - 1)) {
                start = index;
            } else if (index > (k - 1)) {
                end = index;
            }
            index = quickSort(numbers, start, end);
        }
    }

    public static int quickSort(int[] numbers, int start, int end) {
        int middle = new Random().nextInt(end - start + 1) + start;
        int flag = numbers[middle];
        while (start < end) {
            while (numbers[start] <flag && start < end) {
                ++start;
            }
            while (numbers[end] >= flag && start < end) {
                --end;
            }
            if (start < end) {
                int temp = numbers[start];
                numbers[start] = numbers[end];
                numbers[end] = temp;
                ++start;
                --end;
            }
        }
        return start;
    }
    /*适用于处理海量数据，使用大根堆*/
    public static void heapSort(){

    }
}
