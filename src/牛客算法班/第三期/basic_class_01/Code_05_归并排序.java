package 牛客算法班.第三期.basic_class_01;

import java.util.Arrays;

/**
 * 额外空间复杂度为O(N)
 * 时间复杂度O(N*logN)
 * 可以做到 稳定的，遇到相等的拷贝左边的就可以
 */
public class Code_05_归并排序 {

	public static void mergeSort(int[] arr) {
		if (arr == null || arr.length < 2) {
			return;
		}
		sortProcess(arr, 0, arr.length - 1);
	}

	public static void sortProcess(int[] arr, int l, int r) {
		// 优化2: 对于小规模数组, 可以使用插入排序
		if (l == r) {
			return;
		}
		// 注意！！！移位运算符的优先级比加减法还低
		int mid = l + ((r - l) >> 1);//可以防止数值溢出，位运算更快
		sortProcess(arr, l, mid); // T(N/2)
		sortProcess(arr, mid + 1, r);// T(N/2)
		// 优化1: 对于arr[mid] <= arr[mid+1]的情况,可以不进行merge
		// 对于近乎有序的数组非常有效,但是对于一般情况,有一定的性能损失
		merge(arr, l, mid, r);// O(N)
        // T(N) = 2T(N/2) + O(N)
	}

	public static void merge(int[] arr, int l, int m, int r) {
		int[] help = new int[r - l + 1];// 辅助数组
		int i = 0;
		int p1 = l;
		int p2 = m + 1;
		while (p1 <= m && p2 <= r) {
			help[i++] = arr[p1] < arr[p2] ? arr[p1++] : arr[p2++];
		}
		// 两个必有且只有一个越界
		while (p1 <= m) {
			help[i++] = arr[p1++];
		}
		while (p2 <= r) {
			help[i++] = arr[p2++];
		}
		// 辅助数组 拷贝到 原数组
		for (i = 0; i < help.length; i++) {
			arr[l + i] = help[i];
		}
	}

	// for test
	public static void comparator(int[] arr) {
		Arrays.sort(arr);
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
	public static boolean isEqual(int[] arr1, int[] arr2) {
		if ((arr1 == null && arr2 != null) || (arr1 != null && arr2 == null)) {
			return false;
		}
		if (arr1 == null && arr2 == null) {
			return true;
		}
		if (arr1.length != arr2.length) {
			return false;
		}
		for (int i = 0; i < arr1.length; i++) {
			if (arr1[i] != arr2[i]) {
				return false;
			}
		}
		return true;
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
		int maxSize = 100;
		int maxValue = 100;
		boolean succeed = true;
		for (int i = 0; i < testTime; i++) {
			int[] arr1 = generateRandomArray(maxSize, maxValue);
			int[] arr2 = copyArray(arr1);
			mergeSort(arr1);
			comparator(arr2);
			if (!isEqual(arr1, arr2)) {
				succeed = false;
				printArray(arr1);
				printArray(arr2);
				break;
			}
		}
		System.out.println(succeed ? "Nice!" : "Fucking fucked!");

		int[] arr = generateRandomArray(maxSize, maxValue);
		printArray(arr);
		mergeSort(arr);
		printArray(arr);

	}

}
