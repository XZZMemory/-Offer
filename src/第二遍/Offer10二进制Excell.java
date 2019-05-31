package 第二遍;

/**
 * A-1
 * B-2
 * ...
 * Z-26
 * AA-27
 * AB-28
 * created by memory
 * on 2019/5/31 上午10:32
 */
public class Offer10二进制Excell {
    public static void main(String[] args) {
        String test1 = "A";
        System.out.println(test1 + ": " + getColumn(test1));
        String test2 = "AB";
        System.out.println(test2 + ": " + getColumn(test2));
        String test3 = "ZZ";
        System.out.println(test3 + ": " + getColumn(test3));
        String test4 = "";
        System.out.println(test4 + ": " + getColumn(test4));
        String test5 = "A2";
        System.out.println(test5 + ": " + getColumn(test5));
    }

    /* -1->字符串为空！ -2->字符串中出现非法字符*/
    public static int getColumn(String str) {
        if (str == null || str.length() <= 0) {
            System.out.println("字符串为空！");
            return -1;
        }
        int column = 0;
        for (int i = 0; i < str.length(); i++) {
            int currentChar = str.charAt(i);
            if (currentChar < 'A' || currentChar > 'Z') {
                System.out.println("字符串中出现非法字符！");
                return -2;
            }
            column = column * 26 + (currentChar - 'A') + 1;
        }
        return column;
    }

}
