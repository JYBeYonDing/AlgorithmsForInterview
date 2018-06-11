package 其他算法收集.图;

/**
 * Created by 杨杰 on 2018/5/24 19:57.
 * 用于多源最短路径的求解，算出来的是所有的节点到其余各节点之间的最短距离。
 * 时间复杂度O(N^3)
 * Floyed求每对不同顶点对的算法中 允许弧上的权为负,但不能有权和为负的回路。
 * 回路权和为负，那么一直绕这个回路转，最短路径就是负无穷。
 *
 * 使用的是动态规划的思想
 */
public class Floyd佛洛伊德算法_邻接矩阵 {
    private static final int INF = Integer.MAX_VALUE;
    public static void main(String[] args) {
        /**
         * 节点数组
         */
        int[] nodes = {'0', '1', '2', '3'};

        /**
         * 路径矩阵
         * path[i][j]:i到j的有向路径长度
         */
        int[][] path = {
                   /*A*//*B*//*C*//*D*/
          /*A*/ {    0,   1,   2,   1},
          /*B*/ {  INF,   0, INF, INF},
          /*C*/ {  INF,   3,   0,   1},
          /*D*/ {  INF,   1,   1,   0},
        };

        /**
         * floyd算法计算任意两点的最短距离
         */
        int[][] distance = floyd(nodes, path);

        // 打印floyd最短路径的结果
        System.out.printf("floyd: \n");
        for (int i = 0; i < nodes.length; i++) {
            for (int j = 0; j < nodes.length; j++)
                System.out.printf("%12d  ", distance[i][j]);
            System.out.printf("\n");
        }
    }



    private static int[][] floyd(int[] nodes, int[][] path){
        /**
         * 记录最短距离的矩阵
         */
        int[][] distance = new int[nodes.length][nodes.length];

        // 初始化距离矩阵
        for(int i=0; i<nodes.length; i++){
            for(int j=0; j<nodes.length; j++){
                distance[i][j] = path[i][j];
            }
        }

        //循环更新矩阵的值，从i到j的过程中考虑通过k中转后能否距离变近。
        for(int k=0; k<nodes.length; k++){
            for(int i=0; i<nodes.length; i++){
                for(int j=0; j<nodes.length; j++){
                    int temp = (distance[i][k] == INF || distance[k][j] == INF) ? INF : distance[i][k] + distance[k][j];
                    if(distance[i][j] > temp){
                        distance[i][j] = temp;
                    }
                }
            }
        }

        return distance;
    }

}
