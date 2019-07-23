package second;

/**
 * created by memory
 * on 2019/7/22 21:30
 * 题目一：输入一个英文句子，翻转单词中的顺序，但单词内字符的顺序不变。 I am a student. 变成 student. a am I
 * 题目二：字符串的左旋操作是把字符串前面的若干字符转移到字符的尾部.abcdefg 和数字2 左旋2位得到：cdefgab
 * * 理解左旋
 */
public class Offer42翻转单词顺序VS左旋转字符串 {
    public static void main(String[] args) {
        /* 1.1 测试*/
        char[] charMatrix = "    I am a student.  ".toCharArray();
        reverseSentence1(charMatrix);
        traversalOfArray(charMatrix);
        /* 1.2 测试 */
        char[] charMatrix2 = "I am a student.".toCharArray();
        reverseSentence2(charMatrix2);
        traversalOfArray(charMatrix2);
        /* 2. 测试*/
        char[] charMatrix3 = "abcdefg".toCharArray();
        leftRotateString(charMatrix3, 2);
        traversalOfArray(charMatrix3);
    }

    /**
     * 1.1 这个旋转单词与first第一遍比着，多了空格的处理，first中两个单词只有一个空格，这个可以处理多个空格。
     */
    public static void reverseSentence1(char[] data) {
        if (data == null || data.length < 2) {
            return;
        }
        reverse(data, 0, data.length - 1);
        int start = 0;
        int end = 0;
        while (end < data.length) {
            while (start < data.length && data[start] == ' ') {
                ++start;
            }
            end = start + 1;
            while ((end < data.length && data[end] != ' ') || (end == data.length)) {
                ++end;
            }
            if (end <= data.length) {
                reverse(data, start, --end);
                start = end + 2;
                end = start;

            }
        }
        return;
    }

    /**
     * 1.2 first 第一遍，假设英文句子的格式标准，只有一个空格，且句子前后没有空格
     */
    public static void reverseSentence2(char[] data) {
        if (data == null) {
            System.out.println("数据是空！");
            return;
        }
        /* 翻转整个句子 */
        reverse(data, 0, data.length - 1);
        /* 翻转句子中的每个单词*/
        int start = 0;
        int end = 0;
        while (end < data.length) {
            while (end < data.length && data[end] != ' ') {
                ++end;
            }
            if (end <= data.length) {
                /*注意  --end 和 end-1 的区别*/
                reverse(data, start, end - 1);
                ++end;
                start = end;
            }
        }

    }

    /**
     * 2. 字符串的左旋操作
     */
    public static void leftRotateString(char[] data, int index) {
        if (data == null || data.length < 2 || index >= data.length) {
            System.out.println("参数异常!!!");
            return;
        }
        /* 数据个数 data.length()
         * 下标 [data.length()-index ，data.length()-1]
         * 下标 [0,data.length()-index-1] */
        reverse(data, 0, data.length - 1);
        reverse(data, 0, data.length - 1 - index);
        reverse(data, data.length - index, data.length - 1);
    }

    public static void reverse(char[] data, int start, int end) {
        if (data == null || data.length < 2 || start < 0 || end >= data.length || start > end) {
            System.out.println("参数异常！");
            return;
        }
        while (start < end) {
            char temp = data[start];
            data[start] = data[end];
            data[end] = temp;
            ++start;
            --end;
        }
    }

    public static void traversalOfArray(char[] data) {
        if (data == null) {
            System.out.println("字符数组为空！");
            return;
        }
        System.out.print("*");
        for (int i = 0; i < data.length; i++)
            System.out.print(data[i]);
        System.out.print("*");
        System.out.println();
    }
}
