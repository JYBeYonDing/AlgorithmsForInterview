package 牛客算法班.第三期.advanced_class_02;

/**
 * 给定一个整数矩阵matrix， 每个位置你可以向左、 右、 下、 上移动， 找到其中最长的递增路径。
 * 例如：
 * matrix = [
 * [9,9,4],
 * [6,6,8],
 * [2,1,1]
 * ]
 * 返回4
 * 最长路径是[1, 2, 6, 9].
 * matrix = [
 * [3,4,5],
 * [3,2,6],
 * [2,2,1]
 * ]
 * 返回4
 * 最长路径是[1, 2, 6, 9].
 */
public class Code_05_矩阵中最长升序路径 {

    /**
     * 递归版本
     *
     * @param matrix
     * @return
     */
    public static int longest1(int[][] matrix) {
        int max = Integer.MIN_VALUE;
        for (int row = 0; row < matrix.length; row++) {
            for (int col = 0; col < matrix[0].length; col++) {
                max = Math.max(max, process(matrix, row, col));
            }
        }
        return max;
    }

    /**
     * 从row col开始的最长路径
     *
     * @return
     */
    private static int process(int[][] matrix, int row, int col) {
        int path = 1;
        if (col > 0 && matrix[row][col - 1] > matrix[row][col]) {
            path = Math.max(path, process(matrix, row, col - 1) + 1);
        }
        if (row > 0 && matrix[row - 1][col] > matrix[row][col]) {
            path = Math.max(path, process(matrix, row - 1, col) + 1);
        }
        if (row < matrix.length - 1 && matrix[row + 1][col] > matrix[row][col]) {
            path = Math.max(path, process(matrix, row + 1, col));
        }
        if (col < matrix[0].length - 1 && matrix[row][col + 1] > matrix[row][col]) {
            path = Math.max(path, process(matrix, row, col + 1));
        }
        return path;
    }


    /**
     * 记忆搜索方法，空间换时间
     * @param matrix
     * @return
     */
    public static int longest2(int[][] matrix) {
        int max = Integer.MIN_VALUE;
        int[][] dp = new int[matrix.length][matrix[0].length];
        for (int row = 0; row < matrix.length; row++) {
            for (int col = 0; col < matrix[0].length; col++) {
                max = Math.max(max, processDP(matrix, dp, row, col));
            }
        }
        return max;
    }

    /**
     * 从row col开始的最长路径
     *
     * @return
     */
    private static int processDP(int[][] matrix, int[][] dp, int row, int col) {
        if (dp[row][col] == 0) {
            dp[row][col] = 1;
            if (col > 0 && matrix[row][col - 1] > matrix[row][col]) {
                dp[row][col] = Math.max(dp[row][col], processDP(matrix, dp, row, col - 1) + 1);
            }
            if (row > 0 && matrix[row - 1][col] > matrix[row][col]) {
                dp[row][col] = Math.max(dp[row][col], processDP(matrix, dp, row - 1, col) + 1);
            }
            if (row < matrix.length - 1 && matrix[row + 1][col] > matrix[row][col]) {
                dp[row][col] = Math.max(dp[row][col], processDP(matrix, dp, row + 1, col));
            }
            if (col < matrix[0].length - 1 && matrix[row][col + 1] > matrix[row][col]) {
                dp[row][col] = Math.max(dp[row][col], processDP(matrix, dp, row, col + 1));
            }
        }
        return dp[row][col];
    }

    public static int longestIncreasingPath(int[][] m) {
        if (m == null || m.length == 0 || m[0].length == 0) {
            return 0;
        }
        int[][] dp = new int[m.length][m[0].length];
        int max = 0;
        for (int row = 0; row < m.length; row++) {
            for (int col = 0; col < m[0].length; col++) {
                max = Math.max(max, maxIncrease(m, dp, row + 1, col, m[row][col]) + 1);
                max = Math.max(max, maxIncrease(m, dp, row, col + 1, m[row][col]) + 1);
                max = Math.max(max, maxIncrease(m, dp, row - 1, col, m[row][col]) + 1);
                max = Math.max(max, maxIncrease(m, dp, row, col - 1, m[row][col]) + 1);
            }
        }
        return max;
    }

    /**
     * @param m
     * @param dp  相当于缓存
     * @param row
     * @param col
     * @param p   上一步的值
     * @return
     */
    public static int maxIncrease(int[][] m, int[][] dp, int row, int col, int p) {
        if (row < 0 || row >= m.length || col < 0 || col >= m[0].length || m[row][col] >= p) {
            return 0;
        }
        if (dp[row][col] == 0) {// 如果==0，说明这个位置从来没计算过
            dp[row][col] = maxIncrease(m, dp, row + 1, col, m[row][col]) + 1;
            dp[row][col] = Math.max(dp[row][col], maxIncrease(m, dp, row, col + 1, m[row][col]) + 1);
            dp[row][col] = Math.max(dp[row][col], maxIncrease(m, dp, row - 1, col, m[row][col]) + 1);
            dp[row][col] = Math.max(dp[row][col], maxIncrease(m, dp, row, col - 1, m[row][col]) + 1);
        }
        return dp[row][col];
    }

    public static void main(String[] args) {
        int[][] matrix = {
                {9, 9, 4},
                {6, 6, 8},
                {2, 1, 1}
        };
        System.out.println(longest2(matrix));
        System.out.println(longestIncreasingPath(matrix));
    }
}
