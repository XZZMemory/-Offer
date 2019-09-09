package other;

/**
 * created by memory
 * on 2019/9/9 15 32
 */
/*找出第一个比左边数字都大，比右边数字都小的数字*/
public class Demo {
    public static void main(String[] args) {
        int[] data = {2, 4, 1, 6, 8, 10};
        int[] leftMax = new int[data.length];
        int[] rightMin = new int[data.length];
        int in = 0;
        for (int i = 0; i < data.length; i++) {
            if (i == 0) {
                leftMax[i] = data[i];
            } else {
                leftMax[i] = data[i] > leftMax[i - 1] ? data[i] : leftMax[i - 1];
            }
        }
        for (int i = data.length - 1; i >= 0; i--) {
            if (i == data.length - 1) {
                rightMin[i] = data[i];
            } else {
                rightMin[i] = data[i] < rightMin[i + 1] ? data[i] : rightMin[i + 1];
            }
        }
        for (int i = 0; i < data.length; i++) {
            int left = i == 0 ? Integer.MIN_VALUE : leftMax[i - 1];
            int right = i == data.length - 1 ? Integer.MAX_VALUE : rightMin[i + 1];
            if (data[i] > left && data[i] < right) {
                System.out.println(data[i]);
                break;
            }
        }
        System.out.println("程序执行结束！");
    }
}
