package 牛客算法班.第三期.basic_class_02;

/**
 * 子树包含问题
 * 将树序列化，注意：序列化时需要将空子节点也表示出来，节点之间还需要有分隔符
 * 用KMP字符串匹配问题解决子树包含问题
 */
public class Code_03_KMP_子树包含 {

	public static class Node {
		public int value;
		public Node left;
		public Node right;

		public Node(int data) {
			this.value = data;
		}
	}

	public static boolean isSubtree(Node t1, Node t2) {
		String t1Str = serialByPre(t1);
		String t2Str = serialByPre(t2);
		return getIndexOf(t1Str, t2Str) != -1;
	}

	public static String serialByPre(Node head) {
		if (head == null) {
			return "#!";
		}
		String res = head.value + "!";
		res += serialByPre(head.left);
		res += serialByPre(head.right);
		return res;
	}

	// KMP
	public static int getIndexOf(String s, String m) {
		if (s == null || m == null || m.length() < 1 || s.length() < m.length()) {
			return -1;
		}
		char[] ss = s.toCharArray();
		char[] ms = m.toCharArray();
		int[] nextArr = getNextArray(ms);
		int index = 0;
		int mi = 0;
		while (index < ss.length && mi < ms.length) {
			if (ss[index] == ms[mi]) {
				index++;
				mi++;
			} else if (nextArr[mi] == -1) {
				index++;
			} else {
				mi = nextArr[mi];
			}
		}
		return mi == ms.length ? index - mi : -1;
	}

	public static int[] getNextArray(char[] ms) {
		if (ms.length == 1) {
			return new int[] { -1 };
		}
		int[] nextArr = new int[ms.length];
		nextArr[0] = -1;
		nextArr[1] = 0;
		int pos = 2;
		int cn = 0;
		while (pos < nextArr.length) {
			if (ms[pos - 1] == ms[cn]) {
				nextArr[pos++] = ++cn;
			} else if (cn > 0) {
				cn = nextArr[cn];
			} else {
				nextArr[pos++] = 0;
			}
		}
		return nextArr;
	}

	public static void main(String[] args) {
		Node t1 = new Node(1);
		t1.left = new Node(2);
		t1.right = new Node(3);
		t1.left.left = new Node(4);
		t1.left.right = new Node(5);
		t1.right.left = new Node(6);
		t1.right.right = new Node(7);
		t1.left.left.right = new Node(8);
		t1.left.right.left = new Node(9);

		Node t2 = new Node(2);
		t2.left = new Node(4);
		t2.left.right = new Node(8);
		t2.right = new Node(5);
		t2.right.left = new Node(9);

		System.out.println(isSubtree(t1, t2));

	}

}
