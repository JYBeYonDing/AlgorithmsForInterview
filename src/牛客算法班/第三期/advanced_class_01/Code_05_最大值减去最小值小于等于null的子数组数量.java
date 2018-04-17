package 牛客算法班.第三期.advanced_class_01;

import java.util.LinkedList;

/**
 * 最大值减去最小值小于等于null的子数组数量
 * 给定数组arr和整数num， 共返回有多少个子数组满足如下情况：
 max(arr[i..j]) - min(arr[i..j]) <= num
 max(arr[i..j])表示子数组arr[i..j]中的最大值，
 min(arr[i..j])表示子数组arr[i..j]中的最小值。
 【要求】
 如果数组长度为N， 请实现时间复杂度为O(N)的解法。


 思路：
 如果一个子数组达标，内部的所有子数组都达标
 如果一个组数组不达标，往外扩一定不达标

 */
public class Code_05_最大值减去最小值小于等于null的子数组数量 {

	public static int getNum(int[] arr, int num) {
		if (arr == null || arr.length == 0) {
			return 0;
		}
		LinkedList<Integer> qmin = new LinkedList<Integer>();
		LinkedList<Integer> qmax = new LinkedList<Integer>();
		int L = 0;
		int R = 0;
		int res = 0;
		while (L < arr.length) {
			while (R < arr.length) {// R往右扩到不能再扩停
				while (!qmin.isEmpty() && arr[qmin.peekLast()] >= arr[R]) {
					qmin.pollLast();
				}
				qmin.addLast(R);
				while (!qmax.isEmpty() && arr[qmax.peekLast()] <= arr[R]) {
					qmax.pollLast();
				}
				qmax.addLast(R);
				if (arr[qmax.getFirst()] - arr[qmin.getFirst()] > num) {
					break;
				}
				R++;
			}
			if (qmin.peekFirst() == L) {
				qmin.pollFirst();
			}
			if (qmax.peekFirst() == L) {
				qmax.pollFirst();
			}
			res += R - L;
			L++;
		}
		return res;
	}

	// for test
	public static int[] getRandomArray(int len) {
		if (len < 0) {
			return null;
		}
		int[] arr = new int[len];
		for (int i = 0; i < len; i++) {
			arr[i] = (int) (Math.random() * 10);
		}
		return arr;
	}

	// for test
	public static void printArray(int[] arr) {
		if (arr != null) {
			for (int i = 0; i < arr.length; i++) {
				System.out.print(arr[i] + " ");
			}
			System.out.println();
		}
	}

	public static void main(String[] args) {
		int[] arr = getRandomArray(30);
		int num = 5;
		printArray(arr);
		System.out.println(getNum(arr, num));

	}

}
