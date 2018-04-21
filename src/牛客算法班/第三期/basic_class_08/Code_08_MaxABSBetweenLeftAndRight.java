package 牛客算法班.第三期.basic_class_08;

/**
 * 已知一个整型数组arr， 数组长度为size且size大于2， arr有size-1种
 可以划分成左右两部分的方案。
 比如：
 arr = {3, 2, 3, 4, 1, 2}
 第1种划分左部分为[3]， 右部分为[2, 3, 4, 1, 2]
 第2种划分左部分为[3, 2]， 右部分为[3, 4, 1, 2]
 第3种划分左部分为[3, 2, 3]， 右部分为[4, 1, 2]
 第4种划分左部分为[3, 2, 3, 4]， 右部分为[1, 2]
 第5种划分左部分为[3, 2, 3, 4, 1]， 右部分为[2]
 每一种划分下， 左部分都有最大值记为max_left， 右部分都有最大值记
 为max_right。
 求|max_left-max_right|(左部分最大值与左部分最大值之差的绝对值)，
 最大是多少？
 要求： 时间复杂度为O(N)， 额外空间复杂度O(1)。
 */
public class Code_08_MaxABSBetweenLeftAndRight {

	public static int maxABS1(int[] arr) {
		int res = Integer.MIN_VALUE;
		int maxLeft = 0;
		int maxRight = 0;
		for (int i = 0; i != arr.length - 1; i++) {
			maxLeft = Integer.MIN_VALUE;
			for (int j = 0; j != i + 1; j++) {
				maxLeft = Math.max(arr[j], maxLeft);
			}
			maxRight = Integer.MIN_VALUE;
			for (int j = i + 1; j != arr.length; j++) {
				maxRight = Math.max(arr[j], maxRight);
			}
			res = Math.max(Math.abs(maxLeft - maxRight), res);
		}
		return res;
	}

	public static int maxABS2(int[] arr) {
		int[] lArr = new int[arr.length];
		int[] rArr = new int[arr.length];
		lArr[0] = arr[0];
		rArr[arr.length - 1] = arr[arr.length - 1];
		for (int i = 1; i < arr.length; i++) {
			lArr[i] = Math.max(lArr[i - 1], arr[i]);
		}
		for (int i = arr.length - 2; i > -1; i--) {
			rArr[i] = Math.max(rArr[i + 1], arr[i]);
		}
		int max = 0;
		for (int i = 0; i < arr.length - 1; i++) {
			max = Math.max(max, Math.abs(lArr[i] - rArr[i + 1]));
		}
		return max;
	}

	public static int maxABS3(int[] arr) {
		int max = Integer.MIN_VALUE;
		for (int i = 0; i < arr.length; i++) {
			max = Math.max(arr[i], max);
		}
		return max - Math.min(arr[0], arr[arr.length - 1]);
	}

	public static int[] generateRandomArray(int length) {
		int[] arr = new int[length];
		for (int i = 0; i != arr.length; i++) {
			arr[i] = (int) (Math.random() * 1000) - 499;
		}
		return arr;
	}

	public static void main(String[] args) {
		int[] arr = generateRandomArray(200);
		System.out.println(maxABS1(arr));
		System.out.println(maxABS2(arr));
		System.out.println(maxABS3(arr));
	}
}
