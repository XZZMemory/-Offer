package 第二遍;

/**
 * created by memory
 * on 2019/5/30 上午10:57
 */
public class Offer4替换空格 {

    public static void main(String[] args) {
        char[] c = "we are happy.".toCharArray();
        System.out.print("原始数据是：");
        System.out.println(c);
        replaceBlank(c);

    }

    public static void replaceBlank(char string[]) {
        if (string == null || string.length < 1) {
            System.out.println("字符串为空！");
            return;
        }
        int length = string.length;
        int numOfBlank = 0;
        for (char elem : string) {
            if (elem == ' ') {
                ++numOfBlank;
            }
        }
        if (numOfBlank == 0) {
            System.out.println("不存在空格，数据是：" + string);
        }
        int newLength = length + numOfBlank * 2;
        char[] newString = new char[newLength];
        for (int i = length - 1, index = newLength - 1; i >= 0; i--) {
            if (string[i] == ' ') {
                newString[index--] = '0';
                newString[index--] = '2';
                newString[index--] = '%';
            } else {
                newString[index--] = string[i];
            }

        }
        System.out.print("替换空格后的数据是：");
        System.out.println(newString);
    }
}
