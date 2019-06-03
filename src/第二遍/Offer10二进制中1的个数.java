package 第二遍;

/**
 * 正数：源码、反码、补码一样
 * 负数：源码、反码、补码不同 内存中存储的是反码
 * created by memory
 * on 2019/5/31 下午8:14
 */
public class Offer10二进制中1的个数 {
    public static void main(String[] args) {
        System.out.println(getNumOf1a(-5));
        System.out.println();
        System.out.println(getNumOf1c(-5));
        System.out.println(getNumOf1b(-5));
    }

    /*数字1左移 flag<<*/
    public static int getNumOf1a(int num) {
        int count = 0;
        int flag = 1;
        while (flag != 0) {
            System.out.println("num:    " + Integer.toBinaryString(num));
            System.out.println("二进制： " + Integer.toBinaryString(flag));
            System.out.println("十进制： " + flag);
            System.out.println("与操作： " + (num & flag));
            if ((num & flag) != 0) {
                count++;
                System.out.println("count： " + count);
            }
            flag = flag << 1;
            System.out.println(flag);
        }
        return count;
    }

    public static int getNumOf1b(int num) {
        int count = 0;
        while (num != 0) {
            if ((num & 1) != 0) {
                ++count;
            }
            System.out.println(Integer.valueOf(num));
            System.out.println(Integer.toBinaryString(num));
            num = num >>> 1;
        }
        return count;
    }

    public static int getNumOf1c(int num) {
        System.out.println(num + "的二进制表示是：" + Integer.toBinaryString(num));
        int count = 0;
        while (num != 0) {
            System.out.println("num:   " + num);
            System.out.println("num:   " + Integer.toBinaryString(num));
            System.out.println("num-1: " + Integer.toBinaryString(num - 1));
            System.out.println("num-1: " + (num - 1));
            num = num & (num - 1);
            ++count;

        }
        return count;
    }

}
