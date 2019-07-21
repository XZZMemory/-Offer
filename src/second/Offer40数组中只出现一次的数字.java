package second;

/**
 * created by memory
 * on 2019/7/21 21 26
 */

/**
 * 题目：
 * 一个数组找中除了两个数字之外，其他的数字都出现了两次，
 * 要求找出这两个只出现一次的数字，要求时间复杂度是O(n)，空间复杂度是O(1)
 * {2,4,3,6,3,2,5,5,}  4和6
 */
public class Offer40数组中只出现一次的数字 {
    public static void main(String[] args) {
        int[] data = {2, 4, 3, 6, 3, 2, 5, 5};
        int[] num = findNumsAppearOnce(data);
    }

    public static int[] findNumsAppearOnce(int[] data) {
        if (data == null || data.length < 2) {
            return null;
        }
        int num = 0;
        for (int i = 0; i < data.length; i++) {
            num = data[i] ^ num;
        }
        int flag = findBit1(num);
        /*参数异常*/
        if (flag < 0) {
            return null;
        }
        int[] result = new int[2];
        for (int i = 0; i < data.length; i++) {
            int currentData = data[i];
            if (isBit1(currentData, flag)) {
                result[0] = result[0] ^ currentData;
            } else {
                result[1] = result[1] ^ currentData;
            }
        }
        return result;
    }

    /**
     * 找到二进制表示中，最右面是1的是哪一位,最后返回的是2^位数，不是位数，是十进制表示的数值
     */
    public static int findBit1(int num) {
        for (int flag = 1; flag < Integer.MAX_VALUE; flag = flag << 1) {
            if ((flag & num) != 0) {
                return flag;
            }
        }
        return -1;
    }

    public static boolean isBit1(int num, int flag) {
        if ((num & flag) != 0) {
            return true;
        }
        return false;
    }
}

