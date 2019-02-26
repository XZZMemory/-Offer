package 第二遍;

import java.util.*;

/**
 * created by memory
 * on 2018/12/29 上午11:49
 */
public class 大数问题 {
    public static void main(String[] args) {
        System.out.println("##  Hashtable  ##");
        Hashtable<String , String> ht = new Hashtable<String , String>();
        ht.put("1", "OOO");
        ht.put("3", "OOO");
        ht.put("2", "OOO");
        ht.put("5", "OOO");
        ht.put("4", "OOO");

        Iterator<String> it =  ht.keySet().iterator();
        while (it.hasNext()) {
            System.out.println(it.next());
        }

        System.out.println("##  TreeMap  ##");
        TreeMap<String , String> tm = new TreeMap<String , String>();
        tm.put("1", "OOO");
        tm.put("3", "OOO");
        tm.put("2", "OOO");
        tm.put("5", "OOO");
        tm.put("4", "OOO");

        Iterator<String> it2 =  tm.keySet().iterator();
        while (it2.hasNext()) {
            System.out.println(it2.next());
        }

        System.out.println("##  HashMap  ##");
        Map<String , String> hm = new HashMap<String , String>();
        hm.put("1", "OOO");
        hm.put("3", "OOO");
        hm.put("2", "OOO");
        hm.put("5", "OOO");
        hm.put("4", "OOO");

        Iterator<String> it3 =  hm.keySet().iterator();

        while (it3.hasNext()) {
            System.out.println(it3.next());
        }

        System.out.println("##  LinkedHashMap  ##");
        LinkedHashMap<String, String> lhm = new LinkedHashMap<String , String>();
        lhm.put("1", "OOO");
        lhm.put("3", "OOO");
        lhm.put("2", "OOO");
        lhm.put("5", "OOO");
        lhm.put("4", "OOO");

        Iterator<String> it4 =  lhm.keySet().iterator();
        while (it4.hasNext()) {
            System.out.println(it4.next());
        }

        System.out.println("map key-value");
        Map<String, String> map = new HashMap<String, String>();
        map.put("a", "1");
        map.put("c", "3");
        map.put("b", "2");
        map.put("d", "4");

        for(String key : map.keySet()) {
            System.out.println(key+": "+map.get(key));
        }
    }
    /**
     * 由此可见，大致上如下,跟输入 顺序无关
     *
     *   Hashtable.keySet()          降序
     *
     *   TreeMap.keySet()            升序
     *
     *   HashMap.keySet()            乱序
     *
     *   LinkedHashMap.keySet()      原序
     *
     *
     * 除了TreeMap.keySet(), JavaDoc中对keySet()返回值的顺序没有明确说明，
     *
     * 实际应用中，如果对顺序有明确要求，最好能明确的对其顺序进行整理。
     */


}