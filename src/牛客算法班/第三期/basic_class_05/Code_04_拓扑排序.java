package 牛客算法班.第三期.basic_class_05;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.LinkedList;
import java.util.List;
import java.util.Queue;

/**
 * 依赖的先后顺序
 * 适用范围： 要求有向图， 且有入度为0的节点， 且没有环
 */
public class Code_04_拓扑排序 {

	// directed graph and no loop 一定要是有向无环图
	public static List<Node> sortedTopology(Graph graph) {
		HashMap<Node, Integer> inMap = new HashMap<>();
		Queue<Node> zeroInQueue = new LinkedList<>();// 入度为0的点
		// 遍历所有的点，登记所有点的入度，找到入度为0的点
		for (Node node : graph.nodes.values()) {
			inMap.put(node, node.in);
			if (node.in == 0) {
				zeroInQueue.add(node);
			}
		}
		List<Node> result = new ArrayList<>();
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
