package 剑指Offer;

/**
 * Created by James on 2018/8/27 23:37.
 *
 * 分两步进行
 */
public class t18树的子结构 {

    // root1中是否有root2
    public boolean HasSubtree(TreeNode root1,TreeNode root2) {
        boolean result = false;

        if (root1 != null && root2 != null) {
            if (root1.val == root2.val) {
                result = doesTree1HaveTree2(root1, root2);// 判断是否完全匹配
            }
            if (!result) {// 判断树1中的左子树是否有树2
                result = HasSubtree(root1.left, root2);
            }
            if (!result) {// 判断树1中的右子树是否有树2
                result = HasSubtree(root1.right, root2);
            }
        }
        return result;
    }

    private boolean doesTree1HaveTree2(TreeNode root1, TreeNode root2) {
        if (root2 == null) {
            return true;
        }
        if (root1 == null) {
            return false;
        }
        if (root1.val != root2.val) {
            return false;
        }

        return doesTree1HaveTree2(root1.left, root2.left)
                && doesTree1HaveTree2(root1.right, root2.right);
    }




    class TreeNode {
        int val = 0;
        TreeNode left = null;
        TreeNode right = null;

        public TreeNode(int val) {
            this.val = val;

        }

    }

}
