package first;

//实现一个函数，把字符串中的每个空格替换为"%20"
//字符串用字符数组存储
public class Offer4替换空格 {
    public static void main(String[] args) {
        char[] string = new char[30];
        System.out.println(string.length);
        char[] c = "we are happy.".toCharArray();
        for (int i = 0; i < c.length; i++) {
            string[i] = c[i];
        }
        System.out.println(string.length);
        System.out.println(string);
        replaceBlank(string);
        System.out.println(string);
    }

    public static void replaceBlank(char string[]) {
        if (string == null || string.length < 1) {
            System.out.println("字符串为空！");
            return;
        }
        int originLength = 0;
        int postlength = 0;
        int blank = 0;
        for (int i = 0; string[i] != '\0'; i++) {
            originLength++;
            if (string[i] == ' ')
                blank++;
        }
        postlength = originLength + blank * 2;
        if (postlength > originLength) {
            while (originLength >= 0) {
                if (string[originLength] == ' ') {
                    string[postlength--] = '0';
                    string[postlength--] = '2';
                    string[postlength--] = '%';
                } else
                    string[postlength--] = string[originLength];
                originLength--;
            }
        }
        System.out.println(string);
    }
}


