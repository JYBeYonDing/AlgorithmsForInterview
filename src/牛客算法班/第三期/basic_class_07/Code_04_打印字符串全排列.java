package 牛客算法班.第三期.basic_class_07;

import java.util.Arrays;
import java.util.HashSet;

/**
 * 打印一个字符串的全部排列
 *
 * 看后面89行的非递归实现！！！
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
		HashSet<Character> set = new HashSet<>();// 用来记录后面的数字是否有重复
		for (int j = i; j < chs.length; j++) {
			if (!set.contains(chs[j])) {// 只与后面非重复的数字交换。如果重复则不必交换。
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
	 *
	 * 主要思路！！！！！！！！！！：
	 * 算法的具体步骤：二找、一交换、一翻转
	 * 1.找到排列中最后一个升序的首位位置i，x=ai
	 * 2.找到排列中第i位右边最后一个比ai大的位置j，y=aj
	 * 3.交换x和y
	 * 4.把第i+1位到最后的部分翻转（执行此步骤前，因为第i位是最后一个升序的位置，所以从i+1到n一定是降序排列的）
	 *
	 * 比如说，现在我们要找21543的下一个排列，我们可以从左至右逐个扫描每个数，
	 * 看哪个能增大（至于如何判定能增大，是根据如果一个数右面有比它大的数存在，那么这个数就能增大），
	 * 我们可以看到最后一个能增大的数是：x = 1。而1应该增大到多少？
	 * 1能增大到它右面比它大的那一系列数中最小的那个数，即：y = 3，
	 * 故此时21543的下一个排列应该变为23xxx，显然 xxx(对应之前的B’）应由小到大排，
	 * 于是我们最终找到比“21543”大，但字典顺序尽量小的23145，找到的23145刚好比21543大。
	 作者：MinoyJet
	 链接：https://www.jianshu.com/p/e0de4c9b73f2
	 來源：简书
	 简书著作权归作者所有，任何形式的转载都请联系作者获得授权并注明出处。

	 由于全排列有n！种情况，所以时间复杂度是O(N!)
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
