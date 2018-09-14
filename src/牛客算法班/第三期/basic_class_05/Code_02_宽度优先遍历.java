package 牛客算法班.第三期.basic_class_05;

import java.util.ArrayList;
import java.util.HashSet;
import java.util.LinkedList;
import java.util.Queue;

public class Code_02_宽度优先遍历 {

	/**
	 * 宽度优先遍历，用队列 只需要node信息
	 * 用队列实现
	 * @param node
	 */
	public static void bfs(Node node) {
		if (node == null) {
			return;
		}
		Queue<Node> queue = new LinkedList<>();
		HashSet<Node> set = new HashSet<>();// 表示点进没进过这个队列，就是一个注册
		queue.add(node);
		set.add(node);
		while (!queue.isEmpty()) {
			// 弹出并打印
			Node cur = queue.poll();
			System.out.println(cur.value);
			// 加入从cur节点出发的没有注册过的所有节点，并且在set中注册
			for (Node next : cur.nexts) {
				if (!set.contains(next)) {// 没有注册过的才放入队列中并注册
					set.add(next);
					queue.add(next);
				}
			}
		}
	}


	private class Node {
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
	}

}
