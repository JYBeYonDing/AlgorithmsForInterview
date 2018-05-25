package 其他算法收集.图;

/**
 * Created by 杨杰 on 2018/5/24 17:57.
 */
public class 迪杰斯特拉Dijkstra邻接矩阵实现 {
    private static final int INF = Integer.MAX_VALUE;   // 最大值
    public static void main(String[] args) {
        int mEdgNum;        // 边的数量
        char[] mVexs = {'A', 'B', 'C', 'D', 'E', 'F', 'G'};
        int mMatrix[][] = {
                 /*A*//*B*//*C*//*D*//*E*//*F*//*G*/
          /*A*/ {   0,  12, INF, INF, INF,  16,  14},
          /*B*/ {  12,   0,  10, INF, INF,   7, INF},
          /*C*/ { INF,  10,   0,   3,   5,   6, INF},
          /*D*/ { INF, INF,   3,   0,   4, INF, INF},
          /*E*/ { INF, INF,   5,   4,   0,   2,   8},
          /*F*/ {  16,   7,   6, INF,   2,   0,   9},
          /*G*/ {  14, INF, INF, INF,   8,   9,   0}};

        int vs=0;// 起始点

        // 迪杰斯特拉算法
        int[] dist = dijkstra(vs, mVexs, mMatrix);

        // 打印dijkstra最短路径的结果
        System.out.printf("dijkstra(%c): \n", mVexs[vs]);
        for (int i=0; i < mVexs.length; i++) {
            System.out.printf("  shortest(%c, %c)=%d\n", mVexs[vs], mVexs[i], dist[i]);
        }
    }

    /**
     * Dijkstra最短路径。
     * 即，统计图中"顶点vs"到其它各个顶点的最短路径。
     * @param vs 起始顶点(start vertex)。即计算"顶点vs"到其它顶点的最短路径。
     * @param mVexs 顶点数组
     * @param mMatrix 路径数组
     * @return 距离数组
     *
     * 时间复杂度为O(N^2),可以用优先队列优化
     */
    private static int[] dijkstra(int vs, char[] mVexs, int[][] mMatrix) {
        /**
         * 前驱顶点数组。即，prev[i]的值是"顶点vs"到"顶点i"的最短路径所经历的全部顶点中，位于"顶点i"之前的那个顶点。
         */
        int[] prev = new int[mVexs.length];
        /**
         * 长度数组。即，dist[i]是"顶点vs"到"顶点i"的最短路径的长度。
         */
        int[] dist = new int[mVexs.length];
        // flag[i]=true表示"顶点vs"到"顶点i"的最短路径已成功获取
        boolean[] flag = new boolean[mVexs.length];

        // 初始化
        for (int i = 0; i < mVexs.length; i++) {
            flag[i] = false;          // 顶点i的最短路径还没获取到。
            prev[i] = 0;              // 顶点i的前驱顶点为0。
            dist[i] = mMatrix[vs][i];  // 一开始记录到顶点i的最短路径为"顶点vs"到"顶点i"的权。
        }

        // 对"顶点vs"自身进行初始化
        flag[vs] = true;
        dist[vs] = 0;

        // 遍历mVexs.length-1次；每次确定一个到该顶点的最短距离。
        int k = 0;
        for (int i = 1; i < mVexs.length; i++) {
            // 寻找当前最小的路径；
            // 即，在未获取最短路径的顶点中，找到离vs最近的顶点(k)。
            int min = INF;
            for (int j = 0; j < mVexs.length; j++) {// 遍历每个节点
                if (flag[j]==false && dist[j]<min) {// 在没有确定最短距离的点中选择离已确定距离的集合最近的点，则到该点的最短距离也就确定了
                    min = dist[j];
                    k = j;
                }
            }
            // 标记"顶点k"为已经获取到最短路径
            flag[k] = true;

            // 修正当前最短路径（即从已确定集合中任意点出发到其他点的距离）和前驱顶点
            // 即，当已经确定"顶点k的最短路径"之后，更新"未获取最短路径的顶点的最短路径和前驱顶点"。
            for (int j = 0; j < mVexs.length; j++) {//min：原点到k点的最短距离
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
