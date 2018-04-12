package 程序员面试指南.链表问题.单链表的选择排序;

public class SortLink {
    public static class Node {
        public int value;
        public Node next;

        public Node(int data) {
            this.value = data;
        }
    }


    public static Node selectionSort(Node head) {
        if (head == null || head.next == null) {
            return head;
        }
        Node newHead = findMin(head);
        Node newTail = newHead;
        while (newTail.next != null) {
            newTail.next = findMin(newTail.next);
            newTail = newTail.next;
        }
        return newHead;
    }

    /**
     * 找到最小的节点，并将这个最小的节点放在第一个返回。
     * @param head
     * @return
     */
    public static Node findMin(Node head) {
        Node min = head;
        Node minPre = null;
        Node cur = min.next;
        Node curPre = min;
        while (cur != null) {
            Node curNext = cur.next;
            if (cur.value < min.value) {
                minPre = curPre;
                min = cur;
            }
            curPre = cur;
            cur = curNext;
        }
        if (min != head) {
            minPre.next = min.next;
            min.next = head;
        }
        return min;
    }



    /**
     * 测试代码
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
        head = selectionSort(head);
        printLinkedList(head);

        head = new Node(1);
        head = selectionSort(head);
        printLinkedList(head);

        head = new Node(1);
        head.next = new Node(2);
        head = selectionSort(head);
        printLinkedList(head);

        head = new Node(2);
        head.next = new Node(1);
        head = selectionSort(head);
        printLinkedList(head);

        head = new Node(1);
        head.next = new Node(2);
        head.next.next = new Node(3);
        head = selectionSort(head);
        printLinkedList(head);

        head = new Node(1);
        head.next = new Node(3);
        head.next.next = new Node(2);
        head = selectionSort(head);
        printLinkedList(head);

        head = new Node(2);
        head.next = new Node(1);
        head.next.next = new Node(3);
        head = selectionSort(head);
        printLinkedList(head);

        head = new Node(2);
        head.next = new Node(3);
        head.next.next = new Node(1);
        head = selectionSort(head);
        printLinkedList(head);

        head = new Node(3);
        head.next = new Node(1);
        head.next.next = new Node(2);
        head = selectionSort(head);
        printLinkedList(head);

        head = new Node(3);
        head.next = new Node(2);
        head.next.next = new Node(1);
        head = selectionSort(head);
        printLinkedList(head);

        head = new Node(3);
        head.next = new Node(1);
        head.next.next = new Node(4);
        head.next.next.next = new Node(2);
        head = selectionSort(head);
        printLinkedList(head);

    }

    public static Node selectionSort2(Node head) {
        Node tail = null; // sorted part tail
        Node cur = head; // unsorted part head
        Node smallPre = null; // previous node of the smallest node
        Node small = null; // smallest node
        while (cur != null) {
            small = cur;
            smallPre = getSmallestPreNode(cur);
            if (smallPre != null) {
                small = smallPre.next;
                smallPre.next = small.next;
            }
            cur = cur == small ? cur.next : cur;
            if (tail == null) {
                head = small;
            } else {
                tail.next = small;
            }
            tail = small;
        }
        return head;
    }

    public static Node getSmallestPreNode(Node head) {
        Node smallPre = null;
        Node small = head;
        Node pre = head;
        Node cur = head.next;
        while (cur != null) {
            if (cur.value < small.value) {
                smallPre = pre;
                small = cur;
            }
            pre = cur;
            cur = cur.next;
        }
        return smallPre;
    }
}
