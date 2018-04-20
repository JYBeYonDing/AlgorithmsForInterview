package 牛客算法班.第三期.basic_class_04;

import java.util.Comparator;
import java.util.PriorityQueue;

/**
 * 代价数组cost[n]
 * 利润数组profit[n] ：纯利润
 * 启动资金：m
 * 一次只能做一个项目
 * 最多只能做k个项目
 *
 * 输入： 参数1， 正数数组costs 参数2， 正数数组profits 参数3，正数k 参数4， 正数m
 costs[i]表示i号项目的花费 profits[i]表示i号项目在扣除花
 费之后还能挣到的钱(利润) k表示你不能并行、 只能串行的最多
 做k个项目 m表示你初始的资金
 说明： 你每做完一个项目， 马上获得的收益， 可以支持你去做下一个项目。
 输出： 你最后获得的最大钱数


 建一个按花费排序的小根堆
 依次弹出花费比资金低的项目
 放入按收益排序的大根堆
 选择大根堆的堆顶的项目

 这就需要自己建一个新的数据结构，包含项目的花费和利润。

 贪心问题用堆比较多，因为不用完全排序，只需要知道最大或最小就可以了。
 */
public class Code_03_项目利润IPO {
	public static class Node {
		public int p;//收益
		public int c;//花费

		public Node(int p, int c) {
			this.p = p;
			this.c = c;
		}
	}

	public static class MinCostComparator implements Comparator<Node> {

		@Override
		public int compare(Node o1, Node o2) {
			return o1.c - o2.c;
		}

	}

	public static class MaxProfitComparator implements Comparator<Node> {

		@Override
		public int compare(Node o1, Node o2) {
			return o2.p - o1.p;
		}

	}

	/**
	 * 获得最大收益
	 * @param k 最多做k个项目
	 * @param W 启动资金
	 * @param Profits 利润数组
	 * @param Capital 花费数组
	 * @return
	 */
	public static int findMaximizedCapital(int k, int W, int[] Profits, int[] Capital) {
		Node[] nodes = new Node[Profits.length];
		for (int i = 0; i < Profits.length; i++) {
			nodes[i] = new Node(Profits[i], Capital[i]);
		}

		PriorityQueue<Node> minCostQ = new PriorityQueue<>(new MinCostComparator());//花费小根堆
		PriorityQueue<Node> maxProfitQ = new PriorityQueue<>(new MaxProfitComparator());//利润大根堆
		for (int i = 0; i < nodes.length; i++) {
			minCostQ.add(nodes[i]);
		}
		for (int i = 0; i < k; i++) {
			while (!minCostQ.isEmpty() && minCostQ.peek().c <= W) {
				maxProfitQ.add(minCostQ.poll());
			}
			if (maxProfitQ.isEmpty()) {// 如果无项目可做，返回
				return W;
			}
			W += maxProfitQ.poll().p;
		}
		return W;
	}

}
