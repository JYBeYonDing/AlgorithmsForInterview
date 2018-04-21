package 牛客算法班.第三期.basic_class_04;

import java.util.LinkedList;
import java.util.Queue;

/**
 * 判断一棵树是否是搜索二叉树、 判断一棵树是否是完全二叉树
 * 搜索二叉树不出现相同节点，因为没必要，信息可以包含到一个节点中
 */
public class Code_07_判断是否是搜索二叉树_完全二叉树 {

	public static class Node {
		public int value;
		public Node left;
		public Node right;

		public Node(int data) {
			this.value = data;
		}
	}

	/**
	 * 判断是否是 搜索二叉树
	 * 用的是 Morris遍历方法，可以在面试的时候展现自己能力
	 * 思路：搜索二叉树的中序遍历，后一个数总是大于前一个数
	 * 另外也可以由非递归中序遍历中改，很方便
	 * @param head
	 * @return
	 */
	public static boolean isBST(Node head) {
		if (head == null) {
			return true;
		}
		boolean res = true;// 保存结果
		Node pre = null;
		Node cur = head;
		Node mostRight = null;
		while (cur != null) {
			mostRight = cur.left;
			if (mostRight != null) {// 说明左子树不为空
				while (mostRight.right != null && mostRight.right != cur) {
					mostRight = mostRight.right;// 找到左子树最右节点
				}
				if (mostRight.right == null) {
					// 左子树最右节点的右指针为空，利用这个指针指向cur，即中序遍历过程中mostRight的后继节点
					mostRight.right = cur;
					cur = cur.left;
					continue;// cur向左移动后继续
				} else {
					mostRight.right = null;// 最右节点右指针不为空，说明已经遍历过，恢复到null状态
				}
			}
			if (pre != null && pre.value > cur.value) {
				res = false;// 如果前驱节点大于当前节点，说明不是搜索二叉树
			}
			pre = cur;
			cur = cur.right;
		}
		return res;
	}

	/**
	 * 判断是否是 完全二叉树
	 * 需要按层遍历
	 * @param head
	 * @return
	 */
	public static boolean isCBT(Node head) {
		if (head == null) {
			return true;
		}
		Queue<Node> queue = new LinkedList<Node>();
		boolean leaf = false;// 表示是否开启一个阶段
		Node l = null;
		Node r = null;
		queue.offer(head);
		while (!queue.isEmpty()) {
			head = queue.poll();
			l = head.left;
			r = head.right;
			if ( (leaf && (l != null || r != null))// 开启了右节点的阶段，如果左右有一个不为空就返回false
					|| (l == null && r != null)) {//如果一个节点左孩子为空右孩子不为空直接返回false
				return false;
			}
			if (l != null) {// 其实运行到这里，如果左节点为空，则右节点一定也为空，所以else中设置leaf=true可以省去
				queue.offer(l);
			}
			if (r != null) {
				queue.offer(r);
			} else {
				leaf = true;// 如果有一个右节点为空，就需要开始判断剩下节点的是不是都是叶节点，即左右节点都为空
			}
		}
		return true;
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
//		head.left.left = new Node(1);
		head.left.right = new Node(3);
		head.right.left = new Node(5);

		printTree(head);
		System.out.println(isBST(head));
		System.out.println(isCBT(head));

	}
}