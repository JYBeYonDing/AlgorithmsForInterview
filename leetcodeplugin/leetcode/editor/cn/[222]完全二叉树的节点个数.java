
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
    public int countNodes(TreeNode root) {
        if (root == null) {
            return 0;
        }
        int lh = 0;
        TreeNode l = root;

        while (l != null) {
            l = l.left;
            lh++;
        }
        int rh = 0;
        TreeNode r = root;
        while (r != null) {
            r = r.right;
            rh++;
        }
        if (lh == rh) {
            return (int) Math.pow(2, lh) - 1;
        }else{
            return countNodes(root.left) + countNodes(root.right) + 1;
        }

    }
}
//leetcode submit region end(Prohibit modification and deletion)
