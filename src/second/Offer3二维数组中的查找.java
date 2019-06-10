package second;

/**
 * created by memory
 * on 2019/5/29 下午8:32
 */
public class Offer3二维数组中的查找 {
    public static void main(String[] args) {
        int[][] matrix = new int[][]{{1, 2, 8, 9}, {2, 4, 9, 12}, {4, 7, 10, 13}, {6, 8, 11, 15}};
        int[] numbers = {9, 1, 6, 15, 10};
        for (int elem : numbers) {
            System.out.println("从右上角开始，循环方法找数据： " + (elem) + "是否找到： " + findDataRightCircularly(matrix, elem));
            System.out.println("从右上角开始，递归方法找数据： " + (elem) + "是否找到： " + findDataRightRecursively(matrix, elem));
        }
        System.out.println("******************");
        for (int elem : numbers) {
            findDataLeftRecursively(matrix, elem);
            findDataLeftCircularly(matrix, elem);
        }
    }

    /* 1.1 从右上角开始，递归*/
    public static boolean findDataRightRecursively(int[][] matrix, int number) {
        if (matrix == null || matrix.length < 1 || matrix[0].length < 1) {
            return false;
        }
        return findRight(matrix, number, 0, matrix.length - 1);
    }

    public static boolean findRight(int[][] matrix, int number, int row, int column) {
        if (row >= matrix.length || column < 0) {
            return false;
        }
        int currentData = matrix[row][column];
        if (currentData == number) {
            System.out.println("找到数据" + number + "在第 " + (row + 1) + " 行，第 " + (column + 1) + " 列");
            return true;
        } else if (currentData < number) {
            return findRight(matrix, number, ++row, column);
        } else {
            return findRight(matrix, number, row, --column);
        }
    }

    /* 1.2 从右上角开始，循环*/
    public static boolean findDataRightCircularly(int[][] matrix, int number) {
        if (matrix == null || matrix.length < 1) {
            return false;
        }
        int row = 0;
        int column = matrix[0].length - 1;
        while (row < matrix.length && column >= 0) {
            int currentData = matrix[row][column];
            if (currentData == number) {
                System.out.println("找到数据，在第 " + (row + 1) + " 行，第 " + (column + 1) + " 列");
                return true;
            } else if (currentData < number) {
                row++;
            } else {
                column--;
            }
        }
        return false;
    }

    /* 2.1 从坐下角开始，递归*/
    public static boolean findDataLeftRecursively(int[][] matrix, int number) {
        if (matrix == null || matrix.length < 1 || matrix[0].length < 1) {
            return false;
        }
        return findLeft(matrix, number, matrix.length - 1, 0);
    }

    public static boolean findLeft(int[][] matrix, int number, int row, int column) {
        if (row >= matrix.length || column < 0) {
            return false;
        }
        int currentData = matrix[row][column];
        if (currentData == number) {
            System.out.println("找到数据: " + number + " 在第 " + (row + 1) + " 行，第 " + (column + 1) + " 列");
            return true;
        } else if (currentData < number) {
            return findLeft(matrix, number, row, ++column);
        } else {
            return findLeft(matrix, number, --row, column);
        }
    }

    /* 1.2 从左下角开始，循环*/
    public static boolean findDataLeftCircularly(int[][] matrix, int number) {
        if (matrix == null || matrix.length < 1) {
            return false;
        }
        int row = matrix.length - 1;
        int column = 0;
        while (row >= 0 && column < matrix.length) {
            int currentData = matrix[row][column];
            if (currentData == number) {
                System.out.println("找到数据: " + number + " 在第 " + (row + 1) + " 行，第 " + (column + 1) + " 列");
                return true;
            } else if (currentData < number) {
                ++column;
            } else {
                --row;
            }
        }
        return false;
    }
}
