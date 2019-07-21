package second;

/**
 * created by memory
 * on 2019/7/20 12 56
 */

/**
 * 在数组中的两个数字如果前一个数字大于后面的的数字，则这两个数字组成一个逆序对，输入一个数组，求出这个数组中逆序对的总数
 */
public class Offer36数组中的逆序对 {
    public static void main(String[] args) {
        int[] number = {7, 5, 6, 4};
    }

    public static int inverseParisCore(int[] number, int start, int end) {
        if (number == null || start < 0 || end > (number.length - 1) || start > end) {
            System.out.println("参数异常！");
            return -1;
        }
        if (start == end) {
            return 0;
        }
        int mid = (start + end) / 2;
        int left=inverseParisCore(number,start,mid);
        int right=inverseParisCore(number,mid+1,end);
        /*在start-mid-end之间，记录逆序对个数，左边的已有序，右边也是有序数组*/


        return -1;
    }
}
