package 练习;

/**
 * Created by 杨杰 on 2018/4/19 20:25.
 * 完成 20:40
 */
public class 判断链表是否回文 {
    public static class Node {
        public int value;
        public Node next;

        public Node(int data) {
            this.value = data;
        }
    }


    public static void printLinkedList(Node node) {
        System.out.print("Linked List: ");
        while (node != null) {
            System.out.print(node.value + " ");
            node = node.next;
        }
        System.out.println();
    }

    public static void main(String[] args) {

        Node head = null;
        printLinkedList(head);
        System.out.println(isPalindrome3(head) + " | ");
        printLinkedList(head);
        System.out.println("=========================");

        head = new Node(1);
        printLinkedList(head);
        System.out.println(isPalindrome3(head) + " | ");
        printLinkedList(head);
        System.out.println("=========================");

        head = new Node(1);
        head.next = new Node(2);
        printLinkedList(head);
        System.out.println(isPalindrome3(head) + " | ");
        printLinkedList(head);
        System.out.println("=========================");

        head = new Node(1);
        head.next = new Node(1);
        printLinkedList(head);
        System.out.println(isPalindrome3(head) + " | ");
        printLinkedList(head);
        System.out.println("=========================");

        head = new Node(1);
        head.next = new Node(2);
        head.next.next = new Node(3);
        printLinkedList(head);
        System.out.println(isPalindrome3(head) + " | ");
        printLinkedList(head);
        System.out.println("=========================");

        head = new Node(1);
        head.next = new Node(2);
        head.next.next = new Node(1);
        printLinkedList(head);
        System.out.println(isPalindrome3(head) + " | ");
        printLinkedList(head);
        System.out.println("=========================");

        head = new Node(1);
        head.next = new Node(2);
        head.next.next = new Node(3);
        head.next.next.next = new Node(1);
        printLinkedList(head);
        System.out.println(isPalindrome3(head) + " | ");
        printLinkedList(head);
        System.out.println("=========================");

        head = new Node(1);
        head.next = new Node(2);
        head.next.next = new Node(2);
        head.next.next.next = new Node(1);
        printLinkedList(head);
        System.out.println(isPalindrome3(head) + " | ");
        printLinkedList(head);
        System.out.println("=========================");

        head = new Node(1);
        head.next = new Node(2);
        head.next.next = new Node(3);
        head.next.next.next = new Node(2);
        head.next.next.next.next = new Node(1);
        printLinkedList(head);
        System.out.println(isPalindrome3(head) + " | ");
        printLinkedList(head);
        System.out.println("=========================");

    }

    private static boolean isPalindrome3(Node head) {
        if (head == null) {
            return false;
        }
        if (head.next == null) {
            return true;
        }
        if (head.next.next == null) {
            if (head.value == head.next.value) {
                return true;
            } else {
                return false;
            }
        }
        // 找到中间节点
        Node left = head;
        Node right = head;
        while (right.next != null && right.next.next != null) {
            left = left.next;
            right = right.next.next;
        }
        Node cur = left.next;
        left.next = null;
        Node leftEnd = left;
        Node pre = left;
        Node next = null;
        while (cur != null) {
            next = cur.next;
            cur.next = pre;
            pre = cur;
            cur = next;
        }
        Node revHead = pre;

        boolean isPal = true;
        left = head;
        while (left != null) {
            if (left.value != pre.value) {
                isPal = false;
                break;
            }
            left = left.next;
            pre = pre.next;
        }

        pre = null;
        cur = revHead;
        while (cur != leftEnd) {
            next = cur.next;
            cur.next = pre;
            pre = cur;
            cur = next;
        }
        leftEnd.next = pre;
        return isPal;
    }

}
