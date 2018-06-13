package 剑指Offer;

import java.util.ArrayDeque;
import java.util.Queue;

/**
 * Created by 杨杰 on 2018/6/13 12:21.
 * 请实现两个函数，分别用来序列化和反序列化二叉树
 */
public class t62序列化二叉树 {
    private static String Serialize(TreeNode root) {
        if (root == null) {
            return "!#";
        }
        StringBuilder sb = new StringBuilder();
        serializeRec(root, sb);
        return sb.toString();
    }

    private static void serializeRec(TreeNode root, StringBuilder sb) {
        if (root == null) {
            sb.append("!#");
            return;
        }
        sb.append("!" + root.val);
        serializeRec(root.left, sb);
        serializeRec(root.right, sb);
    }

    private static TreeNode Deserialize(String str) {
        if (str.equals("!#")) {
            return null;
        }
        Queue<String> queue = new ArrayDeque<>();
        String[] strs = str.split("!");
        for(int i=1;i<strs.length;i++) {
            queue.add(strs[i]);
        }
        TreeNode root = deserializeRec(strs,queue);
        return root;
    }

    private static TreeNode deserializeRec(String[] strs, Queue<String> queue) {
        String temp = queue.poll();
        if (temp.equals("#")) {
            return null;
        }
        TreeNode root = new TreeNode(Integer.parseInt(temp));
        root.left = deserializeRec(strs, queue);
        root.right = deserializeRec(strs, queue);
        return root;
    }

    public static void main(String[] args) {
        TreeNode root = new TreeNode(1);
        root.left = new TreeNode(2);
        root.right = new TreeNode(3);
        root.left.left = new TreeNode(4);
        root.left.right = new TreeNode(5);
        root.right.left = new TreeNode(6);
        String string = Serialize(root);
        System.out.println(string);
        TreeNode treeNode = Deserialize(string);
        String string2 = Serialize(treeNode);
        System.out.println(string2);
    }
}
