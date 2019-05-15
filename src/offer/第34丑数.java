//只包含因子2，3，5的数称作丑数，求按从小到大的顺序的第1500个丑数
package offer;

public class 第34丑数 {
    public static void main(String[] args) {
        int index = 100;
        System.out.println("第" + index + "个丑数是：" + getUglyNumber(index));
    }

    public static int getUglyNumber(int index) {
        if (index < 1)
            return -1;
        int[] uglyArray = new int[index + 1];
        uglyArray[0] = 1;
        int m2Index = 0;
        int m3Indexx = 0;
        int m5Index = 0;
        for (int i = 1; i < index + 1; i++) {
            int min = Min(uglyArray[m2Index] * 2, uglyArray[m3Indexx] * 3, uglyArray[m5Index] * 5);
            uglyArray[i] = min;
            if (uglyArray[m2Index] * 2 <= min)
                m2Index++;
            if (uglyArray[m3Indexx] * 3 <= min)
                m3Indexx++;
            if (uglyArray[m5Index] * 5 <= min)
                m5Index++;
        }
        return uglyArray[index];
    }

    public static int Min(int number1, int number2, int number3) {
        int min = (number1 < number2) ? number1 : number2;
        return (min < number3) ? min : number3;
    }
}
