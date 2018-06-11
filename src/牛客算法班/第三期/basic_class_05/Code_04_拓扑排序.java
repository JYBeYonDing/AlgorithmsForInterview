package 牛客算法班.第三期.basic_class_05;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.LinkedList;
import java.util.List;
import java.util.Queue;

/**
 * 依赖的先后顺序
 * 适用范围： 要求有向图， 且有入度为0的节点， 且没有环
 * 在图论中，拓扑排序（Topological Sorting）是一个有向无环图（DAG, Directed Acyclic Graph）的所有顶点的线性序列。
 * 且该序列必须满足下面两个条件：
 * 1.每个顶点出现且只出现一次。
 * 2.若存在一条从顶点 A 到顶点 B 的路径，那么在序列中顶点 A 出现在顶点 B 的前面。
 *
 * 如何写出它的拓扑排序呢？这里说一种比较常用的方法：
 * 1.从 DAG 图中选择一个 没有前驱（即入度为0）的顶点并输出。
 * 2.从图中删除该顶点和所有以它为起点的有向边。
 * 3.重复 1 和 2 直到当前的 DAG 图为空或当前图中不存在无前驱的顶点为止。后一种情况说明有向图中必然存在环。
 */
public class Code_04_拓扑排序 {

	/**
	 * 拓扑排序 一定要是有向无环图
	 * @param graph 图
	 * @return 排序后的节点队列
	 */
	public static List<Node> sortedTopology(Graph graph) {
		HashMap<Node, Integer> inMap = new HashMap<>();// node，入度
		Queue<Node> zeroInQueue = new LinkedList<>();// 入度为0的点
		// 遍历所有的点，登记所有点的入度，找到入度为0的点
		for (Node node : graph.nodes.values()) {
			inMap.put(node, node.in);
			if (node.in == 0) {
				zeroInQueue.add(node);
			}
		}
		List<Node> result = new ArrayList<>();// 存放结果的队列
		while (!zeroInQueue.isEmpty()) {
			Node cur = zeroInQueue.poll();
			result.add(cur);// 入度为0的点放入队列
			for (Node next : cur.nexts) {
				inMap.put(next, inMap.get(next) - 1);// 将该点的所有后继节点的入度-1
				if (inMap.get(next) == 0) {//如果入度变为0，加入到入度为0的队列中
					zeroInQueue.add(next);
				}
			}
		}
		return result;
	}
}
