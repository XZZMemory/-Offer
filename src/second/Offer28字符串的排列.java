package second;

/**
 * created by memory
 * on 2019/6/11 下午4:07
 */
/*输入一个字符串，打印出该字符串中字符的所有排列 abc*/
public class Offer28字符串的排列 {
    public static void main(String[] args) {
        char[] item = "abc".toCharArray();
        permutation(item, 0);
    }

    public static void permutation(char[] item, int begin) {
        if (item == null || item.length == 0 || item.length <= begin) {
            return;
        }
        if (begin == item.length - 1) {
            System.out.println(item);
        }
        for (int i = begin; i < item.length; i++) {
            swap(item, i, begin);
            permutation(item, begin + 1);
            swap(item, i, begin);

        }

    }

    public static void swap(char[] item, int i, int j) {
        if (item == null || item.length < 2 || i < 0 || i >= item.length || j < 0 || j >= item.length) {
            System.out.println("参数错误！");
            return;
        }
        char temp = item[i];
        item[i] = item[j];
        item[j] = temp;
    }
}
