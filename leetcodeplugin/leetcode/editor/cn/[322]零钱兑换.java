import java.util.Arrays;

//leetcode submit region begin(Prohibit modification and deletion)
class Solution {
    int[] memo;

    public int coinChange(int[] coins, int amount) {
        int[] dp = new int[amount + 1];
        Arrays.fill(dp, amount + 1);

        dp[0] = 0;

        for (int i = 1; i <= amount; i++) {
            for (int j = 0; j < coins.length; j++) {
                if (i - coins[j] >= 0) {
                    dp[i] = Math.min(dp[i], 1 + dp[i - coins[j]]);
                }
            }

        }
        return dp[amount] == amount + 1 ? -1 : dp[amount];

//        memo = new int[amount+1];
//        for (int i = 0; i <= amount; i++) {
//            memo[i] = -666;
//        }
//        return dp(coins, amount);
    }

    public int dp(int[] coins, int amount) {
        if (amount == 0) {
            return 0;
        }
        if (amount < 0) {
            return -1;
        }
        if (memo[amount] != -666) {
            return memo[amount];
        }
        int res = Integer.MAX_VALUE;
        for (int i = 0; i < coins.length; i++) {
            int dp = dp(coins, amount - coins[i]);
            if (dp == -1) {
                continue;
            }
            res = Math.min(res, 1 + dp);
        }
        res = res == Integer.MAX_VALUE ? -1 : res;
        memo[amount] = res;
        return res;
    }
}
//leetcode submit region end(Prohibit modification and deletion)
