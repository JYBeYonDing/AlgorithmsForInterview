package 牛客算法班.第三期.basic_class_04;

/**
 * 在二叉树中找到一个节点的后继节点
 * 该结构比普通二叉树节点结构多了一个指向父节点的parent指针。假
 设有一棵Node类型的节点组成的二叉树，树中每个节点的parent指针
 都正确地指向自己的父节点，头节点的parent指向null。只给一个在
 二叉树中的某个节点 node，请实现返回node的后继节点的函数。
 在二叉树的 “中序遍历” 的序列中， node的下一个节点叫作node的后继节点。
 */
public class Code_03_后继节点 {

	public static class Node {
		public int value;
		public Node left;
		public Node right;
		public Node parent;

		public Node(int data) {
			this.value = data;
		}
	}

	public static Node getSuccessorNode(Node node) {
		if (node == null) {
			return node;
		}
		if (node.right != null) {// 如果有右子树，后继一定是右子树上最左的节点
			return getLeftMost(node.right);
		} else {// 如果没有右子树，就是找哪一个节点的左子树以该节点结尾
//			Node parent = node.parent;
//			while (parent != null && parent.left != node) {
//				node = parent;
//				parent = node.parent;
//			}
//			return parent;
			// 我认为上面的代码还可以精简成如下形式
			while (node.parent != null && node.parent.left != node) {
				node = node.parent;
			}
			return node.parent;
		}
	}

	public static Node getLeftMost(Node node) {
		if (node == null) {
			return node;
		}
		while (node.left != null) {
			node = node.left;
		}
		return node;
	}

	public static void main(String[] args) {
		Node head = new Node(6);
		head.parent = null;
		head.left = new Node(3);
		head.left.parent = head;
		head.left.left = new Node(1);
		head.left.left.parent = head.left;
		head.left.left.right = new Node(2);
		head.left.left.right.parent = head.left.left;
		head.left.right = new Node(4);
		head.left.right.parent = head.left;
		head.left.right.right = new Node(5);
		head.left.right.right.parent = head.left.right;
		head.right = new Node(9);
		head.right.parent = head;
		head.right.left = new Node(8);
		head.right.left.parent = head.right;
		head.right.left.left = new Node(7);
		head.right.left.left.parent = head.right.left;
		head.right.right = new Node(10);
		head.right.right.parent = head.right;

		Node test = head.left.left;
		System.out.println(test.value + " next: " + getSuccessorNode(test).value);
		test = head.left.left.right;
		System.out.println(test.value + " next: " + getSuccessorNode(test).value);
		test = head.left;
		System.out.println(test.value + " next: " + getSuccessorNode(test).value);
		test = head.left.right;
		System.out.println(test.value + " next: " + getSuccessorNode(test).value);
		test = head.left.right.right;
		System.out.println(test.value + " next: " + getSuccessorNode(test).value);
		test = head;
		System.out.println(test.value + " next: " + getSuccessorNode(test).value);
		test = head.right.left.left;
		System.out.println(test.value + " next: " + getSuccessorNode(test).value);
		test = head.right.left;
		System.out.println(test.value + " next: " + getSuccessorNode(test).value);
		test = head.right;
		System.out.println(test.value + " next: " + getSuccessorNode(test).value);
		test = head.right.right; // 10's next is null
		System.out.println(test.value + " next: " + getSuccessorNode(test));
	}

}
