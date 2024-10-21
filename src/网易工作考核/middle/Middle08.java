package org.example.middle;

import java.util.HashMap;
import java.util.Map;
import java.util.Scanner;

/**
 * 分段反转链表
 * 分数 30
 * 作者 
 * 单位 
 * 给定一个常数 K 和一个单链表 L，请你在单链表上每 K 个元素做一次反转，并输出反转完成后的链表。
 *
 * 如果链表最后一部分不足 K 个元素，则最后一部分不翻转。
 *
 * 例如，假设 L 为 1→2→3→4→5→6
 *
 * 如果 K=3，则你应该输出 3→2→1→6→5→4
 *
 * 如果 K=4，则你应该输出 4→3→2→1→5→6
 *
 *
 * 输入格式:
 * 第一行包含头节点地址，总节点数量 N 以及常数 K。1≤N≤100000，1≤K≤N 。
 *
 * 节点地址用一个 5 位非负整数表示（可能有前导 0），NULL 用 −1 表示。
 *
 * 接下来 N 行，每行描述一个节点的信息，格式如下：
 *
 * Address Data Next
 *
 * 其中 Address 是节点地址，Data 是一个绝对值不超过100000的整数，Next 是下一个节点的地址。
 *
 * 输出格式:
 * 将重新排好序的链表，从头节点开始，依次输出每个节点的信息，格式与输入相同。
 *
 *
 * 输入样例:
 * 在这里给出一组输入。例如：
 *
 * 00100 6 4
 * 00000 4 99999
 * 00100 1 12309
 * 68237 6 -1
 * 33218 3 00000
 * 99999 5 68237
 * 12309 2 33218
 * 输出样例:
 * 在这里给出相应的输出。例如：
 *
 * 00000 4 33218
 * 33218 3 12309
 * 12309 2 00100
 * 00100 1 99999
 * 99999 5 68237
 * 68237 6 -1
 */
public class Middle08 {
    public static void main(String[] args) {
        // read input
        Scanner in = new Scanner(System.in);

        //读取头节点地址，总节点数量，常数K
        String[] infos = in.nextLine().split(" ");
        String headAddr = infos[0];
        int n = Integer.parseInt(infos[1]);
        int k = Integer.parseInt(infos[2]);

        //读取链表
        Map<String, Node> map = readMap(in, n);
        in.close();

        //获取头节点
        Node head = map.get(headAddr);

        //翻转链表
        head = reverse(head, k);

        //输出链表
        while(head != null) {
            System.out.println(head.toString());
            head = head.next;
        }
    }

    private static Map<String, Node> readMap(Scanner in, int n) {
        Map<String, Node> map = new HashMap<>(n);
        while(n > 0) {
            String s = in.nextLine();
            String[] arr = s.split(" ");
            Node node = new Node(Integer.parseInt(arr[1]), arr[0], arr[2]);
            map.put(node.addr, node);
            n--;
        }

        for(Node node : map.values()) {
            String nextAddr = node.nextAddr;
            if(!"-1".equals(nextAddr)) {
                node.next = map.get(nextAddr);
            }
        }

        return map;
    }

    private static Node reverse(Node head, int k) {
        if(head == null) {
            return head;
        }

        //下一个非空节点
        Node tmp = head;
        int t = k-1;
        while(t > 0) {
            if(tmp.next == null) {
                break;
            }
            tmp = tmp.next;
            t--;
        }

        //不到k个不翻转
        if(t > 0) {
            return head;
        }

        //记录链表尾结点
        Node oldHead = head;
        //下个链表的起点
        Node remain = tmp.next;
        //分离链表
        tmp.next = null;
        //翻转k个
        head = doReverse(head);
        //递归剩下的链表
        Node res = reverse(remain, k);
        //连接翻转后的链表
        oldHead.next = res;

        return head;
    }

    private static Node doReverse(Node head) {
        //把第一个元素和后面的链表分离, 头插法翻转
        Node remain = head.next;
        head.next = null;

        Node tmp = null;
        while(remain != null) {
            tmp = remain;
            remain = remain.next;
            tmp.next = head;
            head = tmp;
        }
        return head;
    }

    private static class Node {
        int val;
        String addr;
        String nextAddr;
        Node next;

        public Node(int val, String addr, String nextAddr) {
            this.val = val;
            this.addr = addr;
            this.nextAddr = nextAddr;
        }

        @Override
        public String toString() {
            return addr + " " + val + " " + (next == null ? -1 : next.addr);
        }
    }
}
