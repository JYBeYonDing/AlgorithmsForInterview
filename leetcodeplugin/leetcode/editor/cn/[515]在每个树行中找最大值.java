
//leetcode submit region begin(Prohibit modification and deletion)

import java.util.ArrayList;
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
    List<Integer> res = new ArrayList<>();
    public List<Integer> largestValues(TreeNode root) {
        levelTraverse(root);
        return res;
    }

    public void levelTraverse(TreeNode root) {
        ArrayDeque<TreeNode> queue = new ArrayDeque<TreeNode>();
        if (root != null) {
            queue.offer(root);
        }
        while (!queue.isEmpty()) {
            int size = queue.size();
            int maxValue = Integer.MIN_VALUE;
            for (int i = 0; i < size; i++) {
                TreeNode poll = queue.poll();
                maxValue = Math.max(maxValue, poll.val);
                if (poll.left != null) {
                    queue.offer(poll.left);
                }
                if (poll.right != null) {
                    queue.offer(poll.right);
                }
            }
            res.add(maxValue);
        }
    }
}
//leetcode submit region end(Prohibit modification and deletion)
