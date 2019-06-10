package offer;

/**
 * 题目：不使用加减乘除，完成两个数字的加法操作
 * 对于数的运算只有两种，1.加减乘除，2.位运算 与或非异或左移右移
 * 不使用新的变量，交换两个变量的值
 */
public class Offer47不用加减乘除做加法 {
    public static void main(String[] args) {
        int num1 = 20;
        int num2 = 99;
        int result = add(num1, num2);
        System.out.println(result);
    }

    public static int add(int num1, int num2) {
        int sum = 0;
        while (num2 != 0) {
            sum = (num1 ^ num2);
            num2 = (num1 & num2) << 1;
            num1 = sum;
        }
        return num1;
    }
}
