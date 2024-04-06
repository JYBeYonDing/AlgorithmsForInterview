
//leetcode submit region begin(Prohibit modification and deletion)

import java.util.HashMap;

/**
 * Definition for a binary tree node. public class TreeNode { int val; TreeNode left; TreeNode right; TreeNode() {}
 * TreeNode(int val) { this.val = val; } TreeNode(int val, TreeNode left, TreeNode right) { this.val = val; this.left =
 * left; this.right = right; } }
 */
class Solution {
    HashMap<Integer, Integer> map = new HashMap<>();

    public TreeNode buildTree(int[] inorder, int[] postorder) {
        for (int i = 0; i < inorder.length; i++) {
            map.put(inorder[i], i);
        }
        return buildTree(inorder, 0, inorder.length - 1, postorder, 0, postorder.length - 1);
    }

    public TreeNode buildTree(int[] inorder, int inoStart, int inoEnd, int[] postorder, int posStart, int posEnd) {
        if (posStart > posEnd) {
            return null;
        }
        int val = postorder[posEnd];
        int idx = map.get(val);
        int leftLen = idx - inoStart;
        TreeNode node = new TreeNode(val);
        node.left = buildTree(inorder, inoStart, idx - 1, postorder, posStart, posStart + leftLen - 1);
        node.right = buildTree(inorder, idx + 1, inoEnd, postorder, posStart + leftLen, posEnd - 1);
        return node;
    }
}
//leetcode submit region end(Prohibit modification and deletion)
