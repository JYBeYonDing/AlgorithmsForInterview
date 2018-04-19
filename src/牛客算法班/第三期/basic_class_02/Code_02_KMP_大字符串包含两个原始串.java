package 牛客算法班.第三期.basic_class_02;

/**
 * 求一个最短大字符串，使它包含两个当前字符子串
 * 思路：只需要多求一个 前缀和后缀的最长匹配
 */
public class Code_02_KMP_大字符串包含两个原始串 {

	public static String answer(String str) {
		if (str == null || str.length() == 0) {
			return "";
		}
		char[] chas = str.toCharArray();
		if (chas.length == 1) {
			return str + str;
		}
		if (chas.length == 2) {// 如果等于两个字符，若想等只需再加一个相等的字符，若不相等，重复这两个字符
			return chas[0] == chas[1] ? (str + String.valueOf(chas[0])) : (str + str);
		}
		int endNext = endNextLength(chas);// 返回当前字符串最长相等前缀的后一个位置
		return str + str.substring(endNext);
	}

	public static int endNextLength(char[] chas) {
		int[] next = new int[chas.length + 1];// 需要多求一位
		next[0] = -1;
		next[1] = 0;
		int pos = 2;
		int cn = 0;
		while (pos < next.length) {
			if (chas[pos - 1] == chas[cn]) {
				next[pos++] = ++cn;
			} else if (cn > 0) {
				cn = next[cn];
			} else {
				next[pos++] = 0;
			}
		}
		return next[next.length - 1];
	}

	public static void main(String[] args) {
		String test1 = "a";
		System.out.println(answer(test1));

		String test2 = "aa";
		System.out.println(answer(test2));

		String test3 = "ab";
		System.out.println(answer(test3));

		String test4 = "abcdabcd";
		System.out.println(answer(test4));

		String test5 = "abracadabra";
		System.out.println(answer(test5));

	}

}
