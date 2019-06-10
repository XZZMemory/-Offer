package first;

import java.util.HashMap;
import java.util.Map;

/*
 * 删除字符串中所有重复出现的字符
 * google -> gole
 */
public class Offer35删除字符串中所有重复出现的字符 {
    public static void main(String[] args) {
        StringBuffer stringBuffer = new StringBuffer("google");//编程gole
        char[] data = deleteSameChar(stringBuffer);
    }

    public static char[] deleteSameChar(StringBuffer stringBuffer) {
        if (stringBuffer == null)
            return null;
        char[] array = stringBuffer.toString().toCharArray();
        if (array.length == 1)
            return array;
        Map<Character, Integer> map = new HashMap<>();
        int slow = 0;
        int fast = 0;
        for (; fast < array.length; fast++) {
            if (map.get(array[fast]) == null) {
                map.put(array[fast], 1);
                array[slow++] = array[fast];
            }
        }
        char[] data = new char[slow];
        System.arraycopy(array, 0, data, 0, data.length);
        return data;
    }
}
