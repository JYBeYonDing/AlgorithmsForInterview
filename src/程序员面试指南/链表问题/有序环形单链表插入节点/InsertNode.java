package 程序员面试指南.链表问题.有序环形单链表插入节点;

/**
 * Created by 杨杰 on 2018/4/4.
 */
public class InsertNode {
    public static class Node {
        public int value;
        public Node next;

        public Node(int data) {
            this.value = data;
        }
    }

    public static Node insertNum(Node head, int num) {
        Node newNode = new Node(num);
        if (head == null) {
            newNode.next = newNode;
            return newNode;
        }
        Node cur = head.next;
//        if (cur == head) {
//            newNode.next = cur;
//            cur.next = newNode;
//            if (num < cur.value) {
//                return newNode;
//            } else {
//                return cur;
//            }
//        }
        Node pre = head;
        while (cur != head) {
            if (num > pre.value && num <= cur.value) {
                break;
            } else {
                pre = cur;
                cur = cur.next;
            }
        }
        /**
         * 原来写的代码
         */
//        if (num > pre.value && num <= cur.value) {
//            pre.next = newNode;
//            newNode.next = cur;
//            return head;
//        } else {
//            pre.next = newNode;
//            newNode.next = cur;
//            if (num < head.value) {
//                return newNode;
//            } else {
//                return head;
//            }
//        }
        /**
         * 修改简化
         */
        pre.next = newNode;
        newNode.next = cur;
        return num < head.value ? newNode : head;
    }


    /**
     * 测试代码
     */
    public static void printCircularList(Node head) {
        if (head == null) {
            return;
        }
        System.out.print("Circular List: " + head.value + " ");
        Node cur = head.next;
        while (cur != head) {
            System.out.print(cur.value + " ");
            cur = cur.next;
        }
        System.out.println("-> " + head.value);
    }

    public static void main(String[] args) {
        Node head = null;
        head = insertNum(head, 2);
        printCircularList(head);
        head = insertNum(head, 1);
        printCircularList(head);
        head = insertNum(head, 4);
        printCircularList(head);
        head = insertNum(head, 3);
        printCircularList(head);
        head = insertNum(head, 5);
        printCircularList(head);
        head = insertNum(head, 0);
        printCircularList(head);

    }

    public static Node insertNum2(Node head, int num) {
        Node node = new Node(num);
        if (head == null) {
            node.next = node;
            return node;
        }
        Node pre = head;
        Node cur = head.next;
        while (cur != head) {
            if (pre.value <= num && cur.value >= num) {
                break;
            }
            pre = cur;
            cur = cur.next;
        }
        pre.next = node;
        node.next = cur;
        return head.value < num ? head : node;
    }
}
