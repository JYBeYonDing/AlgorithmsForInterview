package org.example.hard;

import java.util.HashMap;
import java.util.Map;
import java.util.Scanner;
import java.util.Stack;

/**
 * 按格式合并两个链表
 * 分数 60
 * 作者 
 * 单位 
 * 给定两个链表L1​=a1​→a2​→⋯→an−1​→an​ 和L2​=b1​→b2​→⋯→bm−1​→bm​，其中n≥2m。
 *
 * 需要将较短的链表L2​反转并合并到较长的链表L1​中
 *
 * 使得合并后的链表如下形式：a1​→a2​→bm​→a3​→a4​→bm−1​→…
 *
 * 合并规则：在长链表中每隔两个元素，将短链表中的元素倒序插入。
 *
 * 例如：给定一个较长链表1→2→3→4→5，另外一个较短链表6→7，需要输出1→2→7→3→4→6→5
 *
 * 输入格式:
 * 第一行包含两个链表的第一个节点地址（不确定哪个链表更长），以及两个链表的总节点数N(≤100000)。
 *
 * 节点地址用一个 5 位非负整数表示（可能有前导 0），空地址 NULL 用 −1 表示。
 *
 * 例如：00100 01000 7。其中00100表示第一个链表的首个节点地址，01000表示第二个链表的首个节点地址，7表示两个链表的总节点数。
 *
 * 接下来N行，每行描述一个节点的信息，格式如下：
 *
 * Address Data Next
 *
 * 其中 Address 是节点地址，Data 是一个绝对值不超过100000的整数，Next 是下一个节点的地址。
 *
 * 保证两个链表都不为空，且较长的链表至少是较短链表长度的两倍。
 *
 * 输出格式:
 * 对于每个测试用例，按顺序输出合并后的结果链表。每个结点占一行，按输入的格式输出。
 *
 *
 * 输入样例:
 * 在这里给出一组输入。例如：
 *
 * 00100 01000 7
 * 02233 2 34891
 * 00100 6 00001
 * 34891 3 10086
 * 01000 1 02233
 * 00033 5 -1
 * 10086 4 00033
 * 00001 7 -1
 * 输出样例:
 * 在这里给出相应的输出。例如：
 *
 * 01000 1 02233
 * 02233 2 00001
 * 00001 7 34891
 * 34891 3 10086
 * 10086 4 00100
 * 00100 6 00033
 * 00033 5 -1
 */
public class Hard01 {
    public static void main(String[] args) {
        // read input
        Scanner in = new Scanner(System.in);
        String line1 = in.nextLine();

        String[] arr = line1.split(" ");
        String l1HeadAddr = arr[0];
        String l2HeadAddr = arr[1];
        int total = Integer.valueOf(arr[2]);

        Map<String, Node> allNodeMap = readLinkedList(in, total);

        // 构建链表
        allNodeMap.forEach((k, v) -> {
            if (allNodeMap.containsKey(v.nextAddr)) {
                v.nextNode(allNodeMap.get(v.nextAddr));
            }
        });

        
        //链表1
        Node l1 = allNodeMap.get(l1HeadAddr);
        int l1Cnt = count(l1);

        //链表2
        Node l2 = allNodeMap.get(l2HeadAddr);
        int l2Cnt = count(l2);

        //较长的
        Node ll = l1;
        //较短的
        Node sl = l2;
        if (l2Cnt > l1Cnt) {
            ll = l2;
            sl = l1;
        }

        //短链表入栈
        Stack<Node> stack = new Stack<>();
        Node tmp = sl;
        while (tmp != null) {
            stack.push(tmp);
            tmp = tmp.next;
        }

        Node a = ll;
        while (!stack.isEmpty()) {
            Node b = stack.pop();
            //b的前一个节点
            a = a.next;
            if (a == null) {
                break;
            }

            //b的后一个节点
            Node c = a.next;

            //连接
            a.nextNode(b);
            b.nextNode(c);

            //c是b的后一个节点
            a = c;
            if (a == null) {
                break;
            }
        }

        printNode(ll);
    }

    private static int count(Node l1) {
        Node tmp = l1;
        int l1Cnt = 0;
        while (tmp != null) {
            l1Cnt++;
            tmp = tmp.next;
        }

        return l1Cnt;
    }

    private static Map<String, Node> readLinkedList(Scanner in, int n) {
        Map<String, Node> nodeMap = new HashMap<>();
        // 读取节点
        for (int i = 0; i < n; i++) {
            String line = in.nextLine();
            String[] strs = line.split(" ");

            // 当前节点地址，节点值，下一个节点地址
            String addr = strs[0];
            int val = Integer.valueOf(strs[1]);
            String nextAddr = strs[2];

            // 放入map
            Node node = new Node(addr, val, nextAddr);
            nodeMap.put(addr, node);
        }

        in.close();

        return nodeMap;
    }

    /**
     * 打印链表
     */
    private static void printNode(Node head) {
        while (head != null) {
            head.printNode();
            head = head.next;
        }
    }

    /**
     * 链表节点定义
     */
    private static class Node {
        String addr;
        String nextAddr;
        int val;
        Node next;

        public Node(String addr, int val, String nextAddr) {
            this.addr = addr;
            this.val = val;
            this.nextAddr = nextAddr;
        }

        public void printNode() {
            System.out.println(addr + " " + val + " " + (next == null ? "-1" : next.addr));
        }

        public void nextNode(Node next) {
            this.next = next;
            if (next != null) {
                nextAddr = next.addr;
            }
        }
    }
}
