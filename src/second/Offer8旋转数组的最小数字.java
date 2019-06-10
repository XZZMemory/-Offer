package second;

/**
 * 输出旋转数组的最小数字 3, 4, 5, 1, 2 输出 1
 * created by memory
 * on 2019/5/30 下午7:05
 */
public class Offer8旋转数组的最小数字 {
    public static void main(String[] args) {
        //首先考虑二分查找，特殊情况，当两个指针指向的数字以及它们中间的数字相等时
        int[] numbers = {3, 4, 5, 1, 2};
        int[] numbers2 = {2, 1};
        int[] numbers3 = {1, 1, 0, 1};
        findMin(numbers);
        findMin(numbers2);
        findMin(numbers3);
    }

    public static void findMin(int[] numbers) {
        if (numbers == null || numbers.length == 0) {
            return;
        }
        int start = 0;
        int end = numbers.length - 1;
        int mid;
        while (start <= end) {
            /**虽然条件判断没有包括常理的所有情况，但是包括了该排序数组中的所有情况。*/
            if (end - start == 1) {
                System.out.println("找到最小数据是： " + numbers[end]);
                return;
            }
            mid = (start + end) / 2;
            if (numbers[mid] > numbers[start]) {
                start = mid;
            } else if (numbers[mid] < numbers[end]) {
                end = mid;
            } else if (numbers[mid] == numbers[start] && numbers[start] == numbers[end]) {
                System.out.println("找到最小的数据是： " + numbers[sequentialSearch(numbers, start, end)]);
                return;
            }
        }
    }

    public static int sequentialSearch(int[] numbers, int start, int end) {
        int num = numbers[start];
        for (int i = start + 1; i <= end; i++) {
            if (numbers[i] != num) {
                return i;
            }
        }
        return num;
    }
}
