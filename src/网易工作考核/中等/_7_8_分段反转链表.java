package 网易工作考核.中等;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.Scanner;


/**
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
 */
public class _7_8_分段反转链表 {

    public static void main(String[] args) {
        Scanner in = new Scanner(System.in);
        String s = in.nextLine();
        String[] split = s.split(" ");
        Node head = new Node();
        head.next = split[0];
        int n = Integer.parseInt(split[1]);
        int k = Integer.parseInt(split[2]);
        Map<String, Node> map = new HashMap<>();
        for (int i = 0; i < n; i++) {
            split = in.nextLine().split(" ");
            Node node = new Node();
            node.loc = split[0];
            node.v = split[1];
            node.next = split[2];
            map.put(split[0], node);

        }
        Node[] nodes = new Node[n];
        int index = 0;
        Node cur = head;
        while (!cur.next.equals("-1")) {
            nodes[index] = map.get(cur.next);
            cur = nodes[index];
            index++;
        }

        int left = -1;
        for (int i = 0; i < nodes.length; i++) {
            if (i - left == k) {
                reverse(nodes, left, i);
                left = i;
            }
        }

        for (int i = 0; i < nodes.length; i++) {
            if (i != nodes.length - 1) {
                nodes[i].next = nodes[i + 1].loc;
            }else{
                nodes[i].next = "-1";
            }
            System.out.println(nodes[i].loc + " " + nodes[i].v + " " + nodes[i].next);
        }

    }

    private static void reverse(Node[] nodes, int left, int right) {
        while (left + 1 < right) {
            Node temp = nodes[left + 1];
            nodes[left + 1] = nodes[right];
            nodes[right] = temp;
            left++;
            right--;
        }
    }

    private static class Node{
        String v;
        String loc;
        String next;
    }


}
