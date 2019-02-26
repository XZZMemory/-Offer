/**
 * 在字符串中找出第一个只出现一次的字符
 * hacbceff,输出b
 *
 * LinkedHashMap线程不安全，保证了元素迭代的顺序。该迭代顺序可以是插入顺序或者是访问顺序。
 * hashMap：线程不安全，迭代HashMap的顺序并不是HashMap放置的顺序
 *再这个问题中，需要找出第一个只出现一次的字符，所以使用LinkedHashMap，不能用HashMap */
package offer;
import java.util.Collection;
import java.util.Collections;
import java.util.LinkedHashMap;//有序的HashMap
import java.util.Map;

public class 第35第一个只出现一次的字符 {
    public static void main(String[] args)
    {
        StringBuffer str=new StringBuffer("aaababcchedff");
        //str=null;测试
        Character c= firstNotRepeatingChar(str);
        System.out.println("第一次只出现一次的字符是："+c);
    }
    public static Character firstNotRepeatingChar(StringBuffer stringBuffer)
    {
        if (stringBuffer==null)
        {
            System.out.println("字符串为空！");
            return null;
        }
        char[] strChar=stringBuffer.toString().toCharArray();
        Map<Character,Integer> map=new LinkedHashMap<>();
        for(char item:strChar)
        {
            if (map.get(item)==null)
                map.put(item,1);
            else
                map.put(item,map.get(item)+1);
        }
        for (char key:map.keySet())
            if (map.get(key)==1)
                return key;
        return null;
    }


}
