package 牛客算法班.第三期.basic_class_05;

import java.util.Collection;
import java.util.Comparator;
import java.util.HashMap;
import java.util.HashSet;
import java.util.PriorityQueue;
import java.util.Set;

/**
 * 给定一个无方向的带权图G=(V, E)，最小生成树为集合T,
 * T是以最小代价连接V中所有顶点所用边E的最小集合。
 * 集合T中的边能够形成一颗树，这是因为每个节点（除了根节点）都能向上找到它的一个父节点。
 *
 * Kruskal
 * 只能是无向图
 * 依次考察小权重的边，如果没有形成回路就要，否则不要
 * 使用 并查集
 */
public class Code_05_Kruskal最小生成树 {

	public static class EdgeComparator implements Comparator<Edge> {

		@Override
		public int compare(Edge o1, Edge o2) {
			return o1.weight - o2.weight;
		}

	}

	/**
	 * Kruskal算法由 并查集 实现
	 * @param graph 图
	 * @return 最小生成树 边的集合
	 */
	public static Set<Edge> kruskalMST(Graph graph) {
		UnionFind unionFind = new UnionFind();
		unionFind.makeSets(graph.nodes.values());//所有的点变成并查集中的小集合
		// 按 边的权重 组成一个 小根堆
		PriorityQueue<Edge> priorityQueue = new PriorityQueue<>(new EdgeComparator());
		for (Edge edge : graph.edges) {
			priorityQueue.add(edge);
		}

		Set<Edge> result = new HashSet<>();// 结果，用于存放 边的集合
		while (!priorityQueue.isEmpty()) {
			Edge edge = priorityQueue.poll();
			// 如果 边的两个端点已经连通，则不用考虑， 否则将边加入结果的集合中，同时将端点在并查集中连通
			if (!unionFind.isSameSet(edge.from, edge.to)) {
				result.add(edge);
				unionFind.union(edge.from, edge.to);
			}
		}
		return result;
	}


	// Union-Find Set
	public static class UnionFind {
		private HashMap<Node, Node> fatherMap;
		private HashMap<Node, Integer> rankMap;

		public UnionFind() {
			fatherMap = new HashMap<Node, Node>();
			rankMap = new HashMap<Node, Integer>();
		}

		private Node findFather(Node n) {
			Node father = fatherMap.get(n);
			if (father != n) {
				father = findFather(father);
			}
			fatherMap.put(n, father);
			return father;
		}

		public void makeSets(Collection<Node> nodes) {
			fatherMap.clear();
			rankMap.clear();
			for (Node node : nodes) {
				fatherMap.put(node, node);
				rankMap.put(node, 1);
			}
		}

		public boolean isSameSet(Node a, Node b) {
			return findFather(a) == findFather(b);
		}

		public void union(Node a, Node b) {
			if (a == null || b == null) {
				return;
			}
			Node aFather = findFather(a);
			Node bFather = findFather(b);
			if (aFather != bFather) {
				int aFrank = rankMap.get(aFather);
				int bFrank = rankMap.get(bFather);
				if (aFrank <= bFrank) {
					fatherMap.put(aFather, bFather);
					rankMap.put(bFather, aFrank + bFrank);
				} else {
					fatherMap.put(bFather, aFather);
					rankMap.put(aFather, aFrank + bFrank);
				}
			}
		}
	}

}
