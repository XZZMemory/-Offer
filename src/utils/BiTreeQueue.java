package utils;

public class BiTreeQueue {
    //前端出队列front、后端rear进队列
    public BinaryTreeNode[] queue;
    //for(int i=0;i<queue.length;i++)
    //{
        //queue[i]=new BinaryTreeNode()
    //}
    public int front;
    public int rear;
    public static void Init(BiTreeQueue queue)
    {
        queue.front=-1;
        queue.rear=-1;
        queue.queue=new BinaryTreeNode[100];
        for (int i=0;i<queue.queue.length;i++)
        {
            queue.queue[i]=new BinaryTreeNode();
        }
    }
    public static void InQueue(BiTreeQueue queue,BinaryTreeNode p)
    {
        queue.queue[++queue.rear]=p;
    }
    public static BinaryTreeNode DeQueue(BiTreeQueue queue)
    {
        BinaryTreeNode p=new BinaryTreeNode();
        p=queue.queue[++queue.front];
        return  p;
    }
    public static boolean IsEmpty(BiTreeQueue queue)
    {
        if (queue.front==queue.rear)
            return true;
        return false;
    }

}
