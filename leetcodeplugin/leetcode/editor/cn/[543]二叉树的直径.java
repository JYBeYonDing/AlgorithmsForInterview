
//leetcode submit region begin(Prohibit modification and deletion)
/**
 * Definition for a binary tree node. public class TreeNode { int val; TreeNode left; TreeNode right; TreeNode() {}
 * TreeNode(int val) { this.val = val; } TreeNode(int val, TreeNode left, TreeNode right) { this.val = val; this.left =
 * left; this.right = right; } }
 */
class Solution {
    int res;

    public int diameterOfBinaryTree(TreeNode root) {
        maxDepth(root);
        return res;
    }

    public int maxDepth(TreeNode root) {
        if (root == null) {
            return 0;
        }
        int leftDepth = maxDepth(root.left);
        int rightDepth = maxDepth(root.right);
        res = Math.max(res, leftDepth + rightDepth);
        return Math.max(leftDepth, rightDepth) + 1;
    }
}
//leetcode submit region end(Prohibit modification and deletion)
