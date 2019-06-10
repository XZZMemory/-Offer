package first;

//把n个骰子扔在地上，所有骰子朝上的一面点数之和为s。输入n，打印出所有可能的值出现的概率
//也可以理解为，一个骰子扔n次
public class Offer43n个骰子的点数 {
    private final static int maxValue = 6;//类常量

    public static void main(String[] args) {
        int times = 2;
        printProbability2(times);
    }

    /*
    基于递归实现，时间效率低。
    这种代码思路简单，实现起来容易，但由于是基于递归实现的，有很多计算是重复的，从而导致当number变大时，性能慢的让人不能接受。*/
    public static void printProbability1(int times) {
        int arrayLength = times * maxValue - times + 1;// 6-6*times
        int[] array = new int[arrayLength];
        probability(times, array);
        double total_times = Math.pow(maxValue, times);// double result=Math.pow(double 底数,double 指数)
        System.out.println("总的结果有：" + (int) total_times + "种可能");
        for (int i = 0; i < array.length; i++) {
            double ratio = array[i] / total_times;
            System.out.println("点数" + (i + times) + "出现的次数是:" + array[i] + "次  " + "出现的概率是：" + ratio);
        }
    }

    public static void probability(int times, int[] array) {
        if (times < 1)
            return;
        for (int i = 1; i <= 6; i++)
            probability(times, times, i, array);
    }

    public static void probability(int times, int currenttimes, int sum, int[] array) {//times:一共几个骰子，current:当前第几个骰子，sum：当前所有骰子的和，array：存储访问几次的数字
        if (currenttimes == 1) {
            array[sum - times]++;
        } else {
            for (int i = 1; i <= maxValue; i++) {
                probability(times, currenttimes - 1, sum + i, array);
            }
        }
    }

    public static void printProbability2(int number) {
        //基于循环求骰子点数
        int g_maxValue = 6;
        if (number < 1) {
            return;
        }
        int[][] pProbabilities = new int[2][g_maxValue * number + 1];
        for (int i = 0; i < g_maxValue; i++) {//初始化数组
            pProbabilities[0][i] = 0;
            pProbabilities[1][i] = 0;
        }
        int flag = 0;
        for (int i = 1; i <= g_maxValue; i++) {//当第一次抛掷骰子时，有6种可能，每种可能出现一次
            pProbabilities[flag][i] = 1;
        }
        //从第二次开始掷骰子，假设第一个数组中的第n个数字表示骰子和为n出现的次数，
        //在下一循环中，我们加上一个新骰子，此时和为n的骰子出现次数应该等于上一次循环中骰子点数和为n-1,n-2,n-3,n-4,n-5，
        //n-6的次数总和，所以我们把另一个数组的第n个数字设为前一个数组对应的n-1,n-2,n-3,n-4,n-5，n-6之和
        for (int k = 2; k <= number; k++) {
            for (int i = 0; i < k; i++) {//第k次掷骰子，和最小为k，小于k的情况是不可能发生的！所以另不可能发生的次数设置为0！
                pProbabilities[1 - flag][i] = 0;
            }
            for (int i = k; i <= g_maxValue * k; i++) {//第k次掷骰子，和最小为k，最大为g_maxValue*k
                pProbabilities[1 - flag][i] = 0;//初始化，因为这个数组要重复使用，上一次的值要清0
                for (int j = 1; j <= i && j <= g_maxValue; j++) {
                    pProbabilities[1 - flag][i] += pProbabilities[flag][i - j];
                }
            }
            flag = 1 - flag;
        }
        double total = Math.pow(g_maxValue, number);
        for (int i = number; i <= g_maxValue * number; i++) {
            double ratio = pProbabilities[flag][i] / total;
            System.out.println("sum: " + i + " ratio: " + ratio);
        }
    }
}
