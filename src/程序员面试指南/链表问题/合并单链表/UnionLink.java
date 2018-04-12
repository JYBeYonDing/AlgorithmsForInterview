package 程序员面试指南.链表问题.合并单链表;

/**
 * Created by 杨杰 on 2018/4/4 14:07.
 * 14:25完成
 */
public class UnionLink {
    public static class Node {
        public int value;
        public Node next;

        public Node(int data) {
            this.value = data;
        }
    }

    public static Node merge(Node head1, Node head2) {
//        if (head1 == null && head2 == null) {
//            return null;
//        } else if (head1 == null) {
//            return head2;
//        } else if (head2 == null) {
//            return head1;
//        }
        if (head1 == null || head2 == null) {
            return head1 == null ? head2 : head1;
        }

        Node newHead = head1.value < head2.value ? head1 : head2;
        Node newTail = newHead;
        if (newHead == head1) {
            head1 = head1.next;
        } else {
            head2 = head2.next;
        }
        while (head1 != null && head2 != null) {
            if (head1.value < head2.value) {
                newTail.next = head1;
                newTail = head1;
                head1 = head1.next;
            } else {
                newTail.next = head2;
                newTail = head2;
                head2 = head2.next;
            }

        }
//        if (head1 == null) {
//            newTail.next = head2;
//        } else {
//            newTail.next = head1;
//        }
        newTail.next = head1 == null ? head2 : head1;
        return newHead;
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

        Node head1 = null;
        Node head2 = null;
        Node head = merge(head1, head2);
        printLinkedList(head);

        head1 = new Node(1);
        head2 = null;
        head = merge(head1, head2);
        printLinkedList(head);

        head1 = null;
        head2 = new Node(1);
        head = merge(head1, head2);
        printLinkedList(head);

        head1 = new Node(1);
        head2 = new Node(2);
        head = merge(head1, head2);
        printLinkedList(head);

        head1 = new Node(2);
        head2 = new Node(1);
        head = merge(head1, head2);
        printLinkedList(head);

        head1 = new Node(1);
        head1.next = new Node(4);
        head2 = new Node(2);
        head2.next = new Node(3);
        head2.next.next = new Node(5);
        head = merge(head1, head2);
        printLinkedList(head);

        head1 = new Node(1);
        head1.next = new Node(3);
        head1.next.next = new Node(5);
        head1.next.next.next = new Node(7);
        head1.next.next.next.next = new Node(9);
        head2 = new Node(0);
        head2.next = new Node(6);
        head2.next.next = new Node(6);
        head2.next.next.next = new Node(7);
        head = merge(head1, head2);
        printLinkedList(head);

    }


    public static Node merge2(Node head1, Node head2) {
        if (head1 == null || head2 == null) {
            return head1 != null ? head1 : head2;
        }
        Node head = head1.value < head2.value ? head1 : head2;
        Node cur1 = head == head1 ? head1 : head2;
        Node cur2 = head == head1 ? head2 : head1;
        Node pre = null;
        Node next = null;
        while (cur1 != null && cur2 != null) {
            if (cur1.value <= cur2.value) {
                pre = cur1;
                cur1 = cur1.next;
            } else {
                next = cur2.next;
                pre.next = cur2;
                cur2.next = cur1;
                pre = cur2;
                cur2 = next;
            }
        }
        pre.next = cur1 == null ? cur2 : cur1;
        return head;
    }

}
