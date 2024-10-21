package org.example.middle;

import java.util.ArrayList;
import java.util.LinkedList;
import java.util.List;
import java.util.Scanner;

/**
 * 二叉树的中序遍历
 * 分数 30
 * 作者
 * 单位
 * 给定一个二叉树的根节点root，返回它的中序遍历结果。
 *
 *
 * 输入格式:
 * 给定一个二叉树的根节点root。
 * 树上的节点数满足 0 <= n <= 1000, 每个节点的值满足 -1000 <= val <= 1000
 *
 * 输出格式:
 * 输出中序遍历后结果。
 *
 *
 * 输入样例:
 * 在这里给出一组输入。例如：
 *
 * 1,null,2,3
 * 以上输入用例构建的二叉树如下图所示：
 *
 * 7a87d48f-41fb-4630-b0ec-72921061be24.png
 *
 * 输出样例:
 * 在这里给出相应的输出。例如：
 *
 * 中序遍历后，结果输出为：1，3，2
 *
 * 1,3,2
 */
public class Middle12 {

    public static void main(String[] args) {
        Scanner in = new Scanner(System.in);
        String num = in.nextLine();
        in.close();

        String[] nums = num.split(",");
        Node head = new Node(nums[0]);

        //层序遍历转树
        LinkedList<Node> linkedList = new LinkedList<>();
        linkedList.addFirst(head);
        int i = 0;
        while(linkedList.size() > 0) {
            Node node = linkedList.pollLast();
            if(i + 1 < nums.length && !"null".equals(nums[i + 1])) {
                node.left = new Node(nums[i + 1]);
                linkedList.addFirst(node.left);
            }
            if(i + 2 < nums.length && !"null".equals(nums[i + 2])) {
                node.right = new Node(nums[i + 2]);
                linkedList.addFirst(node.right);
            }
            //下一个左右节点
            i += 2;
        }

        //中序遍历
        List<String> result = new ArrayList<>();
        middleTraverse(head, result);

        System.out.println(String.join(",", result));
    }

    private static void middleTraverse(Node node, List<String> result) {
        if(node == null) {
            return;
        }

        //左
        middleTraverse(node.left, result);

        //输出
        result.add(node.val);

        //右
        middleTraverse(node.right,result);
    }

    private static class Node {
        String val;
        Node left;
        Node right;

        public Node(String val) {
            this.val = val;
        }
    }
}
