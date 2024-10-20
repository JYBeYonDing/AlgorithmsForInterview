package org.example.simple;

import java.util.LinkedList;
import java.util.Scanner;

/**
 * 买票需要的时间
 * 分数 30
 * 作者 
 * 单位 
 * 有 n 个人前来排队买票，其中第 0 人站在队伍 最前方 ，第 (n - 1) 人站在队伍 最后方 。
 *
 * 给你一个下标从 0 开始的整数数组 tickets ，数组长度为 n ，其中第 i 人想要购买的票数为 tickets[i] 。
 *
 * 每个人买票都需要用掉 恰好 1 秒 。一个人 一次只能买一张票 ，如果需要购买更多票，他必须走到  队尾 重新排队（瞬间 发生，不计时间）。如果一个人没有剩下需要买的票，那他将会 离开 队伍。
 *
 * 返回位于位置 k（下标从 0 开始）的人完成买票需要的时间（以秒为单位）。
 *
 * 输入格式:
 * 输入第一行为tickets数组，元素用空格分隔
 *
 * 第二行为k
 *
 * 输出格式:
 * 第k个需要的买票时间
 *
 * 输入样例:
 * 在这里给出一组输入。例如：
 *
 * 2 3 2
 * 2
 * 输出样例:
 * 在这里给出相应的输出。例如：
 *
 * 6
 * 注意事项
 * n == tickets.length
 *
 * 1 <= n <= 100
 *
 * 1 <= tickets[i] <= 100
 *
 * 0 <= k < n
 */
public class Simple11 {
    public static void main(String[] args) {
        // read input
        Scanner in = new Scanner(System.in);

        LinkedList<Node> linkedList = new LinkedList<>();
        while(in.hasNext()) {
            linkedList.addLast(new Node(in.nextInt()));
        }
        in.close();

        int k = linkedList.pollLast().val;
        Node kn = linkedList.get(k);

        int t = 0;
        while(kn.val > 0) {
            Node head = linkedList.pollFirst();
            t++;
            head.val--;
            if(head.val > 0) {
                linkedList.addLast(head);
            }
        }

        System.out.println(t);
    }

    private static class Node {
        int val;

        public Node(int val) {
            this.val = val;
        }
    }
}
