package 牛客算法班.第三期.basic_class_05;

import java.util.HashSet;
import java.util.LinkedList;
import java.util.Queue;

public class Code_02_宽度优先遍历 {

	/**
	 * 宽度优先遍历，用队列 只需要node信息
	 * @param node
	 */
	public static void bfs(Node node) {
		if (node == null) {
			return;
		}
		Queue<Node> queue = new LinkedList<>();
		HashSet<Node> set = new HashSet<>();
		queue.add(node);
		set.add(node);
		while (!queue.isEmpty()) {
			// 弹出并打印
			Node cur = queue.poll();
			System.out.println(cur.value);
			// 加入从cur节点出发的所有节点
			for (Node next : cur.nexts) {
				if (!set.contains(next)) {
					set.add(next);
					queue.add(next);
				}
			}
		}
	}

}
