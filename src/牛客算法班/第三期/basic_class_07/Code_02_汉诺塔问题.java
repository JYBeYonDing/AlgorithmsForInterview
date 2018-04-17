package 牛客算法班.第三期.basic_class_07;


/**
 * 介绍递归和动态规划
 暴力递归：
 1， 把问题转化为规模缩小了的同类问题的子问题，要把尝试变成code，也就是暴力算法，代码要有试的思路
 2， 有明确的不需要继续进行递归的条件(base case)
 3， 有当得到了子问题的结果之后的决策过程
 4， 不记录每一个子问题的解

该题无法改成动态规划，因为解空间就是所有的步骤，要打印所有步骤，没有重复计算，所以不能改。

 动态规划
 1， 从暴力递归中来
 2， 将每一个子问题的解记录下来， 避免重复计算
 3， 把暴力递归的过程， 抽象成了状态表达
 4， 并且存在化简状态表达， 使其更加简洁的可能
 */
public class Code_02_汉诺塔问题 {

	public static void hanoi(int n) {
		if (n > 0) {
			func(n, "left", "mid", "right");
		}
	}

	/**
	 * 把 1~n 从 from 移到 to 上
	 * @param n
	 * @param from
	 * @param mid
	 * @param to
	 */
	public static void func(int n, String from, String mid, String to) {
		if (n == 1) {
			System.out.println("move 1 from " + from + " to " + to);
		} else {
			func(n - 1, from, to, mid);
			System.out.println("move "+ n+ " from " + from + " to " + to);// 把最下面的一个从from移到to
//			func(n - 1, mid, from, to);
			func(n - 1, mid, to, from);
		}
	}

	public static void moveLeftToRight(int N) {
		if (N == 1) {
			System.out.println("move 1 from left to right");
		} else {
			moveLeftToMid(N - 1);
			System.out.println("move " + N + "from left to right");
			moveMidToRight(N - 1);
		}
	}

	public static void moveRightToLeft(int N) {

	}

	public static void moveLeftToMid(int N) {
		if (N == 1) {
			System.out.println("move 1 from left to mid");
		} else {
			moveLeftToRight(N - 1);
			System.out.println("move " + N + "from left to mid");
			moveRightToMid(N - 1);
		}
	}

	public static void moveMidToLeft(int N) {

	}

	public static void moveRightToMid(int N) {

	}

	public static void moveMidToRight(int N) {
		if (N == 1) {
			System.out.println("move 1 from mid to right");
		} else {
			moveMidToLeft(N - 1);
			System.out.println("move " + N + "from mid to right");
			moveLeftToRight(N - 1);
		}
	}


	public static void main(String[] args) {
		int n = 3;
		hanoi(n);
	}

}
