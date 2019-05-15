package offer;

import java.util.List;
import java.util.Vector;
//统计一个数字在排序数组中出现的次数，{1，2，3，3，3，3，4，5}，3出现的次数是4次

/**
 * 集合知识：set无序，不可重复: hashSet，TreeSet
 * list，有序，可重复：ArrayList，LinkedLIst，Vector
 */
public class 第38数字在排序数组中出现的次数 {
    public static void main(String[] args) {
        int[] data = {1, 2, 3, 3, 3, 3, 4, 4, 5};
        int k = 4;
        List<Integer> list = new Vector<Integer>();
        for (int item : data)
            list.add(item);
        //vector=null;测试用
        int numberOfK = getNumberK(list, k);
        if (numberOfK == -1)
            System.out.println("输入的数据为空!");
        else
            System.out.println("数字" + k + "出现的次数是：" + numberOfK);
    }

    public static int getNumberK(List<Integer> vector, int k) {
        if (vector == null)
            return -1;
        int numberOfK = 0;
        int first = getFirstK2(vector, k, 0, vector.size() - 1);
        int last = getLastK2(vector, k, 0, vector.size() - 1);
        if (first == -1 || last == -1)
            return 0;
        numberOfK = last - first + 1;
        return numberOfK;
    }

    //使用循环，二分查找找到k出现的第一个位置
    public static int getFirstK(List<Integer> list, int k, int start, int end) {
        if (start > end)
            return -1;
        int mid;
        while ((start <= end)) {
            mid = (start + end) / 2;
            if (list.get(mid) > k)
                end = mid - 1;
            else if (list.get(mid) < k)
                start = mid + 1;
            else {
                if ((mid == 0) || (list.get(mid - 1) != k))
                    return mid;
                else
                    end = mid - 1;
            }
        }
        return -1;
    }

    //使用递归找到k第一次出现的位置，二分查找
    public static int getFirstK2(List<Integer> list, int k, int start, int end) {
        if (start > end)
            return -1;
        int mid = (start + end) / 2;
        if (list.get(mid) > k)
            end = mid - 1;
        else if (list.get(mid) < k)
            start = mid + 1;
        else {
            if ((mid == 0) || (list.get(mid - 1) != k))
                return mid;
            else
                end = mid - 1;
        }
        return getFirstK2(list, k, start, end);
    }

    //循环
    public static int getLastK(List<Integer> list, int k, int start, int end) {
        if (start > end)
            return -1;
        int mid;
        while ((start <= end)) {
            mid = (start + end) / 2;
            if (list.get(mid) > k)
                end = mid - 1;
            else if (list.get(mid) < k)
                start = mid + 1;
            else {
                if ((mid == list.size() - 1) || (list.get(mid + 1) != k))
                    return mid;
                else
                    start = mid + 1;
            }
        }
        return -1;//没找到数据，直接返回-1
    }

    public static int getLastK2(List<Integer> list, int k, int start, int end) {
        if (start > end)
            return -1;
        int mid = (start + end) / 2;
        if (list.get(mid) > k)
            end = mid - 1;
        else if (list.get(mid) < k)
            start = mid + 1;
        else {
            if ((mid == list.size() - 1) || list.get(mid + 1) != k)
                return mid;
            else start = mid + 1;
        }
        return getLastK2(list, k, start, end);
    }
}
