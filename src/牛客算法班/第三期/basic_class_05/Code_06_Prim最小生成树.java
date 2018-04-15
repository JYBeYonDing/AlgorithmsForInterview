package 牛客算法班.第三期.basic_class_05;

import java.util.Comparator;
import java.util.HashSet;
import java.util.PriorityQueue;
import java.util.Set;

// undirected graph only 只能是无向图
public class Code_06_Prim最小生成树 {

	public static class EdgeComparator implements Comparator<Edge> {

		@Override
		public int compare(Edge o1, Edge o2) {
			return o1.weight - o2.weight;
		}

	}

	/**
	 * prim 算法 按点来考查
	 * 点一个一个进来，所以不需要并查集，用一个set就行
	 * @param graph
	 * @return
	 */
	public static Set<Edge> primMST(Graph graph) {
		PriorityQueue<Edge> priorityQueue = new PriorityQueue<>(new EdgeComparator());
		HashSet<Node> set = new HashSet<>();
		Set<Edge> result = new HashSet<>();
		for (Node node : graph.nodes.values()) {
			// 如果给的图是 一个森林 ，即本身就不是都连在一起的，需要上面的for循环
			// 如果给定的本来就是一个连通图，则不需要上面的for循环
			if (!set.contains(node)) {
				set.add(node);
				// 将节点的所有边加入到优先级队列中
				for (Edge edge : node.edges) {
					priorityQueue.add(edge);
				}
				while (!priorityQueue.isEmpty()) {
					Edge edge = priorityQueue.poll();// 弹出 权重最小的边
					Node toNode = edge.to;
					if (!set.contains(toNode)) {// 如果集合中没有该节点，将节点加入，解锁该节点的所有边
						set.add(toNode);
						result.add(edge);
						for (Edge nextEdge : node.edges) {
							priorityQueue.add(nextEdge);
						}
					}
				}
			}
		}
		return result;
	}

}
