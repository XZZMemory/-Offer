package offer;

//输入一个整数，输出该数二进制表示中1的个数，如：9的二进制表示是1001，有2位是1，因此如果输入9，该函数输出2.
//写了三个函数，NumOf1a、NumOf1b、getNumOf1,NumOf1的思路是最好的
public class Offer10二进制中1的个数 {
    public static void main(String[] args) {
        int a = 9;
        int b = -9;
        System.out.println(b >> 1);
        System.out.println("数字 " + a + " 在内存中得二进制表示为：" + Integer.toBinaryString(a) +
                "  二进制表示法包含的位数是：" + getNumOf1(a));
        System.out.println("数字 " + b + " 在内存中得二进制表示为：" + Integer.toBinaryString(b) +
                "  二进制表示法包含的位数是：" + getNumOf1(b));

    }

    public static int getNumOf1a(int n) {//与1做与运算，然后数字右移一位

        int number = 0;
        while (n != 0) {
            if ((n & 1) == 1)
                number++;
            n = n >>> 1;
        }
        return number;
        //存在问题，当n是负数时，右移的话，最左面补位补的是1，一直右移就一直补1.会造成死循环 （1000）>>(1100)>>(1110)>>(1111)>>...>>1111
        //         当n时正数时，右移的话，最左面补0
        //正>> 左面补0     负>> 左面补1   正负<<  右面补0
    }

    public static int getNumOf1c(int data) {
        int num = 0;
        while (data != 0) {
            if (data == 1) {
                num++;
                return num;
            }
            num++;
            data = data / 2;
        }
        return num;
    }

    //与1做与运算，然后数字1左移变成10，10与数字做与运算，10<<100，正负数左移补位均是0
    public static int getNumOf1b(int n) {
        int flag = 1;
        int number = 0;
        while (flag != 0) {
            if ((flag & n) > 0)
                number++;
            flag = flag << 1;
        }
        if (n < 0) {
            number++;
        }
        return number;
    }

    public static int getNumOf1(int n) {
        int number = 0;
        while (n != 0) {
            number++;
            n = n & (n - 1);
        }
        return number;
    }


    //用一条语句判断一个整数是不是2的整数次方
    public static boolean Is2(int number) {
        if ((number & (number - 1)) == 0)
            return true;
        return false;
    }

    //判断两个整数m和n，计算需要改变m的二进制表示中的多少位才能得到n
    public static int Getn(int m, int n) {
        int dif = m ^ n;//一共有多少不同的位
        //求dif中的1的位置
        return getNumOf1(dif);
    }
}
