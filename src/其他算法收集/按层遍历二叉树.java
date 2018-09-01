package 其他算法收集;

import Java数据结构和算法.二叉树.Tree;

import java.util.LinkedList;
import java.util.Queue;

/**
 * Created by James on 2018/9/1 15:33.
 */
public class 按层遍历二叉树 {

    static class TreeNode {
        int val;
        TreeNode left;
        TreeNode right;

        TreeNode(int x) {
            val = x;
        }
    }

    public static void main(String[] args) {

        TreeNode root = new TreeNode(3);//二叉树的根
        root.left = new TreeNode(2);
        root.right = new TreeNode(3);
        root.left.left = new TreeNode(3);
        root.right.right = new TreeNode(1);


        Queue<TreeNode> queue = new LinkedList<TreeNode>();


        TreeNode last = root;
        TreeNode nLast = null;
        TreeNode cur = null;
        queue.offer(root);
        while (!queue.isEmpty()) {
            cur = queue.poll();

            if (cur.left != null) {
                queue.offer(cur.left);
                nLast = cur.left;
            }
            if (cur.right != null) {
                queue.offer(cur.right);
                nLast = cur.right;
            }
            if (cur == last) {// 遍历到一层的结束，将 last 指向 nLast。
                last = nLast;
            }
        }


    }
}
