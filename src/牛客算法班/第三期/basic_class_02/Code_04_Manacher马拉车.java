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

	/**
	 * 将字符串插入虚轴并返回字符数组
	 * @param str 字符串
	 * @return 插入虚轴的字符数组
	 */
	public static char[] manacherString(String str) {
		char[] charArr = str.toCharArray();
		char[] res = new char[str.length() * 2 + 1];// 将字符串扩大，因为需要插入虚轴
		int index = 0;
		for (int i = 0; i != res.length; i++) {
			res[i] = (i & 1) == 0 ? '#' : charArr[index++];
		}
		return res;
	}

	/**
	 * 求最长回文长度
	 * @param str 字符串
	 * @return 最长回文长度
	 */
	public static int maxLcpsLength(String str) {
		if (str == null || str.length() == 0) {
			return 0;
		}
		char[] charArr = manacherString(str);
		int[] pArr = new int[charArr.length];// 回文半径数组
		int C = -1;// 最右回文边界的最早中心
		int pR = -1;// 最右回文边界
		int max = Integer.MIN_VALUE;
		for (int i = 0; i != charArr.length; i++) {
			// pR > i：i在最右回文边界的里面，起码有一个不用验的区域
			pArr[i] = pR > i ? Math.min(pArr[2 * C - i], pR - i) : 1;
			while (i + pArr[i] < charArr.length && i - pArr[i] > -1) {
				//这里即使是情况2或情况3也会向外扩一下，不影响，这样做只是为了让代码更短
				if (charArr[i + pArr[i]] == charArr[i - pArr[i]])
					pArr[i]++;
				else {
					break;
				}
			}
			// 更新
			if (i + pArr[i] > pR) {
				pR = i + pArr[i];
				C = i;
			}
			max = Math.max(max, pArr[i]);
		}
		// 这里的回文半径是加了虚轴后的回文半径，并且是以虚轴结尾的，
		// -1后是原数组的回文直径，奇数偶数长度分别举个例子就知道了
		return max - 1;
	}

	public static void main(String[] args) {
		String str1 = "abc1234321ab";
		System.out.println(maxLcpsLength(str1));
	}

}
