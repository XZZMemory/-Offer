package second;


import java.util.LinkedHashMap;
import java.util.Map;

/**
 * created by memory
 * on 2019/7/20 12 24
 */
public class Offer35第一个只出现一次的字符 {
    public static void main(String[] args) {
        String str = "aaababcchedff";
        System.out.println(firstNotRepeatingChar(str));
    }

    public static Character firstNotRepeatingChar(String str) {
        if (str == null || str.length() < 1) {
            return null;
        }
        /**
         * TreeMap的顺序是自然顺序（如整数从小到大），也可以指定比较函数。但不是插入的顺序。 
         * LinkedHashMap，内部有一个链表，保持插入的顺序。迭代的时候，也是按照插入顺序迭代。
         * HashMap并不能保证按插入的顺序
         */
        Map<Character, Integer> map = new LinkedHashMap<>();
        for (int i = 0; i < str.length(); i++) {
            Character key = str.charAt(i);
            if (map.containsKey(key)) {
                int times = map.get(key);
                map.put(key, ++times);
            } else {
                map.put(key, 1);
            }
        }
        for (Character key : map.keySet()) {
            if (map.get(key) == 1) {
                return key;
            }
        }
        return null;
    }
}
