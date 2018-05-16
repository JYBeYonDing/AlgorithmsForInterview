package 练习;

import static 练习.旋转正方形.printMatrix;

/**
 * Created by 杨杰 on 2018/5/16 11:34.
 */
public class 矩阵最小路径 {
    public static void main(String[] args) {
        int[][] m = {{1, 3, 5, 9}, {8, 1, 3, 4}, {5, 0, 6, 1}, {8, 8, 4, 0}};
//        printMatrix(m);
        System.out.println(minPath1(m));
        System.out.println(minPath2(m));
    }

    /**
     * 动态规划版
     */
    private static int minPath2(int[][] m) {
        int[][] dp = new int[m.length][m[0].length];
        dp[0][0] = m[0][0];
        for(int j=1;j<dp[0].length;j++) {
            dp[0][j] = dp[0][j-1]+m[0][j];
        }
        for (int i=1;i<dp.length;i++) {
            dp[i][0] = dp[i-1][0]+m[i][0];
        }
        for(int i = 1 ; i<dp.length ; i++) {
            for (int j = 1 ; j<dp[0].length ;j++) {
                dp[i][j] = m[i][j] + Math.min(dp[i - 1][j], dp[i][j - 1]);
            }
        }
//        printMatrix(dp);
        return dp[dp.length-1][dp[0].length-1];
    }

    private static int minPath1(int[][] m) {
        int x = m.length - 1;
        int y = m[0].length - 1;
        int res = process1(m, x, y);
        return res;
    }

    private static int process1(int[][] m, int x, int y) {
        if (x == 0 && y == 0) {
            return m[x][y];
        }
        if (x == 0 && y > 0) {
            return m[x][y] + process1(m, 0, y - 1);
        } else if (y == 0 && x > 0) {
            return m[x][y] + process1(m, x - 1, 0);
        } else {
            return m[x][y] + Math.min(process1(m, x - 1, y), process1(m, x, y - 1));
        }
    }
}
