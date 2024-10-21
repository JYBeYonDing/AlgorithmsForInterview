package org.example.hard;

import java.util.Scanner;

/**
 * 二叉树的最大路径和
分数 60
作者 
单位 
二叉树中的 路径 被定义为一条节点序列，序列中每对相邻节点之间都存在一条边。同一个节点在一条路径序列中 至多出现一次 。该路径 至少包含一个 节点，且不一定经过根节点。
路径和 是路径中各节点值的总和。
给你一个二叉树的根节点 root ，返回其 最大路径和 。

输入格式:
树上的节点数满足 0 <= n <= 1000, 每个节点的值满足 -1000 <= val <= 1000

（注：null节点的左右叶子不会再打印null）

输出格式:
输出最大路径的和


输入样例:
在这里给出一组输入。例如：

-10,9,20,null,null,15,7
以上样例构造的二叉树如下图所示：

cf55735b-9607-415d-9e0d-5184eb4e8fec.png


输出样例:
在这里给出相应的输出。例如：

42
 */
public class Hard05 {

    //部分通过

    //求左右子树的价值，过程中记录max
    //节点价值 = 空（0） 或非空， 根节点+左右中更大的价值
    static int max = Integer.MIN_VALUE;

    public static void main(String[] args) {
        Scanner in = new Scanner(System.in);
        String line = in.nextLine();
        in.close();
        
        if ("null".equals(line)) {
            System.out.println("null");
            return;
        }

        String[] btree = line.split(",");

        Node root = new Node(Integer.valueOf(btree[0]));
        buildTree(root, 0, btree);

        getMax(root);
        System.out.println(max);
    }

    private static Integer getMax(Node root) {
        if (root == null) {
            return 0;
        }

        Integer rootVal  = root.val;
        Integer lmax = Math.max(getMax(root.l), 0);
        Integer rmax = Math.max(getMax(root.r), 0);

        max = Math.max(max, rootVal + lmax + rmax);

        return rootVal + Math.max(lmax, rmax);
    }

    private static void buildTree(Node node, int idx, String[] btree) {
        int l = 2 * idx + 1;
        int r = 2 * idx + 2;

        if (l < btree.length && !btree[l].equals("null")) {
            node.l = new Node(Integer.valueOf(btree[l]));
            buildTree(node.l, l, btree);
        }

        if (r < btree.length && !btree[r].equals("null")) {
            node.r = new Node(Integer.valueOf(btree[r]));
            buildTree(node.r, r, btree);
        }
    }

    private static class Node {
        int val;
        Node l;
        Node r;

        Node(int val) {
            this.val = val;
        }
    }
}
