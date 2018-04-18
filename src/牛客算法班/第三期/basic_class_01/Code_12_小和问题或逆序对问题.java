package 牛客算法班.第三期.basic_class_01;

/**
 * 小和问题
 * 在一个数组中， 每一个数左边比当前数小的数累加起来， 叫做这个数的小和。 求一个数组中所有的小和之和。
 *
 * 利用 归并排序 merge过程
 * 逆序对问题也可以利用 归并
 * 归并 组内的比较不会被浪费，合并时只需要组间的比较，这是归并的实质！！！！！
 * 逆序对问题 也是同样的思路
 */
public class Code_12_小和问题或逆序对问题 {

	public static int smallSum(int[] arr) {
		if (arr == null || arr.length < 2) {
			return 0;
		}
		return mergeSort(arr, 0, arr.length - 1);
	}

	/**
	 * 返回从l到r位置上产生多少小和
	 * @param arr 数组
	 * @param l 左边界
	 * @param r 右边界
	 * @return 小和之和
	 */
	public static int mergeSort(int[] arr, int l, int r) {
		if (l == r) {
			return 0;
		}
		int mid = l + ((r - l) >> 1);// l+r可能会溢出，这样不会溢出，且位运算比算数运算快很多
		return mergeSort(arr, l, mid)
				+ mergeSort(arr, mid + 1, r)
				+ merge(arr, l, mid, r);
	}

	/**
	 * 返回 merge 过程中产生多少小和
	 * @param arr 数组
	 * @param l 左边界
	 * @param m 中点
	 * @param r 右边界
	 * @return merge时产生的小和
	 */
	public static int merge(int[] arr, int l, int m, int r) {
		int[] help = new int[r - l + 1];
		int i = 0;
		int p1 = l;
		int p2 = m + 1;
		int res = 0;// 收集小和
		while (p1 <= m && p2 <= r) {
			res += arr[p1] < arr[p2] ? (r - p2 + 1) * arr[p1] : 0;//右边比arr[p1]大的个数*arr[p1]
			help[i++] = arr[p1] < arr[p2] ? arr[p1++] : arr[p2++];
		}
		/*
		 * 本来觉得后面这些可以优化，因为觉得对求res没有帮助，其实想错了，这是merge的过程，会进行排序，不能省去
		 */
		while (p1 <= m) {
			help[i++] = arr[p1++];
		}
		while (p2 <= r) {
			help[i++] = arr[p2++];
		}
		for (i = 0; i < help.length; i++) {
			arr[l + i] = help[i];
		}
		return res;
	}

	// for test
	public static int comparator(int[] arr) {
		if (arr == null || arr.length < 2) {
			return 0;
		}
		int res = 0;
		for (int i = 1; i < arr.length; i++) {
			for (int j = 0; j < i; j++) {
				res += arr[j] < arr[i] ? arr[j] : 0;
			}
		}
		return res;
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
			if (smallSum(arr1) != comparator(arr2)) {
				succeed = false;
				printArray(arr1);
				printArray(arr2);
				break;
			}
		}
		System.out.println(succeed ? "Nice!" : "Fucking fucked!");
	}

}
