package 剑指Offer;

import java.util.ArrayDeque;
import java.util.ArrayList;
import java.util.Queue;

/**
 * Created by 杨杰 on 2018/6/13 12:04.
 * 从上到下按层打印二叉树，同一层结点从左至右输出。每一层输出一行。
 */
public class t61把二叉树打印成多行 {
    private static ArrayList<ArrayList<Integer>> Print(TreeNode pRoot) {
        ArrayList<ArrayList<Integer>> result = new ArrayList<>();
        if (pRoot == null) {
            return result;
        }
        Queue<TreeNode> queue1 = new ArrayDeque<>();
        Queue<TreeNode> queue2 = new ArrayDeque<>();
        queue1.add(pRoot);
        while (queue1.size() != 0 || queue2.size() != 0) {
            if (queue1.size() != 0) {
                ArrayList<Integer> temp = new ArrayList<>();
                while (queue1.size() != 0) {
                    TreeNode node = queue1.poll();
                    temp.add(node.val);
                    if (node.left != null) {
                        queue2.add(node.left);
                    }
                    if (node.right != null) {
                        queue2.add(node.right);
                    }
                }
                result.add(temp);
                Queue<TreeNode> t = queue1;
                queue1 = queue2;
                queue2 = t;
            }
        }
        return result;
    }


    public static void main(String[] args) {
        TreeNode root = new TreeNode(1);
        root.left = new TreeNode(2);
        root.right = new TreeNode(3);
        root.left.left = new TreeNode(4);
        root.left.right = new TreeNode(5);
        root.right.left = new TreeNode(6);
        ArrayList<ArrayList<Integer>> result = Print(root);
        for (ArrayList<Integer> arrayList : result) {
            for (Integer integer : arrayList) {
                System.out.print(integer+" ");
            }
            System.out.println();
        }
    }
}
