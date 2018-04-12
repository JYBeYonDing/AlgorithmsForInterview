package 程序员面试指南.链表问题.相加链表;

import java.util.ArrayDeque;

public class AddLinkedList {
    private static class Node{
        public int value;
        public Node next;

        public Node(int data) {
            this.value = data;
        }
    }

    /**
     * ********************************************************
     * 自己写的方法，没有考虑数值的溢出问题，不好
     * ********************************************************
     */

    public static Node addLists12(Node head1, Node head2) {
        int result = linked2int(head1)+linked2int(head2);
        char[] chars = new Integer(result).toString().toCharArray();
        Node head = null;
        Node last =null;
        for(int i = chars.length-1;i>=0;i--) {
            head = new Node(chars[i]-'0');
            head.next = last;
            last = head;
        }
        return head;
    }

    private static int linked2int(Node head) {
        if (head == null) {
            return 0;
        }
        int result = 0;
        while (head != null) {
            result = result * 10 + head.value;
            head = head.next;
        }
        return result;
    }

//*********************************************************************************
    /**
     * ********************************************************
     * 方法一：用栈
     * ********************************************************
     */

    public static Node addLists1(Node head1, Node head2) {
        ArrayDeque<Integer> s1 = new ArrayDeque<>();
        ArrayDeque<Integer> s2 = new ArrayDeque<>();

        while (head1 != null) {
            s1.push(head1.value);
            head1 = head1.next;
        }
        while (head2 != null) {
            s2.push(head2.value);
            head2 = head2.next;
        }

        int ca = 0;
        Node head = null;
        Node last = null;
        while ((!s1.isEmpty()) && (!s2.isEmpty())) {
            int val1 = s1.pop();
            int val2 = s2.pop();
            val1 = val1+val2+ca;
            ca = val1/10;
            val1 = val1 % 10;

            head = new Node(val1);
            head.next = last;
            last = head;
        }

        if (s1.isEmpty()) {
            s1 = s2;
        }
        while (!s1.isEmpty()) {
            int val1 = s1.pop()+ca;
            ca = val1/10;
            val1 = val1 % 10;

            head = new Node(val1);
            head.next = last;
            last = head;
        }
        if (ca == 1) {
            head = new Node(1);
            head.next = last;
        }
        return head;
    }

    /**
     * ********************************************************
     * 方法二：利用链表的逆序求解，可以省掉用栈的空间
     * ********************************************************
     */
    public static Node addLists2(Node head1, Node head2) {
        head1 = reverseLinkedList(head1);
        head2 = reverseLinkedList(head2);

        int ca = 0;
        Node head = null;
        Node last = null;
        while (head1 != null || head2 != null) {
            int n1 = head1==null? 0 :head1.value;
            head1 = head1 == null ? null : head1.next;
            int n2 = head2==null? 0 :head2.value;
            head2 = head2 == null ? null : head2.next;

            n1 += n2+ca;
            head = new Node(n1 % 10);
            ca = n1/10;
            head.next = last;
            last = head;
        }
        if (ca == 1) {
            head = new Node(1);
            head.next = last;
        }

        reverseLinkedList(head1);
        reverseLinkedList(head2);

        return head;
    }

    private static Node reverseLinkedList(Node head) {
        if (head == null || head.next == null) {
            return head;
        }

        Node cur = head;
        Node pre = null;
        Node next = null;
        while (cur != null) {
            next = cur.next;
            cur.next = pre;
            pre = cur;
            cur = next;
        }
        return pre;
    }


    /**
     * **************************************************
     * 测试用代码
     * **************************************************
     */



    public static void printLinkedList(Node head) {
        System.out.print("Linked List: ");
        while (head != null) {
            System.out.print(head.value + " ");
            head = head.next;
        }
        System.out.println();
    }

    public static void main(String[] args) {
        Node head1 = new Node(9);
        head1.next = new Node(9);
        head1.next.next = new Node(9);

        Node head2 = new Node(1);

        printLinkedList(head1);
        printLinkedList(head2);
//        printLinkedList(addLists1(head1, head2));
        printLinkedList(addLists2(head1, head2));

    }
}
