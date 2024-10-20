package 网易工作考核.中等;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.HashSet;
import java.util.List;
import java.util.Map;
import java.util.Scanner;
import java.util.TreeSet;

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
        for (int i = 0; i < n; i++) {
            split = in.nextLine().split(" ");
            Node node = new Node();
            node.loc = split[0];
            node.v = Integer.parseInt(split[1]);
            node.next = split[2];
            map.put(node.loc, node);
        }
        Node[] nodes = new Node[n];
        for (int i = 0; i < n; i++) {
            if (i == 0) {
                nodes[i] = map.get(head.next);
            }else{
                nodes[i] = map.get(nodes[i - 1].next);
            }
        }

        for (int i = 0; i < n; i++) {
            int j = findFirstDif(nodes, i);
            if (j - i >= 3) {
                remove(nodes,i, j - 1);
                i = j;
            }
        }


        ArrayList<Node> arrayList = new ArrayList<>();
        for (int i = 0; i < n; i++) {
            if (nodes[i] != null) {
                arrayList.add(nodes[i]);
            }
        }

        Node[] res = new Node[arrayList.size()];
        res = arrayList.toArray(res);
        for (int i = 0; i < res.length; i++) {
            if (i == res.length - 1) {
                res[i].next = "-1";
            } else {
                res[i].next = res[i + 1].loc;
            }
            System.out.print(res[i].loc + " " + res[i].v + " " + res[i].next);
            if (i != res.length - 1) {
                System.out.println();
            }
        }
    }

    private static void remove(Node[] nodes, int start, int end) {
        for (int j = start; j <= end; j++) {
            nodes[j] = null;
        }
    }

    private static int findFirstDif(Node[] nodes, int i) {
        for (int j = i; j < nodes.length; j++) {
            if (nodes[j].v != nodes[i].v) {
                return j;
            }
        }
        return nodes.length;
    }

    private  static class Node {
        String loc;
        int v;
        String next;
    }



    public static void main2(String[] args) {
        Scanner in = new Scanner(System.in);

        String[] params = in.nextLine().split(" ");
        String start = params[0];
        int n = Integer.parseInt(params[1]);

        Map<String, String> nextMap = new HashMap<>();
        Map<String, Integer> valueMap = new HashMap<>();

        nextMap.put("0", start); // 初始节点
        for (int i = 0; i < n; i ++) {
            String[] lineArr = in.nextLine().split(" ");
            Integer index = Integer.parseInt(lineArr[1]);

            nextMap.put(lineArr[0], lineArr[2]);
            valueMap.put(lineArr[0], index);
        }

        Map<Integer, Integer> countMap = new HashMap<>();
        String node = start;
        // 统计出现次数
        while (node != null && !node.equals("-1")) {
            Integer value = valueMap.get(node);
            if (countMap.get(value) != null) {
                countMap.put(value, countMap.get(value) + 1);
            } else {
                countMap.put(value, 1);
            }
            node = nextMap.get(node);
        }

        String preNode = "0";
        String nextNode = nextMap.get(preNode);
        while (nextNode != null && !nextNode.equals("-1")) {
            Integer count = countMap.get(valueMap.get(nextNode));
            if (count > 2) {
                nextMap.put(preNode, nextMap.get(nextNode));
                nextNode = nextMap.get(nextNode);
            } else {
                preNode = nextNode;
                nextNode = nextMap.get(nextNode);
            }
        }

        // 打印结果
        preNode = nextMap.get("0");
        nextNode = nextMap.get(preNode);
        while (nextNode != null) {
            System.out.print(preNode);
            System.out.print(" " + valueMap.get(preNode) + " ");
            System.out.print(nextNode);
            System.out.println();

            preNode = nextNode;
            nextNode = nextMap.get(nextNode);
        }


    }
}
