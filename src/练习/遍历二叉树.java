package 练习;

import java.util.ArrayDeque;

/**
 * Created by 杨杰 on 2018/6/28 22:13.
 */
public class 遍历二叉树 {

    private static class Node{
        int value;
        Node left;
        Node right;

        public Node(int value) {
            this.value = value;
        }
    }

    public static void main(String[] args) {
        Node head = new Node(5);
        head.left = new Node(3);
        head.right = new Node(8);
        head.left.left = new Node(2);
        head.left.right = new Node(4);
        head.left.left.left = new Node(1);
        head.right.left = new Node(7);
        head.right.left.left = new Node(6);
        head.right.right = new Node(10);
        head.right.right.left = new Node(9);
        head.right.right.right = new Node(11);

        // recursive
        System.out.println("==============recursive==============");
        preRec(head);
        System.out.println();
        // unrecursive
        System.out.println("============unrecursive=============");
        preOrder(head);
        System.out.println();
        inOrder(head);
        System.out.println();
    }

    static void preOrder(Node head) {
        ArrayDeque<Node> stack = new ArrayDeque<>();
        stack.push(head);
        while (!stack.isEmpty()) {
            Node cur = stack.pop();
            System.out.print(cur.value + " ");
            if (cur.right != null) {
                stack.push(cur.right);
            }
            if (cur.left != null) {
                stack.push(cur.left);
            }
        }
    }
    static void inOrder(Node head) {
        ArrayDeque<Node> stack = new ArrayDeque<>();
        if (head == null) {
            return;
        }
        while (!stack.isEmpty() || head != null) {
            if (head != null) {
                stack.push(head);
                head = head.left;
            } else {
                Node cur = stack.pop();
                System.out.print(cur.value + " ");
                head = cur.right;
            }
        }
    }

    static void preRec(Node head) {
        if (head == null) {
            return;
        }
        System.out.print(head.value +" ");
        preRec(head.left);
        preRec(head.right);
    }
    static void inRec(Node head) {
        if (head == null) {
            return;
        }
        System.out.print(head.value +" ");
        inRec(head.left);
        inRec(head.right);
    }
}
