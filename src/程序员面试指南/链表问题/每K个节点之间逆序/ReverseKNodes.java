package 程序员面试指南.链表问题.每K个节点之间逆序;

import java.awt.*;
import java.util.ArrayDeque;

public class ReverseKNodes {
    public static class Node {
        public int value;
        public Node next;

        public Node(int data) {
            this.value = data;
        }
    }

    /**
     * 方法一：使用栈结构
     * @param head
     * @param K
     * @return
     */
    public static Node reverseKNodes1(Node head, int K) {
        if (head == null || head.next == null) {
            return head;
        }
        if (K < 2) {
            return head;
        }
        ArrayDeque<Node> s = new ArrayDeque<>();
        Node newHead = new Node(0);
        newHead.next = head;
        Node newTail = newHead;
        Node cur = head;
        Node subCur=null;
        Node subHead=null;
        int count = 0;
        while (cur != null) {
            // 链表问题，如果后面会改变指针的话，
            // 先把下一个节点存起来，否则很容易丢失。
            Node next = cur.next;
            s.push(cur);
            count++;
            if (count == K) {
                count = 0;
                subCur = s.pop();
                subHead = subCur;
                while (!s.isEmpty()) {
                    subCur.next = s.pop();
                    subCur = subCur.next;
                }

                newTail.next = subHead;
                newTail = subCur;
                newTail.next = next;//为了防止后面的指针丢失，先让新链的尾节点指向后面开始的节点。
            }
            cur = next;
        }
        return newHead.next;
    }


    /**
     * 方法二：不需要栈结构，在原链表直接调整
     * @param head
     * @param K
     * @return
     */
    public static Node reverseKNodes2(Node head, int K) {
        if (head == null || head.next == null || K < 2) {
            return head;
        }

        Node cur = head;
        Node newHead = head;
        Node newTail = null;
        Node subHead = null;
        Node subTail = null;
        Node next = null;
        int count = 0;
        Node tempHead= null;
        while (cur != null) {
            next = cur.next;
            count++;
            if (count == 1) {
                subHead = cur;
            }
            if (count == K) {
                count=0;
                subTail = cur;
                tempHead = reverse(subHead, subTail.next);
                if (newHead == head) {
                    newHead = tempHead;
                    newTail = head;
                } else {
                    newTail.next = tempHead;
                    newTail = subHead;
                }
                subHead.next = next;
            }
            cur = next;
        }
        return newHead;

    }

    private static Node reverse(Node subHead, Node subTail) {
        Node pre = null;
        Node next = null;
        Node cur = subHead;
        while (cur != subTail) {
            next = cur.next;
            cur.next = pre;
            pre = cur;
            cur = next;
        }
        return pre;
    }

    /**
     * ***************************************************************
     * 测试代码
     * ***************************************************************
     *
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
        Node head = null;
        int K = 3;
        printLinkedList(head);
        head = reverseKNodes1(head, K);
        printLinkedList(head);
        head = reverseKNodes2(head, K);
        printLinkedList(head);
        System.out.println("=======================");

        head = new Node(1);
        K = 3;
        printLinkedList(head);
        head = reverseKNodes1(head, K);
        printLinkedList(head);
        head = reverseKNodes2(head, K);
        printLinkedList(head);
        System.out.println("=======================");

        head = new Node(1);
        head.next = new Node(2);
        K = 2;
        printLinkedList(head);
        head = reverseKNodes1(head, K);
        printLinkedList(head);
        head = reverseKNodes2(head, K);
        printLinkedList(head);
        System.out.println("=======================");

        head = new Node(1);
        head.next = new Node(2);
        K = 3;
        printLinkedList(head);
        head = reverseKNodes1(head, K);
        printLinkedList(head);
        head = reverseKNodes2(head, K);
        printLinkedList(head);
        System.out.println("=======================");

        head = new Node(1);
        head.next = new Node(2);
        head.next.next = new Node(3);
        head.next.next.next = new Node(4);
        K = 2;
        printLinkedList(head);
        head = reverseKNodes1(head, K);
        printLinkedList(head);
        head = reverseKNodes2(head, K);
        printLinkedList(head);
        System.out.println("=======================");

        head = new Node(1);
        head.next = new Node(2);
        head.next.next = new Node(3);
        head.next.next.next = new Node(4);
        head.next.next.next.next = new Node(5);
        head.next.next.next.next.next = new Node(6);
        head.next.next.next.next.next.next = new Node(7);
        head.next.next.next.next.next.next.next = new Node(8);
        K = 3;
        printLinkedList(head);
        head = reverseKNodes1(head, K);
        printLinkedList(head);
        head = reverseKNodes2(head, K);
        printLinkedList(head);
        System.out.println("=======================");

    }

    

    public static Node reverseKNodes22(Node head, int K) {
        if (K < 2) {
            return head;
        }
        Node cur = head;
        Node start = null;
        Node pre = null;
        Node next = null;
        int count = 1;
        while (cur != null) {
            next = cur.next;
            if (count == K) {
                start = pre == null ? head : pre.next;
                head = pre == null ? cur : head;
                resign2(pre, start, cur, next);
                pre = start;
                count = 0;
            }
            count++;
            cur = next;
        }
        return head;
    }

    public static void resign2(Node left, Node start, Node end, Node right) {
        Node pre = start;
        Node cur = start.next;
        Node next = null;
        while (cur != right) {
            next = cur.next;
            cur.next = pre;
            pre = cur;
            cur = next;
        }
        if (left != null) {
            left.next = end;
        }
        start.next = right;
    }

}
