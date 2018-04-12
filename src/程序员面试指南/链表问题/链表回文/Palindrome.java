package 程序员面试指南.链表问题.链表回文;

import java.util.ArrayDeque;

public class Palindrome {
    private static class Node{
        public int value;
        public Node next;

        public Node(int data) {
            this.value = data;
        }
    }

    public static boolean isPalindrome1(Node head) {
        if (head == null) {
            return false;
        }
        ArrayDeque<Node> stack = new ArrayDeque<>();
        Node cur = head;
        while (cur != null) {
            stack.push(cur);
            cur = cur.next;
        }
        while (head != null) {
            if (head.value != stack.pop().value) {
                return false;
            } else {
                head = head.next;
            }
        }
        return true;
    }



    public static boolean isPalindrome3(Node head) {
        if (head == null || head.next == null) {
            return true;
        } else if (head.next.next == null) {
            return head.value == head.next.value;
        } else {
            Node mid = head.next;
            Node cur = head.next.next;
            while (cur.next != null && cur.next.next != null) {
                cur = cur.next.next;
                mid = mid.next;
            }

            //反转后半部分
            Node presend = mid.next;
            Node pre = mid;
            Node next = null;
            while (presend != null) {
                next = presend.next;
                presend.next = pre;
                pre = presend;
                presend = next;
            }
            Node rightStart = pre;
            Node rightTemp = rightStart;
            Node leftStart = head;
            boolean flag = true;
            mid.next=null;
            while (leftStart != null) {
                if (leftStart.value != rightStart.value) {
                    flag = false;
                    break;
                } else {
                    leftStart = leftStart.next;
                    rightStart = rightStart.next;
                }
            }

            presend = rightTemp.next;
            rightTemp.next=null;
            pre = rightTemp;
            while (presend != null) {
                next = presend.next;
                presend.next = pre;
                pre = presend;
                presend = next;
            }

            return flag;
        }
    }

    /**
     *
     * @param node
     */

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
//        System.out.print(isPalindrome1(head) + " | ");
//        System.out.print(isPalindrome2(head) + " | ");
        System.out.println(isPalindrome3(head) + " | ");
        printLinkedList(head);
        System.out.println("=========================");

        head = new Node(1);
        printLinkedList(head);
//        System.out.print(isPalindrome1(head) + " | ");
//        System.out.print(isPalindrome2(head) + " | ");
        System.out.println(isPalindrome3(head) + " | ");
        printLinkedList(head);
        System.out.println("=========================");

        head = new Node(1);
        head.next = new Node(2);
        printLinkedList(head);
//        System.out.print(isPalindrome1(head) + " | ");
//        System.out.print(isPalindrome2(head) + " | ");
        System.out.println(isPalindrome3(head) + " | ");
        printLinkedList(head);
        System.out.println("=========================");

        head = new Node(1);
        head.next = new Node(1);
        printLinkedList(head);
//        System.out.print(isPalindrome1(head) + " | ");
//        System.out.print(isPalindrome2(head) + " | ");
        System.out.println(isPalindrome3(head) + " | ");
        printLinkedList(head);
        System.out.println("=========================");

        head = new Node(1);
        head.next = new Node(2);
        head.next.next = new Node(3);
        printLinkedList(head);
//        System.out.print(isPalindrome1(head) + " | ");
//        System.out.print(isPalindrome2(head) + " | ");
        System.out.println(isPalindrome3(head) + " | ");
        printLinkedList(head);
        System.out.println("=========================");

        head = new Node(1);
        head.next = new Node(2);
        head.next.next = new Node(1);
        printLinkedList(head);
//        System.out.print(isPalindrome1(head) + " | ");
//        System.out.print(isPalindrome2(head) + " | ");
        System.out.println(isPalindrome3(head) + " | ");
        printLinkedList(head);
        System.out.println("=========================");

        head = new Node(1);
        head.next = new Node(2);
        head.next.next = new Node(3);
        head.next.next.next = new Node(1);
        printLinkedList(head);
//        System.out.print(isPalindrome1(head) + " | ");
//        System.out.print(isPalindrome2(head) + " | ");
        System.out.println(isPalindrome3(head) + " | ");
        printLinkedList(head);
        System.out.println("=========================");

        head = new Node(1);
        head.next = new Node(2);
        head.next.next = new Node(2);
        head.next.next.next = new Node(1);
        printLinkedList(head);
//        System.out.print(isPalindrome1(head) + " | ");
//        System.out.print(isPalindrome2(head) + " | ");
        System.out.println(isPalindrome3(head) + " | ");
        printLinkedList(head);
        System.out.println("=========================");

        head = new Node(1);
        head.next = new Node(2);
        head.next.next = new Node(3);
        head.next.next.next = new Node(2);
        head.next.next.next.next = new Node(1);
        printLinkedList(head);
//        System.out.print(isPalindrome1(head) + " | ");
//        System.out.print(isPalindrome2(head) + " | ");
        System.out.println(isPalindrome3(head) + " | ");
        printLinkedList(head);
        System.out.println("=========================");

    }
}
