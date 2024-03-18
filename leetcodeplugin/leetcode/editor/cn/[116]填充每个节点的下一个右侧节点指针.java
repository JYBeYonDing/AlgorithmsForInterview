
//leetcode submit region begin(Prohibit modification and deletion)
/*
// Definition for a Node.
class Node {
    public int val;
    public Node left;
    public Node right;
    public Node next;

    public Node() {}
    
    public Node(int _val) {
        val = _val;
    }

    public Node(int _val, Node _left, Node _right, Node _next) {
        val = _val;
        left = _left;
        right = _right;
        next = _next;
    }
};
*/

class Solution {

    public Node connect(Node root) {
        if (root == null) {
            return null;
        }
        traverse(root.left, root.right);
        return root;
    }

    public void traverse(Node left, Node right) {
        if (left == null) {
            return;
        }
        left.next = right;
        Node leftLeft = left.left;
        Node leftRight = left.right;
        traverse(leftLeft, leftRight);
        if (right != null) {
            Node rightLeft = right.left;
            Node rightRight = right.right;
            traverse(leftRight, rightLeft);
            traverse(rightLeft, rightRight);
        }

    }
}
//leetcode submit region end(Prohibit modification and deletion)
