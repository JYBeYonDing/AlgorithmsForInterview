package 程序员面试指南.书本源码.chapter_4_recursionanddp;

public class Problem_01_FibonacciProblem斐波那契系列问题 {

	public static int f1(int n) {
		if (n < 1) {
			return 0;
		}
		if (n == 1 || n == 2) {
			return 1;
		}
		return f1(n - 1) + f1(n - 2);
	}

	public static int f2(int n) {
		if (n < 1) {
			return 0;
		}
		if (n == 1 || n == 2) {
			return 1;
		}
		int res = 1;
		int pre = 1;
		int tmp = 0;
		for (int i = 3; i <= n; i++) {
			tmp = res;
			res = res + pre;
			pre = tmp;
		}
		return res;
	}

	/**
	 * 矩阵乘法求斐波那契数列，复杂度O(logN)
	 * @param n
	 * @return
	 */
	public static int f3(int n) {
		if (n < 1) {
			return 0;
		}
		if (n == 1 || n == 2) {
			return 1;
		}
		int[][] base = { { 1, 1 }, { 1, 0 } };
		int[][] res = matrixPower(base, n - 2);
		return res[0][0] + res[1][0];
	}

	/**
	 * 矩阵m的p次方
	 * @param m 矩阵
	 * @param p 次方
	 * @return 结果
	 */
	public static int[][] matrixPower(int[][] m, int p) {
		int[][] res = new int[m.length][m[0].length];
		// 先把res设为单位矩阵，相当于整数中的1
		for (int i = 0; i < res.length; i++) {
			res[i][i] = 1;
		}
		int[][] tmp = m;
		for (; p != 0; p >>= 1) {
			if ((p & 1) != 0) {// 如果该位是1，就乘上对应的次方
				res = muliMatrix(res, tmp);
			}
			tmp = muliMatrix(tmp, tmp);// 2次方，4次方，8次方，16次方......
		}
		return res;
	}

	/**
	 * 矩阵m1和矩阵m2相乘
	 * @param m1 矩阵1
	 * @param m2 矩阵2
	 * @return 矩阵相乘结果
	 */
	public static int[][] muliMatrix(int[][] m1, int[][] m2) {
		int[][] res = new int[m1.length][m2[0].length];
		for (int i = 0; i < m1.length; i++) {
			for (int j = 0; j < m2[0].length; j++) {
				for (int k = 0; k < m2.length; k++) {
					res[i][j] += m1[i][k] * m2[k][j];
				}
			}
		}
		return res;
	}

	/**
	 * 跳台阶问题
	 * @param n
	 * @return
	 */
	public static int s1(int n) {
		if (n < 1) {
			return 0;
		}
		if (n == 1 || n == 2) {
			return n;
		}
		return s1(n - 1) + s1(n - 2);
	}

	public static int s2(int n) {
		if (n < 1) {
			return 0;
		}
		if (n == 1 || n == 2) {
			return n;
		}
		int res = 2;
		int pre = 1;
		int tmp = 0;
		for (int i = 3; i <= n; i++) {
			tmp = res;
			res = res + pre;
			pre = tmp;
		}
		return res;
	}

	public static int s3(int n) {
		if (n < 1) {
			return 0;
		}
		if (n == 1 || n == 2) {
			return n;
		}
		int[][] base = { { 1, 1 }, { 1, 0 } };
		int[][] res = matrixPower(base, n - 2);
		return 2 * res[0][0] + res[1][0];
	}

	/**
	 * 母牛生小牛问题
	 * @param n
	 * @return
	 */
	public static int c1(int n) {
		if (n < 1) {
			return 0;
		}
		if (n == 1 || n == 2 || n == 3) {
			return n;
		}
		return c1(n - 1) + c1(n - 3);
	}

	public static int c2(int n) {
		if (n < 1) {
			return 0;
		}
		if (n == 1 || n == 2 || n == 3) {
			return n;
		}
		int res = 3;
		int pre = 2;
		int prepre = 1;
		int tmp1 = 0;
		int tmp2 = 0;
		for (int i = 4; i <= n; i++) {
			tmp1 = res;
			tmp2 = pre;
			res = res + prepre;
			pre = tmp1;
			prepre = tmp2;
		}
		return res;
	}

	public static int c3(int n) {
		if (n < 1) {
			return 0;
		}
		if (n == 1 || n == 2 || n == 3) {
			return n;
		}
		int[][] base = { { 1, 1, 0 }, { 0, 0, 1 }, { 1, 0, 0 } };
		int[][] res = matrixPower(base, n - 3);
		return 3 * res[0][0] + 2 * res[1][0] + res[2][0];
	}

	public static void main(String[] args) {
		int n = 20;
		System.out.println(f1(n));
		System.out.println(f2(n));
		System.out.println(f3(n));
		System.out.println("===");

		System.out.println(s1(n));
		System.out.println(s2(n));
		System.out.println(s3(n));
		System.out.println("===");

		System.out.println(c1(n));
		System.out.println(c2(n));
		System.out.println(c3(n));
		System.out.println("===");

	}

}
