package 练习;

/**
 * Created by 杨杰 on 2018/5/16 15:01.
 */
public class 背包问题 {
    public static void main(String[] args) {
        int[] c = { 3, 2, 4, 7 };
        int[] p = { 5, 6, 3, 19 };
        int bag = 11;
        System.out.println(maxValue1(c, p, bag));
        System.out.println(maxValue2(c, p, bag));
    }

    private static int maxValue2(int[] c, int[] p, int bag) {
        int[][] dp = new int[bag + 1][c.length];
        for(int i = 0 ; i<dp.length ; i++) {
            if (i < c[0]) {
                dp[i][0] = 0;
            } else {
                dp[i][0] = p[0];
            }
        }

        for(int i = 0 ; i< dp.length;i++) {
            for(int j = 1 ; j<dp[0].length ; j++) {
                if (i - c[j] < 0) {
                    dp[i][j] = dp[i][j - 1];
                } else {
                    dp[i][j] = Math.max(p[j] + dp[i - c[j]][j - 1], dp[i][j - 1]);
                }
            }
        }
        return dp[bag][c.length-1];
    }

    private static int maxValue1(int[] c, int[] p, int bag) {
        return process1(c, p, bag, c.length - 1);
    }

    private static int process1(int[] c, int[] p, int bag, int i) {
        if (bag < 0) {
            return Integer.MIN_VALUE;
        }
        if (i < 0) {
            return 0;
        }
        return Math.max(p[i] + process1(c, p, bag - c[i], i - 1), process1(c, p, bag, i - 1));
    }
}
