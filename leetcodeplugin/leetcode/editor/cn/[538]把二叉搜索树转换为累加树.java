
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
    int sum = 0;

    public TreeNode convertBST(TreeNode root) {
        return traverse(root);
    }

    public TreeNode traverse(TreeNode root){
        if (root == null) {
            return null;
        }
        traverse(root.right);
        sum += root.val;
        root.val = sum;
        traverse(root.left);
        return root;
    }
}
//leetcode submit region end(Prohibit modification and deletion)
