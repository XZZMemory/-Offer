package first;

public class Offer29数组中出现次数超过一半的数字 {
    public static void main(String[] args) {
        int[] numbers = {1, 2, 3, 2, 2, 2, 2, 5, 4, 2};
        if (checkInvalidArray(numbers))
            System.out.println("输入的数组无效");
        else {
            int index = moreThanHalfNum(numbers);
            System.out.println("输入的数组中出现次数超过数组长度一半的数字是: " + index);
        }
    }

    /* 1. 基于快速排序完成*/
    public static int moreThanHalfNum(int[] numbers) {
        int index = partition(numbers, 0, numbers.length - 1);
        System.out.println(index);
        int middle = (int) ((numbers.length - 1) / 2);
        int start = 0;
        int end = numbers.length - 1;
        while (index != middle) {
            if (index < middle) {
                index = partition(numbers, index + 1, end);
                System.out.println(index);
            } else if (index > middle) {
                index = partition(numbers, start, index - 1);
                System.out.println(index);
            }
        }
        if (checkMoreThanHalf(numbers, numbers[index]))
            return numbers[index];
        else {
            System.out.println("输入的数组中出现次数最多的数字仍然小于一半");
            return 0;
        }
    }

    //快速排序
    public static int partition(int[] numbers, int start, int end)//数据的起始点start，数据的结束点end
    {
        if ((numbers == null) || (start < 0) || (end >= numbers.length) || (end < start)) {
            System.out.println("信息出错！");
            return -1;
        }
        int index = (int) ((start + end) / 2);
        int num = numbers[index];//选取中间数据
        while (start < end) {
            while ((numbers[end] > num) && (start < end))
                end--;
            while ((numbers[start] <= num) && (start < end))
                start++;
            if (start < end) {
                int temp = numbers[end];
                numbers[end] = numbers[start];
                numbers[start] = temp;
                start++;
                end--;
            }
        }
        return start;
    }

    /*判断输入是否是否有效，判断输入的数组是否为空*/
    public static boolean checkInvalidArray(int[] numbers) {
        if ((numbers == null) || numbers.length < 0)
            return true;
        return false;
    }

    /*判断输入是否有效，最多的数字是否超过一半*/
    public static boolean checkMoreThanHalf(int[] numbers, int num) {
        int times = 0;
        for (int i = 0; i < numbers.length; i++) {
            if (numbers[i] == num)
                times++;
        }
        if (times * 2 < numbers.length)
            return false;
        return true;
    }

    /* 2. 基于数组特点查找，找到出现次数超过一半的数字超过*/
    public static int moreThanHalfNum2(int[] numbers) {
        if (checkInvalidArray(numbers))
            return 0;
        int number = numbers[0];
        int times = 1;
        for (int i = 1; i < numbers.length; i++) {
            if (numbers[i] == number)
                times++;
            else
                times--;
            if (times == 0) {
                number = numbers[i];
                times = 1;
            }
        }
        if (checkMoreThanHalf(numbers, number))
            return number;
        return 0;
    }
}
