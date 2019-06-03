package 第二遍;

/**
 * created by memory
 * on 2019/6/3 上午11:12
 * add, subtract, multiply and divide
 */
public class Offer12任意两个整数的加法 {
    public static void main(String[] args) {

    }

    public static char[] add(char[] num1, char[] num2) {
        if (isInvalid(num1)&&isInvalid(num2)){
            return null;
        }else  if (isInvalid(num1)){
            return num2;
        }else {
            return num1;
        }

    }

    public static void addUnsigned(int[] num1, int[] num2) {

    }

    public static void substractUnsigned(int[] num1, int[] num2) {
    }

    public static void isLarger(int[] num1, int[] num2) {

    }

    public static boolean isInvalid(char[] num) {
        if (num == null || num.length == 0 || ((num[0] < '0' || num[0] > '9') && num.length == 1)) {
            return true;
        }
        return false;
    }
    public static boolean isPositive(char[] num){
        if (num[0]=='-'){
            return false;
        }
        return true;
    }
}
