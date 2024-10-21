package org.example.middle;

import java.util.Scanner;

/**
 * 连通网络的操作次数
 * 分数 30
 * 作者 
 * 单位 
 * 用以太网线缆将 n 台计算机连接成一个网络，计算机的编号从 0 到 n-1。线缆用 connections 表示，其中 connections[i] = [a, b] 连接了计算机 a 和 b。
 *
 * 网络中的任何一台计算机都可以通过网络直接或者间接访问同一个网络中其他任意一台计算机。
 *
 * 给你这个计算机网络的初始布线 connections，你可以拔开任意两台直连计算机之间的线缆，并用它连接一对未直连的计算机。请你计算并返回使所有计算机都连通所需的最少操作次数。如果不可能，则返回 -1 。
 *
 * 输入格式:
 * 第 1 行输入 n 和 m，分别表示计算机的个数和线缆个数，用空格分隔。接下来的 m 行输入，表示有线缆连接的计算机 a 和 b，用空格分隔。
 *
 * 输出格式:
 * 对每一组输入，在一行中输出使所有计算机都连通所需的最少操作次数，如果不可能，则返回-1。
 *
 * 输入样例1:
 * 如图所示：
 * 例子.png
 *
 * 这里相应地给出一组输入：
 *
 * 输入样例1:
 * 4 3
 * 0 1
 * 0 2
 * 1 2
 * 输出样例1:
 * 在这里给出相应的输出。例如：
 *
 * 1
 * 解释：拔下计算机 1 和 2 之间的线缆，并将它插到计算机 1 和 3 上。
 *
 * 输入样例2:
 * 6 4
 * 0 1
 * 0 2
 * 0 3
 * 1 2
 * 输出样例2:
 * 在这里给出相应的输出。例如：
 *
 * -1
 * 解释：线缆数量不足。
 *
 *
 * 提示
 *
 * 1 <= n <= 10^5
 *
 * 1 <= connections.length <= min(n*(n-1)/2, 10^5)
 *
 * connections[i].length == 2
 *
 * 0 <= connections[i][0], connections[i][1] < n
 *
 * connections[i][0] != connections[i][1]
 *
 * 没有重复的连接。
 *
 * 两台计算机不会通过多条线缆连接。
 */
public class Middle07 {

    public static void main(String[] args) {
        // read input
        Scanner in = new Scanner(System.in);
        String line = in.nextLine();

        String[] nm = line.split(" ");
        int n = Integer.parseInt(nm[0]);
        int m = Integer.parseInt(nm[1]);

        int k = m;
        int[][] network = new int[n][n];
        while(k > 0) {
            String [] ij = in.nextLine().split(" ");
            int i = Integer.parseInt(ij[0]);
            int j = Integer.parseInt(ij[1]);
            network[i][j] = 1;
            network[j][i] = 1;
            k--;
        }
        in.close();

        //拆掉的连接数量
        int lineCnt = 0;
        //子图数量
        int subGraph = 0;
        boolean[] visited = new boolean[n];
        for(int i = 0; i < n; i++) {
            if(!visited[i]) {
                subGraph++;
                lineCnt += dfs(network, visited, i);
            }
        }

        //剩下的连接数大于等于子图数-1，说明可以联通
        if(m - lineCnt >= subGraph - 1) {
            System.out.println(subGraph - 1);
        } else {
            System.out.println(-1);
        }
    }

    private static int dfs(int[][] network, boolean[] visited, int row) {
        //标记为已访问
        visited[row] = true;
        //拆掉的连接数量
        int cnt = 0;
        for(int col = 0; col < network.length; col++) {
            //如果没有访问过，且有连接
            if(!visited[col] && network[row][col] == 1) {
                network[row][col] = 0;
                network[col][row] = 0;
                //拆掉的连接数量+1
                cnt++;
                //递归
                cnt += dfs(network, visited, col);
            }
        }

        return cnt;
    }
}
