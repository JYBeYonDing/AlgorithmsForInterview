package 牛客算法班.第四期.advanced_class_05;

/**
 * 给定一个数组， 求子数组的最大异或和。
 一个数组的异或和为， 数组中所有的数异或起来的结果。
 */
public class Code_05_Max_EOR {

	/**
	 * 前缀树节点
	 */
	public static class Node {
		public Node[] nexts = new Node[2];// 前缀树，只有两条路，0或1
	}

	public static class NumTrie {
		public Node head = new Node();

		/**
		 * 将num加入到前缀树中
		 */
		public void add(int num) {
			Node cur = head;
			for (int move = 31; move >= 0; move--) {// 从最高位开始提取每一位的数字
				int path = ((num >> move) & 1);
				cur.nexts[path] = cur.nexts[path] == null ? new Node() : cur.nexts[path];
				cur = cur.nexts[path];
			}
		}

		public int maxXor(int num) {
			Node cur = head;
			int res = 0;
			for (int move = 31; move >= 0; move--) {
				int path = (num >> move) & 1;
				int best = move == 31 ? path : (path ^ 1);// 如果是符号位，希望选的值和符号位一样这样可以得到正数，否则选不一样可以得到1
				best = cur.nexts[best] != null ? best : (best ^ 1);// 如果有则选择这条边，如果没有则只能选择另外的边
				res |= (path ^ best) << move;// 设置答案的每一位
				cur = cur.nexts[best];// 继续往下走
			}
			return res;
		}

	}

	public static int maxXorSubarray(int[] arr) {
		if (arr == null || arr.length == 0) {
			return 0;
		}
		int max = Integer.MIN_VALUE;
		int eor = 0;
		NumTrie numTrie = new NumTrie();
		numTrie.add(0);
		for (int i = 0; i < arr.length; i++) {
			eor ^= arr[i];
			max = Math.max(max, numTrie.maxXor(eor));
			numTrie.add(eor);
		}
		return max;
	}

	// for test
	public static int comparator(int[] arr) {
		if (arr == null || arr.length == 0) {
			return 0;
		}
		int max = Integer.MIN_VALUE;
		for (int i = 0; i < arr.length; i++) {
			int eor = 0;
			for (int j = i; j < arr.length; j++) {
				eor ^= arr[j];
				max = Math.max(max, eor);
			}
		}
		return max;
	}

	// for test
	public static int[] generateRandomArray(int maxSize, int maxValue) {
		int[] arr = new int[(int) ((maxSize + 1) * Math.random())];
		for (int i = 0; i < arr.length; i++) {
			arr[i] = (int) ((maxValue + 1) * Math.random()) - (int) (maxValue * Math.random());
		}
		return arr;
	}

	// for test
	public static void printArray(int[] arr) {
		if (arr == null) {
			return;
		}
		for (int i = 0; i < arr.length; i++) {
			System.out.print(arr[i] + " ");
		}
		System.out.println();
	}

	// for test
	public static void main(String[] args) {
		int testTime = 500000;
		int maxSize = 30;
		int maxValue = 50;
		boolean succeed = true;
		for (int i = 0; i < testTime; i++) {
			int[] arr = generateRandomArray(maxSize, maxValue);
			int res = maxXorSubarray(arr);
			int comp = comparator(arr);
			if (res != comp) {
				succeed = false;
				printArray(arr);
				System.out.println(res);
				System.out.println(comp);
				break;
			}
		}
		System.out.println(succeed ? "Nice!" : "Fucking fucked!");
	}
}
