package 练习;

import java.util.ArrayDeque;

/**
 * Created by 杨杰 on 2018/4/20 8:06.
 */
public class 二叉树遍历 {
    public static class Node {
        public int value;
        public Node left;
        public Node right;

        public Node(int data) {
            this.value = data;
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

        // unrecursive
        System.out.println("============unrecursive=============");
        preOrderUnRecur1(head);
        inOrderUnRecur(head);
        posOrderUnRecur1(head);
        posOrderUnRecur2(head);
        posOrderUnRecur3(head);


    }

    private static void posOrderUnRecur3(Node head) {
        if (head == null) {
            return;
        }
        ArrayDeque<Node> stack = new ArrayDeque<>();
        stack.push(head);
        Node c = null;
        while (!stack.isEmpty()) {
            c = stack.peek();
            if (c.left != null && head!=c.left && head!=c.right) {
                stack.push(c.left);
            } else if (c.right != null && head != c.right) {
                stack.push(c.right);
            } else {
                System.out.print(stack.pop().value+" ");
                head = c;
            }
        }
        System.out.println();
    }

    /**
     * 按照逻辑思路写的后续遍历代码，判断太复杂，不美观
     * @param head
     */
    private static void posOrderUnRecur2(Node head) {
        if (head == null) {
            return;
        }
        ArrayDeque<Node> stack = new ArrayDeque<>();
        stack.push(head);
        Node cur = null;
        while (!stack.isEmpty()) {
            cur = stack.peek();
            if (       (cur.left == null && cur.right == null )
                    || (cur.left != null && cur.right == null && head == cur.left)
                    || (cur.right != null && head == cur.right)) {
                stack.pop();
                System.out.print(cur.value+" ");
                head = cur;
            } else if (cur.right != null) {
                stack.push(cur.right);
                if (cur.left != null) {
                    stack.push(cur.left);
                }
            } else {
                stack.push(cur.left);
            }

        }
        System.out.println();
    }

    private static void posOrderUnRecur1(Node head) {
        if (head == null) {
            return;
        }
        ArrayDeque<Node> stack = new ArrayDeque<>();
        ArrayDeque<Node> printStack = new ArrayDeque<>();
        while (!stack.isEmpty() || head != null) {
            while (head != null) {
                printStack.push(head);
                stack.push(head);
                head = head.right;
            }
            if (!stack.isEmpty()) {
                head = stack.pop().left;
            }
        }
        while (!printStack.isEmpty()) {
            System.out.print(printStack.pop().value+" ");
        }
        System.out.println();
    }

    private static void inOrderUnRecur(Node head) {
        if (head == null) {
            return;
        }
        ArrayDeque<Node> stack = new ArrayDeque<>();
        while (!stack.isEmpty() || head != null) {
            while (head != null) {
                stack.push(head);
                head = head.left;
            }
            if (!stack.isEmpty()) {
                Node cur = stack.pop();
                System.out.print(cur.value+" ");
                head = cur.right;
            }
        }
        System.out.println();
    }

    private static void preOrderUnRecur(Node head) {
        if (head == null) {
            return;
        }
        ArrayDeque<Node> stack = new ArrayDeque<>();
        stack.push(head);
        Node cur = null;
        while (!stack.isEmpty()) {
            cur = stack.pop();
            System.out.print(cur.value);
            if (cur.right != null) {
                stack.push(cur.right);
            }
            if (cur.left != null) {
                stack.push(cur.left);
            }
        }
        System.out.println();
    }

    private static void preOrderUnRecur1(Node head) {
        if (head == null) {
            return;
        }
        ArrayDeque<Node> stack = new ArrayDeque<>();
        while (!stack.isEmpty() || head != null) {
            while (head != null) {
                System.out.print(head.value + " ");
                stack.push(head);
                head = head.left;
            }
            if (!stack.isEmpty()) {
                head = stack.pop().right;
            }
        }
        System.out.println();
    }
}
