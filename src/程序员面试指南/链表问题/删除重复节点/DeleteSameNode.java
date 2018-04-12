package 程序员面试指南.链表问题.删除重复节点;

import java.util.HashSet;

public class DeleteSameNode {
    public static class Node {
        public int value;
        public Node next;

        public Node(int data) {
            this.value = data;
        }
    }


    /**
     * 使用HashSet
     * @param head
     */
    public static void removeRep1(Node head) {
        if (head == null) {
            return;
        }
        HashSet<Integer> hs = new HashSet<>();
        hs.add(head.value);
        Node pre = head;
        head = head.next;
        while (head != null) {
            if (hs.contains(head.value)) {
                pre.next = head.next;
            } else {
                hs.add(head.value);
                pre = head;
            }
            head = head.next;
        }
    }

    /**
     * 空间复杂度O（1），时间复杂度O（n^2）
     * @param head
     */
    public static void removeRep2(Node head) {

        Node out = head;
        while (out != null) {
            Node inPre = out;
            Node inCur = out.next;
            while (inCur != null) {
                Node next = inCur.next;
                if (out.value == inCur.value) {
                    inPre.next = inCur.next;
                    inCur = next;
                } else {
                    inPre = inCur;
                    inCur = next;
                }
            }
            out = out.next;
        }
    }


    /**
     * **********************************************************
     * 测试代码
     * **********************************************************
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
        Node head = new Node(1);
        head.next = new Node(2);
        head.next.next = new Node(3);
        head.next.next.next = new Node(3);
        head.next.next.next.next = new Node(4);
        head.next.next.next.next.next = new Node(4);
        head.next.next.next.next.next.next = new Node(2);
        head.next.next.next.next.next.next.next = new Node(1);
        head.next.next.next.next.next.next.next.next = new Node(1);
        removeRep1(head);
        printLinkedList(head);

        head = new Node(1);
        head.next = new Node(1);
        head.next.next = new Node(3);
        head.next.next.next = new Node(3);
        head.next.next.next.next = new Node(4);
        head.next.next.next.next.next = new Node(4);
        head.next.next.next.next.next.next = new Node(2);
        head.next.next.next.next.next.next.next = new Node(1);
        head.next.next.next.next.next.next.next.next = new Node(1);
        removeRep2(head);
        printLinkedList(head);

    }

    public static void removeRep22(Node head) {
        Node cur = head;
        Node pre = null;
        Node next = null;
        while (cur != null) {
            pre = cur;
            next = cur.next;
            while (next != null) {
                if (cur.value == next.value) {
                    pre.next = next.next;
                } else {
                    pre = next;
                }
                next = next.next;
            }
            cur = cur.next;
        }
    }
}
