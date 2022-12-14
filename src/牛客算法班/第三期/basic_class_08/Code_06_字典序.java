package 牛客算法班.第三期.basic_class_08;

import java.util.Arrays;
import java.util.Comparator;

/**
 * 贪心策略的正确性的证明不用证明
 * 用写 对数器 的方式来验证贪心策略对不对，不要纠结证明
 *
 * 字典序就是理解为 进制的数
 * 长度不等的时候，长度需要补齐
 */
public class Code_06_字典序 {

	/**
	 * 自己定义的比较规则
	 */
	public static class MyComparator implements Comparator<String> {
		@Override
		public int compare(String a, String b) {
			return (a + b).compareTo(b + a);
		}
	}

	public static String lowestString(String[] strs) {
		if (strs == null || strs.length == 0) {
			return "";
		}
		Arrays.sort(strs, new MyComparator());
		String res = "";
		for (int i = 0; i < strs.length; i++) {
			res += strs[i];
		}
		return res;
	}

	public static void main(String[] args) {
		String[] strs1 = { "jibw", "ji", "jp", "bw", "jibw" };
		System.out.println(lowestString(strs1));

		String[] strs2 = { "ba", "b" };
		System.out.println(lowestString(strs2));

	}


}
