package 牛客网.模拟五月场;

import java.util.ArrayList;
import java.util.PriorityQueue;
import java.util.Scanner;

/**
 * Created by 杨杰 on 2018/5/25 10:49.
 * 没有AC，有错误，不知道错在哪
 */
public class 牛牛取快递_邻接表迪杰斯特拉 {
    private static int INF = Integer.MAX_VALUE;

    // 邻接表中表对应的边节点
    private static class EdgeNode {
        int to;       // 该边所指向的顶点的位置
        int weight;     // 该边的权
        public EdgeNode(int to, int weight) {
            this.to = to;
            this.weight = weight;
        }
    }

    /**
     * 初始化，即构建图
     * @param N 节点个数
     * @param edges 边
     * @return 节点数组，数组的长度是N+1，因为这里多了一个无用的0节点
     */
    private static ArrayList<EdgeNode>[] init(int N, int[][] edges) {
        ArrayList<EdgeNode>[] nodes = new ArrayList[N+1];//nodes[i]代表的是节点i，所以这里多产生一个
        for(int i = 0 ; i<N+1;i++) {
            nodes[i] = new ArrayList<EdgeNode>();
        }
        for (int i = 0; i < edges.length; i++) {
            // 读取边的起始顶点和结束顶点
            int from = edges[i][0];
            int to = edges[i][1];
            int weight = edges[i][2];

            if (from != to) {

                // 初始化edgeNode
                EdgeNode edgeNode = new EdgeNode(to,weight);
                // 将edgeNode加入到from点的邻接表中
                nodes[from].add(edgeNode);
            }
        }
        return nodes;
    }

    /**
     * 从原点到各顶点的距离
     */
    private static class Path implements Comparable<Path> {
        int to;// 到的点
        int dist;// 从原点出发到to点的距离
        public Path(int to, int dist) {
            this.to = to;
            this.dist = dist;
        }
        @Override
        public int compareTo(Path o) {
            return this.dist-o.dist;
        }
    }

    /**
     * 从S节点到其他各节点的最短路径
     * @param S 起始点
     * @param nodes 所有的节点数组
     * @return 最短距离数组
     */
    public static int[] dijkstra(int S, ArrayList<EdgeNode>[] nodes) {
        boolean[] flag = new boolean[nodes.length];// true表示到i节点的最短距离已经确定
        int[] dist = new int[nodes.length];// 记录从S到i的最短距离
        for(int i = 0 ; i< dist.length;i++) {// 先初始化都不可达
            dist[i] = INF;
        }

        PriorityQueue<Path> paths = new PriorityQueue<>();
        // 初始化
        for (int i = 0; i < nodes[S].size(); i++) {
            EdgeNode edgeNode = nodes[S].get(i);
            paths.add(new Path(edgeNode.to, edgeNode.weight));
        }

        // 对"顶点vs"自身进行初始化
        flag[S] = true;
        dist[S] = 0;

        // 从dist中且flag为false中选择距离最小的
        while (!paths.isEmpty()) {
            Path minPath = paths.poll();
            // 标记"顶点k"为已经获取到最短路径
            flag[minPath.to] = true;
            dist[minPath.to] = minPath.dist;
            // 修正当前最短路径和前驱顶点
            // 即，遍历k的出边，跟新dist[]
            for (int j = 0; j < nodes[minPath.to].size(); j++) {
                EdgeNode edgeNode = nodes[minPath.to].get(j);
                if (flag[edgeNode.to]==false) {
                    int tmpPath = dist[minPath.to] + edgeNode.weight;
                    if (tmpPath < dist[edgeNode.to]) {
                        paths.add(new Path(edgeNode.to, tmpPath));
                    }
                }
            }
        }

        return dist;
    }


    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        String[] ss = sc.nextLine().split(" ");
        int N = Integer.parseInt(ss[0]);
        int M = Integer.parseInt(ss[1]);
        int S = Integer.parseInt(ss[2]);
        int T = Integer.parseInt(ss[3]);
        int[][] edges = new int[M][3];

        for(int i =0 ;i<M;i++) {
            ss = sc.nextLine().split(" ");
            Integer from = Integer.parseInt(ss[0]);
            Integer to = Integer.parseInt(ss[1]);
            Integer weight = Integer.parseInt(ss[2]);
            edges[i] = new int[]{from, to, weight};
        }

        ArrayList<EdgeNode>[] nodes = init(N, edges);
        int[] dist1 = dijkstra(S, nodes);
        int[] dist2 = dijkstra(T, nodes);
        System.out.println(dist1[T] + dist2[S]);


    }
}
