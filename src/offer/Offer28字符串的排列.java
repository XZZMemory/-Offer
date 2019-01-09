package offer;
//输入一个字符串，打印出该字符串中字符的所有排列 abc
public class Offer28字符串的排列  {
    public static void main(String[] args)
    {
        char[] item="abc".toCharArray();
        permutation(item,0);
    }
    public static void permutation(char[] item, int begin)
    {
        if (item==null||item.length==0)
            return;
        if (begin>=item.length)//说明到末尾了,
            System.out.println(item);
        else
        {
            for (int i=begin;i<item.length;i++)
            {
                swap(item,i,begin);
                permutation(item,begin+1);//i执行完毕，执行i+1，还要交换会回来
                swap(item,i,begin);
            }
        }

    }
    public static void swap(char[] item,int i,int begin)
    {
        char temp=item[i];
        item[i]=item[begin];
        item[begin]=temp;
    }
}
