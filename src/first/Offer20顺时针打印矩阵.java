//输入一个矩阵，按照从外向里以顺时针的顺序打印出每一个数字
//画图形帮助理解
package first;

public class Offer20顺时针打印矩阵 {
    public static void main(String[] args)
    {
        int[][] numbers={{1,2,3,4},{5,6,7,8},{9,10,11,12},{13,14,15,16}};
        printMatrixInCircle(numbers,0,numbers.length-1,0,numbers[0].length-1);
    }
    public static void printMatrixInCircle(int[][] numbers, int cloumnBegin, int cloumnEnd, int rowBegin, int rowEnd)
    {
        if(numbers==null)
            return;
    }
}
