package 牛客算法基础班.basic_class_05;

import java.util.HashSet;
import java.util.Stack;

public class Code_03_深度优先遍历 {

	/**
	 * 深度优先遍历 用栈
	 * 遍历的结果可能有多种
	 * @param node 节点
	 */
	public static void dfs(Node node) {
		if (node == null) {
			return;
		}
		Stack<Node> stack = new Stack<>();
		HashSet<Node> set = new HashSet<>();
		stack.add(node);
		set.add(node);
		System.out.println(node.value);
		while (!stack.isEmpty()) {
			Node cur = stack.pop();
			for (Node next : cur.nexts) {
				if (!set.contains(next)) {
					// 如果有后续节点没有比遍历过，将当前节点和后序节点放入，遍历后序节点，break
					stack.push(cur);
					stack.push(next);
					set.add(next);
					System.out.println(next.value);
					break;
				}
			}
		}
	}

}
