
//leetcode submit region begin(Prohibit modification and deletion)

import java.util.ArrayDeque;

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
    public int minDepth(TreeNode root) {
        ArrayDeque<TreeNode> queue = new ArrayDeque<TreeNode>();
        if (root == null) {
            return 0;
        }
        queue.offer(root);
        int res = 0;
        while (!queue.isEmpty()) {
            int size = queue.size();
            res++;

            for (int i = 0; i < size; i++) {
                TreeNode poll = queue.poll();
                if (poll.left == null && poll.right == null) {
                    return res;
                }
                if (poll.left != null) {
                    queue.offer(poll.left);
                }
                if (poll.right != null) {
                    queue.offer(poll.right);
                }
            }
        }
        return 0;
    }
}
//leetcode submit region end(Prohibit modification and deletion)
