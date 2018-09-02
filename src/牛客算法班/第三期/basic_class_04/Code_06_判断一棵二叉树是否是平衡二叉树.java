package 牛客算法班.第三期.basic_class_04;

/**
 * 判断一棵二叉树是否是平衡二叉树
 *
 * 套路：递归遍历二叉树时，一个节点会被访问三次，
 * 第一次是先到达这个节点，
 * 第二次是遍历完左子树后访问这个节点，
 * 第三次是遍历完右子树后访问这个节点。
 *
 * 可以在遍历左右子树时，收集左右子树的信息。
 * 树形DP 树形动态规划
 */
public class Code_06_判断一棵二叉树是否是平衡二叉树 {

	public static class Node {
		public int value;
		public Node left;
		public Node right;

		public Node(int data) {
			this.value = data;
		}
	}

	/**
	 * 收集信息的数据结构
	 */
	public static class ReturnData {
		public boolean isB;
		public int h;

		public ReturnData(boolean isB, int h) {
			this.isB = isB;
			this.h = h;
		}
	}

	public static ReturnData process(Node head) {
		if (head == null) {
			return new ReturnData(true, 0);
		}
		ReturnData leftData = process(head.left);
		if (!leftData.isB) {// 如果左子树不平衡，直接返回
			return new ReturnData(false, 0);
		}
		ReturnData rightData = process(head.right);
		if (!rightData.isB) {// 如果右子树不平衡，直接返回
			return new ReturnData(false, 0);
		}
		if (Math.abs(leftData.h - rightData.h) > 1) {// 如果左右子树高度差大于1，直接返回
			return new ReturnData(false, 0);
		}
		return new ReturnData(true, Math.max(leftData.h, rightData.h) + 1);
	}

	public static boolean isB(Node head) {
		return process(head).isB;
	}





	/**
	 * 另一种方式
	 */
	public static boolean isBalance(Node head) {
		boolean[] res = new boolean[1];// 引用变量，记录结果
		res[0] = true;
		getHeight(head, 1, res);
		return res[0];
	}

	public static int getHeight(Node head, int level, boolean[] res) {
		if (head == null) {
			return level;
		}
		int lH = getHeight(head.left, level + 1, res);
		if (!res[0]) {
			return level;
		}
		int rH = getHeight(head.right, level + 1, res);
		if (!res[0]) {
			return level;
		}
		if (Math.abs(lH - rH) > 1) {
			res[0] = false;
		}
		return Math.max(lH, rH);
	}

	public static void main(String[] args) {
		Node head = new Node(1);
		head.left = new Node(2);
		head.right = new Node(3);
		head.left.left = new Node(4);
		head.left.right = new Node(5);
		head.right.left = new Node(6);
		head.right.right = new Node(7);

		System.out.println(isBalance(head));

	}

}
