package 第二遍;

import java.util.Queue;
import java.util.Stack;

/**
 * created by memory
 * on 2019/5/30 下午4:31
 */
public class Offer7用两个栈实现队列 {
    public static void main(String[] args) {
        MyQueue myQueue = new MyQueue();
        myQueue.add(10);
        System.out.println("队列是否为空！" + myQueue.isEmpty());
        System.out.println("对列大小： " + myQueue.size());
        System.out.println("出队列的元素是： " + myQueue.remove());
        System.out.println("队列是否为空！" + myQueue.isEmpty());
        System.out.println("队列大小： " + myQueue.size());
        myQueue.remove();
    }
}

class MyQueue {
    private Stack<Integer> stackIn = new Stack<>();
    private Stack<Integer> stackDe = new Stack<>();

    public void add(Integer value) {
        stackIn.push(value);
    }

    public Integer remove() {
        if (stackDe.isEmpty()) {
            if (stackIn.isEmpty()) {
                System.out.println("队列元素为空！请先入队列");
                return null;
            }
            while (!stackIn.isEmpty()) {
                stackDe.push(stackIn.pop());
            }
        }
        return stackDe.pop();
    }

    public boolean isEmpty() {
        if (stackIn.isEmpty() && stackDe.isEmpty()) {
            return true;
        }
        return false;
    }

    public int size() {
        return stackIn.size() + stackDe.size();
    }
}
