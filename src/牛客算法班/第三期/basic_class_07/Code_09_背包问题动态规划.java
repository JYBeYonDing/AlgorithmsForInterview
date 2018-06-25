package 牛客算法班.第三期.basic_class_07;

public class Code_09_背包问题动态规划 {
    /**
     * 动态规划
     * 背包问题九讲
     * 01背包问题
     */
    public static int maxValue3(int[] c, int[] p, int bag) {
        int[] dp = new int[bag + 1];// 0...bag
        for (int i = 0; i < c.length; i++) {
            for (int j = bag; j >= c[i]; j--) {//注意!!!
                dp[j] = Math.max(dp[j], dp[j - c[i]] + p[i]);
            }
        }
        return dp[bag];
    }

    /**
     * 动态规划
     * 背包问题九讲
     * 完全背包问题
     */
    public static int maxValue4(int[] c, int[] p, int bag) {
        int[] dp = new int[bag + 1];// 0...bag
        for (int i = 0; i < c.length; i++) {
            for (int j = c[i]; j <= bag; j++) {//注意!!!
                dp[j] = Math.max(dp[j], dp[j - c[i]] + p[i]);
            }
        }
        return dp[bag];
    }


    public static int maxValue1(int[] c, int[] p, int bag) {
        return process1(c, p, 0, 0, bag);
    }

    /**
     * 递归
     */
    public static int process1(int[] c, int[] p, int i, int cost, int bag) {
        if (cost > bag) {
            return Integer.MIN_VALUE;// 无效值
        }
        if (i == c.length) {
            return 0;
        }
        return Math.max(process1(c, p, i + 1, cost, bag), p[i] + process1(c, p, i + 1, cost + c[i], bag));
    }

    /**
     * 动态规划 空间还可以省一点
     */
    public static int maxValue2(int[] c, int[] p, int bag) {
        int[][] dp = new int[c.length + 1][bag + 1];
        for (int i = c.length - 1; i >= 0; i--) {
            for (int j = bag; j >= 0; j--) {
                dp[i][j] = dp[i + 1][j];
                if (j + c[i] <= bag) {
                    dp[i][j] = Math.max(dp[i][j], p[i] + dp[i + 1][j + c[i]]);
                }
            }
        }
        return dp[0][0];
    }


    public static void main(String[] args) {
        int[] c = {3, 2, 4, 7};
        int[] p = {5, 6, 3, 19};
        int bag = 11;
        System.out.println("01背包问题:");
        System.out.println(maxValue1(c, p, bag));
        System.out.println(maxValue2(c, p, bag));
        System.out.println(maxValue3(c, p, bag));
        System.out.println("完全背包问题:");
        System.out.println(maxValue4(c, p, bag));
    }

}
