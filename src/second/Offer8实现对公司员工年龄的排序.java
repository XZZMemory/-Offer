package second;

/**
 * 对公司员工年龄排序，时间复杂度为O(n),辅助内存只允许使用常量大小的辅助空间，不超过O(n)
 * created by memory
 * on 2019/5/31 上午10:38
 */
public class Offer8实现对公司员工年龄的排序 {
    public static void main(String[] args) {
        int[] ages = {1, 2, 3, 4, 5, 5, 2, 1};
        sortAges(ages);
    }

    public static void sortAges(int[] ages) {
        if (ages == null || ages.length <= 0) {
            return;
        }
        final int oldestAge = 99;
        final int youngestAge = 0;
        /*timesOgAge下标i代表年龄*/
        int[] timesOgAge = new int[oldestAge - youngestAge + 1];
        for (int i = 0; i < ages.length; i++) {
            int currentAge = ages[i];
            if (currentAge < youngestAge || currentAge > oldestAge) {
                System.out.println("年龄出错！");
                return;
            }
            ++timesOgAge[currentAge];
        }
        int index = 0;
        for (int i = 0; i < oldestAge; i++) {
            for (int j = 0; j < timesOgAge[i]; j++) {
                ages[index] = i;
                ++index;
            }
        }

    }
}
