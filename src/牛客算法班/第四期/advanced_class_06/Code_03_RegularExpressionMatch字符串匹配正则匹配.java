package 牛客算法班.第四期.advanced_class_06;

/**
 * 字符串KMP算法匹扩配展问题题目二
 【题目】
 给定字符串str， 其中绝对不含有字符'.'和'*'。 再给定字符串exp，
 其中可以含有'.'或'*'， '*'字符不能是exp的首字符， 并且任意两个
 '*'字符不相邻。 exp中的'.'代表任何一个字符， exp中的'*'表示'*'
 的前一个字符可以有0个或者多个。 请写一个函数， 判断str是否能被
 exp匹配。
 【举例】
 str="abc"， exp="abc"， 返回true。
 str="abc"， exp="a.c"， exp中单个'.'可以代表任意字符， 所以返回
 true。
 str="abcd"， exp=".*"。 exp中'*'的前一个字符是'.'， 所以可表示任
 意数量的'.'字符， 当exp是"...."时与"abcd"匹配， 返回true。
 str=""， exp="..*"。 exp中'*'的前一个字符是'.'， 可表示任意数量
 的'.'字符， 但是".*"之前还有一个'.'字符， 该字符不受'*'的影响，
 所以str起码有一个字符才能被exp匹配。 所以返回false。


 */
public class Code_03_RegularExpressionMatch字符串匹配正则匹配 {

	/**
	 * 线检查有效性
	 * s不能包含.或*
	 * e'*'字符不能是exp的首字符， 并且任意两个'*'字符不相邻。
	 */
	public static boolean isValid(char[] s, char[] e) {
		for (int i = 0; i < s.length; i++) {
			if (s[i] == '*' || s[i] == '.') {
				return false;
			}
		}
		for (int i = 0; i < e.length; i++) {
			if (e[i] == '*' && (i == 0 || e[i - 1] == '*')) {
				return false;
			}
		}
		return true;
	}

	// 递归版本
	public static boolean isMatch(String str, String exp) {
		if (str == null || exp == null) {
			return false;
		}
		char[] s = str.toCharArray();
		char[] e = exp.toCharArray();
		return isValid(s, e) && process(s, e, 0, 0);
	}

	// str[i..一直到最后]这个字符串 能不能被exp[j..一直到最后]的字符串 匹配出来
	public static boolean process(char[] str, char[] exp, int si, int ej) {
		if (ej == exp.length) {// 当exp耗尽了，str必须也耗尽才会返回true
			return si == str.length;
		}
		// 如果j上还有字符，考查j+1的情况，后面的位置不是*
		if (ej + 1 == exp.length || exp[ej + 1] != '*') {
			return si != str.length //如果i==str.length,说明正则表达式没有匹配完，而字符串已经没了，则一定没有匹配成功
					&& (exp[ej] == str[si] || exp[ej] == '.')
					&& process(str, exp, si + 1, ej + 1);
		}
		// 下面部分都是j+1的位置都为'*'的情况
		// exp的j+1位置，不仅有字符而且字符是'*'
		while (si != str.length && (exp[ej] == str[si] || exp[ej] == '.')) {
			if (process(str, exp, si, ej + 2)) {
				return true;
			}
			si++;
		}
		return process(str, exp, si, ej + 2);// 匹配不上时，将*和前一个字符看成0个字符
	}

	/************************************
	 * 可以通过依赖关系推测出需要先知道的baseCase
	 * 推出普遍位置发现baseCase不够，得结合原题意，把缺的位置填上
	 *
	 *************************************/

	public static boolean isMatchDP(String str, String exp) {
		if (str == null || exp == null) {
			return false;
		}
		char[] s = str.toCharArray();
		char[] e = exp.toCharArray();
		if (!isValid(s, e)) {
			return false;
		}
		boolean[][] dp = initDPMap(s, e);// 填写dp表中的最后一行和倒数两列
		for (int i = s.length - 1; i > -1; i--) {
			for (int j = e.length - 2; j > -1; j--) {
				if (e[j + 1] != '*') {
					dp[i][j] = (s[i] == e[j] || e[j] == '.')
							&& dp[i + 1][j + 1];
				} else {
					int si = i;
					while (si != s.length && (s[si] == e[j] || e[j] == '.')) {
						if (dp[si][j + 2]) {
							dp[i][j] = true;
							break;
						}
						si++;
					}
					if (dp[i][j] != true) {
						dp[i][j] = dp[si][j + 2];
					}
				}
			}
		}
		return dp[0][0];
	}

	public static boolean[][] initDPMap(char[] s, char[] e) {
		int slen = s.length;
		int elen = e.length;
		boolean[][] dp = new boolean[slen + 1][elen + 1];
		dp[slen][elen] = true;
		for (int j = elen - 2; j > -1; j = j - 2) {
			if (e[j] != '*' && e[j + 1] == '*') {
				dp[slen][j] = true;
			} else {
				break;
			}
		}
		if (slen > 0 && elen > 0) {
			if ((e[elen - 1] == '.' || s[slen - 1] == e[elen - 1])) {
				dp[slen - 1][elen - 1] = true;
			}
		}
		return dp;
	}

	public static void main(String[] args) {
		String str = "abcccdefg";
		String exp = "ab.*d.*e.*";
		System.out.println(isMatch(str, exp));
		System.out.println(isMatchDP(str, exp));

	}

}
