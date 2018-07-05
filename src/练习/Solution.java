package 练习;
/**
 * Definition for binary tree
 * public class TreeNode {
 * int val;
 * TreeNode left;
 * TreeNode right;
 * TreeNode(int x) { val = x; }
 * }
 */

import java.util.Arrays;

public class Solution {
    static public TreeNode reConstructBinaryTree(int[] pre, int[] in) {
        if (pre.length < 1 || in.length < 1) {
            return null;
        }
        return build(pre, 0, pre.length - 1, in, 0, in.length - 1);
    }

    static private TreeNode build(int[] pre, int startPre, int endPre, int[] in, int startIn, int endIn) {
        if (startPre > endPre || startIn > endIn) {
            return null;
        }
        TreeNode node = new TreeNode(pre[startPre]);
        int leftLen=0;
        for(int i = 0 ; i<in.length ; i++) {
            if (in[i] == pre[startPre]) {
                leftLen = i - startIn;
                break;
            }
        }
        if (leftLen > 0) {
            node.left = build(pre, startPre + 1, startPre + leftLen, in, startIn, startIn + leftLen - 1);
        }
        if (leftLen <= endPre - startPre+1) {
            node.right = build(pre, startPre + leftLen + 1, endPre, in, startIn + leftLen + 1, endIn);
        }
        return node;
    }

    public static void main(String[] args) {
        int[] pre = {1, 2, 4, 7, 3, 5, 6, 8};
        int[] in = {4, 7, 2, 1, 5, 3, 8, 6};
        reConstructBinaryTree(pre, in);
    }
}

class TreeNode {
    int val;
    TreeNode left;
    TreeNode right;

    TreeNode(int x) {
        val = x;
    }
}