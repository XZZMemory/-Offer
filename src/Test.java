public class Test {
    public static void main(String[] args) {
        System.out.println("二进制转换为十进制： "+Integer.parseInt("111",2));
        int a = 1;
        System.out.println(getN(a));
        System.out.println(getN(12));
        System.out.println(getN(-12));
    }

    public static int getN(int data) {
        int num = 0;
        int flag=1;
        while (flag!=0) {
            if ((flag&data)>0){
                num++;
            }
            flag=flag<<1;
        }
        return num;
    }
}