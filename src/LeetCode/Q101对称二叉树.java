package LeetCode;

import java.util.LinkedList;
import java.util.Queue;

/**
 * Created by James on 2018/9/2 14:47.
 *
 * 思路1：
 * 将二叉树翻转后，比较两颗二叉树是否相等，比较麻烦！！！
 *
 * 可以直接用递归解决！！！
 *
 *
 */
public class Q101对称二叉树 {

    private class TreeNode {
        int val;
        TreeNode left;
        TreeNode right;

        TreeNode(int x) {
            val = x;
        }
    }


    // 递归
    public boolean isSymmetric(TreeNode root) {

        if (root == null) {
            return true;
        } else {
            return symmetric(root.left, root.right);
        }

    }

    private boolean symmetric(TreeNode left, TreeNode right) {
        if (left == null && right == null) {
            return true;
        } else if (left == null || right == null) {
            return false;
        } else {
            return left.val == right.val && symmetric(left.left, right.right) && symmetric(left.right, right.left);
        }

    }




    // 迭代 注意！！！：LinkedList中可以插入null
    public boolean isSymmetric2(TreeNode root) {

        if (root == null) {
            return true;
        } else {

            Queue<TreeNode> queue1 = new LinkedList<>();
            Queue<TreeNode> queue2 = new LinkedList<>();

            queue1.offer(root.left);
            queue2.offer(root.right);

            TreeNode temp1;
            TreeNode temp2;
            while (!queue1.isEmpty() && !queue2.isEmpty()) {
                temp1 = queue1.poll();
                temp2 = queue2.poll();

                if (temp1 == null && temp2 == null) {
                    continue;
                }
                if (temp1 == null || temp2 == null || temp1.val != temp2.val) {
                    return false;
                } else {
                    queue1.offer(temp1.left);
                    queue1.offer(temp1.right);
                    queue2.offer(temp2.right);
                    queue2.offer(temp2.left);
                }
            }
            if (queue1.isEmpty() && queue2.isEmpty()) {
                return true;
            } else {
                return false;
            }

        }

    }

    public static void main(String[] args) {
        Queue<TreeNode> queue1 = new LinkedList<>();
        queue1.offer(null);
        queue1.offer(null);
        queue1.offer(null);
        System.out.println(queue1.size());
        System.out.println(queue1.isEmpty());
    }

}
