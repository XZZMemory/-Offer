package utils;

public class Queue {
    //前端出队列front、后端rear进队列
    public int[] queue=new int[100];
    public int front=-1;
    public int rear=-1;
    public static  boolean IsEmpty(Queue queue)
    {
        if (queue.front==queue.rear)
            return true;
        return false;
    }

}
