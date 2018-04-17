package 牛客算法班.第三期.basic_class_05;

import java.util.HashSet;
import java.util.Stack;

/**
 * 深度优先遍历
 * 一遍路上都走完才返回
 * 用栈实现
 */
public class Code_03_深度优先遍历 {

	/**
	 * 深度优先遍历
	 * 用栈
	 * 遍历的结果可能有多种
	 * @param node 节点
	 */
	public static void dfs(Node node) {
		if (node == null) {
			return;
		}
		Stack<Node> stack = new Stack<>();
		HashSet<Node> set = new HashSet<>();// 表示点进没进过这个栈，就是一个注册
		stack.add(node);
		set.add(node);
		System.out.println(node.value);
		while (!stack.isEmpty()) {
			Node cur = stack.pop();
			for (Node next : cur.nexts) {// 遍历弹出节点的后继节点
				if (!set.contains(next)) {
					// 如果有后续节点有一个没有被遍历过，就将当前节点和没有遍历的后序节点放入，break
					stack.push(cur);
					stack.push(next);
					set.add(next);// 注册
					System.out.println(next.value);
					break;
				}
			}
		}
	}

}
