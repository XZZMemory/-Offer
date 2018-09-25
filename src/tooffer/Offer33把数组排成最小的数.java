package tooffer;
import java.util.Arrays;
import java.util.Comparator;
import java.util.Scanner;
//
public class Offer33把数组排成最小的数 {

    public static void main(String[] args){
        System.out.println("请输入一组数字，以 , 隔开");
        Scanner scanner=new Scanner(System.in);
        String str=new String(scanner.nextLine());
        String[] temp=str.split(",");
        scanner.close();
        int[] array=new int[temp.length];
        for (int i=0;i<array.length;i++)
            array[i]=Integer.parseInt(temp[i]);
        /*
        * 输入一个正整数数组，把数组中所有数字连接起来排成一个数，使拼接的数字是所有数字中最小的一个{3,32,321} -> 321323 */
         System.out.println(PrintMinNumber2(array));

    }
    public static String PrintMinNumber2(int[] numbers){
        if(numbers == null || numbers.length == 0)
            return "";
        int len = numbers.length;
        String[] str = new String[len];
        StringBuilder stringbuilder = new StringBuilder();
        for(int i = 0; i < len; i++){
            str[i] = String.valueOf(numbers[i]);			//也可用str[i] = "" + numbers[i];将整数数组转化为字符串数组
        }
		/*在基本数据中，compareTo()是比较两个Character 对象；
		在 Boolean中，是用boolean的实例于其它实例进行比较；
		在String 中，则是按照字典顺序进行比较，返回的值是一个int 型。*/
        Arrays.sort(str,new Comparator<String>(){
            @Override
            public int compare(String s1,String s2){
                String c1 = s1 + s2;
                String c2 = s2 + s1;
                return c1.compareTo(c2);			//在String中，compareTo是按照字典顺序进行比较，返回的值是一个int型。
            }
        });
        for(int i = 0; i < len; i++){
            stringbuilder.append(str[i]);
        }
        return stringbuilder.toString();
    }

}
