
//leetcode submit region begin(Prohibit modification and deletion)

/**
 * Definition for a binary tree node.
 * public class TreeNode {
 * int val;
 * TreeNode left;
 * TreeNode right;
 * TreeNode() {}
 * TreeNode(int val) { this.val = val; }
 * TreeNode(int val, TreeNode left, TreeNode right) {
 * this.val = val;
 * this.left = left;
 * this.right = right;
 * }
 * }
 */
class Solution {
    int res = 0;
    int depth = 0;
    public int maxDepth(TreeNode root) {
//        traverse(root);
//        return res;
        if (root == null) {
            return 0;
        }
        int leftDepth = maxDepth(root.left);
        int rightDepth = maxDepth(root.right);

        return Math.max(leftDepth, rightDepth) + 1;
    }


    public void traverse(TreeNode root) {
        if (root == null) {
            return;
        }
        depth++;
        res = Math.max(depth, res);
        if (root.left != null) {
            traverse(root.left);
        }
        if (root.right != null) {
            traverse(root.right);
        }
        depth--;
    }
}
//leetcode submit region end(Prohibit modification and deletion)
