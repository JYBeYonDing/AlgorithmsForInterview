
//leetcode submit region begin(Prohibit modification and deletion)
/**
 * Definition for a binary tree node.
 * public class TreeNode {
 *     int val;
 *     TreeNode left;
 *     TreeNode right;
 *     TreeNode() {}
 *     TreeNode(int val) { this.val = val; }
 *     TreeNode(int val, TreeNode left, TreeNode right) {
 *         this.val = val;
 *         this.left = left;
 *         this.right = right;
 *     }
 * }
 */
class Solution {
    int rank = 0;
    int res = 0;
    int kk = 0;

    public int kthSmallest(TreeNode root, int k) {
        kk = k;
        traverse(root);
        return res;
    }

    public void traverse(TreeNode root) {
        if (root == null) {
            return;
        }
        traverse(root.left);
        rank++;
        if (rank == kk) {
            res = root.val;
            return;
        }
        traverse(root.right);
    }
}
//leetcode submit region end(Prohibit modification and deletion)
