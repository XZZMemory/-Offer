package second;

/**
 * created by memory
 * on 2019/7/19 22 02
 */
public class Offer34丑数 {
    public static void main(String[] args) {
        int index = 100;
        System.out.println(getUglyNumber(index));
    }

    public static int getUglyNumber(int index) {
        if (index < 1) {
            System.out.println("参数异常！");
            return -1;
        }
        int[] uglyArray = new int[index + 1];
        uglyArray[0] = 1;
        int m2Index = 0;
        int m3Index = 0;
        int m5Index = 0;
        for (int i = 1; i < uglyArray.length; i++) {
            int min = getMin(uglyArray[m2Index] * 2, uglyArray[m3Index] * 3, uglyArray[m5Index] * 5);
            uglyArray[i] = min;
            if (min == uglyArray[m2Index] * 2) {
                ++m2Index;
            }
            if (min == uglyArray[m3Index] * 3) {
                ++m3Index;
            }
            if (min == uglyArray[m5Index] * 5) {
                ++m5Index;
            }
        }
        return uglyArray[uglyArray.length - 1];
    }

    public static int getMin(int a, int b, int c) {
        int min;
        min = a < b ? a : b;
        return min < c ? min : c;
    }
}
