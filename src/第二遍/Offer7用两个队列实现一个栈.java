package 第二遍;

import java.util.LinkedList;
import java.util.Queue;

/**
 * created by memory
 * on 2019/5/30 下午4:53
 */
public class Offer7用两个队列实现一个栈 {
    public static void main(String[] args) {
        MyStack myStack = new MyStack();
        myStack.push(10);
        System.out.println("大小：" + myStack.size());
        myStack.push(11);
        System.out.println("大小：" + myStack.size());
        System.out.println("弹出元素是：" + myStack.pop() + " 当前栈大小： " + myStack.size());
        myStack.push(12);
        System.out.println("大小：" + myStack.size());
        System.out.println("弹出元素是：" + myStack.pop() + " 当前栈大小： " + myStack.size());
        System.out.println("弹出元素是：" + myStack.pop() + " 当前栈大小： " + myStack.size());
        System.out.println("弹出元素是：" + myStack.pop() + " 当前栈大小： " + myStack.size());
    }
}

class MyStack {
    private Queue<Integer> queue1 = new LinkedList<>();
    private Queue<Integer> queue2 = new LinkedList<>();

    public void push(Integer value) {
        if (queue1.size() == 0) {
            queue2.add(value);
        } else if (queue2.size() == 0) {
            queue1.add(value);
        } else {
            System.out.println("出错！");
        }
    }

    public Integer pop() {
        if (queue1.size() > 0 && queue2.size() == 0) {
            return transferQueue(queue1, queue2);
        } else if (queue2.size() > 0 && queue1.size() == 0) {
            return transferQueue(queue2, queue1);
        } else {
            System.out.println("栈为空！请先入栈 ");
            return null;
        }
    }

    public Integer transferQueue(Queue<Integer> from, Queue<Integer> to) {
        while (from.size() != 1) {
            to.add(from.poll());
        }
        return from.poll();
    }

    public int size() {
        return queue1.size() + queue2.size();
    }
}
