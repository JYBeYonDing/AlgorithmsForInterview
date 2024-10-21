package org.example.simple;

import java.util.ArrayList;
import java.util.LinkedList;
import java.util.List;
import java.util.Scanner;

/**
 * 二叉搜索树中第K小的元素
 * 分数 30
 * 作者 
 * 单位 
 * 给定一个二叉搜索树的根节点 root ，和一个整数 K ，请你设计一个算法查找其中第 K 个最小元素（从 1 开始计数）
 *
 * 输入格式:
 * 树上的节点数满足 0 <= n <= 1000, 每个节点的值满足 -1000 <= val <= 1000
 * 第K个最小元素 满足 K <= 1000
 *
 * 输出格式:
 * 第K小的节点值
 *
 * 输入样例:
 * 在这里给出一组输入。例如：
 *
 * 3,1,4,null,2
 * 3
 * 以上给出的输入用例构造的二叉树如下图所示：
 *
 * 7a87d48f-41fb-4630-b0ec-72921061be24.png
 *
 * 输出样例:
 * 在这里给出相应的输出。例如：
 *
 * 3
 */
public class Simple30 {

    public static void main(String[] args) {
        Scanner in = new Scanner(System.in);
        String str = in.nextLine();
        int k = in.nextInt();
        in.close();

        String[] nums = str.split(",");
        LinkedList<Node> list = new LinkedList<>();
        Node head = new Node(Integer.parseInt(nums[0]));
        list.addLast(head);

        //层序遍历转二叉搜索树
        int i = 0;
        while(list.size() > 0 && i < nums.length) {
            Node node = list.poll();
            if(i + 1 < nums.length && !"null".equals(nums[i + 1])) {
                node.left = new Node(Integer.parseInt(nums[i + 1]));
                list.addLast(node.left);
            }
            if(i + 2 < nums.length && !"null".equals(nums[i + 2])) {
                node.right = new Node(Integer.parseInt(nums[i + 2]));
                list.addLast(node.right);
            }
            i+=2;
        }

        //中序遍历
        List<Integer> result = new ArrayList<>();
        search(head, result);

        //结果
        if(result.size() >= k) {
            System.out.println(result.get(k -1));
            return;
        }

        System.out.println("");
    }

    private static void search(Node node, List<Integer> result) {
        if(node == null) {
            return;
        }

        search(node.left, result);

        result.add(node.v);

        search(node.right, result);
    }

    private static class Node {
        int v;
        Node left;
        Node right;

        public Node(int v) {
            this.v = v;
        }
    }
}
