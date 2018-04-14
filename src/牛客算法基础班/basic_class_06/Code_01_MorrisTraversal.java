package 牛客算法基础班.basic_class_06;

public class Code_01_MorrisTraversal {

	public static class Node {
		public int value;
		Node left;
		Node right;

		public Node(int data) {
			this.value = data;
		}
	}

	/**
	 * 中序遍历
	 * @param head
	 */
	public static void morrisIn(Node head) {
		if (head == null) {
			return;
		}
		Node cur1 = head;
		Node cur2 = null;
		while (cur1 != null) {
			cur2 = cur1.left;
			if (cur2 != null) {//如果有左子树
				while (cur2.right != null && cur2.right != cur1) {// 找到左子树最右节点
					cur2 = cur2.right;
				}
				// cur2已经变成了左子树上最右节点
				if (cur2.right == null) { // 说明第一次来到cur1
					cur2.right = cur1;
					cur1 = cur1.left;
					continue;
				} else { // 说明第二次来到cur1
					cur2.right = null;
				}
			}
			System.out.print(cur1.value + " ");// 没有左子树直接往右蹿，有左子树也是第二次到达后往右蹿时打印
			cur1 = cur1.right;
		}
		System.out.println();
	}

	/**
	 * 先序遍历
	 * @param head
	 */
	public static void morrisPre(Node head) {
		if (head == null) {
			return;
		}
		Node cur1 = head;
		Node cur2 = null;
		while (cur1 != null) {
			cur2 = cur1.left;
			if (cur2 != null) {
				while (cur2.right != null && cur2.right != cur1) {
					cur2 = cur2.right;
				}
				if (cur2.right == null) {
					cur2.right = cur1;
					System.out.print(cur1.value + " ");// 第一次来到节点 打印
					cur1 = cur1.left;
					continue;
				} else {
					cur2.right = null;
				}
			} else {
				System.out.print(cur1.value + " ");//没有左子树直接打印当前节点
			}
			cur1 = cur1.right;
		}
		System.out.println();
	}

	/**
	 * 后序遍历
	 * @param head
	 */
	public static void morrisPos(Node head) {
		if (head == null) {
			return;
		}
		Node cur1 = head;
		Node cur2 = null;
		while (cur1 != null) {
			cur2 = cur1.left;
			if (cur2 != null) {
				while (cur2.right != null && cur2.right != cur1) {
					cur2 = cur2.right;
				}
				if (cur2.right == null) {
					cur2.right = cur1;
					cur1 = cur1.left;
					continue;
				} else {
					cur2.right = null;
					printEdge(cur1.left);
				}
			}
			cur1 = cur1.right;
		}
		printEdge(head);//单独打印最后的右边界
		System.out.println();
	}

	public static void printEdge(Node head) {
		Node tail = reverseEdge(head);//右边界链表逆序
		Node cur = tail;
		while (cur != null) {
			System.out.print(cur.value + " ");
			cur = cur.right;
		}
		reverseEdge(tail);//右边界链表调回来
	}

	public static Node reverseEdge(Node from) {
		Node pre = null;
		Node next = null;
		while (from != null) {
			next = from.right;
			from.right = pre;
			pre = from;
			from = next;
		}
		return pre;
	}

	// for test -- print tree
	public static void printTree(Node head) {
		System.out.println("Binary Tree:");
		printInOrder(head, 0, "H", 17);
		System.out.println();
	}

	public static void printInOrder(Node head, int height, String to, int len) {
		if (head == null) {
			return;
		}
		printInOrder(head.right, height + 1, "v", len);
		String val = to + head.value + to;
		int lenM = val.length();
		int lenL = (len - lenM) / 2;
		int lenR = len - lenM - lenL;
		val = getSpace(lenL) + val + getSpace(lenR);
		System.out.println(getSpace(height * len) + val);
		printInOrder(head.left, height + 1, "^", len);
	}

	public static String getSpace(int num) {
		String space = " ";
		StringBuffer buf = new StringBuffer("");
		for (int i = 0; i < num; i++) {
			buf.append(space);
		}
		return buf.toString();
	}

	public static void main(String[] args) {
		Node head = new Node(4);
		head.left = new Node(2);
		head.right = new Node(6);
		head.left.left = new Node(1);
		head.left.right = new Node(3);
		head.right.left = new Node(5);
		head.right.right = new Node(7);
		printTree(head);
		morrisIn(head);
		morrisPre(head);
		morrisPos(head);
		printTree(head);

	}

}
