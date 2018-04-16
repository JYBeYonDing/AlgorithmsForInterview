package 牛客算法班.第三期.basic_class_01;

import java.util.Arrays;

/**
 * 堆排序
 * 做不到稳定，不稳定的
 * 堆 其实是一个 完全二叉树
 * 用一个 大根堆 和一个 小根堆 可以求数据流的中位数 牛客算法班.第三期.basic_class_04.Code_01_数据流中取中位数
 */
public class Code_03_堆排序 {

	public static void heapSort(int[] arr) {
		if (arr == null || arr.length < 2) {
			return;
		}
		//建大根堆 log(1)+log(2)+log(3)+...+log(N) -> N ???怀疑
		for (int i = 0; i < arr.length; i++) {
			heapInsert(arr, i);//[0,i]变成大根堆
		}
		//每次取堆顶元素
		int size = arr.length;
		swap(arr, 0, --size);
		while (size > 0) {
			heapify(arr, 0, size);
			swap(arr, 0, --size);
		}
	}

	/**
	 * 插入arr[index]，建立大根堆
	 */
	public static void heapInsert(int[] arr, int index) {
		// -1/2 = 0/2 = 1/2 = 0 所以不会越界 2/2 = 3/2 = 1
		// (0-1)/2 = 0，所以0的父节点是自己
		// 由于-1 的补码为 全1 所以这里不能用 >>1 代替 /2, 否则会越界
		while (arr[index] > arr[(index - 1) / 2]) {// 该节点大于父节点 则交换
			swap(arr, index, (index - 1) / 2);
			index = (index - 1) / 2;
		}
	}

	/**
	 * 调整大根堆
	 * 复杂度只有 logN
	 * @param arr
	 * @param index
	 * @param size 堆的大小
	 */
	public static void heapify(int[] arr, int index, int size) {
		int left = index * 2 + 1;
		while (left < size) {// 如果有左孩子
			// 左右子节点中取一个最大值，如果只有左，则取左节点
			int largest = left + 1 < size && arr[left + 1] > arr[left] ? left + 1 : left;
			// 左右子节点中的最大值和当前节点比较，取最大值
			largest = arr[largest] > arr[index] ? largest : index;
			if (largest == index) {
				// 如果最大节点==当前节点，说明节点到达需要的位置，调整结束
				break;
			}
			swap(arr, largest, index);
			index = largest;
			left = index * 2 + 1;
		}
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
			heapSort(arr1);
			comparator(arr2);
			if (!isEqual(arr1, arr2)) {
				succeed = false;
				break;
			}
		}
		System.out.println(succeed ? "Nice!" : "Fucking fucked!");

		int[] arr = generateRandomArray(maxSize, maxValue);
		printArray(arr);
		heapSort(arr);
		printArray(arr);
	}

}
