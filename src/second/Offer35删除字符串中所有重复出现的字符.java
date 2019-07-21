package second;

import java.util.HashSet;
import java.util.Set;

/**
 * created by memory
 * on 2019/7/20 12 14
 */
public class Offer35删除字符串中所有重复出现的字符 {
    public static void main(String[] args) {
        String str = "google";//编程gole
        System.out.println(deleteSameChar(str));
    }

    public static String deleteSameChar(String str) {
        if (str == null || str.length() < 1) {
            return str;
        }
        Set<Character> set = new HashSet<>();
        StringBuffer sb = new StringBuffer();
        for (int i = 0; i < str.length(); i++) {
            char currentChar = str.charAt(i);
            if (!set.contains(currentChar)) {
                sb.append(currentChar);
                set.add(currentChar);
            }
        }
        return sb.toString();
    }
}
