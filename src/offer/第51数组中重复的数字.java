package offer;

/**
 * 一个长度为n的数组中所有数字均在（0，n-1）范围内，
 * 数组中某些数字是重复的，但不知道几个数字重复了，也不知道每个数字重复几次。请找出数组中任意一个重复的数字
 */
// 比如长度是7的数组{2,3,1,0,4,5,3}，那么对应输出的重复的数字是2或者3
public class 第51数组中重复的数字 {
    public static void main(String[] args) {
        int[] data = {2, 3, 1, 0, 4, 5, 7};
        int duplication = FindDuplication(data);
    }

    public static int FindDuplication(int[] data) {
        if (data == null || data.length == 0) {
            System.out.println("输入的数组没有数据！");
            return -3;
        }
        for (int i = 0; i < data.length; ) {
            if (data[i] >= data.length || data[i] < 0) {
                System.out.println("输入数据不符合规范！");
                return -2;
            }
            if (data[i] != i) {
                int temp = data[i];
                if (data[temp] == temp)
                    return temp;
                else {
                    data[i] = data[temp];
                    data[temp] = temp;
                }

            } else if (data[i] == i)
                i++;
        }
        return -1;
    }
}


