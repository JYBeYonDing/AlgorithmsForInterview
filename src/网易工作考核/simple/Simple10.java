package org.example.simple;

import java.util.ArrayList;
import java.util.LinkedList;
import java.util.List;
import java.util.Scanner;

/**
 * 判断二叉树是不是搜索树
 * 分数 30
 * 作者 
 * 单位 
 * 给定一个二叉树根节点，请你判断这棵树是不是二叉搜索树.
 *
 * 输入格式:
 * 二叉搜索树满足每个节点的左子树上的所有节点均小于当前节点且右子树上的所有节点均大于当前节点。
 * 树上的节点数满足 1 <= n <= 10000, 每个节点的值满足 −2的31次方 <= val <= 2的31次方−1
 *
 * 输出格式:
 * true or false
 *
 * 输入样例:
 * 在这里给出一组输入（空节点用null-小写表示），例如：
 *
 * 20,null,40,34,70,21,null,55,78
 * 以上输入样例构建的二叉树为：
 *
 * POPO-20240202-182522.png
 *
 * 输出样例:
 * 在这里给出相应的输出。例如：
 *
 * true
 *
 */
public class Simple10 {

    public static void main(String[] args) {
        //read
        Scanner in = new Scanner(System.in);
        String vals = in.nextLine();
        in.close();

        //层序遍历转树
        String[] val = vals.split(",");
        Node head = buildTree(val);

        //中序遍历
        List<Integer> list = new ArrayList<>();
        binarySearchTree(head, list);

        //是否递增
        boolean incr = isIncr(list);

        System.out.println(incr);
    }

    private static boolean isIncr(List<Integer> list) {
        boolean incr = true;
        int pre = list.get(0);
        for(int i = 1; i < list.size(); i++) {
            if(list.get(i) <= pre) {
                incr = false;
                break;
            }
            pre = list.get(i);
        }
        return incr;
    }

    private static Node buildTree(String[] val) {

        //队列
        LinkedList<Node> list = new LinkedList<>();
        Node head = new Node(Integer.parseInt(val[0]));
        list.addFirst(head);

        int idx = 0;
        while(list.size() > 0) {
            Node node = list.pollLast();
            if(++idx < val.length) {
                if(!"null".equals(val[idx])) {
                    Integer v = Integer.parseInt(val[idx]);
                    node.left = new Node(v);
                    list.addFirst(node.left);
                }
            }
            if(++idx < val.length) {
                if(!"null".equals(val[idx])) {
                    Integer v = Integer.parseInt(val[idx]);
                    node.right = new Node(v);
                    list.addFirst(node.right);
                }
            }
        }

        return head;
    }

    //中序遍历递增, 左 < 中 < 右
    // 20 21 34 40 55 70 78
    private static void binarySearchTree(Node curr, List<Integer> list) {
        if(curr == null) {
            return;
        }

        binarySearchTree(curr.left, list);

        list.add(curr.val);

        binarySearchTree(curr.right, list);
    }

    private static class Node {
        Node left;
        Node right;
        Integer val;

        public Node(Integer val) {
            this.val = val;
        }
    }
}
