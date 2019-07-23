package second;

/**
 * created by memory
 * on 2019/7/23 16 25
 * 题目： 不使用字符串转换成数字的库函数
 */
public class Offer48把字符串转换成整数 {
    public static void main(String[] args) {
        String str = "-570";
        System.out.println(strToIntRight(str));
        System.out.println(flag);
        String str2 = "-570";
        System.out.println(strToIntLeft(str2));
        System.out.println(flag);
    }

    public static int flag = 0;//类常量0-正常 1-字符串空 2-非法输入

    /**
     * 1.1 从字符串的右面开始转换成数字
     */
    public static int strToIntRight(String str) {
        if (str == null || str.length() < 1) {
            flag = 1;
            return 0;
        }
        int num = 0;
        int posi = 1;
        for (int index = str.length() - 1; index >= 0; --index) {
            char currentChar = str.charAt(index);
            if (currentChar == '-') {
                if (index == 0) {
                    num = -num;
                } else {
                    flag = 2;
                    return 0;
                }
            } else if (currentChar == '+') {
                if (index != 0) {
                    flag = 2;
                    return 0;
                }
            } else if (currentChar >= '0' && currentChar <= '9') {
                int currentData = currentChar - '0';
                num += currentData * posi;
                posi = posi * 10;
            } else {
                flag = 2;
                return 0;
            }
        }
        return num;
    }

    /**
     * 1.2从字符串的左面开始转换成数字
     */
    public static int strToIntLeft(String str) {
        if (str == null || str.length() < 1) {
            flag = 1;
            return 0;
        }
        int num = 0;
        boolean numFlag = false;
        for (int index = 0; index < str.length(); ++index) {
            char currentChar = str.charAt(index);
            if (currentChar == '-') {
                if (index == 0) {
                    numFlag = true;
                } else {
                    flag = 2;
                    return 0;
                }
            } else if (currentChar == '+') {
                if (index != 0) {
                    flag = 2;
                    return 0;
                }
            } else if (currentChar >= '0' && currentChar <= '9') {
                int currentData = currentChar - '0';
                num = num * 10;
                num += currentData;
            } else {
                flag = 2;
                return 0;
            }
        }
        if (numFlag) {
            num = -num;
        }
        return num;
    }
}
