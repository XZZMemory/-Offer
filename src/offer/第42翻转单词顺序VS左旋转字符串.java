package offer;
//题目一：输入一个英文句子，翻转单词中的顺序，但单词内字符的顺序不变。 I am a student. 变成 student. a am I
//题目二：字符串的左旋操作是把字符串前面的若干字符转移到字符的尾部.abcdefg 和数字2 左旋2位得到：cdefgab
public class 第42翻转单词顺序VS左旋转字符串 {
    public static void main(String[] args)
    {
        char[] data="I am a student.".toCharArray();
        reverseSentence(data);
        treversalOfArray(data);
        System.out.println();
        char[] data2="abcdefg".toCharArray();
        data2=null;
        leftRotateString(data2,2);
        treversalOfArray(data2);
    }
    public static void treversalOfArray(char[] data)
    {
        if (data==null)
        {
            System.out.println("字符数组为空！");
            return;
        }

        for (int i=0;i<data.length;i++)
            System.out.print(data[i]);
    }
    public static void reverse(char[] data, int begin, int end)
    {
        if (begin<0||end>=data.length||begin>end||data==null)
        {
            System.out.println("参数信息错误！");
            return;
        }
        while (begin<end)
        {
            char temp=data[begin];
            data[begin]=data[end];
            data[end]=temp;
            begin++;
            end--;
        }
    }
    public static void reverseSentence(char[] data)
    {
        if (data==null)
        {
            System.out.println("数据是空！");
            return;
        }
        reverse(data,0,data.length-1);//翻转整个句子
        //翻转句子中的每个单词。
        int start=0;
        int end=0;
        while (end<data.length)
        {
            if (data[end]==' '||end==data.length-1)
            {
                reverse(data,start,end-1);
                end++;
                start=end;
            }
            while(end<data.length&&(data[end]!=' '))
                end++;
        }
    }
    //字符串的左旋操作
    public static void leftRotateString(char[] data, int index)
    {
        if (data==null||index<0||index>=data.length)
        {
            System.out.println("参数错误！");
            return;
        }
        //abcedf
        reverse(data,0,index-1);//bacdef
        reverse(data,index,data.length-1);//bafedc
        reverse(data,0,data.length-1);//cdefab

    }
}
