package second;

/**
 * created by memory
 * on 2019/6/14 下午4:03
 */
public class Offer31连续子数组的最大和 {
    public static void main(String[] args) {
        int[] numbers = {1, -2, 3, 10, -4, 7, 2, -5, 6};
        System.out.println(find(numbers));
    }

    public static int find(int[] numbers) {
        if (numbers == null || numbers.length < 1) {
            System.out.println("输入的数组无效！");
            return -1;
        }
        int currentNum = 0;
        int lastMax = 0;
        for (int i = 0; i < numbers.length; i++) {
            if (numbers[i] < 0) {
                if (currentNum > lastMax) {
                    lastMax = currentNum;
                }
                currentNum += numbers[i];
                if (currentNum < 0) {
                    currentNum = 0;
                }
            } else {
                currentNum += numbers[i];
            }
        }
        if (currentNum > lastMax) {
            lastMax = currentNum;
        }
        return lastMax;
    }
}
