package LeetCode.Q322;

import edu.princeton.cs.algs4.In;

import java.util.HashMap;
import java.util.Map;

/**
 * Created by 杨杰 on 2018/4/9 18:03.
 */
class Solution {
    public static int maxValue = 10000000;
    public static int[][] f;

    public static int search(int idx, int amount, int[] coins) {
        if (amount == 0) {
            return 0;
        }
        if (amount < 0) {
            return maxValue;
        }
        if (idx >= coins.length) {
            return maxValue;
        }
        if (f[idx][amount] >= 0) {
            return f[idx][amount];
        }
        int a = search(idx, amount - coins[idx], coins) + 1;
        int b = search(idx + 1, amount, coins);
        return Math.min(a, b);
    }

    public static int coinChange1(int[] coins, int amount) {
        if (coins.length == 0) {
            return -1;
        }
        if (amount == 0) {
            return 0;
        }
        int[][] res = new int[coins.length][amount + 1];
        for (int i = 0; i < coins.length; i++) {
            res[i][0] = 0;
        }
        for (int j = 1; j <= amount; j++) {
            if (j % coins[0] == 0) {
                res[0][j] = j / coins[0];
            } else {
                res[0][j] = maxValue;
            }
        }
        for (int i = 1; i < coins.length; i++) {
            for (int j = 1; j <= amount; j++) {
                int a;
                if (j - coins[i] < 0) {
                    a = maxValue;
                } else {
                    a = res[i][j - coins[i]] + 1;
                }

                int b = res[i - 1][j];

                res[i][j] = Math.min(a, b);
            }
        }
        if (res[coins.length - 1][amount] < maxValue) {
            return res[coins.length - 1][amount];
        } else {
            return -1;
        }
    }

    public static int coinChange(int[] coins, int amount) {
        f = new int[coins.length][amount + 1];
        for (int i = 0; i < coins.length; i++) {
            for (int j = 0; j <= amount; j++) {
                f[i][j] = -1;
            }
        }
        int res = search(0, amount, coins);
        if (res < maxValue) {
            return res;
        } else {
            return -1;
        }
    }

    public static void main(String[] args) {
        int[] coins = {2, 5, 10, 1};

        int amount = 27;
        System.out.println(coinChange1(coins, amount));
    }

    public static int coinChange2(int[] coins, int amount) {
        int[] dp = new int[amount + 1];
        dp[0] = 0;
        for (int i = 1; i <= amount; i++) {
            dp[i] = Integer.MAX_VALUE - 1;
        }
        for (int i = 1; i <= amount; i++) {
            for (int j = 0; j < coins.length; j++) {
                if (i - coins[j] >= 0)
                    dp[i] = Math.min(dp[i - coins[j]] + 1, dp[i]);
            }
        }
        return dp[amount] == Integer.MAX_VALUE - 1 ? -1 : dp[amount];
    }

    public int coinChange3(int[] coins, int amount) {
        if (amount < 1) return 0;
        int[] dp = new int[amount + 1];
        for (int i = 1; i <= amount; i++)
            dp[i] = Integer.MAX_VALUE;
        for (int i = 0; i < coins.length; i++) {
            for (int j = coins[i]; j <= amount; j++)
                if (dp[j - coins[i]] != Integer.MAX_VALUE)
                    dp[j] = Math.min(dp[j], dp[j - coins[i]] + 1);
//            System.out.println(Arrays.toString(dp));
        }
        return dp[amount] > amount ? -1 : dp[amount];
    }
}
