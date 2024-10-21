package org.example.simple;

import java.util.HashMap;
import java.util.Map;
import java.util.PriorityQueue;
import java.util.Scanner;

/**
 * 根据字符出现频率排序
 * 分数 30
 * 作者 
 * 单位 
 * 给定一个字符串 s ，根据字符出现的 频率 对其进行 降序排序 。一个字符出现的 频率 是它出现在字符串中的次数。
 *
 * 返回 已排序的字符串 。如果有多个答案，返回其中任何一个。
 *
 * 输入格式:
 * 字符串
 *
 * 输出格式:
 * 排序后的字符串
 * 注：如果出现次数相同， 则按字典序升序排列
 *
 * 输入样例:
 * 在这里给出一组输入。例如：
 *
 * tree
 * 输出样例:
 * 在这里给出相应的输出。例如：
 *
 * eert
 */
public class Simple29 {
    public static void main(String[] args) {
        Scanner in = new Scanner(System.in);

        String str = in.nextLine();
        in.close();

        //统计
        Map<Character, Integer> map = new HashMap<>();
        for(char c : str.toCharArray()) {
            Integer cnt = map.getOrDefault(c, 0);
            map.put(c, cnt + 1);
        }

        //优先队列，自定义比较器
        PriorityQueue<Node> queue = new PriorityQueue<>();
        for(Map.Entry<Character, Integer> e : map.entrySet()) {
            queue.offer(new Node(e.getKey(), e.getValue()));
        }

        //输出
        int k = 0;
        char[] chars = new char[str.length()];
        while(!queue.isEmpty()) {
            Node cn = queue.poll();
            for(int i = 0; i < cn.cnt; i++) {
                chars[k++] = cn.c;
            }
        }

        System.out.println(new String(chars));
    }

    //Comparable接口不能漏掉泛型
    private static class Node implements Comparable<Node> {
        char c;
        int cnt;
        public Node(char c, int cnt) {
            this.c = c;
            this.cnt = cnt;
        }

        @Override
        public int compareTo(Node o) {
            return o.cnt == this.cnt ? this.c - o.c : o.cnt - this.cnt;
        }
    }
}
