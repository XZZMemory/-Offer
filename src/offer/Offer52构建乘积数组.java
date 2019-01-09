package offer;
//不能使用除法
public class Offer52构建乘积数组 {
    public static void main(String[] args)
    {
        int[] A={1,2,3,4,5};
        int[] B=Multipy(A);
    }
    public static int[] Multipy(int[] A)
    {
        int[] B=new int[A.length];
        int[] C=new int[A.length];
        int[] D=new int[A.length];
        for (int i=0;i<C.length;i++)
        {
            if (i==0)
                C[i]=1;
            else
                C[i]=A[i-1]*C[i-1];
        }
        for (int i=A.length-1;i>=0;i--)
        {
            if (i==A.length-1)
                D[i]=1;
            else D[i]=D[i+1]*A[i+1];
        }
        for (int i=0;i<B.length;i++)
            B[i]=C[i]*D[i];
        return B;
    }
}
