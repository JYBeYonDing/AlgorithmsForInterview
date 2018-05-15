package 牛客算法班.第三期.basic_class_07;

import java.util.Arrays;
import java.util.HashSet;

/**
 * 打印一个字符串的全部排列
 */
public class Code_04_打印字符串全排列 {

	private static void printAllPermutations1(String str) {
		char[] chs = str.toCharArray();
		process1(chs, 0);
	}

	private static void process1(char[] chs, int i) {
		if (i == chs.length) {
			System.out.println(String.valueOf(chs));
		}
		for (int j = i; j < chs.length; j++) {
			swap(chs, i, j);
			process1(chs, i + 1);
			swap(chs, i, j);
		}
	}

	/**
	 * 去掉重复
	 * 由于全排列就是从第一个数字起每个数分别与它后面的数字交换。
	 * 我们先尝试加个这样的判断：如果一个数与后面的数字相同那么这二个数就不交换了。
	 * 如122，第一个数与后面交换得212、221。然后122中第二数就不用与第三个数交换了，
	 * 但对212，它第二个数与第三个数是不相同的，交换之后得到221。与由122中第一个数与第三个数交换所得的221重复了。所以这个方法不行。
	 *
	 * 换种思维，对122，第一个数1与第二个数2交换得到212，然后考虑第一个数1与第三个数2交换，
	 * 此时由于第三个数等于第二个数，所以第一个数不再与第三个数交换。
	 * 再考虑212，它的第二个数与第三个数交换可以得到解决221。此时全排列生成完毕。
	 * 这样我们也得到了在全排列中去掉重复的规则：去重的全排列就是从第一个数字起每个数分别与它后面非重复出现的数字交换。
	 * @param str
	 */
	private static void printAllPermutations2(String str) {
		char[] chs = str.toCharArray();
		process2(chs, 0);
	}

	private static void process2(char[] chs, int i) {
		if (i == chs.length) {
			System.out.println(String.valueOf(chs));
		}
		HashSet<Character> set = new HashSet<>();
		for (int j = i; j < chs.length; j++) {
			if (!set.contains(chs[j])) {
				set.add(chs[j]);
				swap(chs, i, j);
				process2(chs, i + 1);
				swap(chs, i, j);
			}
		}
	}

	public static void swap(char[] chs, int i, int j) {
		char tmp = chs[i];
		chs[i] = chs[j];
		chs[j] = tmp;
	}

	public static void main(String[] args) {
		String test1 = "abc";
		printAllPermutations1(test1);
		System.out.println("======");
		printAllPermutations2(test1);
		System.out.println("======");
		System.out.println("非递归");
		allPermutation(test1);
		System.out.println("======");

		String test2 = "acc";
		printAllPermutations1(test2);
		System.out.println("======");
		printAllPermutations2(test2);
		System.out.println("======");
		System.out.println("非递归");
		allPermutation(test2);
	}


	/**
	 * 非递归实现全排列
	 * 用到了字典序的思想：
	 * 1.算法起点：字典序最小的排列
	 * 2.算法终点：字典序最大的排列
	 * 3.算法的执行过程：从当前排列生成字典序刚好比它大的下一个排列
	 * <p>
	 * 算法的具体步骤：二找、一交换、一翻转
	 * 1.找到排列中最后一个升序的首位位置i，x=ai
	 * 2.找到排列中第i位右边最后一个比ai大的位置j，y=aj
	 * 3.交换x和y
	 * 4.把第i+1位到最后的部分翻转（执行此步骤前，因为第i位是最后一个升序的位置，所以从i+1到n一定是降序排列的）
	 */
	private static void allPermutation(String s) {
		//先进行排序，得到字典组最小的排列
		char[] chars = s.toCharArray();
		Arrays.sort(chars);
		System.out.println(new String(chars));
		while (hasNextPermutation(chars)) {
			System.out.println(new String(chars));
		}
	}

	private static boolean hasNextPermutation(char[] chars) {
		int i;
		// 步骤一：找到排列中最后一个升序的首位位置i，x=ai
		for(i=chars.length-2 ;(i>=0)&& chars[i]>=chars[i+1];i--) {
		}
		if (i < 0) {//说明已经找到了所有的排列
			return false;
		}
		int j;
		// 步骤二：找到排列中第i位右边最后一个比ai大的位置j，y=aj
		for(j=chars.length-1;(j>i)&&chars[j]<=chars[i];j--) {
		}
		// 步骤三：交换x和y
		swap(chars, i, j);
		// 步骤四：把第i+1位到最后的部分翻转
		reverse(chars, i + 1, chars.length - 1);

		return true;
	}

	private static void reverse(char[] chars, int start, int end) {
		while (end > start) {
			swap(chars,start++,end--);
		}
	}
}
