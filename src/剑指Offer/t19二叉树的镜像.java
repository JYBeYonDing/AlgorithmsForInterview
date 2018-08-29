package 剑指Offer;

import java.util.ArrayDeque;

/**
 * Created by James on 2018/8/28 15:19.
 */
public class t19二叉树的镜像 {
    public static void main(String[] args) {

    }

    public void Mirror(TreeNode root) {
        ArrayDeque<TreeNode> treeStack = new ArrayDeque<>();
        TreeNode temp = root;
        if (root != null) {
            treeStack.push(root);
            while (!treeStack.isEmpty()) {
                temp = treeStack.pop();
                if (temp.left != null) {
                    treeStack.push(temp.left);
                }
                if (temp.right != null) {
                    treeStack.push(temp.right);
                }
                TreeNode switTemp = temp.left;
                temp.left = temp.right;
                temp.right = switTemp;
            }
        }
    }

    private void mirrorRecursively(TreeNode root) {
        if (root != null) {
            TreeNode temp = root.left;
            root.left = root.right;
            root.right = temp;
            mirrorRecursively(root.left);
            mirrorRecursively(root.right);
        }
    }
}
