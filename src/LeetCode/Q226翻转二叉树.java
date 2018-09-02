package LeetCode;

/**
 * Created by James on 2018/9/2 14:33.
 */
public class Q226翻转二叉树 {

    private class TreeNode {
        int val;
        TreeNode left;
        TreeNode right;

        TreeNode(int x) {
            val = x;
        }
    }





    public TreeNode invertTree(TreeNode root) {

        if (root == null) {
            return root;
        }
        TreeNode temp = root.left;
        root.left = root.right;
        root.right = temp;
        invertTree(root.left);
        invertTree(root.right);

        return root;
    }
}
