package 程序员面试指南.链表问题.删除中间节点;

public class DeleteNode {
    private static class Node{
        public int value;
        public Node next;

        public Node(int data) {
            this.value = data;
        }
    }

    public static Node deleteMidNode(Node head) {
        if (head == null || head.next==null) {
            return head;
        }
        if (head.next.next == null) {
            return head.next;
        }

        Node beforeDelete = head;
        Node temp = head.next.next;
        while (temp .next!=null && temp.next.next != null) {
            temp = temp.next.next;
            beforeDelete = beforeDelete.next;
        }
        beforeDelete.next = beforeDelete.next.next;
        return head;
    }

    public static Node deleteByRatio(Node head, int a, int b) {
        int numOfNode = 0;
        Node cur = head;
        while (cur != null) {
            numOfNode++;
            cur = cur.next;
        }
        if (numOfNode == 0 || numOfNode == 1) {
            return head;
        }
        int beforeDeleteIndex =(int)Math.ceil(a*numOfNode/(double)b)-1 ;
        Node beforeDelete = head;

        while (--beforeDeleteIndex > 0) {
            beforeDelete = beforeDelete.next;
        }
        beforeDelete.next = beforeDelete.next.next;
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
        Node head = new Node(1);
        head.next = new Node(2);
        head.next.next = new Node(3);
        head.next.next.next = new Node(4);
        head.next.next.next.next = new Node(5);
        head.next.next.next.next.next = new Node(6);

        printLinkedList(head);
        head = deleteMidNode(head);
        printLinkedList(head);

        head = deleteByRatio(head, 2, 5);
        printLinkedList(head);
        head = deleteByRatio(head, 1, 3);
        printLinkedList(head);

    }

    public static Node removeMidNode(Node head) {
        if (head == null || head.next == null) {
            return head;
        }
        if (head.next.next == null) {
            return head.next;
        }
        Node pre = head;
        Node cur = head.next.next;
        while (cur.next != null && cur.next.next != null) {
            pre = pre.next;
            cur = cur.next.next;
        }
        pre.next = pre.next.next;
        return head;
    }

    public static Node removeByRatio(Node head, int a, int b) {
        if (a < 1 || a > b) {
            return head;
        }
        int n = 0;
        Node cur = head;
        while (cur != null) {
            n++;
            cur = cur.next;
        }
        n = (int) Math.ceil(((double) (a * n)) / (double) b);
        if (n == 1) {
            head = head.next;
        }
        if (n > 1) {
            cur = head;
            while (--n != 1) {
                cur = cur.next;
            }
            cur.next = cur.next.next;
        }
        return head;
    }
}
