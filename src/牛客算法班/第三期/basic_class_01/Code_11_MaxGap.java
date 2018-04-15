package 牛客算法班.第三期.basic_class_01;

import java.util.Arrays;

/**
 *
 * 给定一个数组， 求如果排序之后， 相邻两数的最大差值，
 * 要求时间复杂度O(N)， 且要求不能用非基于比较的排序。
 * 利用 桶 的思想
 */
public class Code_11_MaxGap {

	public static int maxGap(int[] nums) {
		if (nums == null || nums.length < 2) {
			return 0;
		}
		int len = nums.length;
		int min = Integer.MAX_VALUE;
		int max = Integer.MIN_VALUE;
		for (int i = 0; i < len; i++) {
			min = Math.min(min, nums[i]);
			max = Math.max(max, nums[i]);
		}
		if (min == max) {
			return 0;
		}

		// 桶的数量要比数据的数量多1，保证必有空桶。保证有空桶的目的是排除最大差值在同一个桶中的情况
		boolean[] hasNum = new boolean[len + 1]; // 桶中是否进来过数
		int[] maxs = new int[len + 1];// 每个桶的最大值，注意：这里初始值都为0！！！
		int[] mins = new int[len + 1];// 每个桶的最小值，注意：这里初始值都为0！！！
		int bid = 0;
		for (int i = 0; i < len; i++) {// 遍历一遍数组
			bid = bucket(nums[i], len, min, max);// 确定一个数属于第几个桶
			mins[bid] = hasNum[bid] ? Math.min(mins[bid], nums[i]) : nums[i];
			maxs[bid] = hasNum[bid] ? Math.max(maxs[bid], nums[i]) : nums[i];
			hasNum[bid] = true;
		}
		int res = 0;// 记录最大差值的结果
		int lastMax = maxs[0];// 前一个非空桶的最大值，第一个桶肯定有值
		int i = 1;
		for (; i <= len; i++) {// 遍历一遍桶，找到每个桶的最小值和前一个非空桶的最大值的差的最大值
			if (hasNum[i]) {
				res = Math.max(res, mins[i] - lastMax);
				lastMax = maxs[i];
			}
		}
		return res;
	}

	public static int bucket(long num, long len, long min, long max) {
		//这里应该是没有问题的，这样计算桶id的话，最后一个桶有且只能有最大值，视频中的讲解有错误。
		return (int) ((num - min) * len / (max - min));
	}

	// for test
	public static int comparator(int[] nums) {
		if (nums == null || nums.length < 2) {
			return 0;
		}
		Arrays.sort(nums);
		int gap = Integer.MIN_VALUE;
		for (int i = 1; i < nums.length; i++) {
			gap = Math.max(nums[i] - nums[i - 1], gap);
		}
		return gap;
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
	public static int[] copyArray(int[] arr) {
		if (arr == null) {
			return null;
		}
		int[] res = new int[arr.length];
		for (int i = 0; i < arr.length; i++) {
			res[i] = arr[i];
		}
		return res;
	}

	// for test
	public static void main(String[] args) {

		int testTime = 500000;
		int maxSize = 100;
		int maxValue = 100;
		boolean succeed = true;
		for (int i = 0; i < testTime; i++) {
			int[] arr1 = generateRandomArray(maxSize, maxValue);
			int[] arr2 = copyArray(arr1);
			if (maxGap(arr1) != comparator(arr2)) {
				succeed = false;
				break;
			}
		}
		System.out.println(succeed ? "Nice!" : "Fucking fucked!");
	}

}
