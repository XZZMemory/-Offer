package utils;

public class NodeWithParent {
    public int info;
    public NodeWithParent left;
    public NodeWithParent right;
    public NodeWithParent parent;
    public NodeWithParent(int info)//构造函数
    {
        this.info=info;
    }
}
