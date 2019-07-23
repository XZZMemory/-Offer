package second;

/**
 * created by memory
 * on 2019/7/23 14 49
 * * 题目：不使用加减乘除，完成两个数字的加法操作
 * * 对于数的运算只有两种，1.加减乘除，2.位运算 与或非异或左移右移
 * * 不使用新的变量，交换两个变量的值
 */
public class Offer47不用加减乘除做加法 {
    public static void main(String[] args) {
        System.out.println(add(5, 6));
    }

    public static int add(int num1, int num2) {
        while (num2 != 0) {
            int sum = num1 ^ num2;
            num2 = (num1 & num2) << 1;/*进位*/
            num1 = sum;
        }
        return num1;
    }
}
