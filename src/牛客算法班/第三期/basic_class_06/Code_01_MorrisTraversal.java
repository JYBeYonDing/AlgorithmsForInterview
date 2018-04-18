package 牛客算法班.第三期.basic_class_06;

/**
 * Morris遍历
 * 空间复杂度O(1)，利用了二叉树中的空闲空间
 * 时间复杂度O(N)
 *
 * Morris遍历
 利用Morris遍历实现二叉树的先序， 中序， 后续遍历， 时间复
 杂度O(N)， 额外空间复杂度O(1)。
 *
 * 来到的当前节点记为cur
 * 1）如果cur没有左孩子，cur向右移动(cur = cur.right)
 * 2）如果cur有左孩子，找到cur左子树上最右的节点，记为mostRight
 *       1.如果mostRight的右指针为空，让其指向cur，cur向左移动（cur = cur.left）
 *       2.如果mostRight的右指针指向cur，让其指向空，cur向右移动(cur = cur.right)
 *
 * 有左子树可以来到该节点两次，没有左子树只能来到该节点一次。
 */
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
	 * 递归版
	 * 可以三次到达一个节点
	 * @param head
	 */
	public static void process(Node head) {
		if(head == null) {
			return;
		}
		// 1
		//System.out.println(head.value);
		process(head.left);
		// 2
		//System.out.println(head.value);
		process(head.right);
		// 3
		//System.out.println(head.value);
	}


	/**
	 * 中序遍历
	 * @param head
	 */
	public static void morrisIn(Node head) {
		if (head == null) {
			return;
		}
		Node cur = head;
		Node mostRight = null;
		while (cur != null) {
			mostRight = cur.left;
			if (mostRight != null) {//如果有左子树
				while (mostRight.right != null && mostRight.right != cur) {// 找到左子树最右节点
					mostRight = mostRight.right;
				}
				// mostRight已经变成了左子树上最右节点
				if (mostRight.right == null) { // 说明第一次来到cur
					mostRight.right = cur;
					cur = cur.left;
					continue;
				} else { // 说明第二次来到cur
					mostRight.right = null;
				}
			}
			System.out.print(cur.value + " ");// 没有左子树直接往右蹿，有左子树也是第二次到达后往右蹿时打印
			cur = cur.right;
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
	 * 没有第三次到达怎么做到后序？
	 * 只关心能到达该节点两次的节点
	 * 然后逆序打印其右边界
	 * 最后打印整棵树的右边界
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
					printEdge(cur1.left);// 第二次到达节点时，逆序打印右边界
				}
			}
			cur1 = cur1.right;
		}
		printEdge(head);//单独打印整棵树的右边界
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
