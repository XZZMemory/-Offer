package first;

/**
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
        int[] num = new int[2];
        int result = 0;
        for (int i = 0; i < data.length; i++)
            result = result ^ data[i];
        int index = findFirstBitsIs1(result);
        for (int i = 0; i < data.length; i++) {
            if (isBit1(data[i], index))
                num[0] ^= data[i];
            else
                num[1] ^= data[i];
        }
        return num;
    }

    public static int findFirstBitsIs1(int num)//找到数字num最右面为1的位
    {
        int indexBit = 1;
        while (((num & 1) == 0) && (indexBit < 32)) {
            num = num >> 1;
            indexBit++;
        }
        if ((num & 1) == 1)
            return indexBit;
        else
            return -1;
    }

    public static boolean isBit1(int num, int indexBit) {
        if (((num >> indexBit - 1) & 1) == 1)
            return true;
        else
            return false;
    }
}

