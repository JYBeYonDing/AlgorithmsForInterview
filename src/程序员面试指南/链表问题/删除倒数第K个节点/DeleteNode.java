package 程序员面试指南.链表问题.删除倒数第K个节点;

public class DeleteNode {
    private static class Node{
        public int value;
        public Node next;

        public Node(int data) {
            this.value = data;
        }
    }

    public static Node deleteNode(Node head,int k) {
        if (head == null || k <= 0) {
            return head;
        }
        Node cur = head;
        while (cur != null) {
            cur = cur.next;
            k--;
        }
        if (k == 0) {
            return head.next;
        }
        if (k > 0) {
            return head;
        }
        if (k <0) {
            Node beforeDelete = head;
            while (++k != 0) {
                beforeDelete = beforeDelete.next;
            }
            beforeDelete.next = beforeDelete.next.next;
        }
        return head;

    }

    public static void printLinkedList(Node head) {
        System.out.print("Linked List: ");
        while (head != null) {
            System.out.print(head.value + " ");
            head = head.next;
        }
        System.out.println();
    }

    public static void main(String[] args) {
        Node head1 = new Node(1);
        head1.next = new Node(2);
        head1.next.next = new Node(3);
        head1.next.next.next = new Node(4);
        head1.next.next.next.next = new Node(5);
        head1.next.next.next.next.next = new Node(6);
        printLinkedList(head1);
        head1 = deleteNode(head1, 3);
        // head1 = removeLastKthNode(head1, 6);
        // head1 = removeLastKthNode(head1, 7);
        printLinkedList(head1);
    }
}
