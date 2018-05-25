package 牛客网.模拟五月场;

import java.util.*;

/**
 * Created by 杨杰 on 2018/5/23 19:55.
 * 牛牛的快递到了，他迫不及待地想去取快递，
 * 但是天气太热了，以至于牛牛不想在烈日下多走一步。
 * 他找来了你，请你帮他规划一下，他最少要走多少距离才能取回快递。
 输入描述:
 每个输入包含一个测试用例。
 输入的第一行包括四个正整数，
 表示位置个数N(2<=N<=10000)，
 道路条数M(1<=M<=100000)，
 起点位置编号S(1<=S<=N)和快递位置编号T(1<=T<=N)。
 位置编号从1到N，道路是单向的。
 数据保证S≠T，保证至少存在一个方案可以从起点位置出发到达快递位置再返回起点位置。
 接下来M行，每行包含三个正整数，
 表示当前道路的起始位置的编号U(1<=U<=N)，当前道路通往的位置的编号V(1<=V<=N)和当前道路的距离D(1<=D<=1000)。
 输出描述:
 对于每个用例，在单独的一行中输出从起点出发抵达快递位置再返回起点的最短距离。
 示例1
 输入
3 3 1 3
1 2 3
2 3 3
3 1 1
 输出
 7

 没有AC 复杂度太大
 */
public class 牛牛取快递复杂度太大 {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        String[] ss = sc.nextLine().split(" ");
        int N = Integer.parseInt(ss[0]);
        int M = Integer.parseInt(ss[1]);
        int S = Integer.parseInt(ss[2]);
        int T = Integer.parseInt(ss[3]);

        Graph graph = new Graph();

        for(int i =0 ;i<M;i++) {
            ss = sc.nextLine().split(" ");

            Integer from = Integer.parseInt(ss[0]);
            Integer to = Integer.parseInt(ss[1]);
            Integer weight = Integer.parseInt(ss[2]);
            // 如果点没有，则新建
            if (!graph.nodes.containsKey(from)) {
                graph.nodes.put(from, new Node(from));
            }
            if (!graph.nodes.containsKey(to)) {
                graph.nodes.put(to, new Node(to));
            }

            Node fromNode = graph.nodes.get(from);
            Node toNode = graph.nodes.get(to);
            Edge newEdge = new Edge(weight, fromNode, toNode);// 建立新的边
            fromNode.nexts.add(toNode);
            fromNode.out++;
            toNode.in++;
            fromNode.edges.add(newEdge);
            graph.edges.add(newEdge);
        }
        HashMap<Node, Integer> res1 = dijkstra(graph.nodes.get(S),graph.nodes.get(T));
        int to = res1.get(graph.nodes.get(T));
        HashMap<Node, Integer> res2 = dijkstra(graph.nodes.get(T),graph.nodes.get(S));
        int turn = res2.get(graph.nodes.get(S));
        System.out.println(turn+to);
    }


    public static HashMap<Node, Integer> dijkstra(Node head,Node dis) {
        HashMap<Node, Integer> distanceMap = new HashMap<>();// 记录结果的hashMap
        distanceMap.put(head, 0);
        HashSet<Node> selectedNodes = new HashSet<>();// 包含在这个集合中的点说明从原点到该点的最短距离已经确定了

        Node minNode = getMinDistanceAndUnselectedNode(distanceMap, selectedNodes);// 从distanceMap中但是没有松弛完毕的点中寻找距离原点最近的点
        while (minNode != null) {
            selectedNodes.add(minNode);// 进行登记，说明确定了从原点到该节点的最短距离
            int distance = distanceMap.get(minNode);//从原点到该点的距离
            if (dis.equals(minNode)) {
                break;
            }
            for (Edge edge : minNode.edges) {// 遍历从该点出来的所有边，进行松弛操作
                Node toNode = edge.to;
                if (!distanceMap.containsKey(toNode)) {// 将没有访问过的点放入distanceMap中
                    distanceMap.put(toNode, distance + edge.weight);
                }
                distanceMap.put(edge.to, Math.min(distanceMap.get(toNode), distance + edge.weight));
            }
            minNode = getMinDistanceAndUnselectedNode(distanceMap, selectedNodes);
        }
        return distanceMap;
    }

    public static Node getMinDistanceAndUnselectedNode(HashMap<Node, Integer> distanceMap, HashSet<Node> touchedNodes) {
        Node minNode = null;
        int minDistance = Integer.MAX_VALUE;
        // 遍历distanceMap中的每个点，从没有确定最短距离的点中选择距原点最近的点
        for (Map.Entry<Node, Integer> entry : distanceMap.entrySet()) {
            Node node = entry.getKey();
            int distance = entry.getValue();
            if (!touchedNodes.contains(node) && distance < minDistance) {
                minNode = node;
                minDistance = distance;
            }
        }
        return minNode;
    }

    static class Node {
        public int value;
        public int in;// 入度
        public int out;// 出度
        public ArrayList<Node> nexts;// 从我出发能到达的所有节点
        public ArrayList<Edge> edges;// 从我出发的所有边

        public Node(int value) {
            this.value = value;
            in = 0;
            out = 0;
            nexts = new ArrayList<>();
            edges = new ArrayList<>();
        }

        @Override
        public boolean equals(Object obj) {
            return this.value==((Node)obj).value;
        }
    }

    static class Edge {
        public int weight;
        public Node from;
        public Node to;

        public Edge(int weight, Node from, Node to) {
            this.weight = weight;
            this.from = from;
            this.to = to;
        }

    }

    static class Graph {
        public HashMap<Integer,Node> nodes;// 点的编号，实际的node
        public HashSet<Edge> edges;

        public Graph() {
            nodes = new HashMap<>();
            edges = new HashSet<>();
        }
    }
}
