package 牛客算法班.第三期.advanced_class_04;

/**
 * 数组中未出现的最小正整数
 【题目】
 给定一个无序整型数组arr， 找到数组中未出现的最小正整数。
 【举例】
 arr=[-1,2,3,4]。 返回1。
 arr=[1,2,3,4]。 返回5。
 */
public class Code_06_SmallestMissNum {

	public static int missNum(int[] arr) {
		int l = 0;
		int r = arr.length;
		while (l < r) {
			if (arr[l] == l + 1) {
				l++;
			} else if (arr[l] <= l || arr[l] > r || arr[arr[l] - 1] == arr[l]) {// arr[arr[l] - 1] == arr[l]表示arr[l]上的数在它原本应该出现的地方已经有了
				arr[l] = arr[--r];
			} else {
				swap(arr, l, arr[l] - 1);
			}
		}
		return l + 1;
	}

	public static void swap(int[] arr, int index1, int index2) {
		int tmp = arr[index1];
		arr[index1] = arr[index2];
		arr[index2] = tmp;
	}

	public static void main(String[] args) {
		int[] arr = { -1, 0, 2, 1, 3, 5 };
		System.out.println(missNum(arr));

	}
}
