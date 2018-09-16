package tooffer;
import java.util.Vector;
//统计一个数字在排序数组中出现的次数，{1，2，3，3，3，3，4，5}，3出现的次数是4次
public class Offer38数字在排序数组中出现的次数 {
    public static void main(String[] args)
    {
        int[] data={1,2,3,3,3,3,4,4,5};
        int k=4;
        Vector<Integer> vector=new Vector<Integer>();
        for (int item:data)
            vector.add(item);
        //vector=null;测试用
        int numberOfK=GetNumberK(vector,k);
        if (numberOfK==-1)
            System.out.println("输入的数据为空!");
        else
            System.out.println("数字"+k+"出现的次数是："+numberOfK);
    }
    public static int GetNumberK(Vector<Integer> vector,int k)
    {
        if (vector==null)
            return -1;
        int numberOfK=0;
        int first=GetFirstK2(vector,k,0,vector.size()-1);
        int last=GetLastK2(vector,k,0,vector.size()-1);
        if (first==-1||last==-1)
            return 0;
        numberOfK=last-first+1;
        return numberOfK;
    }
    //使用循环，二分查找找到k出现的第一个位置
    public static int GetFirstK(Vector<Integer> vector,int k,int start,int end)
    {
        if (start>end)
            return -1;
        int mid;
        int firstKPosition=-1;
        while((start<=end)&&(firstKPosition==-1))
        {
            mid=(start+end)/2;
            if (vector.get(mid)>k)
                end=mid-1;
            else if (vector.get(mid)<k)
                start=mid+1;
            else
            {
                if ((mid==0)||(vector.get(mid - 1) != k))
                    firstKPosition = mid;
                else
                    end = mid - 1;
            }
        }
        return firstKPosition;
    }
    //使用递归找到k第一次出现的位置，二分查找
    public static int GetFirstK2(Vector<Integer> vector,int k,int start,int end)
    {
        if (start>end)
            return -1;
        int mid=(start+end)/2;
        if (vector.get(mid)>k)
            end=mid-1;
        else if (vector.get(mid)<k)
            start=mid+1;
        else
        {
            if ((mid==0)||(vector.get(mid - 1) != k))
                    return mid;
            else
                end = mid - 1;
            }
        return GetFirstK2(vector,k,start,end);
    }
    //循环
    public static int GetLastK(Vector<Integer> vector,int k,int start,int end)
    {
        if (start>end)
            return -1;
        int lastKPosition=-1;
        int mid;
        while ((start<=end)&&(lastKPosition==-1))
        {
            mid=(start+end)/2;
            if (vector.get(mid)>k)
                end=mid-1;
            else if (vector.get(mid)<k)
                start=mid+1;
            else
            {
                if ((mid==vector.size()-1)||(vector.get(mid + 1) != k))
                    lastKPosition = mid;
                else
                    start = mid + 1;
            }

        }
        return lastKPosition;
    }
    public static int GetLastK2 (Vector<Integer> vector,int k,int start,int end)
    {
        if (start>end)
            return -1;
        int mid=(start+end)/2;
        if (vector.get(mid)>k)
            end=mid-1;
        else if (vector.get(mid)<k)
            start=mid+1;
        else
        {
            if ((mid==vector.size()-1)||vector.get(mid+1)!=k)
                return mid;
            else start=mid+1;
        }
        return GetLastK2(vector,k,start,end);
    }
}
