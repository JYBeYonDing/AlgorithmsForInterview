package 牛客算法班.第三期.basic_class_03;


/**
 * 旋转正方形矩阵
 【题目】 给定一个整型正方形矩阵matrix， 请把该矩阵调整成
 顺时针旋转90度的样子。
 【要求】 额外空间复杂度为O(1)。

 宏观调度
 一圈一圈转，一圈里面一组一组转
 */
public class Code_05_旋转正方形矩阵 {

	public static void rotate(int[][] matrix) {
		int tR = 0;// 左上角的点
		int tC = 0;
		int dR = matrix.length - 1;// 右下角的点
		int dC = matrix[0].length - 1;
		while (tR < dR) {
			rotateEdge(matrix, tR++, tC++, dR--, dC--);
		}
	}

	public static void rotateEdge(int[][] m, int tR, int tC, int dR, int dC) {
		int times = dC - tC; 
		int tmp = 0;
		for (int i = 0; i != times; i++) {
			tmp = m[tR][tC + i];
			m[tR][tC + i] = m[dR - i][tC];
			m[dR - i][tC] = m[dR][dC - i];
			m[dR][dC - i] = m[tR + i][dC];
			m[tR + i][dC] = tmp;
		}
	}

	public static void printMatrix(int[][] matrix) {
		for (int i = 0; i != matrix.length; i++) {
			for (int j = 0; j != matrix[0].length; j++) {
				System.out.print(matrix[i][j] + " ");
			}
			System.out.println();
		}
	}

	public static void main(String[] args) {
		int[][] matrix = { { 1, 2, 3, 4 }, { 5, 6, 7, 8 }, { 9, 10, 11, 12 },
				{ 13, 14, 15, 16 } };
		printMatrix(matrix);
		rotate(matrix);
		System.out.println("=========");
		printMatrix(matrix);

	}

}
