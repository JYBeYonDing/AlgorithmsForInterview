package LeetCode;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.LinkedList;
import java.util.Queue;

/**
 * Created by James on 2018/9/1 14:45.
 */
public class Q337打家劫舍3在二叉树结构中取非相邻元素求和取最大 {

    static class TreeNode {
        int val;
        TreeNode left;
        TreeNode right;

        TreeNode(int x) {
            val = x;
        }
    }


    public int rob(TreeNode root) {
        if (root == null) {
            return 0;
        }

        int takeThis = root.val;// 加上左右孩子的左右孩子的和
        if (root.left != null) {
            takeThis += rob(root.left.left) + rob(root.left.right);
        }
        if (root.right != null) {
            takeThis += rob(root.right.left) + rob(root.right.right);
        }

        int notTakeThis = rob(root.left) + rob(root.right);// 左右孩子的和


        return Math.max(takeThis, notTakeThis);
    }

    public static void main(String[] args) {
        Q337打家劫舍3在二叉树结构中取非相邻元素求和取最大 dajia = new Q337打家劫舍3在二叉树结构中取非相邻元素求和取最大();

        TreeNode root = new TreeNode(3);
        root.left = new TreeNode(2);
        root.right = new TreeNode(3);
        root.left.left = new TreeNode(3);
        root.right.right = new TreeNode(1);

        System.out.println(dajia.rob(root));
    }


    //**************************************************************
    // 牛逼的优化

    public int rob2(TreeNode root) {
        return dfs(root)[1];
    }

    private int[] dfs(TreeNode root) {
        int res[] = {0, 0}; // 0 表示不娶当前层 1表示取当前层
        if (root != null) {
            int[] left = dfs(root.left);
            int[] right = dfs(root.right);
            res[0] = left[1] + right[1];
            res[1] = Math.max(res[0], root.val + left[0] + right[0]);
        }
        return res;
    }
}
