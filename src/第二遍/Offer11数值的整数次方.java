package 第二遍;

/**
 * created by memory
 * on 2019/6/3 上午10:50
 */
public class Offer11数值的整数次方 {
    public static void main(String[] args) {
        System.out.println(power(0, 2));

    }

    public static double power(double base, int exponent) {
        if (base == 0 && exponent <= 0) {
            return -1;
        }
        if (base == 0 && exponent > 0) {
            return 0;
        }
        if (exponent == 0) {
            return 1;
        }
        if (exponent > 0) {
            return unSignPower(base, exponent);
        } else {
            return 1 / unSignPower(base, -exponent);
        }
    }

    public static double unSignPower(double base, int exponent) {
        if (exponent == 0) {
            return 1;
        }
        if ((exponent & 1) != 0) {
            return Math.pow(unSignPower(base, exponent / 2), 2) * base;
        } else {
            return Math.pow(unSignPower(base, exponent / 2), 2);
        }
    }
}
