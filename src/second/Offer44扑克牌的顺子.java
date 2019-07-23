package second;

import java.util.Arrays;

/**
 * created by memory
 * on 2019/7/23 10 52
 * 题目：从扑克牌中随机抽取5张牌，判断是不是一个顺子,即这五张牌是不是连续的。2~10为数字本身，A为1，J为11，Q为12，K为13，而大小王可以看成任意数字
 */
public class Offer44扑克牌的顺子 {
    private static final int number = 5;

    public static void main(String[] args) {
        char[] data = "QKJ*5".toCharArray();
        System.out.println(isContinuous(data));

    }

    public static boolean isContinuous(char[] data) {
        int[] formatData = checkAndFormatData(data);
        if (formatData == null) {
            return false;
        }
        int numOf0 = 0;
        /* 统计大小王的个数*/
        for (int i = 0; i < formatData.length; i++) {
            if (formatData[i] == 0) {
                ++numOf0;
                if (numOf0 > 2) {
                    return false;
                }
            }
        }
        Arrays.sort(formatData);
        int distance = 0;
        for (int i = numOf0; i < formatData.length - 1; i++) {
            int currentDistance = formatData[i + 1] - formatData[i];
            if (currentDistance == 0) {
                return false;
            }
            distance += currentDistance;
        }
        if (distance <= 4) {
            return true;
        }
        return false;
    }

    /**
     * 2~10为数字本身，A为1，J为11，Q为12，K为13，而大小王可以看成任意数字
     */
    public static int[] checkAndFormatData(char[] data) {
        if (data == null || data.length != number) {
            return null;
        }
        int[] result = new int[number];
        for (int i = 0; i < data.length; i++) {
            char currentData = data[i];
            if (currentData >= '1' && currentData <= '9') {
                result[i] = currentData - '1' + 1;
            } else if (currentData == '*') {
                /*大小王用* 表示*/
                result[i] = 0;
            } else if (currentData == 'A') {
                result[i] = 1;
            } else if (currentData == 'J') {
                result[i] = 11;
            } else if (currentData == 'Q') {
                result[i] = 12;
            } else if (currentData == 'K') {
                result[i] = 13;
            } else {
                return null;
            }
        }
        return result;
    }
}
