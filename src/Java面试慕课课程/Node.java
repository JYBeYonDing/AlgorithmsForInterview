package Java面试慕课课程;

/**
 * Created by 杨杰 on 2018/6/22 15:02.
 */
public class Node {
    private final int value;
    private Node next;

    public Node(int value) {
        this.value = value;
        this.next = null;
    }

    public int getValue() {
        return value;
    }

    public Node getNext() {
        return next;
    }

    public void setNext(Node next) {
        this.next = next;
    }

    public static void printLinkedList(Node head) {
        while (head != null) {
            System.out.print(head.getValue()+"->");
            head = head.getNext();
        }
        System.out.println("null");
    }
}
