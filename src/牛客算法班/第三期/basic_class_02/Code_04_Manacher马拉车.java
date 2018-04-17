package 牛客算法班.第三期.basic_class_02;

/**
 * 一个字符串中找最长回文子串
 * 首先需要对字符串处理，在字符串两头和中间都加入#，加入的字符可以任意，因为比对过程中虚轴永远和虚轴比对
 * 概念：
 * 回文直径
 * 回文半径
 * 回文半径数组记录从每个位置开始扩的回文半径
 * 最右回文右边界：所有回文半径中最靠右的位置
 * 回文右边界的最早中心
 *
 * Manacher算法就是在暴力算法上加速
 * 可能性1：如果当前位置不在回文右边界R里面则暴力扩
 * 如果当前位置在回文右边界R里面，LR为当前最大的回文直径
 * 可能性2：当前位置i关于回文右边界的最早中心的中心对称点i'的回文半径在最大回文直径的内部，则i的回文半径和i'一样
 * 可能性3：i'的回文半径超过了最大回文直径，i的回文半径就是i到R
 * 可能性4：i'的回文半径正好和L压线，i需要从R之后开始验
 *
 * 时间复杂度：可能性1 R在变大，可能性4 R在变大，可能性2和可能性3的时间复杂度为O(1)，所以整个算法的时间复杂度为O(N)。
 */
public class Code_04_Manacher马拉车 {

	public static char[] manacherString(String str) {
		char[] charArr = str.toCharArray();
		char[] res = new char[str.length() * 2 + 1];
		int index = 0;
		for (int i = 0; i != res.length; i++) {
			res[i] = (i & 1) == 0 ? '#' : charArr[index++];
		}
		return res;
	}

	public static int maxLcpsLength(String str) {
		if (str == null || str.length() == 0) {
			return 0;
		}
		char[] charArr = manacherString(str);
		int[] pArr = new int[charArr.length];
		int index = -1;
		int pR = -1;
		int max = Integer.MIN_VALUE;
		for (int i = 0; i != charArr.length; i++) {
			pArr[i] = pR > i ? Math.min(pArr[2 * index - i], pR - i) : 1;
			while (i + pArr[i] < charArr.length && i - pArr[i] > -1) {
				if (charArr[i + pArr[i]] == charArr[i - pArr[i]])
					pArr[i]++;
				else {
					break;
				}
			}
			if (i + pArr[i] > pR) {
				pR = i + pArr[i];
				index = i;
			}
			max = Math.max(max, pArr[i]);
		}
		return max - 1;
	}

	public static void main(String[] args) {
		String str1 = "abc1234321ab";
		System.out.println(maxLcpsLength(str1));
	}

}
