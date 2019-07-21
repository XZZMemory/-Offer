package second;

import java.util.Arrays;
import java.util.Comparator;

/**
 * created by memory
 * on 2019/6/14 下午4:38
 */

/**
 * 善于发现规律，自定义新规则，并能证明新规则的有效性。
 */
public class Offer33把数组排成最小的数 {
    public static void main(String[] args){
        String[] matrix={"11","33","22","12"};
        System.out.println(sort(matrix));
    }
    public static String sort(String[] strMatrix){
        if (strMatrix==null||strMatrix.length<1){
            return null;
        }
        StringBuffer sb=new StringBuffer();
        Arrays.sort(strMatrix, new Comparator<String>() {
            @Override
            public int compare(String o1, String o2) {
                String s1=o1+o2;
                String s2=o2+o1;
                return s1.compareTo(s2);
            }
        });
        for (int i = 0; i <strMatrix.length ; i++) {
            sb.append(strMatrix[i]);
        }
        return sb.toString();
    }
}
