package 牛客算法班.第三期.basic_class_02;

/**
 *
 * 子序列，可以连续，可以不连续
 * 子串和子数组，必须连续
 *
 * 前缀不能包含最后一个字符，后缀不能包含第一个字符，即都不能取整体
 * 前缀和后缀相等的最长长度：前面没有字符串则规定为-1，前面只有一个字符则规定为0.
 *
 * 时间复杂度为O(m+n)
 *
 */
public class Code_01_KMP {

	/**
	 * KMP查找匹配字符串
	 * @param s 被匹配字符串
	 * @param m 匹配字符串
	 * @return 如果s找到m，返回在s中的第一个匹配字符的下标，否则返回-1
	 */
	public static int getIndexOf(String s, String m) {
		if (s == null || m == null || m.length() < 1 || s.length() < m.length()) {
			return -1;
		}
		char[] ss = s.toCharArray();
		char[] ms = m.toCharArray();
		int si = 0;
		int mi = 0;
		int[] next = getNextArray(ms);
		while (si < ss.length && mi < ms.length) {
			if (ss[si] == ms[mi]) {
				si++;
				mi++;
			} else if (next[mi] == -1) {//如果 匹配字符串 跳到了第一个字符都没有匹配，只能被匹配字符串下标向后移
				si++;
			} else {
				mi = next[mi];// 匹配字符串往前跳
			}
		}
		return mi == ms.length ? si - mi : -1;// 如果匹配字符串已经划过了所有的字符，说明匹配成功
	}

	/**
	 *
	 * @param ms 匹配字符数组
	 * @return 前缀和后缀相等的最长长度：前面没有字符串则规定为-1，前面只有一个字符则规定为0.
	 */
	public static int[] getNextArray(char[] ms) {
		if (ms.length == 1) {
			return new int[] { -1 };
		}
		int[] next = new int[ms.length];
		next[0] = -1;
		next[1] = 0;
		int pos = 2;// 当前位置
		int cn = 0;// 前缀的下一个位置，因为pos从2开始，所以cn从0开始
		// 下面这个while分析复杂度有点困难，看第九章2.2 6min和22min， 把复杂度绑定到一个标杆上，主要需要评价中间那个分支的复杂度
		while (pos < next.length) {
			if (ms[pos - 1] == ms[cn]) {
				next[pos++] = ++cn;
			} else if (cn > 0) {// 如果不相等，且cn>0，则往前跳
				cn = next[cn];// cn往前跳，跳到cn位置处前缀的下一个字符
			} else {// cn已经跳到0位置
				next[pos++] = 0;
			}
		}
		return next;
	}

	public static void main(String[] args) {
		String str = "abcabcababaccc";
		String match = "ababa";
		System.out.println(getIndexOf(str, match));

	}

}
