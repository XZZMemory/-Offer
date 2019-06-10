package first;

public class Offer3二维数组中的查找 {
    public static void main(String[] args) {
        int[][] data = {{1, 2, 8, 9}, {2, 4, 9, 12}, {4, 7, 10, 13}, {6, 8, 11, 15}};
        findData(null, 9);
        findData(data, 9);
        findData(data, 6);
        findData(data, 1);
        findData(data, 15);
        findData(data, 0);
    }

    public static boolean findData(int[][] data, int number) {
        if (data == null || data.length == 0) {
            System.out.println("矩阵为空！");
            return false;
        }
        int row = 0;
        int column = data[0].length - 1;
        while (row < data.length && column >= 0) {
            if (data[row][column] == number) {
                System.out.println("行:" + row + ",列：" + column);
                return true;
            } else if (data[row][column] < number)
                row++;
            else if (data[row][column] > number)
                column--;
        }
        System.out.println("未找到数据！");
        return false;

    }
}
