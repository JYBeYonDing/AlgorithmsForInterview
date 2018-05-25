package 牛客网.模拟五月场;

import java.util.Scanner;

/**
 * Created by 杨杰 on 2018/5/24 17:57.
 * https://www.nowcoder.com/questionTerminal/071695ed1d0b4e65b07eb969d212b92a
 * 没有AC，有错误，不知道错在哪
 */
public class 牛牛取快递_邻接矩阵 {
    private static final int INF = Integer.MAX_VALUE;   // 最大值
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        String[] ss = sc.nextLine().split(" ");
        int N = Integer.parseInt(ss[0]);
        int M = Integer.parseInt(ss[1]);
        int S = Integer.parseInt(ss[2]);
        int T = Integer.parseInt(ss[3]);

        int mMatrix[][] = new int[N + 1][N + 1];
        for(int i = 0; i< N+1; i++) {
            for(int j = 0; j< N+1; j++) {
                mMatrix[i][j] = INF;
            }
        }

        for(int i = 0 ; i< M; i++) {
            ss = sc.nextLine().split(" ");
            Integer from = Integer.parseInt(ss[0]);
            Integer to = Integer.parseInt(ss[1]);
            Integer weight = Integer.parseInt(ss[2]);
            mMatrix[from][to] = weight;
        }


        // 迪杰斯特拉算法
        int[] dist1 = dijkstra(S, N, mMatrix);
        int[] dist2 = dijkstra(T, N, mMatrix);
        System.out.println(dist1[T] + dist2[S]);

    }

    /**
     * Dijkstra最短路径。
     * 即，统计图中"顶点vs"到其它各个顶点的最短路径。
     * @param vs 起始顶点(start vertex)。即计算"顶点vs"到其它顶点的最短路径。
     * @param mMatrix 路径数组
     * @return 距离数组
     *
     * 时间复杂度为O(N^2),可以用优先队列优化
     */
    private static int[] dijkstra(int vs, int N,int[][] mMatrix) {
        /**
         * 前驱顶点数组。即，prev[i]的值是"顶点vs"到"顶点i"的最短路径所经历的全部顶点中，位于"顶点i"之前的那个顶点。
         */
        int[] prev = new int[N+1];
        /**
         * 长度数组。即，dist[i]是"顶点vs"到"顶点i"的最短路径的长度。
         */
        int[] dist = new int[N+1];
        // flag[i]=true表示"顶点vs"到"顶点i"的最短路径已成功获取
        boolean[] flag = new boolean[N+1];

        // 初始化
        for (int i = 0; i < N+1; i++) {
            flag[i] = false;          // 顶点i的最短路径还没获取到。
            prev[i] = 0;              // 顶点i的前驱顶点为0。
            dist[i] = mMatrix[vs][i];  // 一开始记录到顶点i的最短路径为"顶点vs"到"顶点i"的权。
        }

        // 对"顶点vs"自身进行初始化
        flag[vs] = true;
        dist[vs] = 0;

        // 遍历mVexs.length-1次；每次确定一个到该顶点的最短距离。
        int k = 0;
        for (int i = 1; i < N+1; i++) {
            // 寻找当前最小的路径；
            // 即，在未获取最短路径的顶点中，找到离vs最近的顶点(k)。
            int min = INF;
            for (int j = 0; j < N+1; j++) {// 遍历每个节点
                if (flag[j]==false && dist[j]<min) {// 在没有确定最短距离的点中选择离已确定距离的集合最近的点，则到该点的最短距离也就确定了
                    min = dist[j];
                    k = j;
                }
            }
            // 标记"顶点k"为已经获取到最短路径
            flag[k] = true;

            // 修正当前最短路径（即从已确定集合中任意点出发到其他点的距离）和前驱顶点
            // 即，当已经确定"顶点k的最短路径"之后，更新"未获取最短路径的顶点的最短路径和前驱顶点"。
            for (int j = 0; j < N+1; j++) {//min：原点到k点的最短距离
                int tmp = (mMatrix[k][j]==INF ? INF : (min + mMatrix[k][j]));
                if (flag[j]==false && (tmp<dist[j]) ) {// 如果经过k点到j的最短距离要比原来到j的最短距离小，则更新前驱节点
                    dist[j] = tmp;
                    prev[j] = k;
                }
            }
        }
        return dist;
    }

}
