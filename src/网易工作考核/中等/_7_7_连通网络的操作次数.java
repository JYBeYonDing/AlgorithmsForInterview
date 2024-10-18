package 网易工作考核.中等;

import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;


/**
 * 用以太网线缆将 n 台计算机连接成一个网络，计算机的编号从 0 到 n-1。线缆用 connections 表示，其中 connections[i] = [a, b] 连接了计算机 a 和 b。
 * <p>
 * 网络中的任何一台计算机都可以通过网络直接或者间接访问同一个网络中其他任意一台计算机。
 * <p>
 * 给你这个计算机网络的初始布线 connections，你可以拔开任意两台直连计算机之间的线缆，并用它连接一对未直连的计算机。请你计算并返回使所有计算机都连通所需的最少操作次数。如果不可能，则返回 -1 。
 * <p>
 * 输入格式:
 * 第 1 行输入 n 和 m，分别表示计算机的个数和线缆个数，用空格分隔。接下来的 m 行输入，表示有线缆连接的计算机 a 和 b，用空格分隔。
 * <p>
 * 输出格式:
 * 对每一组输入，在一行中输出使所有计算机都连通所需的最少操作次数，如果不可能，则返回-1。
 */
public class _7_7_连通网络的操作次数 {

    public static void main(String[] args) {
        Scanner in = new Scanner(System.in);
        String s = in.nextLine();
        String[] split = s.split(" ");
        int n = Integer.parseInt(split[0]);
        int m = Integer.parseInt(split[1]);
        int[][] lines = new int[m][2];
        for (int i = 0; i < m; i++) {
            split = in.nextLine().split(" ");
            lines[i][0] = Integer.parseInt(split[0]);
            lines[i][1] = Integer.parseInt(split[1]);
        }
        int res = solution(n, m, lines);
        System.out.println(res);

    }

    private static int solution(int n, int m, int[][] lines) {
        if (m < n - 1) {
            return -1;
        }
        boolean[] visited = new boolean[n];
        List<Integer>[] nears = new List[n];
        for (int i = 0; i < nears.length; i++) {
            nears[i] = new ArrayList<>();
        }
        for (int i = 0; i < lines.length; i++) {
            int[] line = lines[i];
            nears[line[0]].add(line[1]);
            nears[line[1]].add(line[0]);
        }
        int res = -1;
        for (int i = 0; i < n; i++) {
            if (visited[i]) {
                continue;
            }
            dfs(nears, i, visited);
            res++;
        }

        return res;
    }

    private static void dfs(List<Integer>[] nears, int i, boolean[] visited) {
        if (visited[i]) {
            return;
        }
        visited[i] = true;
        List<Integer> near = nears[i];
        for (Integer node : near) {
            dfs(nears, node, visited);
        }

    }


}
