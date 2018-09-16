//定义栈的数据结构，实现一个能够得到栈的最小元素的min函数，在该栈中，调用min、push、pop的时间复杂度都是O(1)
package tooffer;
import utils.*;

import javax.swing.text.html.Option;
import java.util.Scanner;

public class Offer21包含min函数的栈 {
    public static void main(String[] args) {
        System.out.println("请输入操作，0-退出程序，1-出栈，2-最小元素，其他数据-进栈元素");
        Stack dataStack=new Stack();
        Stack minData=new Stack();
        Scanner scanner;
        scanner=new Scanner(System.in);
        int option=scanner.nextInt();
        while(option!=0)
        {
            if (option==1)//出栈
            {
                if (dataStack.top==-1)//判断栈是否为空,若空则需进栈
                    System.out.println("栈空! 没有数据，请先入栈");
                else //栈不空
                {
                    System.out.println(dataStack.stack[dataStack.top]);//输出栈孩子中数据
                    dataStack.top--;
                    minData.top--;
                }
            }
            else if (option==2)//看当前栈中最小元素。只需输出当前最小元素即可，不需出栈操作
            {
                if (dataStack.top == -1)
                    System.out.println("栈空！没有数据，请先入栈");
                else //栈不空，直接输出数据即可
                    System.out.println(minData.stack[minData.top]);
            }
            else//进栈操作
            {
                if (dataStack.top>=dataStack.stack.length-1)//栈满，进栈不行，需要先出栈
                    System.out.println("栈已满，请先出栈");
                else
                {

                    if (dataStack.top==-1)//栈内没有数据
                    {
                        dataStack.stack[++dataStack.top]=option;
                        minData.stack[++minData.top]=option;
                    }
                    else//栈内有数据
                    {
                        dataStack.stack[++dataStack.top]=option;
                        if (minData.stack[minData.top]<option)
                        {
                            int min=minData.stack[minData.top];
                            minData.stack[++minData.top]=min;
                        }
                        else
                            minData.stack[++minData.top]=option;
                    }
                    System.out.println("进栈成功！");
                }
            }
            System.out.println("请输入操作，0-退出程序，1-出栈，2-最小元素，其他数据-进栈元素");
            scanner=new Scanner(System.in);
            option=scanner.nextInt();
        }
        System.out.println("退出程序！");
    }
}
