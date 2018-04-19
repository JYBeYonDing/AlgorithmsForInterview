package 练习;

import javax.print.attribute.standard.NumberUp;

/**
 * Created by 杨杰 on 2018/4/19 21:10.
 */
public class 链表分小中大 {
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
        Node head1 = new Node(7);
        head1.next = new Node(9);
        head1.next.next = new Node(1);
        head1.next.next.next = new Node(8);
        head1.next.next.next.next = new Node(5);
        head1.next.next.next.next.next = new Node(2);
        head1.next.next.next.next.next.next = new Node(5);
        printLinkedList(head1);
        // head1 = listPartition1(head1, 4);
        head1 = listPartition2(head1, 5);
        printLinkedList(head1);

    }

    private static Node listPartition2(Node head1, int i) {
        if (head1 == null || head1.next ==null) {
            return head1;
        }
        Node lH = null;
        Node lE = null;
        Node mH = null;
        Node mE = null;
        Node bH = null;
        Node bE = null;
        Node cur = head1;
        while (cur != null) {
            if (cur.value < i) {
                if (lH == null) {
                    lH = cur;
                    lE = cur;
                } else {
                    lE.next = cur;
                    lE = cur;
                }
            } else if (cur.value > i) {
                if (bH == null) {
                    bH = cur;
                    bE = cur;
                } else {
                    bE.next = cur;
                    bE = cur;
                }
            } else {
                if (mH == null) {
                    mH = cur;
                    mE = cur;
                } else {
                    mE.next = cur;
                    mE = cur;
                }
            }
            cur = cur.next;
        }
        if (lE != null) {
            lE.next = null;
        }
        if (mE != null) {
            mE.next = null;
        }
        if (bE != null) {
            bE.next = null;
        }
        if (mE == null) {
            if (lE != null) {
                lE.next = bH;
                return lH;
            } else {
                return bH;
            }
        } else {
            if (lE != null) {
                lE.next = mH;
                mE.next = bH;
                return lH;
            } else {
                mE.next = bH;
                return mH;
            }
        }
    }
}
