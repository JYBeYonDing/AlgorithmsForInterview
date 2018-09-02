package LeetCode;

/**
 * Created by James on 2018/9/2 15:32.
 */
public class Q222完全二叉树的节点个数 {

    private class TreeNode {
        int val;
        TreeNode left;
        TreeNode right;

        TreeNode(int x) {
            val = x;
        }
    }


    /**
     * 思路：
     * 二分法统计
     * 如果右子树的深度到达整棵树的最大深度则左子树为满二叉树，
     * 如果右子树的深度没有达到整棵树的最大深度，则右子树也是满二叉树，只不过这个满二叉树的层数要小1层
     *
     */
    public int countNodes(TreeNode root) {

        if (root == null) {
            return 0;
        }


        return count(root, 1, depth(root,0));

    }

    /**
     * 统计节点数量
     * @param root 根节点
     * @param cur 当前层
     * @param depth 最大深度
     * @return
     */
    private int count(TreeNode root, int cur, int depth) {

        if (root == null) {
            return 0;
        }
        int rightDepth = depth(root.right, cur);// 右子树的最大深度
        if (rightDepth == depth) {
            // 说明左子树是满二叉树
            return (1 << (depth - cur)) + count(root.right, cur + 1, depth);
        } else {
            return (1 << (rightDepth - cur)) + count(root.left, cur + 1, depth);
        }



    }

    private int depth(TreeNode root, int curLevel) {

        while (root != null) {
            curLevel++;
            root = root.left;
        }
        return curLevel;
    }
}
