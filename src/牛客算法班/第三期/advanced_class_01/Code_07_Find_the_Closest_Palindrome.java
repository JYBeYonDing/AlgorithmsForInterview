package 牛客算法班.第三期.advanced_class_01;

/**
 * 给一个字符串str， 代表一个整数， 找到除了这个数之外， 绝对值和这个数相差
 最小的回文数。
 例如：
 str = “123”
 返回“121”
 注意：
 假设字符串str一定能变成long类型

 思路：比他小的数离他最近的回文，比他大的数离他最近的回文
 */
public class Code_07_Find_the_Closest_Palindrome {

	public static String nearestPalindromic(String n) {
		Long num = Long.valueOf(n);
		Long raw = getRawPalindrome(n);// 得到原始的回文
		Long big = raw > num ? raw : getBigPalindrome(raw);// 求比我大的回文
		Long small = raw < num ? raw : getSmallPalindrome(raw);// 求比我小的回文
		return String.valueOf(big - num >= num - small ? small : big);
	}

	/**
	 * 得到原始的回文，即将前半部分拷贝到后半部分
	 * @param n
	 * @return
	 */
	public static Long getRawPalindrome(String n) {
		char[] chs = n.toCharArray();
		int len = chs.length;
		for (int i = 0; i < len / 2; i++) {
			chs[len - 1 - i] = chs[i];
		}
		return Long.valueOf(String.valueOf(chs));
	}

	/**
	 * 求比raw大的最小回文
	 * @param raw
	 * @return
	 */
	public static Long getBigPalindrome(Long raw) {
		char[] chs = String.valueOf(raw).toCharArray();
		char[] res = new char[chs.length + 1];// 多准备一位
		res[0] = '0';
		for (int i = 0; i < chs.length; i++) {
			res[i + 1] = chs[i];
		}
		int size = chs.length;
		for (int j = (size - 1) / 2 + 1; j >= 0; j--) {
			if (++res[j] > '9') {
				res[j] = '0';
			} else {
				break;
			}
		}
		int offset = res[0] == '1' ? 1 : 0;
		size = res.length;
		for (int i = size - 1; i >= (size + offset) / 2; i--) {
			res[i] = res[size - i - offset];
		}
		return Long.valueOf(String.valueOf(res));
	}

	public static Long getSmallPalindrome(Long raw) {
		char[] chs = String.valueOf(raw).toCharArray();
		char[] res = new char[chs.length];
		int size = res.length;
		for (int i = 0; i < size; i++) {
			res[i] = chs[i];
		}
		for (int j = (size - 1) / 2; j >= 0; j--) {
			if (--res[j] < '0') {
				res[j] = '9';
			} else {
				break;
			}
		}
		if (res[0] == '0') {// 如果最高位减成了0，最近的一定是9999...
			res = new char[size - 1];
			for (int i = 0; i < res.length; i++) {
				res[i] = '9';
			}
			return size == 1 ? 0 : Long.parseLong(String.valueOf(res));// 如果长度为1，还减到了0，直接返回0
		}
		for (int k = 0; k < size / 2; k++) {// 如果高位减完后不是0，则直接把左边部分拷贝
			res[size - 1 - k] = res[k];
		}
		return Long.valueOf(String.valueOf(res));
	}

}
