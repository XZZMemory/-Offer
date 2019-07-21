package second;

import java.util.HashSet;
import java.util.Set;

/**
 * created by memory
 * on 2019/7/19 22 16
 */
public class Offer35删除在第二个字符串中出现的字符 {
    public static void main(String[] args) {
        String str1 = "We are student";
        String str2 = "aaeiou";
        System.out.println(deleteSame(str1, str2));
    }

    public static String deleteSame(String str1, String str2) {
        if (str1 == null || str1.length() < 1) {
            return null;
        }
        if (str2 == null || str2.length() < 1) {
            return str1;
        }
        Set<Character> set = new HashSet<>();
        for (int i = 0; i < str2.length(); i++) {
            set.add(str2.charAt(i));
        }
        StringBuffer sb = new StringBuffer();
        for (int i = 0; i < str1.length(); i++) {
            if (!set.contains(str1.charAt(i))) {
                sb.append(str1.charAt(i));
            }
        }
        return sb.toString();
    }
}
