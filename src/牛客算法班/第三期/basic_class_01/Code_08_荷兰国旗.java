package 牛客算法班.第三期.basic_class_01;

public class Code_08_荷兰国旗 {

	/**
	 * 在[l,r]区域内以num值划分 小于 等于 大于 区域
	 * @return 返回等于区域的左边界和右边界
	 */
	public static int[] partition(int[] arr, int l, int r, int num) {
		int less = l - 1;//属于小于区域的右边界
		int more = r + 1;//属于大于区域的左边界
		while (l < more) {
			if (arr[l] < num) {
				swap(arr, ++less, l++);
			} else if (arr[l] > num) {
				swap(arr, --more, l);
			} else {// == num
				l++;
			}
		}
		return new int[] { less + 1, more - 1 };// 返回等于区域的左边界和右边界
	}

	// for test
	public static void swap(int[] arr, int i, int j) {
		int tmp = arr[i];
		arr[i] = arr[j];
		arr[j] = tmp;
	}

	// for test
	public static int[] generateArray() {
		int[] arr = new int[10];
		for (int i = 0; i < arr.length; i++) {
			arr[i] = (int) (Math.random() * 3);
		}
		return arr;
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

	public static void main(String[] args) {
		int[] test = generateArray();

		printArray(test);
		int[] res = partition(test, 0, test.length - 1, 1);
		printArray(test);
		System.out.println(res[0]);
		System.out.println(res[1]);

	}
}
