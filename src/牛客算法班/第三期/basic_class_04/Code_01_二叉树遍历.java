package 牛客算法班.第三期.basic_class_04;

import java.util.ArrayDeque;
import java.util.Stack;

/**
 * 重要！！！特别是只用一个栈的非递归后序遍历
 * 实现二叉树的先序、 中序、 后序遍历， 包括递归方式和非递归方式
 * 如果忽略打印行为，遍历过程中会多次到达一个节点，打印时机放在不同位置就是先序、中序、后序遍历
 * 《程序员代码面试指南》p88
 */
public class Code_01_二叉树遍历 {

	public static class Node {
		public int value;
		public Node left;
		public Node right;

		public Node(int data) {
			this.value = data;
		}
	}

	public static void preOrderRecur(Node head) {
		if (head == null) {
			return;
		}
		System.out.print(head.value + " ");
		preOrderRecur(head.left);
		preOrderRecur(head.right);
	}

	public static void inOrderRecur(Node head) {
		if (head == null) {
			return;
		}
		inOrderRecur(head.left);
		System.out.print(head.value + " ");
		inOrderRecur(head.right);
	}

	public static void posOrderRecur(Node head) {
		if (head == null) {
			return;
		}
		posOrderRecur(head.left);
		posOrderRecur(head.right);
		System.out.print(head.value + " ");
	}

	/**
	 * 非递归版本，每个节点都只访问两次，无法做到递归版本中每个节点访问三次
	 * @param head
	 */
	public static void preOrderUnRecur(Node head) {
		System.out.print("pre-order: ");
		if (head != null) {
			Stack<Node> stack = new Stack<Node>();
			stack.add(head);
			while (!stack.isEmpty()) {
				head = stack.pop();
				System.out.print(head.value + " ");
				if (head.right != null) { // 先压入右
					stack.push(head.right);
				}
				if (head.left != null) {// 后压入左
					stack.push(head.left);
				}
			}
		}
		System.out.println();
	}

	/**
	 * 非递归版 前序遍历 自己写 第二种方法
	 * @param head
	 */
	private static void preOrderUnRecur1(Node head) {
		System.out.print("pre-order1: ");
		if (head == null) {
			return;
		}
		ArrayDeque<Node> stack = new ArrayDeque<>();
		while (!stack.isEmpty() || head != null) {
			while (head != null) {
				System.out.print(head.value + " ");
				stack.push(head);
				head = head.left;
			}
			if (!stack.isEmpty()) {
				head = stack.pop().right;
			}
		}
		System.out.println();
	}

	/**
	 * 中序遍历 非递归
	 * 这个不太好理解，inOrderUnRecur1理解稍微容易点
	 * @param head
	 */
	public static void inOrderUnRecur(Node head) {
		System.out.print("in-order: ");
		if (head != null) {
			Stack<Node> stack = new Stack<Node>();
			while (!stack.isEmpty() || head != null) {
				if (head != null) {// 当前节点一定会把自己的左边界都压到栈里去
					stack.push(head);
					head = head.left;
				} else {// 当前节点为空，从栈中拿出一个打印
					head = stack.pop();
					System.out.print(head.value + " ");
					head = head.right;
				}
			}
		}
		System.out.println();
	}

	/**
	 * 中序遍历，自己写
	 * @param head
	 */
	private static void inOrderUnRecur1(Node head) {
		if (head == null) {
			return;
		}
		ArrayDeque<Node> stack = new ArrayDeque<>();
		while (!stack.isEmpty() || head != null) {
			while (head != null) {
				stack.push(head);
				head = head.left;
			}
			if (!stack.isEmpty()) {
				Node cur = stack.pop();
				System.out.print(cur.value+" ");
				head = cur.right;
			}
		}
		System.out.println();
	}
	/**
	 * 由于在递归的实现中，后序遍历是在第三次访问节点的时候打印，
	 * 然而在非递归实现中只有两次访问，很难做到三个访问，
	 * 为了简单实现，先仿照先序遍历实现 中右左 ， 把它放到栈里，最后弹出栈打印。
	 * @param head
	 */
	public static void posOrderUnRecur1(Node head) {
		System.out.print("pos-order: ");
		if (head != null) {
			Stack<Node> s1 = new Stack<Node>();
			Stack<Node> s2 = new Stack<Node>();// 存打印结果的栈
			s1.push(head);
			while (!s1.isEmpty()) {
				head = s1.pop();
				s2.push(head);
				if (head.left != null) {// 先压左
					s1.push(head.left);
				}
				if (head.right != null) {// 后压右
					s1.push(head.right);
				}
			}
			while (!s2.isEmpty()) {
				System.out.print(s2.pop().value + " ");
			}
		}
		System.out.println();
	}

	/**
	 * 只用一个栈 实现后序遍历 书上有讲解
	 * @param h
	 */
	public static void posOrderUnRecur2(Node h) {
		System.out.print("pos-order: ");
		if (h != null) {
			Stack<Node> stack = new Stack<Node>();
			stack.push(h);
			Node c = null;
			while (!stack.isEmpty()) {
				c = stack.peek();
				if (c.left != null && h != c.left && h != c.right) {// 有左节点，且上一个弹出的节点不是c的左右节点
					stack.push(c.left);
				} else if (c.right != null && h != c.right) {// 有右子树，且上一个弹出的节点不是c的右节点
					stack.push(c.right);// 注意这里在压入右节点时的c和上面压入左节点时的c肯定不是同一个
				} else {// 左右都为空或者左右子树都是遍历过的，
					// 分析：
					// 如果第一个分支判断中h == c.left，进入第二个判断分支，如果有右节点则进入第二步push，不会进入这里，
					// 如果第二个判断分支中c.right == null，那也说明c的左右子树都遍历完了，因为此时只有左子树。
					// 如果第一个分支判断中h == c.right，说明c的左右子树都比遍历完了，因为是先遍历左子树，再遍历右子树的。
					System.out.print(stack.pop().value + " ");
					h = c;
				}
			}
		}
		System.out.println();
	}

	public static void main(String[] args) {
		Node head = new Node(5);
		head.left = new Node(3);
		head.right = new Node(8);
		head.left.left = new Node(2);
		head.left.right = new Node(4);
		head.left.left.left = new Node(1);
		head.right.left = new Node(7);
		head.right.left.left = new Node(6);
		head.right.right = new Node(10);
		head.right.right.left = new Node(9);
		head.right.right.right = new Node(11);

		// recursive
		System.out.println("==============recursive==============");
		System.out.print("pre-order: ");
		preOrderRecur(head);
		System.out.println();
		System.out.print("in-order: ");
		inOrderRecur(head);
		System.out.println();
		System.out.print("pos-order: ");
		posOrderRecur(head);
		System.out.println();

		// unrecursive
		System.out.println("============unrecursive=============");
		preOrderUnRecur(head);
		preOrderUnRecur1(head);
		inOrderUnRecur(head);
		posOrderUnRecur1(head);
		posOrderUnRecur2(head);

	}

}
