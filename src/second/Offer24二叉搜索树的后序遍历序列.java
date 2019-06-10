package second;

/**
 * created by memory
 * on 2019/6/10 下午9:18
 */
/*输入一个整数数组，判断该二叉数组是不是某二叉搜索树的后序遍历的结果*/
public class Offer24二叉搜索树的后序遍历序列 {
    public static void main(String[] args) {
        int[] sequence = {5, 7, 6, 9, 11, 10, 8};
        int[] sequence2 = {7, 4, 6, 5};
        System.out.println(verifySquenceOfBST(sequence, 0, sequence.length - 1));
        System.out.println(verifySquenceOfBST(sequence2, 0, sequence2.length - 1));
    }

    public static boolean verifySquenceOfBST(int sequence[], int start, int end) {
        if (start < 0 || end >= sequence.length) {
            return false;
        }
        if (start >= end) {
            return true;
        }
        int root = sequence[end];
        int middle = start;
        while (middle <= end && sequence[middle] <= root) {
            ++middle;
        }
        for (int i = middle; i < end; i++) {
            if (sequence[i] <= root) {
                return false;
            }
        }
        return verifySquenceOfBST(sequence, start, middle - 1) && verifySquenceOfBST(sequence, middle, end - 1);

    }
}
