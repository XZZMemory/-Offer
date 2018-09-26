package tooffer;
import java.util.LinkedHashMap;
/*google -> gole
* 删除字符串中所有重复出现的字符*/
public class Offer35删除字符串中所有重复出现的字符 {
    public static void main(String[] args)
    {
        StringBuffer stringBuffer=new StringBuffer("google");
        char[] data=DeleteSameChar(stringBuffer);
    }
    public static char[] DeleteSameChar(StringBuffer stringBuffer)
    {
        if (stringBuffer==null)
            return null;
        char[] array=stringBuffer.toString().toCharArray();
        if (array.length==1)
            return array;
        LinkedHashMap<Character,Integer> linkedHashMap=new LinkedHashMap<>();
        int slow=0;
        int fast=0;
        for (;fast<array.length;fast++)
        {
            if (linkedHashMap.get(array[fast])==null)
            {
                linkedHashMap.put(array[fast],1);
                array[slow++]=array[fast];
            }
        }
        char[] data=new char[slow];
        System.arraycopy(array,0,data,0,data.length);
        return data;
    }
}
