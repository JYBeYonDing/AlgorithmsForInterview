package 牛客算法班.第三期.basic_class_04;

/**
 * 已知一棵完全二叉树， 求其节点的个数
 要求： 时间复杂度低于O(N)， N为这棵树的节点个数
 */
public class Code_08_完全二叉树节点个数 {

	public static class Node {
		public int value;
		public Node left;
		public Node right;

		public Node(int data) {
			this.value = data;
		}
	}

	/**
	 * 主函数
	 * @param head 完全二叉树的头结点
	 * @return 完全二叉树节点个数
	 */
	public static int nodeNum(Node head) {
		if (head == null) {
			return 0;
		}
		return bs(head, 1, mostLeftLevel(head, 1));
	}

	/**
	 *
	 * @param node 当前节点
	 * @param level 当前节点在第几层
	 * @param h 树的最大高度
	 * @return 以node为头的整棵树的节点个数
	 */
	public static int bs(Node node, int level, int h) {
		if (level == h) {// 叶节点返回1
			return 1;
		}
		if (mostLeftLevel(node.right, level + 1) == h) {// 右子树的深度是否到达最大深度
			return (1 << (h - level)) + bs(node.right, level + 1, h);// 达到最大深度，说明左子树是满二叉树
		} else {// 没达到最大深度说明右子树一定是满二叉树
			return (1 << (h - level - 1)) + bs(node.left, level + 1, h);
		}
	}

	/**
	 *
	 * @param node 当前节点
	 * @param level 当前节点处在第几层
	 * @return 整棵树的高度
	 */
	public static int mostLeftLevel(Node node, int level) {
		while (node != null) {
			level++;
			node = node.left;
		}
		return level - 1;
	}

	public static void main(String[] args) {
		Node head = new Node(1);
		head.left = new Node(2);
		head.right = new Node(3);
		head.left.left = new Node(4);
		head.left.right = new Node(5);
		head.right.left = new Node(6);
		System.out.println(nodeNum(head));

	}

}
