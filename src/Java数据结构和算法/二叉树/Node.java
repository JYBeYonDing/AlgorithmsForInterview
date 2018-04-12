package Java数据结构和算法.二叉树;

public class Node {
    public int iData;
    public double dData;
    public Node leftChild;
    public Node rightChild;

    public void displayNode() {
        System.out.println('{');
        System.out.println(iData);
        System.out.println(',');
        System.out.println(dData);
        System.out.println('}');
    }
}
