
//leetcode submit region begin(Prohibit modification and deletion)

import java.util.HashMap;

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
    HashMap<Integer, Integer> map = new HashMap<>();
    public TreeNode buildTree(int[] preorder, int[] inorder) {
        for (int i = 0; i < inorder.length; i++) {
            map.put(inorder[i], i);
        }
        return buildTree(preorder, 0, preorder.length - 1, inorder, 0, inorder.length - 1);
    }

    public TreeNode buildTree(int[] preorder, int preStart, int preEnd, int[] inorder, int inoStart, int inoEnd) {
        if (preStart > preEnd) {
            return null;
        }
        int val = preorder[preStart];
        TreeNode node = new TreeNode(val);
        Integer idx = map.get(val);
        Integer leftLen = idx - inoStart;
        node.left = buildTree(preorder, preStart + 1, preStart + leftLen, inorder, inoStart, idx - 1);
        node.right = buildTree(preorder, preStart + leftLen + 1, preEnd, inorder, idx + 1, inoEnd);
        return node;
    }
}
//leetcode submit region end(Prohibit modification and deletion)
