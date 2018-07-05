package 牛客算法班.第三期.basic_class_01;

import java.util.Arrays;

/**
 * 这种快排的partition函数适用于荷兰国旗问题，这种在系数项上有改进
 * 传统的快排还是参照   牛客算法班.第三期.basic_class_01.Code_04_算法导论经典快排
 * 时间复杂度O(N*logN)
 * 快排的额外空间复杂度的长期期望是O(logN)，浪费在划分点
 * 工程上要使用非递归版本，自己实现栈来保存
 * 做不到稳定， 不稳定的，因为partition过程做不到稳定
 * partition过程就相当于将数据根据 “0-1标准” 分到左右两边，时间复杂度O(N)，空间复杂度O(1)，但无法做到稳定性
 * （论文级别是可以做到稳定，01 stable sort）
 */
public class Code_04_快排 {

	public static void quickSort(int[] arr) {
		if (arr == null || arr.length < 2) {
			return;
		}
		quickSort(arr, 0, arr.length - 1);
	}

    /**
     * 随机快排的复杂度是一个长期期望的复杂度
     * 随机快排的代码简单，常数项很小，所以快排使用率很高
     * 随机是为了防止出现最差的情况
     * 绕开数据原始的状况，处理方式有：使用随机或hash处理
     *
     * 这里使用的是三路快排，即分成小于部分，等于部分，大于部分。
     */
	public static void quickSort(int[] arr, int l, int r) {
		if (l < r) {
			// 从l到r中随机取出一个数交换到数组尾部作为pivot，random()取值[0,1)
			swap(arr, l + (int) (Math.random() * (r - l + 1)), r);
			// 以r位置为pivot进行荷兰国旗划分，[p[0],p[1]]为等于pivot的位置。
			int[] p = partition(arr, l, r);
			quickSort(arr, l, p[0] - 1);
			quickSort(arr, p[1] + 1, r);
		}
	}

	public static int[] partition(int[] arr, int l, int r) {
		int less = l - 1;// 小于区域的最右边
		int more = r;// 大于区域的最左边， 因为r为pivot，所以这里不用加1
		while (l < more) {
			if (arr[l] < arr[r]) {
				swap(arr, ++less, l++);
			} else if (arr[l] > arr[r]) {
				swap(arr, --more, l);
			} else {
				l++;
			}
		}
		swap(arr, more, r);// 将pivot和大于区域的左边界交换
		return new int[] { less + 1, more };// 因为是以最后一个值划分，等于区域一定有效
	}

	public static void swap(int[] arr, int i, int j) {
		int tmp = arr[i];
		arr[i] = arr[j];
		arr[j] = tmp;
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
			quickSort(arr1);
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
		quickSort(arr);
		printArray(arr);

	}

}
