package 网易工作考核.中等;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.Scanner;

/**
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
 */
public class _7_14_按格式重排链表 {

    public static void main(String[] args) {
        Scanner in = new Scanner(System.in);
        String s = in.nextLine();
        String[] split = s.split(" ");
        int n = Integer.parseInt(split[1]);
        Node head = new Node();
        head.setNextStr(split[0]);
        Map<String, Node> map = new HashMap<>();

        for (int i = 0; i < n; i++) {
            split = in.nextLine().split(" ");
            Node node = new Node();
            node.setLoc(split[0]);
            node.setV(split[1]);
            node.setNextStr(split[2]);
            map.put(node.getLoc(), node);
        }

        Node[] nodes = new Node[n+1];
        nodes[0] = head;
        Node cur = head;
        int idx = 1;
        while (!cur.getNextStr().equals("-1")) {
            cur = map.get(cur.getNextStr());
            nodes[idx++] = cur;
        }
//        for (int i = 0; i < nodes.length; i++) {
//            System.out.println(nodes[i].getV());
//        }

        ArrayList<Node> nodeList = new ArrayList<>();
        int i = n;
        int j = 1;
        while (i >= j) {
            nodeList.add(nodes[i]);
            if (i != j) {
                nodeList.add(nodes[j++]);
            }
            i = i - 1;
        }

        Node[] res = new Node[nodeList.size()];
        res = nodeList.toArray(res);
        for (int k = 0; k < res.length; k++) {
            if (k < res.length - 1) {
                res[k].setNextStr(res[k + 1].getLoc());
            }else{
                res[k].setNextStr("-1");
            }
            System.out.println(res[k].getLoc() + " " + res[k].getV() + " " + res[k].getNextStr());
        }
    }



    public static class Node {
        private String loc;
        private String v;
        private Node next;

        public String getNextStr() {
            return nextStr;
        }

        public void setNextStr(String nextStr) {
            this.nextStr = nextStr;
        }

        private String nextStr;

        public String getLoc() {
            return loc;
        }


        public void setLoc(String loc) {
            this.loc = loc;
        }

        public String getV() {
            return v;
        }

        public void setV(String v) {
            this.v = v;
        }

        public Node getNext() {
            return next;
        }

        public void setNext(Node next) {
            this.next = next;
        }
    }



}
