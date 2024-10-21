package org.example.middle;

import java.util.HashMap;
import java.util.Map;
import java.util.Scanner;

/**
 * 删除有序链表中重复2次以上元素
 * 分数 30
 * 作者
 * 单位
 * 给出一个升序排序的链表 L，删除链表中重复2次以上出现的元素，只保留原链表中出现一次或重复2次 的元素。
 *
 * 例如：
 *
 * 给出的链表为 1→2→3→3→4→4→4→4→5, 返回 1→2→3→3→5.
 *
 * 给出的链表为1→1→1→2→3, 返回 2→3.
 *
 * 数据范围： 链表长度 0≤size≤100000，链表中的值满足 ∣val∣≤10000。
 *
 *
 *
 * 输入格式:
 * 第一行包含头节点地址，总节点数量 N （1≤N≤100000）
 *
 * 节点地址用一个 5 位非负整数表示（可能有前导 0），NULL 用 −1 表示。
 *
 * 接下来 N 行，每行描述一个节点的信息，格式如下：
 *
 * Address Data Next
 *
 * 其中 Address 是节点地址，Data 是一个绝对值不超过100000的整数，Next 是下一个节点的地址。
 *
 *
 *
 * 输出格式:
 * 输出删除有序链表中重复2次以上元素后的链表。每个结点占一行，按输入的格式输出。
 *
 *
 * 输入样例:
 * 在这里给出一组输入。例如：
 *
 * 00100 10
 * 99999 3 87654
 * 87654 4 11111
 * 55555 8 -1
 * 44444 4 55555
 * 23854 2 00000
 * 11111 4 22222
 * 00100 1 23854
 * 22222 4 33333
 * 00000 3 99999
 * 33333 4 44444
 * 输出样例:
 * 在这里给出相应的输出。例如：
 *
 * 00100 1 23854
 * 23854 2 00000
 * 00000 3 99999
 * 99999 3 55555
 * 55555 8 -1
 */
public class Middle16 {

    public static void main(String[] args) {
        Scanner in = new Scanner(System.in);
        String[] input = in.nextLine().split(" ");
        String headAddr = input[0];
        int n = Integer.parseInt(input[1]);

        //无节点场景
        if(n == 0) {
            System.out.println(headAddr);
            return;
        }

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
        Node tmp = head;
        k = n;
        while(k > 0) {
            tmp.next = nodeMap.get(tmp.nAddr);
            tmp = tmp.next;
            k--;
        }

        //虚拟节点
        Node pre = new Node(null, null, null);

        //虚拟节点指向头节点
        pre.next = head;
        //备份头结点
        Node nHead = pre;
        //当前节点
        Node r = head;
        int c = 1;
        while(r != null) {
            if(r.next == null || !r.next.val.equals(r.val)) {
                //重复次数大于2,跳过这些元素
                if(c > 2) {
                    pre.next = r.next;
                } else {
                    //记录下一个变化节点的前序节点
                    pre = r;
                }
                c = 1;
            } else {
                //重复次数加1
                c++;
            }
            r = r.next;
        }

        //去掉虚拟节点
        nHead = nHead.next;
        while(nHead != null) {
            nHead.print();
            nHead = nHead.next;
        }
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
