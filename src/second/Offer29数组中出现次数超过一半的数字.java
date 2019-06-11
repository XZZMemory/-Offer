package second;

/**
 * created by memory
 * on 2019/6/11 下午7:54
 */
public class Offer29数组中出现次数超过一半的数字 {
    public static void main(String[] args) {
        int[] numbers = {1, 2, 3, 2, 2, 2, 2, 5, 4, 2};
        System.out.println(moreThanHalfNum2(numbers));
        moreThanHalfNum(numbers);
    }

    public static boolean isInvalid(int[] numbers) {
        if (numbers == null || numbers.length < 1) {
            return false;
        }
        return true;
    }

    /*判断输入的数组是否有效，遍历数组，统计数字 num 出现的次数*/
    public static boolean isMoreThanHalf1(int[] numbers, int num) {
        if (!isInvalid(numbers)) {
            return false;
        }
        int times = 0;
        for (int i = 0; i < numbers.length; i++) {
            if (numbers[i] == num) {
                ++times;
            }
        }
        if (times > numbers.length / 2) {
            return true;
        }
        return false;
    }

    /* 1. 基于快速排序完成*/
    public static int moreThanHalfNum(int[] numbers) {
        if (!isInvalid(numbers)) {
            return -1;
        }
        int num = partion(numbers, 0, numbers.length - 1);
        System.out.println(num);
        return -1;

    }

    public static int partion(int[] numbers, int start, int end) {
        int middle = (start + end) / 2;
        int flag = numbers[middle];
        while (start < end) {
            while (numbers[start] < flag && start < end) {
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
        if (start == (numbers.length + 1) / 2) {
            return numbers[start];
        } else if (start <= (numbers.length + 1) / 2) {
            return partion(numbers, start, numbers.length - 1);
        } else {
            return partion(numbers, 0, start);
        }

    }

    /* 2. 基于数组特点查找，遍历数组，找到出现次数超过一半的数字超过*/
    public static int moreThanHalfNum2(int[] numbers) {
        if (!isInvalid(numbers)) {
            return -1;
        }
        int num = numbers[0];
        int times = 1;
        for (int i = 1; i < numbers.length; i++) {
            if (numbers[i] == num) {
                ++times;
            } else {
                --times;
                if (times == 0) {
                    times = 1;
                    num = numbers[i];
                }
            }
        }
        if (times > 0) {
            if (isMoreThanHalf1(numbers, num)) {
                return num;
            }
        }
        return -1;
    }
}
