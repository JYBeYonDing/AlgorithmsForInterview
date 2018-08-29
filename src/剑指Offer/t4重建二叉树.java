package 剑指Offer;

import java.util.Arrays;

/**
 * Created by James on 2018/8/27 10:44.
 * <p>
 * 输入某二叉树的前序遍历和中序遍历的结果，请重建出该二叉树。假设输入的前序遍历和中序遍历的结果中都不含重复的数字。
 * 例如输入前序遍历序列{1,2,4,7,3,5,6,8}和中序遍历序列{4,7,2,1,5,3,8,6}，则重建二叉树并返回。
 */
public class t4重建二叉树 {
    public static void main(String[] args) {
        reConstructBinaryTree(new int[]{1, 2, 4, 7, 3, 5, 6, 8}, new int[]{4, 7, 2, 1, 5, 3, 8, 6});
    }
    public static TreeNode reConstructBinaryTree(int [] pre,int [] in) {
        if (pre == null || pre.length == 0) {
            return null;
        }
        int preStart = 0;
        int preEnd = pre.length - 1;
        int inStart = 0;
        int inEnd = in.length - 1;
        return reConstructBinaryTreeRec(pre, in, preStart, preEnd, inStart, inEnd);
    }

    private static TreeNode reConstructBinaryTreeRec(int[] pre, int[] in, int preStart, int preEnd, int inStart, int inEnd) {
        if (preStart > preEnd || inStart > inEnd) {
            return null;
        }
        int rootValue = pre[preStart];
        TreeNode tempRoot = new TreeNode(rootValue);
        int inIndex = find(in, inStart,rootValue);
        int leftLen = inIndex - inStart;
        int leftPreStart = preStart + 1;
        int leftPreEnd = preStart + leftLen;
        int leftInEnd = inIndex - 1;
        tempRoot.left = reConstructBinaryTreeRec(pre, in, leftPreStart, leftPreEnd, inStart, leftInEnd);
        int rightPreStart = leftPreEnd + 1;
        int rightInStart = inIndex + 1;
        tempRoot.right = reConstructBinaryTreeRec(pre, in, rightPreStart, preEnd, rightInStart, inEnd);
        return tempRoot;
    }

    private static int find(int[] in, int inStart, int rootValue) {
        for (int i = inStart; i < in.length; i++) {
            if (in[i] == rootValue) {
                return i;
            }
        }
        return -1;
    }


    private static class TreeNode {
        int val;
        TreeNode left;
        TreeNode right;

        TreeNode(int x) {
            val = x;
        }
    }

}
