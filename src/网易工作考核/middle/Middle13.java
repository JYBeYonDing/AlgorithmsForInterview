package org.example.middle;

import java.util.Arrays;
import java.util.Scanner;

/**
 * https://blog.csdn.net/lq1990717/article/details/128825856
 * 信使
 * 分数 30
 * 作者
 * 单位
 * 题目描述
 *
 * 战争时期，前线有 n 个哨所，每个哨所可能会与其他若干个哨所之间有通信联系。信使负责在哨所之间传递信息，当然，这是要花费一定时间的（以天为单位）。指挥部设在第一个哨所。当指挥部下达一个命令后，指挥部就派出若干个信使向与指挥部相连的哨所送信。当一个哨所接到信后，这个哨所内的信使们也以同样的方式向其他哨所送信。直至所有 n 个哨所全部接到命令后，送信才算成功。因为准备充足，每个哨所内都安排了足够的信使（如果一个哨所与其他k个哨所有通信联系的话，这个哨所内至少会配备k个信使）。
 *
 * 现在总指挥请你编一个程序，计算出完成整个送信过程最短需要多少时间。
 *
 * 输入格式:
 * 输入第 1 行有两个整数 n 和 m，中间用 1 个空格隔开，分别表示有 n 个哨所和 m 条通信线路。1≤n≤100。
 *
 * 第 2 至 m+1 行：每行三个整数 i,j,k，中间用 1 个空格隔开，表示第 i 个和第 j 个哨所之间存在通信线路，且这条线路要花费 k 天。
 *
 * 输出格式:
 * 输出仅一个整数，表示完成整个送信过程的最短时间。如果不是所有的哨所都能收到信，就输出 -1。
 *
 * 输入样例:
 * 在这里给出一组输入。例如：
 *
 * 4 4
 * 1 2 4
 * 2 3 7
 * 2 4 1
 * 3 4 6
 * 输出样例:
 * 在这里给出相应的输出。例如：
 *
 * 11
 */
public class Middle13 {

    //求有向图中, 从指定节点到其他所有节点的最短路径,取最大值
    //Floyd算法, 或者Dijkstra算法, 或Dijkstra算法的优化, 或 SPFA算法
    public static void main(String[] args) {
        Scanner in = new Scanner(System.in);
        String[] nm = in.nextLine().split(" ");
        int n = Integer.parseInt(nm[0]);
        int m = Integer.parseInt(nm[1]);
        int[][] arr = new int[n][n];
        for(int[] a : arr) {
            Arrays.fill(a, -1);
        }
        for(int i = 0; i < n; i++) {
            arr[i][i] = 0;
        }
        while(m > 0) {
            String line = in.nextLine();
            String[] nums = line.split(" ");
            int i = Integer.parseInt(nums[0]);
            int j = Integer.parseInt(nums[1]);
            int v = Integer.parseInt(nums[2]);
            arr[i- 1][j -1] = v;
            arr[j- 1][i -1] = v;
            m--;
        }
        in.close();

        //必须先遍历k
        for(int k = 0; k < n; k++) {
            for(int i = 0; i < n; i++) {
                for(int j = 0; j < n; j++) {
                    if(arr[i][k] == -1 || arr[k][j] == -1) {
                        continue;
                    }
                    if(arr[i][j] == -1 || arr[i][j] > arr[i][k] + arr[k][j]) {
                        arr[i][j] = arr[i][k] + arr[k][j];
                    }
                }
            }
        }

        //找出最大值
        int max = -1;
        for(int i = 0; i < n; i++) {
            //有节点无法到达, 返回-1
            if(arr[0][i] == -1) {
                System.out.println(-1);
                return;
            }
            if(arr[0][i] > max) {
                max = arr[0][i];
            }
        }

        System.out.println(max);
    }
}
