package tooffer;
//题目一：输入一个英文句子，翻转单词中的顺序，但单词内字符的顺序不变。 I am a student. 变成 student. a am I
//题目二：字符串的左旋操作是把字符串前面的若干字符转移到字符的尾部.abcdefg 和数字2 左旋2位得到：cdefgab
public class Offer42翻转单词顺序VS左旋转字符串 {
    public static void main(String[] args)
    {
        String str="I am a student.";
        char[] data=str.toCharArray();
        ReverseSentence(data);
        TreversalOfArray(data);
        System.out.println();
        String str2="abcdefg";
        char[] data2=str2.toCharArray();
        data2=null;
        LeftRotateString(data2,2);
        TreversalOfArray(data2);
    }
    public static void TreversalOfArray(char[] data)
    {
        if (data==null)
        {
            System.out.println("字符数组为空！");
            return;
        }

        for (int i=0;i<data.length;i++)
            System.out.print(data[i]);
    }
    public static void Reverse(char[] data,int begin,int end)
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
    public static void ReverseSentence(char[] data)
    {
        if (data==null)
        {
            System.out.println("数据是空！");
            return;
        }
        Reverse(data,0,data.length-1);//翻转整个句子
        //翻转句子中的每个单词。
        int start=0;
        int end=0;
        while (end<data.length)
        {
            if (data[end]==' '||end==data.length-1)
            {
                Reverse(data,start,end-1);
                end++;
                start=end;
            }
            while(end<data.length&&(data[end]!=' '))
                end++;
        }
    }
    public static void LeftRotateString(char[] data,int index)
    {
        if (data==null||index<0||index>=data.length)
        {
            System.out.println("参数错误！");
            return;
        }
        Reverse(data,0,index-1);
        Reverse(data,index,data.length-1);
        Reverse(data,0,data.length-1);

    }
}
