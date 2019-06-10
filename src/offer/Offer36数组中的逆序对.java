//在数组中的两个数字如果前一个数字大于后面的的数字，则这两个数字组成一个逆序对，输入一个数组，求出这个数组中逆序对的总数
package offer;

public class Offer36数组中的逆序对 {
    public static void main(String[] args) {
        int[] number = {7, 5, 6, 4};
        int[] copy = new int[number.length];
        System.arraycopy(number, 0, copy, 0, number.length);//数组的复制，将数组number的值复制到数组copy中
        int count = inverseParisCore(number, copy, 0, number.length - 1);
        System.out.println("数组中的逆序对个数是：" + count);
    }

    public static int inverseParisCore(int[] data, int[] copy, int start, int end) {//data数组会改变，两个子数组均是排好序的，两个排序的数组再进行合并
        if (start == end)
            return 0;
        int mid = (start + end) >> 1;
        int leftcount = inverseParisCore(data, copy, start, mid);//左【start,mid】
        int rightvount = inverseParisCore(data, copy, mid + 1, end);//右[mid+1,end]
        int i = mid;
        int j = end;
        int copyIndex = end;
        int count = 0;
        //两个排序的数组进行合并，在合并的过程中，再统计本次逆序的对数
        while ((i >= start) && (j >= mid + 1)) {
            if (data[i] > data[j]) {
                copy[copyIndex--] = data[i--];
                count += j - mid;
            } else
                copy[copyIndex--] = data[j--];
        }
        for (; i >= start; i--)
            copy[copyIndex--] = data[i];
        for (; j >= mid + 1; j--)
            copy[copyIndex--] = data[j];
        System.arraycopy(copy, 0, data, 0, copy.length);//需要拷贝
        return leftcount + rightvount + count;
    }
}
