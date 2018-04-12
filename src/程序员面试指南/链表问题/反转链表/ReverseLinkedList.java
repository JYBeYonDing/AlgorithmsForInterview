package 程序员面试指南.链表问题.反转链表;

public class ReverseLinkedList {
    private static class Node{
        public int value;
        public Node next;

        public Node(int data) {
            this.value = data;
        }
    }


    public static Node reverse(Node head) {
        Node pre = null;
        Node next = null;

        while (head != null) {
            next = head.next;
            head.next = pre;
            pre = head;
            head = next;
        }

        return pre;
    }
}
