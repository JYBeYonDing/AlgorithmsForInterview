package 牛客算法班.第三期.basic_class_02;


/**
 * 在无须数组中找到第k小的数或第k大的数
 * 复杂度O(N)
 *
 * 简单的方法可以用荷兰国旗的partition过程解决，时间复杂度的期望是O(N)
 *
 * BFPRT是不基于概率的，严格做到O(N)
 * 选划分值不随机
 * 第一步：分组，5个数为一组
 * 第二步：每个组各自排序，5个数排序O(1),共N/5组，总时间代价O(N)
 * 第三步：取出每个组的中位数，组成一个新的数组，长度为N/5
 * 第四步：递归调用num = BFPRT(new_arr,new_arr.length/2)，即找到这个新数组的中位数
 * 第五步：使用num进行partition划分
 *
 * T(N) = T(N/5)+T(7*N/10)+O(N)
 * 证明：算法导论第9章
 *
 * 在数组找出最小的k个数，通常都用堆做了，但复杂度O(N*logK)要比BFPRT复杂度高。
 */
public class Code_06_BFPRT第k小第k大 {

	/**
	 * 使用堆来做
	 * @param arr
	 * @param k
	 * @return
	 */
	// O(N*logK)
	public static int[] getMinKNumsByHeap(int[] arr, int k) {
		if (k < 1 || k > arr.length) {
			return arr;
		}
		int[] kHeap = new int[k];
		for (int i = 0; i != k; i++) {
			heapInsert(kHeap, arr[i], i);
		}
		for (int i = k; i != arr.length; i++) {
			if (arr[i] < kHeap[0]) {
				kHeap[0] = arr[i];
				heapify(kHeap, 0, k);
			}
		}
		return kHeap;
	}

	public static void heapInsert(int[] arr, int value, int index) {
		arr[index] = value;
		while (index != 0) {
			int parent = (index - 1) / 2;
			if (arr[parent] < arr[index]) {
				swap(arr, parent, index);
				index = parent;
			} else {
				break;
			}
		}
	}

	public static void heapify(int[] arr, int index, int heapSize) {
		int left = index * 2 + 1;
		int right = index * 2 + 2;
		int largest = index;
		while (left < heapSize) {
			if (arr[left] > arr[index]) {
				largest = left;
			}
			if (right < heapSize && arr[right] > arr[largest]) {
				largest = right;
			}
			if (largest != index) {
				swap(arr, largest, index);
			} else {
				break;
			}
			index = largest;
			left = index * 2 + 1;
			right = index * 2 + 2;
		}
	}

	/**
	 * 使用BFPRT算法
	 * @param arr
	 * @param k
	 * @return
	 */
	// O(N)
	public static int[] getMinKNumsByBFPRT(int[] arr, int k) {
		if (k < 1 || k > arr.length) {
			return arr;
		}
		int minKth = getMinKthByBFPRT(arr, k);
		int[] res = new int[k];
		int index = 0;
		for (int i = 0; i != arr.length; i++) {
			if (arr[i] < minKth) {
				res[index++] = arr[i];
			}
		}
		for (; index != res.length; index++) {
			res[index] = minKth;
		}
		return res;
	}

	public static int getMinKthByBFPRT(int[] arr, int K) {
		int[] copyArr = copyArray(arr);
		return bfprt(copyArr, 0, copyArr.length - 1, K - 1);
	}

	public static int[] copyArray(int[] arr) {
		int[] res = new int[arr.length];
		for (int i = 0; i != res.length; i++) {
			res[i] = arr[i];
		}
		return res;
	}

	/**
	 * 在begin到end范围上求第i小的数
	 * @param arr
	 * @param begin
	 * @param end
	 * @param i
	 * @return
	 */
	public static int bfprt(int[] arr, int begin, int end, int i) {
		if (begin == end) {
			return arr[begin];
		}
		int pivot = medianOfMedians(arr, begin, end);// 中位数数组的中位数
		int[] pivotRange = partition(arr, begin, end, pivot);// 等于区域
		if (i >= pivotRange[0] && i <= pivotRange[1]) {
			return arr[i];
		} else if (i < pivotRange[0]) {
			return bfprt(arr, begin, pivotRange[0] - 1, i);
		} else {
			return bfprt(arr, pivotRange[1] + 1, end, i);
		}
	}

	/**
	 * 求中位数数组的中位数
	 * @param arr
	 * @param begin
	 * @param end
	 * @return
	 */
	public static int medianOfMedians(int[] arr, int begin, int end) {
		int num = end - begin + 1;
		int offset = num % 5 == 0 ? 0 : 1;
		int[] mArr = new int[num / 5 + offset];// 中位数数组
		for (int i = 0; i < mArr.length; i++) {
			int beginI = begin + i * 5;
			int endI = beginI + 4;
			mArr[i] = getMedian(arr, beginI, Math.min(end, endI));
		}
		return bfprt(mArr, 0, mArr.length - 1, mArr.length / 2);
	}

	public static int[] partition(int[] arr, int begin, int end, int pivotValue) {
		int small = begin - 1;
		int cur = begin;
		int big = end + 1;
		while (cur != big) {
			if (arr[cur] < pivotValue) {
				swap(arr, ++small, cur++);
			} else if (arr[cur] > pivotValue) {
				swap(arr, cur, --big);
			} else {
				cur++;
			}
		}
		int[] range = new int[2];
		range[0] = small + 1;
		range[1] = big - 1;
		return range;
	}

	public static int getMedian(int[] arr, int begin, int end) {
		insertionSort(arr, begin, end);
		int sum = end + begin;
		int mid = (sum / 2) + (sum % 2);
		return arr[mid];
	}

	public static void insertionSort(int[] arr, int begin, int end) {
		for (int i = begin + 1; i != end + 1; i++) {
			for (int j = i; j != begin; j--) {
				if (arr[j - 1] > arr[j]) {
					swap(arr, j - 1, j);
				} else {
					break;
				}
			}
		}
	}

	public static void swap(int[] arr, int index1, int index2) {
		int tmp = arr[index1];
		arr[index1] = arr[index2];
		arr[index2] = tmp;
	}

	public static void printArray(int[] arr) {
		for (int i = 0; i != arr.length; i++) {
			System.out.print(arr[i] + " ");
		}
		System.out.println();
	}

	public static void main(String[] args) {
		int[] arr = { 6, 9, 1, 3, 1, 2, 2, 5, 6, 1, 3, 5, 9, 7, 2, 5, 6, 1, 9 };
		// sorted : { 1, 1, 1, 1, 2, 2, 2, 3, 3, 5, 5, 5, 6, 6, 6, 7, 9, 9, 9 }
		printArray(getMinKNumsByHeap(arr, 10));
		printArray(getMinKNumsByBFPRT(arr, 10));

	}

}
