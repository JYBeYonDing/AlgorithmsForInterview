package 网易工作考核.中等;


import java.util.HashMap;
import java.util.Map;
import java.util.Scanner;

/**
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
 */
public class _7_13_删除有序链表中重复2次以上元素 {

    public static void main(String[] args) {
        Scanner in = new Scanner(System.in);
        String s = in.nextLine();
        String[] split = s.split(" ");
        Node head = new Node();
        head.next = split[0];
        int n = Integer.parseInt(split[1]);

        Map<String, Node> map = new HashMap<>();
        Map<String, Integer> countMap = new HashMap<>();
        for (int i = 0; i < n; i++) {
            split = in.nextLine().split(" ");
            Node node = new Node();
            node.loc = split[0];
            node.value = split[1];
            node.next = split[2];
            map.put(node.loc, node);
            Integer count = countMap.get(node.value);
            if (count == null) {
                count = 1;
            }else{
                count = count + 1;
            }
            countMap.put(node.value, count);
        }

        Node pre = head;
        Node cur = map.get(head.next);
        while (cur != null) {
            if (countMap.get(cur.value) > 2) {
                pre.next = cur.next;
                cur = map.get(cur.next);
            } else {
                pre = cur;
                cur = map.get(cur.next);
            }
        }

        cur = map.get(head.next);
        while (cur != null) {
            System.out.println(cur.loc + " " + cur.value + " " + cur.next);
            cur = map.get(cur.next);
        }

    }

    private static class Node{
        String loc;
        String value;
        String next;
    }


}
