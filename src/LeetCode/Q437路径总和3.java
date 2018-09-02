package LeetCode;

/**
 * Created by James on 2018/9/2 19:43.
 */
public class Q437路径总和3 {

    class TreeNode {
        int val;
        TreeNode left;
        TreeNode right;

        TreeNode(int x) {
            val = x;
        }
    }


    public int pathSum(TreeNode root, int sum) {

        if (root == null) {
            return 0;
        }

        int res = findPath(root, sum);
        res += pathSum(root.left, sum);
        res += pathSum(root.right, sum);
        return res;

    }

    /**
     * 以node开始的和为sum的路径个数
     *
     */
    private int findPath(TreeNode node, int sum) {
        if (node == null) {
            return 0;
        }
        int res = 0;


        if (node.val == sum) {
            res += 1;
        }

        res += findPath(node.left, sum - node.val);
        res += findPath(node.right, sum - node.val);

        return res;

    }
}
