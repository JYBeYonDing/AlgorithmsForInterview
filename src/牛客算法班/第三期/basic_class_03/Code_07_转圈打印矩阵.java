package 牛客算法班.第三期.basic_class_03;

/**
 * 转圈打印矩阵
 【题目】 给定一个整型矩阵matrix， 请按照转圈的方式打印它。
 例如：
 1 2 3 4
 5 6 7 8
 9 10 11 12
 13 14 15 16
 打印结果为： 1， 2， 3， 4， 8， 12， 16， 15， 14， 13， 9，
 5， 6， 7， 11， 10
 【要求】 额外空间复杂度为O(1)。

 思路：锻炼宏观的调度能力


 */
public class Code_07_转圈打印矩阵 {

	public static void spiralOrderPrint(int[][] matrix) {
		int tR = 0;
		int tC = 0;
		int dR = matrix.length - 1;
		int dC = matrix[0].length - 1;
		while (tR <= dR && tC <= dC) {
			printEdge(matrix, tR++, tC++, dR--, dC--);// 打印一圈
		}
	}

	/**
	 * 打印一圈
	 */
	public static void printEdge(int[][] m, int tR, int tC, int dR, int dC) {
		if (tR == dR) { //只有一行
			for (int i = tC; i <= dC; i++) {
				System.out.print(m[tR][i] + " ");
			}
		} else if (tC == dC) { //只有一列
			for (int i = tR; i <= dR; i++) {
				System.out.print(m[i][tC] + " ");
			}
		} else { //多行多列
			int curC = tC;
			int curR = tR;
			while (curC != dC) {
				System.out.print(m[tR][curC] + " ");
				curC++;
			}
			while (curR != dR) {
				System.out.print(m[curR][dC] + " ");
				curR++;
			}
			while (curC != tC) {
				System.out.print(m[dR][curC] + " ");
				curC--;
			}
			while (curR != tR) {
				System.out.print(m[curR][tC] + " ");
				curR--;
			}
		}
	}

	public static void main(String[] args) {
		int[][] matrix = { { 1, 2, 3, 4 }, { 5, 6, 7, 8 }, { 9, 10, 11, 12 },
				{ 13, 14, 15, 16 } };
		spiralOrderPrint(matrix);

	}

}
