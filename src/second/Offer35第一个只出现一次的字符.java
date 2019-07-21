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
