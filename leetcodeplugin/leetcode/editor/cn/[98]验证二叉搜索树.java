
//leetcode submit region begin(Prohibit modification and deletion)
/**
 * Definition for a binary tree node. public class TreeNode { int val; TreeNode left; TreeNode right; TreeNode() {}
 * TreeNode(int val) { this.val = val; } TreeNode(int val, TreeNode left, TreeNode right) { this.val = val; this.left =
 * left; this.right = right; } }
 */
class Solution {
    public boolean isValidBST(TreeNode root) {
        return isValidBST(root, null, null);
    }

    /**
     * 判断这颗是否满足
     *
     * @param root
     * @param min
     * @param max
     * @return
     */
    public boolean isValidBST(TreeNode root, TreeNode min, TreeNode max) {
        if (root == null) {
            return true;
        }
        if (min != null) {
            if (min.val >= root.val) {
                return false;
            }
        }
        if (max != null) {
            if (max.val <= root.val) {
                return false;
            }
        }

        return isValidBST(root.left, min, root) && isValidBST(root.right, root, max);
    }
}
//leetcode submit region end(Prohibit modification and deletion)
