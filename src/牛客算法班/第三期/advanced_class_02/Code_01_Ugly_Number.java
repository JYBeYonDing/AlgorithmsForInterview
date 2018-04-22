package 牛客算法班.第三期.advanced_class_02;

/**
 * 规定1是丑数， 其他的数如果只含有2或3或5的因子， 那么这个
 数也是丑数。
 比如依次的丑数为： 1,2,3,4,5,6,8,9,10,12,15...
 求第n个丑数

 思路：让你求某个序列的某个位置的数，你就想这个数是从前面的哪个数得到的，通常可以得到一个优良的解。

 判断num是否是质数：从2试到根号num
 */
public class Code_01_Ugly_Number {

	public static int uglyNumber1(int index) {
		int number = 0;
		int count = 0;
		while (count < index) {
			++number;
			if (isUgly(number))
				count++;
		}
		return number;
	}

	public static boolean isUgly(int number) {
		while (number % 2 == 0)
			number = number / 2;
		while (number % 3 == 0)
			number = number / 3;
		while (number % 5 == 0)
			number = number / 5;
		return (number == 1) ? true : false;
	}

	public static int uglyNumber2(int n) {
		int[] help = new int[n];
		help[0] = 1;
		int i2 = 0;
		int i3 = 0;
		int i5 = 0;
		int index = 1;
		while (index < n) {
			help[index] = Math.min(2 * help[i2], Math.min(3 * help[i3], 5 * help[i5]));
			if (help[index] == 2 * help[i2])
				i2++;
			if (help[index] == 3 * help[i3])
				i3++;
			if (help[index] == 5 * help[i5])
				i5++;
			index++;
		}
		return help[index - 1];
	}

	public static void main(String[] args) {
		int test = 8;
		System.out.println(uglyNumber1(test));
		System.out.println(uglyNumber2(test));
	}
}
