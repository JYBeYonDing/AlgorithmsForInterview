
//leetcode submit region begin(Prohibit modification and deletion)

import java.util.HashMap;

/**
 * Definition for a binary tree node. public class TreeNode { int val; TreeNode left; TreeNode right; TreeNode() {}
 * TreeNode(int val) { this.val = val; } TreeNode(int val, TreeNode left, TreeNode right) { this.val = val; this.left =
 * left; this.right = right; } }
 */
class Solution {
    HashMap<Integer, Integer> map = new HashMap<>();

    public TreeNode constructFromPrePost(int[] preorder, int[] postorder) {
        for (int i = 0; i < postorder.length; i++) {
            map.put(postorder[i], i);
        }

        return constructFromPrePost(preorder, 0, preorder.length - 1, postorder, 0, postorder.length - 1);
    }

    public TreeNode constructFromPrePost(int[] preorder, int preStart, int preEnd, int[] postorder, int posStart,
        int posEnd) {
        if (preStart > preEnd) {
            return null;
        }
        if (preStart == preEnd) {
            return new TreeNode(preorder[preStart]);
        }
        int val = preorder[preStart];
        TreeNode root = new TreeNode(val);
        int leftVal = preorder[preStart + 1];
        int leftIdx = map.get(leftVal);
        int leftLen = leftIdx - posStart + 1;
        root.left = constructFromPrePost(preorder, preStart + 1, preStart + leftLen, postorder, posStart, leftIdx - 1);
        root.right = constructFromPrePost(preorder, preStart + leftLen + 1, preEnd, postorder, leftIdx + 1, posEnd - 1);
        return root;
    }
}
//leetcode submit region end(Prohibit modification and deletion)
