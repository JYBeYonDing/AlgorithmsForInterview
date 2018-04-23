package 牛客算法班.第三期.advanced_class_03;

/**
 * 第三期进阶第三章1:50
 * 根据情况 无状态转移的 有套路，及有通式的问题
 * |F(n)F(n-1)|=|F(2)F(1)|*|2*2矩阵|^(n-2) 可以推广
 * 根据前面初始项，求解2*2矩阵
 *
 * 通式：
 * F(n) = F()+...+F(n-k) 最大的k就是k阶问题
 * 则
 * |F(n),F(n-1),F(n-2),...,F(n-k+1)| = |F(k),F(k-1),F(k-2),...,F(1)|*|k*k阶矩阵|^(n-k)
 * |k*k阶矩阵| 待求，可以自己手动求
 *
 *
 * 根据情况有状态转移的
 */
public class Code_06_FibonacciProblem {

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

	public static int f3(int n) {
		if (n < 1) {
			return 0;
		}
		if (n == 1 || n == 2) {
			return 1;
		}
		int[][] base = { { 1, 1 }, { 1, 0 } };// 可以自己手动求解这个矩阵
		int[][] res = matrixPower(base, n - 2);
		return 1*res[0][0] + 1*res[1][0];//f1=1，f2=1
	}

	/**
	 * 求矩阵m的p次方
	 * @param m
	 * @param p
	 * @return
	 */
	public static int[][] matrixPower(int[][] m, int p) {
		int[][] res = new int[m.length][m[0].length];
		for (int i = 0; i < res.length; i++) {// 生成单位矩阵
			res[i][i] = 1;
		}
		int[][] tmp = m;
		for (; p != 0; p >>= 1) {
			if ((p & 1) != 0) {// 只有次方项中二进制表示相应位置是1的时候才乘到res中
				res = muliMatrix(res, tmp);
			}
			tmp = muliMatrix(tmp, tmp);// tmp*tmp
		}
		return res;
	}

	/**
	 * 矩阵m1和m2相乘
	 * @param m1
	 * @param m2
	 * @return
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
	 * 假设农场中成熟的母牛每年只会生1头小母牛， 并且永远不会死。 第一年农场有1只成熟的母牛， 从第二年开始，
	 母牛开始生小母牛。 每只小母牛3年之后成熟又可以生小母牛。 给定整数N， 求出N年后牛的数量。
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
		return 3 * res[0][0] + 2 * res[1][0] + res[2][0];// 第三年3只，第二年2只，第一年1只，
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
