package 牛客算法班.第三期.basic_class_02;

/**
 * 如果只能向字符串的后面添加字符，如何使整个字符串形成回文，要求添加的字符最少。
 *
 * 解法：求包含最后一个字符的最长回文串是多少，前面不是的部分逆序添加到字符串尾部。
 */
public class Code_05_Manacher_ShortestEnd {

	public static char[] manacherString(String str) {
		char[] charArr = str.toCharArray();
		char[] res = new char[str.length() * 2 + 1];
		int index = 0;
		for (int i = 0; i != res.length; i++) {
			res[i] = (i & 1) == 0 ? '#' : charArr[index++];
		}
		return res;
	}

	public static String shortestEnd(String str) {
		if (str == null || str.length() == 0) {
			return null;
		}
		char[] charArr = manacherString(str);
		int[] pArr = new int[charArr.length];
		int C = -1;
		int pR = -1;// 最右回文右边界，pR不包括在回文内！！！
		int maxContainsEnd = -1;
		for (int i = 0; i != charArr.length; i++) {
			pArr[i] = pR > i ? Math.min(pArr[2 * C - i], pR - i) : 1;
			while (i + pArr[i] < charArr.length && i - pArr[i] > -1) {
				if (charArr[i + pArr[i]] == charArr[i - pArr[i]])
					pArr[i]++;
				else {
					break;
				}
			}
			if (i + pArr[i] > pR) {
				pR = i + pArr[i];
				C = i;
			}
			if (pR == charArr.length) { // charArr[charArr.length-1]即最后一个字符被包含在回文中
				maxContainsEnd = pArr[i];// 插入虚轴后的回文半径，-1后就是原数组的回文直径
				break;
			}
		}
		char[] res = new char[str.length() - maxContainsEnd + 1];
		for (int i = 0; i < res.length; i++) {
			res[res.length - 1 - i] = charArr[i * 2 + 1];
		}
		return String.valueOf(res);// 需要添加到原字符串后面的字符串
	}

	public static void main(String[] args) {
		String str2 = "abcd123321";
		System.out.println(shortestEnd(str2));

	}

}
