package 练习;

/**
 * Created by 杨杰 on 2018/5/14 20:19.
 */
public class Morris遍历 {
    public static class Node {
        Node left;
        Node right;
        int value;

        public Node(int value) {
            this.value = value;
        }
    }

    public static void morrisIn(Node head) {
        if (head == null) {
            return;
        }
        Node cur = head;
        while (cur != null) {
            Node mostRight = cur.left;
            if (mostRight != null) {
                //有左子树，找到左子树上的最右节点
                while (mostRight.right != null && mostRight.right != cur) {
                    mostRight = mostRight.right;
                }
                if (mostRight.right == null) {
                    mostRight.right = cur;
                    cur = cur.left;
                } else {
                    //第二次到达cur
                    System.out.println(cur.value);
                    mostRight.right = null;
                    cur = cur.right;
                }

            } else {
                System.out.println(cur.value);
                cur = cur.right;
            }
        }
    }
    public static void main(String[] args) {
        Node head = new Node(1);
        head.left = new Node(2);
        head.right = new Node(3);
        head.left.left = new Node(4);
        head.right.left = new Node(5);
        head.right.right = new Node(6);
        morrisIn(head);
    }
}
