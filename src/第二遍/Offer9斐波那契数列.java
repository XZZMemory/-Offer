package 第二遍;

/**
 * created by memory
 * on 2019/5/30 下午7:59
 */
public class Offer9斐波那契数列 {
    public static void main(String[] args) {
        int n=6;
        System.out.println(fibonacciByArray(n));
        System.out.println(fibonacciByAdd(n));
        System.out.println(fibonacciByRecur(n));
    }

    /**
     * 利用数组，存储每个数据
     */
    public static int fibonacciByArray(int n) {
        if (n == 0) {
            return 0;
        } else if (n == 1) {
            return 1;
        }
        int[] fibonaccis = new int[n + 1];
        fibonaccis[0] = 0;
        fibonaccis[1] = 1;
        int i = 2;
        while (i <= n) {
            fibonaccis[i] = fibonaccis[i - 1] + fibonaccis[i - 2];
            i++;
        }
        return fibonaccis[n];
    }

    /*通过加法，获取最终的值*/
    public static int fibonacciByAdd(int n) {
        if (n == 0) {
            return 0;
        } else if (n == 1) {
            return 1;
        }
        int first = 0;
        int second = 1;
        int i=2;
        while (i<=n){
            int currentNum=first+second;
            first=second;
            second=currentNum;
            i++;
        }
        return second;
    }

    /*利用递归，时间、空间开销大*/
    public static int fibonacciByRecur(int n) {
        if (n == 0) {
            return 0;
        } else if (n == 1) {
            return 1;
        }
        return fibonacciByRecur(n - 1) + fibonacciByRecur(n - 2);
    }
}
