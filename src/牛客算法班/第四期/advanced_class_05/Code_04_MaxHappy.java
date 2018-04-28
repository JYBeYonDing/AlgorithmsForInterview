package 牛客算法班.第四期.advanced_class_05;

import com.sun.org.apache.regexp.internal.RE;

import java.util.ArrayList;
import java.util.List;

/**
 * 一个公司的上下节关系是一棵多叉树， 这个公司要举办晚会， 你作为组织者已经摸清了大家的心理： 一个员工的直
 接上级如果到场， 这个员工肯定不会来。 每个员工都有一个活跃度的值， 决定谁来你会给这个员工发邀请函， 怎么
 让舞会的气氛最活跃？ 返回最大的活跃值。
 举例：
 给定一个矩阵来表述这种关系
 matrix =
 { 1,6
 1,5
 1,4
 }
 这个矩阵的含义是：
 matrix[0] = {1 , 6}， 表示0这个员工的直接上级为1,0这个员工自己的活跃度为6
 matrix[1] = {1 , 5}， 表示1这个员工的直接上级为1（他自己是这个公司的最大boss）,1这个员工自己的活跃度为5
 matrix[2] = {1 , 4}， 表示2这个员工的直接上级为1,2这个员工自己的活跃度为4
 为了让晚会活跃度最大，应该让1不来， 0和2来。 最后返回活跃度为10


树形DP，在树上做动态规划，比普通的动态规划还简单
 难点在于 分析可能性
 先分析可能性，先搞小树，再搞大树，
 可能性分析完后列信息全集，
 定返回值类型结构
 代码中默认每个子树都给出这样的信息，
 由这些自信息加工出新的信息，
 注意点：Base Case
 */
public class Code_04_MaxHappy {

	//多叉树的节点
	private static class Node{
		public int huo;// 活跃度
		public List<Node> nexts;// 下一级

		public Node(int huo) {
			this.huo = huo;
			nexts = new ArrayList<>();
		}
	}

	/**
	 * 主函数
	 */
	private static int getMaxHuo(Node head) {
		ReturnData data = process(head);
		return Math.max(data.lai_huo, data.bu_lai_huo);
	}

	//求一个节点为头的可能性

	/**
	 * 可能性1：该节点来的活跃度=该节点所有子节点不来的活跃度之和
	 * 可能性2：该节点不来的活跃度=子节点1来与不来的活跃度中最大值+子节点2来与不来的活跃度中最大值+...
	 */
	//返回体
	private static class ReturnData {
		public int lai_huo;
		public int bu_lai_huo;

		public ReturnData(int lai_huo, int bu_lai_huo) {
			this.lai_huo = lai_huo;
			this.bu_lai_huo = bu_lai_huo;
		}
	}

	private static ReturnData process(Node head) {
		int lai_huo = head.huo;
		int bu_lai_huo = 0;

		for(int i=0;i<head.nexts.size();i++) {
			Node next = head.nexts.get(i);
			ReturnData nextData = process(next);
			lai_huo += nextData.bu_lai_huo;
			bu_lai_huo += Math.max(nextData.lai_huo, nextData.bu_lai_huo);
		}

		return new ReturnData(lai_huo, bu_lai_huo);
	}


	/**
	 ******************************************************************
	 * 数组动态规划方法
	 ******************************************************************
	 */

	private static int maxHappy(int[][] matrix) {
		int[][] dp = new int[matrix.length][2];
		boolean[] visited = new boolean[matrix.length];
		int root = 0;
		for (int i = 0; i < matrix.length; i++) {
			if (i == matrix[i][0]) {
				root = i;
			}
		}
		process(matrix, dp, visited, root);
		return Math.max(dp[root][0], dp[root][1]);
	}

	private static void process(int[][] matrix, int[][] dp, boolean[] visited, int root) {
		visited[root] = true;
		dp[root][1] = matrix[root][1];
		for (int i = 0; i < matrix.length; i++) {
			if (matrix[i][0] == root && !visited[i]) {
				process(matrix, dp, visited, i);
				dp[root][1] += dp[i][0];
				dp[root][0] += Math.max(dp[i][1], dp[i][0]);
			}
		}
	}

	public static void main(String[] args) {
		int[][] matrix = { { 1, 8 }, { 1, 9 }, { 1, 10 } };
		System.out.println(maxHappy(matrix));
	}
}
