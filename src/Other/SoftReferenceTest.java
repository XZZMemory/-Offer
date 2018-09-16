package Other;
import java.lang.ref.ReferenceQueue;
import java.lang.ref.SoftReference;//软引用
import java.lang.ref.WeakReference;
public class SoftReferenceTest {
    public  static void main(String[] args)
    {
        /*
        MyObject obj=new MyObject();//强引用
        ReferenceQueue softQueue=new ReferenceQueue<MyObject>();//创建引用队列
        SoftReference<MyObject> softRef=new SoftReference<MyObject>(obj,softQueue);//创建虚引用
        obj=null;//删除强引用
        System.gc();
        System.out.println("gc之后：Soft Get="+softRef.get());
        System.out.println("分配内存块大小");
        byte[] b=new byte[4*1024*925];
        System.out.println("分配内存之后：Soft Get="+softRef.get());*/
        SoftReference<String> softReference=new SoftReference<String>(new String("Hello"));
        System.out.println(softReference.get()+"jkhdkdjhjs");
        WeakReference<String> weakReference=new WeakReference<String>("Hello");
        System.out.println(weakReference.get()+"gc之后");
        System.gc();

        System.out.println(weakReference.get());

    }

}
