package 牛客算法班.第三期.advanced_class_06;

/**
 * 子数组的最大累加和问题
 【题目】
 给定一个数组arr， 返回子数组的最大累加和。 并且可以做到长度是最长的。
 例如， arr=[1,-2,3,5,-2,6,-1]， 所有的子数组中， [3,5,-2,6]
 可以累加出最大的和12， 所以返回12。
 【要求】
 如果arr长度为N， 要求时间复杂度为O(N)， 额外空间复杂度为
 O(1)。
 【补充题目】
 给定一个数组arr， 返回两个不相容子数组的最大累加和。即两个子数组是不重合的。
 思路：求[0,i]中的最大累加和 生成一个数组，再求[i,N-1]的最大累加和 生成一个数组。
 预处理数组技巧+本题的算法原型
 要学会算法步骤的分解
 */
public class Code_01_SubArrayMaxSum {

	public static int maxSum(int[] arr) {
		if (arr == null || arr.length == 0) {
			return 0;
		}
		int max = Integer.MIN_VALUE;
		int cur = 0;
		for (int i = 0; i != arr.length; i++) {
			cur += arr[i];// 每到一个数进行累加
			max = Math.max(max, cur);// 更新最大值
			cur = cur < 0 ? 0 : cur;// 如果累加和小于0，则将累加和变为0，实质就是换了开头，开始收集
		}
		return max;
	}

	public static void printArray(int[] arr) {
		for (int i = 0; i != arr.length; i++) {
			System.out.print(arr[i] + " ");
		}
		System.out.println();
	}

	public static void main(String[] args) {
		int[] arr1 = { -2, -3, -5, 40, -10, -10, 100, 1 };
		System.out.println(maxSum(arr1));

		int[] arr2 = { -2, -3, -5, 0, 1, 2, -1 };
		System.out.println(maxSum(arr2));

		int[] arr3 = { -2, -3, -5, -1 };
		System.out.println(maxSum(arr3));

	}

}
