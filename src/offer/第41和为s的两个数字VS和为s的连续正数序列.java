package offer;

//输入一个递增排序的数组和一个数字s。在数组中查找两个数，使得它们的和正好是s。如果有多对数字的和等于s，输出任意一对即可。
public class 第41和为s的两个数字VS和为s的连续正数序列 {
    public static void main(String[] args) {
        int[] data = {1, 2, 4, 7, 11, 15};
        int sum = 100;
        int[] num = new int[2];
        findNumberWithSum(data, sum, num);
        findContinuousSequence(9);
    }

    public static void findNumberWithSum(int[] data, int sum, int[] num) {
        int start = 0;
        int end = data.length - 1;
        int currentsum;
        while (start <= end) {
            currentsum = data[start] + data[end];
            if (currentsum < sum)
                start--;
            else if (currentsum > sum)
                end--;
            else {
                num[0] = data[start];
                num[1] = data[end];
                break;
            }
        }
        num = null;
    }

    //输入一个正数，打印出所有和为s的连续正数序列 1+2+3+4+5=4+5+6=7+8=15
    public static void findContinuousSequence(int sum) {
        if (sum < 3)
            return;
        int start = 1;
        int end = 2;
        int currentSum = 3;
        int middle = (sum + 1) / 2;
        while ((start < end) && (end <= middle)) {
            if (currentSum == sum) {
                printContinuousSequence(start, end);
                System.out.println("相等");
                end++;
                currentSum += end;
            } else if (currentSum < sum) {
                while ((currentSum < sum) && (end <= middle)) {
                    end++;
                    currentSum += end;
                }
            } else {
                while ((currentSum > sum) && (end <= middle)) {
                    currentSum -= start;
                    start++;
                }
            }
        }
    }

    public static void printContinuousSequence(int start, int end) {
        for (int i = start; i <= end; i++)
            System.out.print(i + " ");
        System.out.println();
    }
}
