package offer;

import java.util.LinkedHashMap;

public class Offer35删除在第二个字符串中出现的字符 {
    public static void main(String[] args)
    {
        StringBuffer str1=new StringBuffer("We are student");
        StringBuffer str2=new StringBuffer("aaeiou");
        char[] data= deleteSame(str1,str2);
        for (int i=0;i<data.length;i++)
            System.out.print(data[i]);
        //System.out.println("删除之后的数据是："+data);

    }
    public static char[] deleteSame(StringBuffer str1, StringBuffer str2) {
        if (str1 == null || str1.length() == 0)
            return null;
        if (str2 == null || str2.length() == 0)
            return str1.toString().toCharArray();
        char[] c1 = str1.toString().toCharArray();
        char[] c2 = str2.toString().toCharArray();
        LinkedHashMap<Character, Integer> linkedHashMap = new LinkedHashMap<>();
        for (char item : c2)
            if (linkedHashMap.get(item)==null)
                linkedHashMap.put(item, 1);
        int slow = 0;
        int fast = 0;
        for (; fast < c1.length; fast++)
        {
            if (linkedHashMap.get(c1[fast])==null)
                c1[slow++]=c1[fast];
        }
        c2=new char[slow];
        System.arraycopy(c1,0,c2,0,c2.length);
        return c2;
    }
}
