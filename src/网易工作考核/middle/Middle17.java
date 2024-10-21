package org.example.middle;

import java.util.HashMap;
import java.util.Map;
import java.util.Scanner;

/**
 * 按格式重排链表
 * 分数 30
 * 作者
 * 单位
 * 给定一个单链表L1​→L2​→⋯→Ln−1​→Ln​
 *
 * 请编写程序将链表重新排列为Ln​→L1​→Ln−1​→L2​→…
 *
 * 例如：给定L为1→2→3→4→5→6，则输出应该为6→1→5→2→4→3
 *
 * 输入格式：
 * 第一行包含头节点地址，总节点数量 N （1≤N≤100000）
 *
 * 节点地址用一个 5 位非负整数表示（可能有前导 0），空地址 NULL 用 −1 表示。
 *
 * 接下来 N 行，每行描述一个节点的信息，格式如下：
 *
 * Address Data Next
 *
 * 其中 Address 是节点地址，Data 是一个绝对值不超过100000的整数，Next 是下一个节点的地址。
 *
 * 题目保证给出的链表上至少有两个结点。
 *
 * 输出格式：
 * 对每个测试用例，顺序输出重排后的结果链表，其上每个结点占一行，格式与输入相同。
 *
 *
 * 输入样例:
 * 在这里给出一组输入。例如：
 *
 * 00100 6
 * 00000 4 99999
 * 00100 1 12309
 * 68237 6 -1
 * 33218 3 00000
 * 99999 5 68237
 * 12309 2 33218
 * 输出样例:
 * 在这里给出相应的输出。例如：
 *
 * 68237 6 00100
 * 00100 1 99999
 * 99999 5 12309
 * 12309 2 00000
 * 00000 4 33218
 * 33218 3 -1
 */
public class Middle17 {

    public static void main(String[] args) {
        Scanner in = new Scanner(System.in);
        String[] input = in.nextLine().split(" ");
        String headAddr = input[0];
        int n = Integer.parseInt(input[1]);

        //构建链表
        int k = n;
        Map<String, Node> nodeMap = new HashMap<>(n);
        while(k > 0) {
            String line = in.nextLine();
            String[] data = line.split(" ");
            Node node = new Node(data[0],data[1],data[2]);
            nodeMap.put(data[0], node);
            k--;
        }
        Node head = nodeMap.get(headAddr);
        Node pre = head;
        k = n;
        while(k > 0) {
            pre.next = nodeMap.get(pre.nAddr);
            pre = pre.next;
            k--;
        }

        //边界场景
        if(n == 1) {
            head.print();
            return;
        }

        //找到中间节点
        Node tmp = head;
        //这里取后半段节点的前一个节点
        k = n / 2 - 1;
        while(k > 0) {
            tmp = tmp.next;
            k--;
        }

        //翻转后半段节点
        Node sub = tmp.next;
        tmp.next = null;
        sub = reverse(sub);

        //合并链表
        head = merge(head, sub);

        //输出
        while(head != null) {
            head.print();
            head = head.next;
        }
    }

    private static Node reverse(Node node) {
        if(node == null){
            return null;
        }

        Node head = node;
        Node n = head.next;
        Node b = head.next;

        head.next = null;
        while(b != null) {
            //先保存下一个节点
            b = b.next;
            n.next = head;
            head = n;
            n = b;
        }

        return head;
    }

    private static Node merge(Node node1, Node node2) {
        if(node1 == null) {
            return node2;
        }
        if(node2 == null) {
            return node1;
        }

        //使用虚拟节点
        Node head = new Node(null,null,null);
        Node result = head;
        //交替合并
        Node t1 = node1;
        Node t2 = node2;
        while(node1 != null && node2 != null) {
            //保存下一个节点
            node1 = node1.next;
            node2 = node2.next;
            t1.next = null;
            t2.next = null;

            head.next = t2;
            head = head.next;
            head.next = t1;
            head = head.next;

            t1 = node1;
            t2 = node2;
        }

        if(node1 != null) {
            head.next = node1;
        }
        if(node2 != null) {
            head.next = node2;
        }

        return result.next;
    }

    private static class Node {
        String addr;
        String val;
        String nAddr;
        Node next;

        public Node(String addr, String val, String nAddr) {
            this.addr = addr;
            this.val = val;
            this.nAddr = nAddr;
        }

        public void print() {
            System.out.println(addr + " " + val + " " + (next == null ? "-1" : next.addr));
        }
    }
}
