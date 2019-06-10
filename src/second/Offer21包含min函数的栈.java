package second;

import java.util.EmptyStackException;
import java.util.Stack;

/**
 * created by memory
 * on 2019/6/3 下午9:12
 */
public class Offer21包含min函数的栈 {
    public static void main(String[] args) {
        MyMinStack minStack = new MyMinStack();
        minStack.push(3);
        minStack.push(5);
        minStack.pop();
        minStack.push(2);
        minStack.push(0);
        minStack.push(4);
    }
}

class MyMinStack {
    private Stack<Integer> dataStack = new Stack<>();
    private Stack<Integer> minStack = new Stack<>();

    public void push(int data) {
        if (isEmpty()) {
            minStack.push(data);
        } else {
            int currentMin = minStack.peek();
            if (currentMin > data) {
                minStack.push(data);
            } else {
                minStack.push(currentMin);
            }
        }
        dataStack.push(data);
        travere();
    }

    public Integer pop() {
        if (isEmpty()) {
            System.out.println("栈为空！");
            return null;
        } else {
            minStack.pop();
            int data = dataStack.pop();
            travere();
            return data;
        }
    }

    public boolean isEmpty() {
        return dataStack.isEmpty();
    }

    public int size() {
        return dataStack.size();
    }

    public int min() {
        if (size() == 0) {
            System.out.println("当前栈为空！没有最小元素");
            throw new EmptyStackException();
        }
        return minStack.peek();
    }

    public void travere() {
        System.out.println("****************");
        System.out.println("当前数据栈元素是：");
        int i = dataStack.size() - 1;
        while (i >= 0) {
            int elem = dataStack.elementAt(i);
            System.out.println(elem);
            --i;
        }
        System.out.println("当前最小栈元素是：");
        i = minStack.size() - 1;
        while (i >= 0) {
            int elem = minStack.elementAt(i);
            System.out.println(elem);
            --i;
        }
    }
}
