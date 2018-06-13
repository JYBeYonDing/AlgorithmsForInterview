package 剑指Offer;

import Java数据结构和算法.二叉树.Tree;
import edu.princeton.cs.algs4.In;

import java.util.ArrayDeque;
import java.util.ArrayList;

/**
 * Created by 杨杰 on 2018/6/2 22:51.
 * 请实现一个函数按照之字形打印二叉树，即第一行按照从左到右的顺序打印，
 * 第二层按照从右至左的顺序打印，第三行按照从左到右的顺序打印，其他行以此类推。
 */
public class t60按之字形顺序打印二叉树 {
    public static ArrayList<ArrayList<Integer>> Print(TreeNode pRoot) {
        ArrayList<ArrayList<Integer>> result = new ArrayList<>();
        if (pRoot == null) {
            return result;
        }
        ArrayDeque<TreeNode> stack1 = new ArrayDeque<>();
        ArrayDeque<TreeNode> stack2 = new ArrayDeque<>();
        stack1.push(pRoot);
        while (stack1.size() != 0 || stack2.size() != 0) {
            if (stack1.size() != 0) {
                ArrayList<Integer> temp = new ArrayList<>();
                while (stack1.size() != 0) {
                    TreeNode node = stack1.pop();
                    temp.add(node.val);
                    if (node.left != null) {
                        stack2.push(node.left);
                    }
                    if (node.right != null) {
                        stack2.push(node.right);
                    }
                }
                result.add(temp);
            } else {
                ArrayList<Integer> temp = new ArrayList<>();
                while (stack2.size() != 0) {
                    TreeNode node = stack2.pop();
                    temp.add(node.val);
                    if (node.right != null) {
                        stack1.push(node.right);
                    }
                    if (node.left != null) {
                        stack1.push(node.left);
                    }
                }
                result.add(temp);
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
