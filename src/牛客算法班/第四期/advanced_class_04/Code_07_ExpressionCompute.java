package 牛客算法班.第四期.advanced_class_04;

import java.util.LinkedList;

/**
 * 给定一个字符串str， str表示一个公式， 公式里可能有整数、 加减乘除符号和
 左右括号， 返回公式的计算结果。
 【举例】
 str="48*((70-65)-43)+8*1"， 返回-1816。
 str="3+1*4"， 返回7。 str="3+(1*4)"， 返回7。
 【说明】
 1． 可以认为给定的字符串一定是正确的公式， 即不需要对str做公式有效性检查。
 2． 如果是负数， 就需要用括号括起来， 比如"4*(-3)"。 但如果负数作为公式的
 开头或括号部分的开头， 则可以没有括号， 比如"-3*4"和"(-3*4)"都是合法的。
 3． 不用考虑计算过程中会发生溢出的情况


 */
public class Code_07_ExpressionCompute {

	public static int getValue(String str) {
		return value(str.toCharArray(), 0)[0];
	}

	/**
	 *
	 * @param str
	 * @param i
	 * @return 长度为2的数组，arr[0]：计算结果，arr[1]：算到了哪个位置
	 */
	public static int[] value(char[] str, int i) {
		LinkedList<String> que = new LinkedList<String>();// 收集
		int pre = 0;// 搜集数字
		int[] bra = null;
		while (i < str.length && str[i] != ')') {
			if (str[i] >= '0' && str[i] <= '9') {
				pre = pre * 10 + str[i++] - '0';
			} else if (str[i] != '(') {// 遇到的不是数字，也不是左括号，说明遇到了+-*/
				addNum(que, pre);// 收集到数字
				que.addLast(String.valueOf(str[i++]));// 收集到运算符
				pre = 0;// 归零，下一次收集开始
			} else {// 遇到了左括号，即i位置是左括号
				bra = value(str, i + 1);
				pre = bra[0];// 收集到括号内的计算结果
				i = bra[1] + 1;// 这个位置一定会是一个运算符或结束
			}
		}
		addNum(que, pre);
		return new int[] { getNum(que), i };
	}

	public static void addNum(LinkedList<String> que, int num) {
		if (!que.isEmpty()) {
			int cur = 0;
			String top = que.pollLast();
			if (top.equals("+") || top.equals("-")) {
				que.addLast(top);
			} else {
				cur = Integer.valueOf(que.pollLast());
				num = top.equals("*") ? (cur * num) : (cur / num);
			}
		}
		que.addLast(String.valueOf(num));
	}

	public static int getNum(LinkedList<String> que) {
		int res = 0;
		boolean add = true;
		String cur = null;
		int num = 0;
		while (!que.isEmpty()) {
			cur = que.pollFirst();
			if (cur.equals("+")) {
				add = true;
			} else if (cur.equals("-")) {
				add = false;
			} else {
				num = Integer.valueOf(cur);
				res += add ? num : (-num);
			}
		}
		return res;
	}

	public static void main(String[] args) {
		String exp = "48*((70-65)-43)+8*1";
		System.out.println(getValue(exp));

		exp = "4*(6+78)+53-9/2+45*8";
		System.out.println(getValue(exp));

		exp = "10-5*3";
		System.out.println(getValue(exp));

		exp = "-3*4";
		System.out.println(getValue(exp));

		exp = "3+1*4";
		System.out.println(getValue(exp));

	}

}
