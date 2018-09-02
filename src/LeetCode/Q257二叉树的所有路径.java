package LeetCode;

import java.util.ArrayList;
import java.util.LinkedList;
import java.util.List;

/**
 * Created by James on 2018/9/2 17:42.
 */
public class Q257二叉树的所有路径 {

    private class TreeNode {
        int val;
        TreeNode left;
        TreeNode right;

        TreeNode(int x) {
            val = x;
        }
    }



    public List<String> binaryTreePaths(TreeNode root) {


        List<String> list = new ArrayList<>();
        if (root == null) {
            return list;
        }

        if (root.left == null && root.right == null) {
            list.add(root.val + "");
            return list;
        }

        List<String> leftS = binaryTreePaths(root.left);
        for (String s : leftS) {
            list.add(root.val + "->" + s);
        }
        List<String> rightS = binaryTreePaths(root.right);
        for (String s : rightS) {
            list.add(root.val + "->" + s);
        }
        return list;
    }

}
