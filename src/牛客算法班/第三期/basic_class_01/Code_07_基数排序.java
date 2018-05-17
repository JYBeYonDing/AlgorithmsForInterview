package 牛客算法班.第三期.basic_class_01;

import java.util.Arrays;

/**
 * 将所有待比较数值（正整数）统一为同样的数位长度，数位较短的数前面补零。
 * 然后，从最低位开始，依次进行一次排序。
 * 这样从最低位排序一直到最高位排序完成以后, 数列就变成一个有序序列。
 *
 * 相当于是多次计数排序，即对每一位上的数字进行计数排序，这里计数排序的“稳定性”很重要！！！
 *
 */
public class Code_07_基数排序 {
	/**
	 * 只能用于非负数的排序
	 * @param arr
	 */
	public static void radixSort(int[] arr) {
		if (arr == null || arr.length < 2) {
			return;
		}
		radixSort(arr, 0, arr.length - 1, maxbits(arr));
	}

	/**
	 * 数组中的最大值是几位
	 * @param arr 数组
	 * @return 最大值的位数
	 */
	public static int maxbits(int[] arr) {
		int max = Integer.MIN_VALUE;// 数组中的最大值
		for (int i = 0; i < arr.length; i++) {
			max = Math.max(max, arr[i]);
		}
		int res = 0;//记录有几位
		while (max != 0) {
			res++;
			max /= 10;
		}
		return res;
	}

	/**
	 * 基数排序
	 * @param arr 要排序的数组
	 * @param begin 要排序部分的开始索引
	 * @param end 要排序部分的末索引
	 * @param digit 位数
	 */
	public static void radixSort(int[] arr, int begin, int end, int digit) {
		final int radix = 10;// 10进制
		int i = 0, j = 0;
		int[] count = new int[radix];// 根据进制产生需要的桶
		int[] help = new int[end - begin + 1];// 存放每次排序后的数组
		for (int d = 1; d <= digit; d++) {// 根据各个位进行排序，个、十、百、千、万 注意！！！这里是从1开始
			for (i = 0; i < radix; i++) {// 初始化计数
				count[i] = 0;
			}

			// 下面用到了“计数排序”
			for (i = begin; i <= end; i++) {
				j = getDigit(arr[i], d);// 第d位上的数
				count[j]++;
			}
			for (i = 1; i < radix; i++) {
				count[i] = count[i] + count[i - 1];//位数上的数小于等于i的个数
			}
			for (i = end; i >= begin; i--) {// 从后往遍历数，根据count[j]找到对应桶的位置，放置数
				j = getDigit(arr[i], d);
				help[--count[j]] = arr[i];
			}
			for (i = begin, j = 0; i <= end; i++, j++) {// 拷贝数据
				arr[i] = help[j];
			}
		}
	}

	/**
	 * 得到x第d位上的数字
	 * @param x 数值
	 * @param d 位置
	 * @return 数字
	 */
	public static int getDigit(int x, int d) {
		return ((x / ((int) Math.pow(10, d - 1))) % 10);
	}




	//***********************************************************************************************


	// for test
	public static void comparator(int[] arr) {
		Arrays.sort(arr);
	}

	// for test
	public static int[] generateRandomArray(int maxSize, int maxValue) {
		int[] arr = new int[(int) ((maxSize + 1) * Math.random())];
		for (int i = 0; i < arr.length; i++) {
			arr[i] = (int) ((maxValue + 1) * Math.random());
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
		int maxValue = 100000;
		boolean succeed = true;
		for (int i = 0; i < testTime; i++) {
			int[] arr1 = generateRandomArray(maxSize, maxValue);
			int[] arr2 = copyArray(arr1);
			radixSort(arr1);
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
		radixSort(arr);
		printArray(arr);

	}

}
