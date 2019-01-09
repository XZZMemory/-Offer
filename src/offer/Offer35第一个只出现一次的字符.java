//在字符串中找出第一个只出现一次的字符    abaccdeff,输出b
package offer;
import java.util.LinkedHashMap;//有序的HashMap
public class Offer35第一个只出现一次的字符 {
    public static void main(String[] args)
    {
        StringBuffer str=new StringBuffer("aaababccdeff");
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
        LinkedHashMap<Character,Integer> linkedHashMap=new LinkedHashMap<Character,Integer>();
        for(char item:strChar)
        {
            if (linkedHashMap.get(item)==null)
                linkedHashMap.put(item,1);
            else
                linkedHashMap.put(item,linkedHashMap.get(item)+1);
        }
        for (char key:linkedHashMap.keySet())
            if (linkedHashMap.get(key)==1)
                return key;
        return null;
    }


}
