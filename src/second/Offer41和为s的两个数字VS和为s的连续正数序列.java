package second;

/**
 * created by memory
 * on 2019/7/21 21 45
 */

/**
 * 两个题目
 * 题目1: 输入一个递增排序的数组和一个数字s。在数组中查找两个数，使得它们的和正好是s。如果有多对数字的和等于s，输出任意一对即可。
 * 题目2：输入一个正数，打印出所有和为s的连续正数序列 1+2+3+4+5=4+5+6=7+8=15
 */
public class Offer41和为s的两个数字VS和为s的连续正数序列 {
    public static void main(String[] args) {
        /* 题目1测试用例：*/
        int[] data = {1, 2, 4, 7, 11, 15};
        int sum = 11;
        int[] num = findTwoNumbers(data, sum);
        /* 题目2测试用例： */
        findContinuousSequence2(15);
    }

    /**
     * 题目1: 输入一个递增排序的数组和一个数字s。在数组中查找两个数，使得它们的和正好是s。如果有多对数字的和等于s，输出任意一对即可。
     */
    public static int[] findTwoNumbers(int[] data, int sum) {
        if (data == null || data.length < 2) {
            return null;
        }
        for (int begin = 0, end = data.length - 1; begin < end; ) {
            int currentSum = data[begin] + data[end];
            if (currentSum == sum) {
                int[] result = new int[2];
                result[0] = data[begin];
                result[1] = data[end];
                return result;
            } else if (currentSum < sum) {
                ++begin;
            } else {
                --end;
            }
        }
        return null;
    }

    /**
     * 题目2：输入一个正数，打印出所有和为s的连续正数序列 1+2+3+4+5=4+5+6=7+8=15
     * 2.1自己的理解写算法流程
     */
    public static void findContinuousSequence(int sum) {
        if (sum < 3) {
            return;
        }
        int currentSum = 3;
        int start = 1;
        int end = 2;
        int middle = (sum + 1) / 2;
        while (start < end && end <= middle) {
            if (currentSum == sum) {
                /*输出当前连续正数序列*/
                printContinuousSequence(start, end);
                ++end;
                currentSum += end;
            } else if (currentSum < sum) {
                while (currentSum < sum && end <= middle) {
                    ++end;
                    currentSum += end;
                }
            } else {
                while (currentSum > sum && start < end) {
                    currentSum -= start;
                    ++start;
                }
            }
        }
    }

    /**
     * 题目2：输入一个正数，打印出所有和为s的连续正数序列 1+2+3+4+5=4+5+6=7+8=15
     * 2.2书上算法流程。和2.1 算法思想一样，只是执行流程不一样。
     */
    public static void findContinuousSequence2(int sum) {
        int currentSum = 3;
        int start = 1;
        int end = 2;
        int middle = (sum + 1) / 2;
        while (start < middle) {
            if (currentSum == sum) {
                printContinuousSequence(start, end);
            } else if (currentSum > sum) {
                while (currentSum > sum && start < end) {
                    currentSum -= start;
                    ++start;
                }
                if (currentSum == sum) {
                    printContinuousSequence(start, end);
                }
            }
            ++end;
            currentSum += end;
        }
    }

    public static void printContinuousSequence(int start, int end) {
        for (int i = start; i <= end; i++) {
            System.out.print(" " + i);
        }
        System.out.println();
    }

}
