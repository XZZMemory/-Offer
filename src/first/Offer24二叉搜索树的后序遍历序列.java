package first;

//输入一个整数数组，判断该二叉数组是不是某二叉搜索树的后序遍历的结果
public class Offer24二叉搜索树的后序遍历序列 {
    public static void main(String[] args) {
        int[] sequence = {5, 7, 6, 9, 11, 10, 8};
        int[] sequence2 = {7, 4, 6, 5};
        boolean result1 = verifySquenceOfBST(sequence, 0, sequence.length - 1);
        boolean result2 = verifySquenceOfBST(sequence2, 0, sequence2.length - 1);
    }

    public static boolean verifySquenceOfBST(int sequence[], int start, int end) {
        if ((sequence == null) || (start < 0) || (end < 0))
            return false;
        int root = sequence[end];
        int i = start;
        while ((sequence[i] < root) && (i < end))
            i++;
        //int j=i;//左子树start---i-1 右子树  i---end-1
        for (int j = i; j < end; j++)//右子树均大于根，小于根就说明错误
        {
            if (sequence[j] < root)
                return false;
        }
        boolean left = true;
        if (i > start)
            left = verifySquenceOfBST(sequence, start, i - 1);
        boolean right = true;
        if (i < end)
            right = verifySquenceOfBST(sequence, i, end - 1);
        return (right && left);
    }
}
