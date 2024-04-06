
//leetcode submit region begin(Prohibit modification and deletion)
class Solution {
    int[][] mem;
    public int minFallingPathSum(int[][] matrix) {
        int n = matrix.length;
        int res = Integer.MAX_VALUE;
        mem = new int[n][n];
        for (int i = 0; i < n; i++) {
            for (int j = 0; j < n; j++) {
                if (i == 0) {
                    mem[i][j] = matrix[i][j];
                }else{
                    mem[i][j] = 99999;
                }
            }
        }

        for (int i = 0; i < n; i++) {
            res = Math.min(res, dp(matrix, n-1, i));
        }
        return res;
    }

    private int dp(int[][] matrix, int i, int j) {
        if (j < 0 || j >= matrix.length) {
            return 200000;
        }
        if (i == 0) {
            return mem[i][j];
        }

        if (mem[i][j] != 99999) {
            return mem[i][j];
        }

        int temp = matrix[i][j]+min(dp(matrix, i - 1, j - 1), dp(matrix, i - 1, j), dp(matrix, i - 1, j + 1));
        mem[i][j] = temp;
        return temp;
    }

    private int min(int a, int b, int c) {
        return Math.min(a, Math.min(b, c));
    }
}
//leetcode submit region end(Prohibit modification and deletion)
