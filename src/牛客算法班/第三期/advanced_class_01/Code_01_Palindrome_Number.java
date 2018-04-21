package 牛客算法班.第三期.advanced_class_01;

/**
 * 给定一个整数， 判断该数是否是回文数
 *
 * 10^8 以内的计算量能通过oj
 * 通过输入量多少可以推测有一个什么样复杂度的解。
 *
 * 思路：如果转成字符串做，常数项复杂度大，如果oj卡常数项的话就无法通过，所以不如直接数值计算来得快。
 *
 */
public class Code_01_Palindrome_Number {

	public static boolean isPalindrome(int n) {
		if (n < 0) {
			return false;
		}
		int help = 1;
		while (n / help >= 10) {// 找到10进制的最高位
			help *= 10;
		}
		/*
		不能用这种形式，因为help可能会溢出，变成负的就会有问题
		while (help <= n) {
			help *= 10;
		}
		help /= 10;
		*/
		while (n != 0) {
			if (n / help != n % 10) {
				return false;
			}
			n = (n % help) / 10;// 一次剥掉两边的两个数
			help /= 100;
		}
		return true;
	}

}
