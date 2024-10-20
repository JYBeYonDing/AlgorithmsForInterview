package 网易工作考核.中等;

import java.util.ArrayDeque;
import java.util.LinkedList;
import java.util.Queue;
import java.util.Scanner;
import java.util.Stack;

/**
 * 给定一个二叉树的根节点root，返回它的中序遍历结果。 输入格式: 给定一个二叉树的根节点root。 树上的节点数满足 0 <= n <= 1000, 每个节点的值满足 -1000 <= val <= 1000 输出格式:
 * 输出中序遍历后结果。 输入样例: 在这里给出一组输入。例如： 1,null,2,3 以上输入用例构建的二叉树如下图所示： 7a87d48f-41fb-4630-b0ec-72921061be24.png 输出样例:
 * 在这里给出相应的输出。例如： 中序遍历后，结果输出为：1，3，2 1,3,2
 */
public class _7_11_二叉树的中序遍历 {
    private static StringBuilder sb = new StringBuilder();

    public static void main(String[] args) {
        Scanner in = new Scanner(System.in);
        String s = in.nextLine();
        String[] split = s.split(",");
        TreeNode treeNode = buildTree(split);

        dfs(treeNode);

        System.out.println(sb.substring(0, sb.length() - 1));
    }

    private static void dfs(TreeNode treeNode) {
        if (treeNode == null) {
            return;
        }
        dfs(treeNode.left);
        sb.append(treeNode.v).append(",");
        dfs(treeNode.right);

    }


    private static TreeNode buildTree(String[] nodeArray) {
        Queue<TreeNode> queue = new LinkedList<>();
        TreeNode root = new TreeNode(nodeArray[0]);
        queue.offer(root);
        int i = 1;
        while (i < nodeArray.length && !queue.isEmpty()) {
            TreeNode parent = queue.poll();
            if (!"null".equals(nodeArray[i])) {
                TreeNode left = new TreeNode(nodeArray[i]);
                parent.left = left;
                queue.offer(left);
            }
            i++;
            if (i < nodeArray.length && !"null".equals(nodeArray[i])) {
                TreeNode right = new TreeNode(nodeArray[i]);
                parent.right = right;
                queue.offer(right);
            }
            i++;
        }
        return root;
    }

    private static class TreeNode{
        String v;
        TreeNode left;
        TreeNode right;

        public TreeNode(String v) {
            this.v = v;
        }
    }

}
