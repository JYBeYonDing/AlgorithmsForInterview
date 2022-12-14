package 程序员面试指南.链表问题.搜索二叉树转换成双向链表;

import java.util.ArrayDeque;
import java.util.ArrayList;

public class DoubleLink {
    public static class Node {
        public int value;
        public Node left;
        public Node right;

        public Node(int data) {
            this.value = data;
        }
    }

    /**
     * 使用队列 空间复杂度为O(N)
     *
     * @param head
     * @return
     */
    public static Node convert1(Node head) {
        if (head == null) {
            return head;
        }
        ArrayList<Node> nodes = new ArrayList<>();
        inOrderToList(nodes, head);
        Node pre = nodes.get(0);
        for (int i = 1; i < nodes.size(); i++) {
            Node cur = nodes.get(i);
            pre.right = cur;
            cur.left = pre;
            pre = cur;
        }
        return nodes.get(0);
    }

    private static void inOrderToList(ArrayList<Node> nodes, Node head) {
        if (head.left != null) {
            inOrderToList(nodes, head.left);
        }
        nodes.add(head);
        if (head.right != null) {
            inOrderToList(nodes, head.right);
        }
    }


    /**
     * 只用递归，空间复杂度为O（h）h为树的高度
     *
     * @param head
     * @return
     */
    public static Node convert2(Node head) {
        if (head == null) {
            return head;
        }
        Node last = tree2Link(head);
        Node newHead = last.right;
        last.right = null;
        return newHead;
    }

    private static Node tree2Link(Node head) {
        if (head == null) {
            return null;
        }
        Node leftLast = tree2Link(head.left);
        Node rightLast = tree2Link(head.right);

        if (leftLast == null && rightLast == null) {
            head.right = head;
            return head;
        } else if (leftLast == null) {
            head.right = rightLast.right;
            head.right.left = head;
            rightLast.right = head;
            return rightLast;
        } else if (rightLast == null) {
            head.right = leftLast.right;
            head.left = leftLast;
            leftLast.right = head;
            return head;
        } else {
            head.right = rightLast.right;
            head.right.left = head;
            rightLast.right = leftLast.right;
            leftLast.right = head;
            head.left = leftLast;
            return rightLast;
        }

    }


    /**
     * 测试代码
     */

    public static void printBSTInOrder(Node head) {
        System.out.print("BST in-order: ");
        if (head != null) {
            inOrderPrint(head);
        }
        System.out.println();
    }

    public static void inOrderPrint(Node head) {
        if (head == null) {
            return;
        }
        inOrderPrint(head.left);
        System.out.print(head.value + " ");
        inOrderPrint(head.right);
    }

    public static void printDoubleLinkedList(Node head) {
        System.out.print("Double Linked List: ");
        Node end = null;
        while (head != null) {
            System.out.print(head.value + " ");
            end = head;
            head = head.right;
        }
        System.out.print("| ");
        while (end != null) {
            System.out.print(end.value + " ");
            end = end.left;
        }
        System.out.println();
    }

    public static void main(String[] args) {
        Node head = new Node(5);
        head.left = new Node(2);
        head.right = new Node(9);
        head.left.left = new Node(1);
        head.left.right = new Node(3);
        head.left.right.right = new Node(4);
        head.right.left = new Node(7);
        head.right.right = new Node(10);
        head.right.left.left = new Node(6);
        head.right.left.right = new Node(8);

        printBSTInOrder(head);
        head = convert1(head);
        printDoubleLinkedList(head);

        head = new Node(5);
        head.left = new Node(2);
        head.right = new Node(9);
        head.left.left = new Node(1);
        head.left.right = new Node(3);
        head.left.right.right = new Node(4);
        head.right.left = new Node(7);
        head.right.right = new Node(10);
        head.left.left = new Node(1);
        head.right.left.left = new Node(6);
        head.right.left.right = new Node(8);

        printBSTInOrder(head);
        head = convert2(head);
        printDoubleLinkedList(head);

    }


    /**
     * @param head
     * @return
     */

    public static Node convert22(Node head) {
        if (head == null) {
            return null;
        }
        Node last = process(head);
        head = last.right;
        last.right = null;
        return head;
    }

    public static Node process(Node head) {
        if (head == null) {
            return null;
        }
        Node leftE = process(head.left); // left end
        Node rightE = process(head.right); // right end
        Node leftS = leftE != null ? leftE.right : null; // left start
        Node rightS = rightE != null ? rightE.right : null; // right start
        if (leftE != null && rightE != null) {
            leftE.right = head;
            head.left = leftE;
            head.right = rightS;
            rightS.left = head;
            rightE.right = leftS;
            return rightE;
        } else if (leftE != null) {
            leftE.right = head;
            head.left = leftE;
            head.right = leftS;
            return head;
        } else if (rightE != null) {
            head.right = rightS;
            rightS.left = head;
            rightE.right = head;
            return rightE;
        } else {
            head.right = head;
            return head;
        }
    }
}
