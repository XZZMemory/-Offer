package Other;

public class MyObject {
    protected void finalize() throws Throwable
    {
        super.finalize();
        System.out.println("MyObject's finalize called");//垃圾回收器执行时会调用被回收对象的finalize()方法
    }
    public String toString()
    {
        return "I am MyObiect";
    }
}
