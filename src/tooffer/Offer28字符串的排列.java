package tooffer;
//输入一个字符串，打印出该字符串中字符的所有排列 abc
public class Offer28字符串的排列  {
    public static void main(String[] args)
    {
        String str="abc";
        if (str==null)
            return;
        char[] item=str.toCharArray();
        int n=str.length();
        char nn=item[1];
        int nnn=item.length;
        Permutation(item,0);
    }
    public static void Permutation(char[] item,int begin)
    {
        if (item==null)
            return;
        if (begin>=item.length)//说明到末尾了,
            System.out.println(item);
        else
        {
            for (int i=begin;i<item.length;i++)
            {
                char temp=item[i];
                item[i]=item[begin];
                item[begin]=temp;
                Permutation(item,begin+1);//i执行完毕，执行i+1，还要交换会回来
                temp=item[i];
                item[i]=item[begin];
                item[begin]=temp;

            }
        }

    }
}
